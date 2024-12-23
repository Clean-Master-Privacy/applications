package com.applovin.mediation.impl;

import android.app.Activity;
import android.content.Context;

import com.applovin.mediation.AppLovinMediatedAdInfo;
import com.applovin.mediation.AppLovinMediationAdapterConfig;
import com.applovin.mediation.AppLovinMediationDisplayListener;
import com.applovin.mediation.AppLovinMediationErrorCode;
import com.applovin.mediation.AppLovinMediationLoadListener;
import com.applovin.sdk.AppLovinSdk;
import com.applovin.sdk.AppLovinSdkUtils;
import com.inmobi.ads.InMobiAdRequestStatus;
import com.inmobi.ads.InMobiInterstitial;
import com.inmobi.rendering.InMobiAdActivity;
import com.inmobi.sdk.InMobiSdk;

import java.util.Map;

/**
 * This is a mediation adapter for the Heyzap Ad SDK
 * <p>
 * Created by basil on 12/13/16.
 */

public class AppLovinInMobiMediationAdapter
        extends MediationAdapterBase
{
    private Activity rootActivity;

    @Override
    public void initialize(final AppLovinMediationAdapterConfig configuration, final AppLovinSdk sdk, final Activity activity) throws Exception
    {
        super.initialize( configuration, sdk, activity );

        // Check input
        if ( activity == null ) throw new IllegalArgumentException( "No activity specified" );

        // Check existence of SDK classes
        checkExistence( InMobiSdk.class, InMobiInterstitial.class, InMobiInterstitial.InterstitialAdListener2.class );

        // Check existence of SDK activities
        checkActivities( InMobiAdActivity.class );

        // If we should automatically initialize the adapter
        if ( configuration.getBoolean( KEY_INIT ) )
        {
            log( "Initializing..." );

            rootActivity = activity;

            // First, figure out the app ID
            final String accountId = configuration.getString( "account_id", null );
            if ( accountId == null ) throw new IllegalArgumentException( "Unable to initialize InMobi: no account ID found" );

            final String interstitialPlacementId = configuration.getString( KEY_INTERSTITIAL_PLACEMENT_ID, null );
            final String incentivizedPlacementId = configuration.getString( KEY_INCENTIVIZED_PLACEMENT_ID, null );
            if ( !AppLovinSdkUtils.isValidString( interstitialPlacementId ) && !AppLovinSdkUtils.isValidString( incentivizedPlacementId ) ) throw new IllegalArgumentException( "Unable to initialize InMobi: no placement id found" );

            final String logLevel = configuration.getString( "log_level", null );
            if ( AppLovinSdkUtils.isValidString( logLevel ) )
            {
                if ( "debug".equalsIgnoreCase( logLevel ) )
                {
                    InMobiSdk.setLogLevel( InMobiSdk.LogLevel.DEBUG );
                }
                else if ( "error".equalsIgnoreCase( logLevel ) )
                {
                    InMobiSdk.setLogLevel( InMobiSdk.LogLevel.ERROR );
                }
                else if ( "none".equalsIgnoreCase( logLevel ) )
                {
                    InMobiSdk.setLogLevel( InMobiSdk.LogLevel.NONE );
                }
            }

            rootActivity.runOnUiThread( new Runnable()
            {
                @Override
                public void run()
                {
                    try
                    {
                        InMobiSdk.init( rootActivity, accountId );

                        markEnabled();
                    }
                    catch ( Throwable th )
                    {
                        logger.e( tag, "Unable to initialize InMobi SDK", th );

                        markDisabled();
                    }
                }
            } );
        }
        else if ( configuration.getBoolean( KEY_ATTACH ) )
        {
            log( "Using existing initialization..." );

            rootActivity = activity;

            markEnabled();
        }
    }

    @Override
    public String getVersion()
    {
        return InMobiSdk.getVersion();
    }

    @Override
    public void prepareInterstitialAd(final AppLovinMediationAdapterConfig configuration, final Context context) {}

    @Override
    public void loadInterstitialAd(final AppLovinMediationAdapterConfig configuration, final Context context, final AppLovinMediationLoadListener loadListener)
    {
        log( "Loading interstitial ad..." );
        loadInMobiAd( KEY_INTERSTITIAL_PLACEMENT_ID, configuration, loadListener );
    }

    @Override
    public void showInterstitialAd(final AppLovinMediatedAdInfo adInfo, final AppLovinMediationAdapterConfig configuration, final Activity activity, final AppLovinMediationDisplayListener displayListener)
    {
        log( "Showing interstitial ad..." );
        showInMobiAd( adInfo, displayListener );
    }

    @Override
    public void prepareIncentivizedAd(final AppLovinMediationAdapterConfig configuration, final Context context) {}

    @Override
    public void loadIncentivizedAd(final AppLovinMediationAdapterConfig configuration, final Context context, final AppLovinMediationLoadListener loadListener)
    {
        log( "Loading incentivized ad..." );
        loadInMobiAd( KEY_INCENTIVIZED_PLACEMENT_ID, configuration, loadListener );
    }

    @Override
    public void showIncentivizedAd(final AppLovinMediatedAdInfo adInfo, final AppLovinMediationAdapterConfig configuration, final Activity activity, final AppLovinMediationDisplayListener displayListener)
    {
        log( "Showing incentivized ad..." );
        showInMobiAd( adInfo, displayListener );
    }

    private void loadInMobiAd(final String placementKeyName, AppLovinMediationAdapterConfig configuration, AppLovinMediationLoadListener loadListener)
    {
        final long placementId = configuration.getLong( placementKeyName, 0 );
        if ( placementId < 1 ) throw new IllegalArgumentException( "No placement specified for " + placementKeyName );

        final InterstitialListenerAdapter adapter = new InterstitialListenerAdapter( configuration );
        adapter.loadListener = loadListener;

        final InMobiInterstitial interstitial = new InMobiInterstitial( rootActivity, placementId, adapter );
        interstitial.load();
    }

    private void showInMobiAd(final AppLovinMediatedAdInfo ad, final AppLovinMediationDisplayListener displayListener)
    {
        final AdWrapper adWrapper = fromMediatedAd( AdWrapper.class, ad );
        if ( adWrapper != null )
        {
            if ( adWrapper.interstitial.isReady() )
            {
                adWrapper.listenerAdapter.displayListener = displayListener;
                adWrapper.listenerAdapter.mediatedAd = ad;
                adWrapper.interstitial.show();
            }
            else
            {
                log( "Unable to show InMobi ad: not loaded" );

                // Ad load failed
                if ( displayListener != null ) displayListener.failedToDisplayAd( ad, AppLovinMediationErrorCode.NETWORK_DISPLAY_INVALID_STATE );
            }
        }
        else
        {
            log( "Unable to show InMobi ad: no ad wrapper provided" );

            // Ad load failed
            if ( displayListener != null ) displayListener.failedToDisplayAd( ad, AppLovinMediationErrorCode.NETWORK_DISPLAY_INVALID_STATE );
        }
    }

    private static AppLovinMediationErrorCode toAppLovinError(final InMobiAdRequestStatus inMobiAdRequestStatus)
    {
        if ( InMobiAdRequestStatus.StatusCode.NETWORK_UNREACHABLE.equals( inMobiAdRequestStatus ) )
        {
            return AppLovinMediationErrorCode.NETWORK_NO_CONNECTION;
        }
        else if ( InMobiAdRequestStatus.StatusCode.NO_FILL.equals( inMobiAdRequestStatus ) )
        {
            return AppLovinMediationErrorCode.NETWORK_NO_FILL;
        }
        else if ( InMobiAdRequestStatus.StatusCode.REQUEST_INVALID.equals( inMobiAdRequestStatus ) )
        {
            return AppLovinMediationErrorCode.NETWORK_BAD_REQUEST;
        }
        else if ( InMobiAdRequestStatus.StatusCode.REQUEST_PENDING.equals( inMobiAdRequestStatus ) )
        {
            return AppLovinMediationErrorCode.NETWORK_INVALID_STATE;
        }
        else if ( InMobiAdRequestStatus.StatusCode.REQUEST_TIMED_OUT.equals( inMobiAdRequestStatus ) )
        {
            return AppLovinMediationErrorCode.NETWORK_TIMEOUT;
        }
        else if ( InMobiAdRequestStatus.StatusCode.INTERNAL_ERROR.equals( inMobiAdRequestStatus ) )
        {
            return AppLovinMediationErrorCode.NETWORK_INTERNAL_ERROR;
        }
        else if ( InMobiAdRequestStatus.StatusCode.SERVER_ERROR.equals( inMobiAdRequestStatus ) )
        {
            return AppLovinMediationErrorCode.NETWORK_SERVER_ERROR;
        }
        else if ( InMobiAdRequestStatus.StatusCode.AD_ACTIVE.equals( inMobiAdRequestStatus ) )
        {
            return AppLovinMediationErrorCode.NETWORK_DISPLAY_INVALID_STATE;
        }
        else if ( InMobiAdRequestStatus.StatusCode.EARLY_REFRESH_REQUEST.equals( inMobiAdRequestStatus ) )
        {
            return AppLovinMediationErrorCode.NETWORK_DISPLAY_INVALID_STATE;
        }
        else if ( InMobiAdRequestStatus.StatusCode.AD_NO_LONGER_AVAILABLE.equals( inMobiAdRequestStatus ) )
        {
            return AppLovinMediationErrorCode.NETWORK_DISPLAY_INVALID_STATE;
        }
        else
        {
            return AppLovinMediationErrorCode.NETWORK_UNSPECIFIED;
        }
    }

    /**
     * This is a wrapper class that couples an interstitial with its respective listener.
     */
    private static class AdWrapper
    {
        private InMobiInterstitial          interstitial;
        private InterstitialListenerAdapter listenerAdapter;

        public AdWrapper(final InMobiInterstitial interstitial, final InterstitialListenerAdapter listenerAdapter)
        {
            this.interstitial = interstitial;
            this.listenerAdapter = listenerAdapter;
        }
    }

    private class InterstitialListenerAdapter
            implements InMobiInterstitial.InterstitialAdListener2
    {
        private final AppLovinMediationAdapterConfig configuration;

        private AppLovinMediationLoadListener    loadListener;
        private AppLovinMediationDisplayListener displayListener;
        private AppLovinMediatedAdInfo           mediatedAd;

        private InterstitialListenerAdapter(final AppLovinMediationAdapterConfig configuration)
        {
            this.configuration = configuration;
        }

        @Override
        public void onAdLoadFailed(InMobiInterstitial inMobiInterstitial, InMobiAdRequestStatus inMobiAdRequestStatus)
        {
            if ( loadListener != null ) loadListener.failedToLoadAd( toAppLovinError( inMobiAdRequestStatus ) );
        }

        @Override
        public void onAdLoadSucceeded(InMobiInterstitial inMobiInterstitial)
        {
            final AdWrapper wrapper = new AdWrapper( inMobiInterstitial, this );
            if ( loadListener != null ) loadListener.adLoaded( toMediatedAd( wrapper, AdWrapper.class ) );
        }

        @Override
        public void onAdReceived(InMobiInterstitial inMobiInterstitial) {}

        @Override
        public void onAdRewardActionCompleted(InMobiInterstitial inMobiInterstitial, Map<Object, Object> map)
        {
            final Map<String, String> rewardInfo = createRewardInfo( configuration );
            if ( displayListener != null ) displayListener.rewardVerified( mediatedAd, rewardInfo );
        }

        @Override
        public void onAdDisplayFailed(InMobiInterstitial inMobiInterstitial)
        {
            if ( displayListener != null ) displayListener.failedToDisplayAd( mediatedAd, AppLovinMediationErrorCode.NETWORK_DISPLAY_UNSPECIFIED );
        }

        @Override
        public void onAdWillDisplay(InMobiInterstitial inMobiInterstitial) {}

        @Override
        public void onAdDisplayed(InMobiInterstitial inMobiInterstitial)
        {
            if ( displayListener != null ) displayListener.adDisplayed( mediatedAd );
        }

        @Override
        public void onAdInteraction(InMobiInterstitial inMobiInterstitial, Map<Object, Object> map)
        {
            if ( displayListener != null ) displayListener.adClicked( mediatedAd );
        }

        @Override
        public void onAdDismissed(InMobiInterstitial inMobiInterstitial)
        {
            if ( displayListener != null ) displayListener.adHidden( mediatedAd );
        }

        @Override
        public void onUserLeftApplication(InMobiInterstitial inMobiInterstitial) {}
    }
}
