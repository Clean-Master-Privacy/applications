    package com.applovin.mediation.impl;

import android.app.Activity;
import android.content.Context;

import com.applovin.mediation.AppLovinMediationAdapterConfig;
import com.applovin.mediation.AppLovinMediationErrorCode;
import com.applovin.sdk.AppLovinSdk;
import com.applovin.sdk.AppLovinSdkUtils;
import com.vungle.publisher.AdConfig;
import com.vungle.publisher.EventListener;
import com.vungle.publisher.FullScreenAdActivity;
import com.vungle.publisher.MraidFullScreenAdActivity;
import com.vungle.publisher.Orientation;
import com.vungle.publisher.VideoFullScreenAdActivity;
import com.vungle.publisher.VunglePub;

import java.util.Map;

/**
 * This is a mediation adapter for the Vungle Ad SDK
 * <p>
 * Created by basil on 12/5/16.
 */

public class AppLovinVungleMediationAdapter
        extends GlobalListenerAdapterBase
        implements EventListener
{
    private VunglePub vunglePub;

    private boolean vungleInitialized;
    private boolean isShowingInterstitial;

    private AppLovinMediationAdapterConfig configuration;

    @Override
    public void initialize(final AppLovinMediationAdapterConfig configuration, final AppLovinSdk sdk, final Activity activity) throws Exception
    {
        super.initialize( configuration, sdk, activity );

        // Check existence of SDK classes
        checkExistence( VunglePub.class, EventListener.class, AdConfig.class );

        // Check existence of SDK activities
        checkActivities( FullScreenAdActivity.class, VideoFullScreenAdActivity.class, MraidFullScreenAdActivity.class );

        this.configuration = configuration;

        if ( configuration.getBoolean( KEY_INIT ) )
        {
            if ( activity == null ) throw new IllegalStateException( "Unable to initialize Vungle: no activity provided" );

            final String appId = configuration.getString( "app_id", null );
            if ( appId == null ) throw new IllegalStateException( "Unable to initialize Vungle: no app key provided" );

            log( "Initializing..." );

            activity.runOnUiThread( new Runnable()
            {
                @Override
                public void run()
                {
                    try
                    {
                        vunglePub = VunglePub.getInstance();

                        vungleInitialized = vunglePub.init( activity, appId );
                        vunglePub.addEventListeners( AppLovinVungleMediationAdapter.this );

                        markEnabled();
                    }
                    catch ( Throwable th )
                    {
                        logger.e( tag, "Unable to initialize Vungle Adapter", th );
                        markDisabled();
                    }
                }
            } );
        }
        else if ( configuration.getBoolean( KEY_ATTACH ) )
        {
            log( "Using existing initialization..." );

            vunglePub = VunglePub.getInstance();
            vunglePub.addEventListeners( this );
            vungleInitialized = true;

            markEnabled();
        }
    }

    @Override
    public String getVersion()
    {
        return VunglePub.VERSION;
    }

    @Override
    protected boolean isInterstitialLoaded()
    {
        return vunglePub.isAdPlayable();
    }

    @Override
    protected void doLoadInterstitialAd(final Context context, final AppLovinMediationAdapterConfig configuration) {}

    @Override
    protected void doShowInterstitialAd(final AppLovinMediationAdapterConfig configuration, final Activity activity)
    {
        isShowingInterstitial = true;

        final AdConfig adConfig = createInterstitialAdConfig( configuration );
        vunglePub.playAd( adConfig );
    }

    @Override
    protected boolean isIncentivizedLoaded()
    {
        return vunglePub.isAdPlayable();
    }

    @Override
    protected void doLoadIncentivizedAd(final Context context, final AppLovinMediationAdapterConfig configuration) {}

    @Override
    protected void doShowIncentivizedAd(final AppLovinMediationAdapterConfig configuration, final Activity activity)
    {
        isShowingInterstitial = false;

        final AdConfig adConfig = createIncentivizedAdConfig( configuration );
        vunglePub.playAd( adConfig );
    }

    @Override
    public boolean isReady()
    {
        return super.isReady() && vungleInitialized;
    }

    // -------- EventListener ---------

    @Override
    public void onAdPlayableChanged(boolean isPlayable)
    {
        log( "Playable changed: " + isPlayable );

        if ( isPlayable )
        {
            markInterstitialAdLoaded();
            markIncentivizedAdLoaded();
        }
    }

    @Override
    public void onAdStart()
    {
        if ( isShowingInterstitial )
        {
            log( "Interstitial ad displayed" );
            markInterstitialAdDisplayed();
        }
        else
        {
            log( "Incentivized ad displayed" );
            markIncentivizedAdDisplayed();
        }
    }

    @Override
    public void onAdEnd(boolean wasSuccessfulView, boolean wasCallToActionClicked)
    {
        if ( wasCallToActionClicked )
        {
            if ( isShowingInterstitial )
            {
                log( "Interstitial ad clicked" );
                markInterstitialAdClicked();
            }
            else
            {
                log( "Incentivized ad clicked" );
                markIncentivizedAdClicked();
            }
        }

        // If we are showing incentivized ad
        if ( !isShowingInterstitial )
        {
            if ( wasSuccessfulView )
            {
                log( "Incentivized ad completed" );

                final Map<String, String> rewardInfo = createRewardInfo( configuration );
                markIncentivizedRewardVerified( rewardInfo );
            }
            else
            {
                log( "Incentivized ad failed to complete" );

                final Map<String, String> rejectionInfo = createEmptyRewardInfo();
                markIncentivizedRewardRejected( rejectionInfo );
            }
        }

        if ( isShowingInterstitial )
        {
            log( "Interstitial ad hidden" );
            markInterstitialAdHidden();
        }
        else
        {
            log( "Incentivized ad hidden" );
            markIncentivizedAdHidden();
        }
    }

    @Override
    public void onAdUnavailable(String s)
    {
        log( "Ad unavailable" );

        markInterstitialLoadFailed( AppLovinMediationErrorCode.NETWORK_NO_FILL );
        markIncentivizedLoadFailed( AppLovinMediationErrorCode.NETWORK_NO_FILL );
    }

    @Override
    public void onVideoView(final boolean isCompletedView, final int watchedMillis, final int videoMillis) {}

    private AdConfig createIncentivizedAdConfig(final AppLovinMediationAdapterConfig configuration)
    {
        final AdConfig result = createBaseAdConfig( configuration );
        result.setIncentivized( true );

        final String title = configuration.getString( "incent_title", null );
        if ( AppLovinSdkUtils.isValidString( title ) )
        {
            result.setIncentivizedCancelDialogTitle( title );
        }

        final String body = configuration.getString( "incent_body", null );
        if ( AppLovinSdkUtils.isValidString( body ) )
        {
            result.setIncentivizedCancelDialogBodyText( body );
        }

        final String closeButtonText = configuration.getString( "incent_close_button_text", null );
        if ( AppLovinSdkUtils.isValidString( closeButtonText ) )
        {
            result.setIncentivizedCancelDialogCloseButtonText( closeButtonText );
        }

        final String keepWatchingButtonText = configuration.getString( "incent_keep_watching_button_text", null );
        if ( AppLovinSdkUtils.isValidString( keepWatchingButtonText ) )
        {
            result.setIncentivizedCancelDialogKeepWatchingButtonText( keepWatchingButtonText );
        }

        final String userIdentifier = sdk.getUserIdentifier();
        if ( AppLovinSdkUtils.isValidString( userIdentifier ) )
        {
            result.setIncentivizedUserId( userIdentifier );
        }

        return result;
    }

    private AdConfig createInterstitialAdConfig(final AppLovinMediationAdapterConfig configuration)
    {
        final AdConfig result = createBaseAdConfig( configuration );
        result.setIncentivized( false );

        return result;
    }

    private AdConfig createBaseAdConfig(final AppLovinMediationAdapterConfig configuration)
    {
        final AdConfig result = new AdConfig();

        final String placement = configuration.getString( "placement", null );
        if ( AppLovinSdkUtils.isValidString( placement ) )
        {
            result.setPlacement( placement );
        }

        final String preferredOrientation = configuration.getString( "orientation_preference", null );
        if ( AppLovinSdkUtils.isValidString( preferredOrientation ) )
        {
            if ( "match_video".equalsIgnoreCase( preferredOrientation ) )
            {
                result.setOrientation( Orientation.matchVideo );
            }
            else if ( "auto_rotate".equalsIgnoreCase( preferredOrientation ) )
            {
                result.setOrientation( Orientation.autoRotate );
            }
        }

        final Boolean muted = configuration.getBoolean( KEY_MUTED, null );
        if ( muted != null )
        {
            result.setSoundEnabled( !muted );
        }

        final Boolean skipEnabled = configuration.getBoolean( "is_video_skippable", null );
        if ( skipEnabled != null )
        {
            result.setBackButtonImmediatelyEnabled( skipEnabled );
        }

        final Boolean immersiveModeEnabled = configuration.getBoolean( "video_immersive_mode_enabled", null );
        if ( immersiveModeEnabled != null )
        {
            result.setImmersiveMode( immersiveModeEnabled );
        }

        final Boolean standardFragmentTransitionAnimationEnabled = configuration.getBoolean( "standard_fragment_transition_animation_enabled", null );
        if ( standardFragmentTransitionAnimationEnabled != null )
        {
            result.setTransitionAnimationEnabled( standardFragmentTransitionAnimationEnabled );
        }

        return result;
    }
}
    
