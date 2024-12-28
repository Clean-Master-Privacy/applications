    package com.applovin.mediation.impl;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;

import com.applovin.mediation.AppLovinMediatedAdInfo;
import com.applovin.mediation.AppLovinMediationAdapterConfig;
import com.applovin.mediation.AppLovinMediationDisplayListener;
import com.applovin.mediation.AppLovinMediationErrorCode;
import com.applovin.mediation.AppLovinMediationLoadListener;
import com.applovin.sdk.AppLovinSdk;
import com.applovin.sdk.AppLovinSdkUtils;
import com.mopub.common.MoPub;
import com.mopub.common.MoPubReward;
import com.mopub.mobileads.MoPubActivity;
import com.mopub.mobileads.MoPubErrorCode;
import com.mopub.mobileads.MoPubInterstitial;
import com.mopub.mobileads.MoPubRewardedVideoListener;
import com.mopub.mobileads.MoPubRewardedVideos;

import java.util.Map;
import java.util.Set;

/**
 * This is a mediation adapter for the MoPub Ad SDK Created by basil on 12/7/16.
 */
public class AppLovinMoPubMediationAdapter
        extends MediationAdapterBase
{
    private static final String INCENT_AD_UNIT_ID = "incent_ad_unit_id";
    private static final String INTER_AD_UNIT_ID  = "inter_ad_unit_id";

    private Activity rootActivity;

    @Override
    public void initialize(final AppLovinMediationAdapterConfig configuration, final AppLovinSdk sdk, final Activity activity) throws Exception
    {
        super.initialize( configuration, sdk, activity );

        // Check existence of SDK classes
        checkExistence( MoPub.class, MoPubReward.class, MoPubInterstitial.class, MoPubRewardedVideoListener.class );

        // Check existence of SDK activities
        checkActivities( MoPubActivity.class );

        // If we should automatically initialize the adapter
        if ( configuration.getBoolean( KEY_INIT ) )
        {
            log( "Initializing..." );

            if ( activity == null ) throw new IllegalStateException( "Unable to initialize MoPub: no activity provided" );

            this.rootActivity = activity;

            activity.runOnUiThread( new Runnable()
            {
                @Override
                public void run()
                {
                    try
                    {
                        if ( configuration.getString( INCENT_AD_UNIT_ID, null ) != null )
                        {
                            MoPubRewardedVideos.initializeRewardedVideo( activity );
                        }

                        markEnabled();
                    }
                    catch ( Throwable th )
                    {
                        logger.e( tag, "Unable to initialize MoPub SDK", th );
                        markDisabled();
                    }
                }
            } );
        }
        else if ( configuration.getBoolean( KEY_ATTACH ) )
        {
            log( "Using existing initialization..." );

            if ( activity == null ) throw new IllegalStateException( "Unable to initialize MoPub: no activity provided" );

            this.rootActivity = activity;

            markEnabled();
        }
    }

    @Override
    public String getVersion()
    {
        return MoPub.SDK_VERSION;
    }

    @Override
    public void prepareInterstitialAd(final AppLovinMediationAdapterConfig configuration, final Context context) {}

    @Override
    public void loadInterstitialAd(final AppLovinMediationAdapterConfig configuration, final Context context, final AppLovinMediationLoadListener loadListener)
    {
        log( "Loading interstitial ad..." );

        final String adUnitId = configuration.getString( INTER_AD_UNIT_ID, null );
        if ( !AppLovinSdkUtils.isValidString( adUnitId ) ) throw new IllegalArgumentException( "Unable to load MoPub: no intersitial ad unit id found" );

        rootActivity.runOnUiThread( new Runnable()
        {
            @Override
            public void run()
            {
                try
                {
                    final MoPubInterstitial interstitial = new MoPubInterstitial( rootActivity, adUnitId );
                    interstitial.setInterstitialAdListener( new InterstitialAdListenerAdapter()
                    {
                        @Override
                        public void onInterstitialLoaded(MoPubInterstitial moPubInterstitial)
                        {
                            super.onInterstitialLoaded( moPubInterstitial );

                            if ( loadListener != null ) loadListener.adLoaded( toMediatedAd( interstitial, MoPubInterstitial.class ) );
                        }

                        @Override
                        public void onInterstitialFailed(MoPubInterstitial moPubInterstitial, MoPubErrorCode moPubErrorCode)
                        {
                            super.onInterstitialFailed( moPubInterstitial, moPubErrorCode );

                            if ( loadListener != null ) loadListener.failedToLoadAd( toAppLovinError( moPubErrorCode ) );
                        }
                    } );
                    interstitial.load();
                }
                catch ( Throwable th )
                {
                    logger.e( tag, "Unable to load MoPub SDK ad", th );

                    markDisabled();
                }
            }
        } );
    }

    @Override
    public void showInterstitialAd(final AppLovinMediatedAdInfo adInfo, final AppLovinMediationAdapterConfig configuration, final Activity activity, final AppLovinMediationDisplayListener displayListener)
    {
        // Check input
        if ( adInfo == null ) throw new IllegalArgumentException( "No ad info specified" );

        final MoPubInterstitial interstitialAd = fromMediatedAd( MoPubInterstitial.class, adInfo );
        if ( interstitialAd != null )
        {
            log( "Showing interstitial ad..." );
            if ( interstitialAd.isReady() )
            {
                interstitialAd.setInterstitialAdListener( new InterstitialAdListenerAdapter()
                {
                    @Override
                    public void onInterstitialShown(MoPubInterstitial moPubInterstitial)
                    {
                        if ( displayListener != null ) displayListener.adDisplayed( adInfo );
                    }

                    @Override
                    public void onInterstitialClicked(MoPubInterstitial moPubInterstitial)
                    {
                        if ( displayListener != null ) displayListener.adClicked( adInfo );
                    }

                    @Override
                    public void onInterstitialDismissed(MoPubInterstitial moPubInterstitial)
                    {
                        if ( displayListener != null ) displayListener.adHidden( adInfo );
                    }
                } );
                interstitialAd.show();
            }
            else
            {
                log( "Unable to show Mopub ad: interstitial not loaded" );

                // Ad load failed
                if ( displayListener != null ) displayListener.failedToDisplayAd( adInfo, AppLovinMediationErrorCode.NETWORK_DISPLAY_INVALID_STATE );
            }
        }
        else
        {
            log( "Unable to show Mopub ad: no interstitial provided" );

            // Ad load failed
            if ( displayListener != null ) displayListener.failedToDisplayAd( adInfo, AppLovinMediationErrorCode.NETWORK_DISPLAY_INVALID_STATE );
        }
    }

    @Override
    public void prepareIncentivizedAd(final AppLovinMediationAdapterConfig configuration, final Context context) {}

    @Override
    public void loadIncentivizedAd(final AppLovinMediationAdapterConfig configuration, final Context context, final AppLovinMediationLoadListener loadListener)
    {
        log( "Loading incentivized ad..." );

        final String adUnitId = configuration.getString( INCENT_AD_UNIT_ID, null );
        if ( !AppLovinSdkUtils.isValidString( adUnitId ) ) throw new IllegalArgumentException( "Unable to initialize Mopub: no incentivized ad unit id found" );

        if ( MoPubRewardedVideos.hasRewardedVideo( adUnitId ) )
        {
            log( "Incentivized already loaded" );

            if ( loadListener != null ) loadListener.adLoaded( null );
        }
        else
        {
            MoPubRewardedVideos.setRewardedVideoListener( new MoPubRewardedVideoListenerAdapter()
            {
                @Override
                public void onRewardedVideoLoadSuccess(@NonNull String s)
                {
                    if ( loadListener != null ) loadListener.adLoaded( null );
                }

                @Override
                public void onRewardedVideoLoadFailure(@NonNull String s, @NonNull MoPubErrorCode moPubErrorCode)
                {
                    if ( loadListener != null ) loadListener.failedToLoadAd( toAppLovinError( moPubErrorCode ) );
                }
            } );
            MoPubRewardedVideos.loadRewardedVideo( adUnitId );
        }
    }

    @Override
    public void showIncentivizedAd(final AppLovinMediatedAdInfo ad, final AppLovinMediationAdapterConfig configuration, final Activity activity, final AppLovinMediationDisplayListener displayListener)
    {
        log( "Showing incentivized ad..." );

        final String adUnitId = configuration.getString( INCENT_AD_UNIT_ID, null );
        if ( !AppLovinSdkUtils.isValidString( adUnitId ) )
            throw new IllegalArgumentException( "Unable to initialize Mopub: no incentivized ad unit id found" );

        if ( MoPubRewardedVideos.hasRewardedVideo( adUnitId ) )
        {
            MoPubRewardedVideos.setRewardedVideoListener( new MoPubRewardedVideoListenerAdapter()
            {
                @Override
                public void onRewardedVideoClosed(@NonNull String adUnitId)
                {
                    if ( displayListener != null ) displayListener.adHidden( ad );
                }

                @Override
                public void onRewardedVideoCompleted(@NonNull Set<String> adUnitIds, @NonNull MoPubReward moPubReward)
                {
                    if ( moPubReward != null && moPubReward.isSuccessful() )
                    {
                        final Map<String, String> rewardInfo = createRewardInfo( moPubReward.getAmount(), moPubReward.getLabel(), configuration );

                        if ( displayListener != null ) displayListener.rewardVerified( ad, rewardInfo );
                    }
                    else
                    {
                        final Map<String, String> rejectionInfo = createEmptyRewardInfo();
                        if ( displayListener != null ) displayListener.rewardRejected( ad, rejectionInfo );
                    }
                }

                @Override
                public void onRewardedVideoStarted(@NonNull String adUnitId)
                {
                    if ( displayListener != null )
                    {
                        displayListener.adDisplayed( ad );
                    }
                }
            } );
            MoPubRewardedVideos.showRewardedVideo( adUnitId );
        }
        else
        {
            log( "Unable to show Mopub ad: incentivized ad not loaded" );

            // Ad load failed
            if ( displayListener != null ) displayListener.failedToDisplayAd( ad, AppLovinMediationErrorCode.NETWORK_DISPLAY_INVALID_STATE );
        }
    }

    private static AppLovinMediationErrorCode toAppLovinError(final MoPubErrorCode moPubErrorCode)
    {
        if ( moPubErrorCode == MoPubErrorCode.NO_FILL )
        {
            return AppLovinMediationErrorCode.NETWORK_NO_FILL;
        }
        else if ( moPubErrorCode == MoPubErrorCode.WARMUP )
        {
            return AppLovinMediationErrorCode.NETWORK_INVALID_STATE;
        }
        else if ( moPubErrorCode == MoPubErrorCode.SERVER_ERROR )
        {
            return AppLovinMediationErrorCode.NETWORK_TIMEOUT;
        }
        else if ( moPubErrorCode == MoPubErrorCode.INTERNAL_ERROR )
        {
            return AppLovinMediationErrorCode.NETWORK_INTERNAL_ERROR;
        }
        else if ( moPubErrorCode == MoPubErrorCode.CANCELLED )
        {
            return AppLovinMediationErrorCode.NETWORK_INVALID_STATE;
        }
        else if ( moPubErrorCode == MoPubErrorCode.NO_CONNECTION )
        {
            return AppLovinMediationErrorCode.NETWORK_NO_CONNECTION;
        }
        else if ( moPubErrorCode == MoPubErrorCode.ADAPTER_NOT_FOUND )
        {
            return AppLovinMediationErrorCode.NETWORK_INVALID_STATE;
        }
        else if ( moPubErrorCode == MoPubErrorCode.ADAPTER_CONFIGURATION_ERROR )
        {
            return AppLovinMediationErrorCode.NETWORK_INVALID_STATE;
        }
        else if ( moPubErrorCode == MoPubErrorCode.NETWORK_TIMEOUT )
        {
            return AppLovinMediationErrorCode.NETWORK_TIMEOUT;
        }
        else if ( moPubErrorCode == MoPubErrorCode.NETWORK_NO_FILL )
        {
            return AppLovinMediationErrorCode.NETWORK_NO_FILL;
        }
        else if ( moPubErrorCode == MoPubErrorCode.NETWORK_INVALID_STATE )
        {
            return AppLovinMediationErrorCode.NETWORK_INVALID_STATE;
        }
        else if ( moPubErrorCode == MoPubErrorCode.MRAID_LOAD_ERROR )
        {
            return AppLovinMediationErrorCode.NETWORK_INTERNAL_ERROR;
        }
        else if ( moPubErrorCode == MoPubErrorCode.VIDEO_CACHE_ERROR )
        {
            return AppLovinMediationErrorCode.NETWORK_INTERNAL_ERROR;
        }
        else if ( moPubErrorCode == MoPubErrorCode.VIDEO_DOWNLOAD_ERROR )
        {
            return AppLovinMediationErrorCode.NETWORK_INTERNAL_ERROR;
        }
        else if ( moPubErrorCode == MoPubErrorCode.VIDEO_NOT_AVAILABLE )
        {
            return AppLovinMediationErrorCode.NETWORK_INTERNAL_ERROR;
        }
        else if ( moPubErrorCode == MoPubErrorCode.VIDEO_PLAYBACK_ERROR )
        {
            return AppLovinMediationErrorCode.NETWORK_INTERNAL_ERROR;
        }
        else if ( moPubErrorCode == MoPubErrorCode.UNSPECIFIED )
        {
            return AppLovinMediationErrorCode.NETWORK_UNSPECIFIED;
        }
        else
        {
            return AppLovinMediationErrorCode.NETWORK_UNSPECIFIED;
        }
    }

    private static class InterstitialAdListenerAdapter
            implements MoPubInterstitial.InterstitialAdListener
    {
        @Override
        public void onInterstitialLoaded(MoPubInterstitial moPubInterstitial) {}

        @Override
        public void onInterstitialFailed(MoPubInterstitial moPubInterstitial, MoPubErrorCode moPubErrorCode) {}

        @Override
        public void onInterstitialShown(MoPubInterstitial moPubInterstitial) {}

        @Override
        public void onInterstitialClicked(MoPubInterstitial moPubInterstitial) {}

        @Override
        public void onInterstitialDismissed(MoPubInterstitial moPubInterstitial) {}
    }

    private static class MoPubRewardedVideoListenerAdapter
            implements MoPubRewardedVideoListener
    {
        @Override
        public void onRewardedVideoLoadSuccess(@NonNull String s) {}

        @Override
        public void onRewardedVideoLoadFailure(@NonNull String s, @NonNull MoPubErrorCode moPubErrorCode) {}

        @Override
        public void onRewardedVideoStarted(@NonNull String s) {}

        @Override
        public void onRewardedVideoPlaybackError(@NonNull String s, @NonNull MoPubErrorCode moPubErrorCode) {}

        @Override
        public void onRewardedVideoClosed(@NonNull String s) {}

        @Override
        public void onRewardedVideoCompleted(@NonNull Set<String> set, @NonNull MoPubReward moPubReward) {}
    }
}
    
