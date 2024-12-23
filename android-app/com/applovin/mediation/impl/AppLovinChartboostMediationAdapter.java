package com.applovin.mediation.impl;

import android.app.Activity;
import android.content.Context;

import com.applovin.mediation.AppLovinMediationAdapterConfig;
import com.applovin.mediation.AppLovinMediationErrorCode;
import com.applovin.sdk.AppLovinSdk;
import com.chartboost.sdk.CBImpressionActivity;
import com.chartboost.sdk.Chartboost;
import com.chartboost.sdk.ChartboostDelegate;
import com.chartboost.sdk.Libraries.CBLogging;
import com.chartboost.sdk.Model.CBError;

import java.util.Map;

/**
 * This is a mediation adapter for Chartboost Ad SDK
 * <p>
 * Created by basil on 12/5/16.
 */

public class AppLovinChartboostMediationAdapter
        extends GlobalListenerAdapterBase
{
    private static final String PLACEMENT_INTERSTITIAL = "applovin_interstitial";
    private static final String PLACEMENT_INCENTIVIZED = "applovin_incentivized";

    private AppLovinChartboostDelegate chartboostDelegate;

    @Override
    public void initialize(final AppLovinMediationAdapterConfig configuration, final AppLovinSdk sdk, final Activity activity) throws Exception
    {
        super.initialize( configuration, sdk, activity );

        // Check existence of SDK classes
        checkExistence( Chartboost.class, ChartboostDelegate.class );

        // Check existence of SDK activities
        checkActivities( CBImpressionActivity.class );

        chartboostDelegate = new AppLovinChartboostDelegate( configuration );

        // If we should automatically initialize the adapter
        if ( configuration.getBoolean( KEY_INIT ) )
        {
            log( "Initializing..." );

            if ( activity == null ) throw new IllegalStateException( "Unable to initialize Chartboost: no activity provided" );

            final String appId = configuration.getString( "app_id", null );
            if ( appId == null ) throw new IllegalStateException( "Unable to initialize Chartboost: no app id provided" );

            final String appSignature = configuration.getString( "app_signature", null );
            if ( appSignature == null ) throw new IllegalStateException( "Unable to initialize Chartboost: no app signature provided" );

            if ( configuration.getBoolean( "log_all" ) )
            {
                Chartboost.setLoggingLevel( CBLogging.Level.ALL );
            }

            activity.runOnUiThread( new Runnable()
            {
                @Override
                public void run()
                {
                    try
                    {
                        Chartboost.startWithAppId( activity, appId, appSignature );

                        Chartboost.onCreate( activity );

                        final Boolean shouldRequestInterstitialsInFirstSession = configuration.getBoolean( "request_interstitial_in_first_session", null );
                        if ( shouldRequestInterstitialsInFirstSession != null )
                        {
                            Chartboost.setShouldRequestInterstitialsInFirstSession( shouldRequestInterstitialsInFirstSession );
                        }

                        final Boolean autoCacheAds = configuration.getBoolean( "auto_cache_ads", null );
                        if ( autoCacheAds != null )
                        {
                            Chartboost.setAutoCacheAds( autoCacheAds );
                        }

                        final Boolean shouldPrefetchVideoContent = configuration.getBoolean( "should_prefetch_video_content", null );
                        if ( shouldPrefetchVideoContent != null )
                        {
                            Chartboost.setShouldPrefetchVideoContent( shouldPrefetchVideoContent );
                        }

                        final Boolean shouldHideSystemUI = configuration.getBoolean( "should_hide_system_ui", null );
                        if ( shouldHideSystemUI != null )
                        {
                            Chartboost.setShouldHideSystemUI( shouldHideSystemUI );
                        }

                        Chartboost.setDelegate( chartboostDelegate );

                        Chartboost.onStart( activity );
                        Chartboost.onResume( activity );

                        Chartboost.cacheInterstitial( PLACEMENT_INTERSTITIAL );
                        Chartboost.cacheRewardedVideo( PLACEMENT_INCENTIVIZED );

                        markEnabled();
                    }
                    catch ( Throwable th )
                    {
                        logger.e( tag, "Unable to initialize Chartboost SDK", th );
                        markDisabled();
                    }
                }
            } );
        }
        else if ( configuration.getBoolean( KEY_ATTACH ) )
        {
            log( "Using existing initialization..." );

            Chartboost.setDelegate( chartboostDelegate );
            markEnabled();
        }
    }

    @Override
    public String getVersion()
    {
        return Chartboost.getSDKVersion();
    }

    @Override
    protected boolean isInterstitialLoaded()
    {
        Chartboost.setDelegate( chartboostDelegate );
        return Chartboost.hasInterstitial( PLACEMENT_INTERSTITIAL );
    }

    @Override
    protected void doLoadInterstitialAd(final Context context, final AppLovinMediationAdapterConfig configuration)
    {
        Chartboost.setDelegate( chartboostDelegate );
        Chartboost.cacheInterstitial( PLACEMENT_INTERSTITIAL );
    }

    @Override
    protected void doShowInterstitialAd(final AppLovinMediationAdapterConfig configuration, final Activity activity)
    {
        Chartboost.setDelegate( chartboostDelegate );
        Chartboost.showInterstitial( PLACEMENT_INTERSTITIAL );
    }

    @Override
    protected boolean isIncentivizedLoaded()
    {
        Chartboost.setDelegate( chartboostDelegate );
        return Chartboost.hasRewardedVideo( PLACEMENT_INCENTIVIZED );
    }

    @Override
    protected void doLoadIncentivizedAd(final Context context, final AppLovinMediationAdapterConfig configuration)
    {

        Chartboost.setDelegate( chartboostDelegate );
        Chartboost.cacheRewardedVideo( PLACEMENT_INCENTIVIZED );
    }

    @Override
    protected void doShowIncentivizedAd(final AppLovinMediationAdapterConfig configuration, final Activity activity)
    {
        Chartboost.setDelegate( chartboostDelegate );

        Chartboost.onStart( activity );
        Chartboost.showRewardedVideo( PLACEMENT_INCENTIVIZED );
    }

    private class AppLovinChartboostDelegate
            extends ChartboostDelegate
    {
        private final AppLovinMediationAdapterConfig configuration;

        private AppLovinChartboostDelegate(final AppLovinMediationAdapterConfig configuration)
        {
            this.configuration = configuration;
        }

        @Override
        public void didCacheInterstitial(String location)
        {
            super.didCacheInterstitial( location );

            markInterstitialAdLoaded();
        }

        @Override
        public void didFailToLoadInterstitial(String location, CBError.CBImpressionError error)
        {
            super.didFailToLoadInterstitial( location, error );

            markInterstitialLoadFailed( toAppLovinError( error ) );
        }

        @Override
        public void didDisplayInterstitial(String location)
        {
            super.didDisplayInterstitial( location );

            markInterstitialAdDisplayed();
        }

        @Override
        public void didDismissInterstitial(String location)
        {
            super.didDismissInterstitial( location );

            markInterstitialAdHidden();
        }

        @Override
        public void didClickInterstitial(String location)
        {
            super.didClickInterstitial( location );

            markInterstitialAdClicked();
        }

        //
        // Incentivized Callbacks
        //

        @Override
        public void didCacheRewardedVideo(String location)
        {
            super.didCacheRewardedVideo( location );

            markIncentivizedAdLoaded();
        }

        @Override
        public void didFailToLoadRewardedVideo(String location, CBError.CBImpressionError error)
        {
            super.didFailToLoadRewardedVideo( location, error );

            markIncentivizedAdFailedToDisplay( toAppLovinError( error ) );
        }

        @Override
        public void didDisplayRewardedVideo(final String location)
        {
            super.didDisplayRewardedVideo( location );

            markIncentivizedAdDisplayed();
        }

        @Override
        public void didDismissRewardedVideo(String location)
        {
            super.didDismissRewardedVideo( location );

            markIncentivizedAdHidden();
        }

        @Override
        public void didClickRewardedVideo(String location)
        {
            super.didClickRewardedVideo( location );

            markIncentivizedAdClicked();
        }

        @Override
        public void didCompleteRewardedVideo(String location, int reward)
        {
            super.didCompleteRewardedVideo( location, reward );

            final Map<String, String> rewardInfo = createRewardInfo( reward, null, configuration );
            markIncentivizedRewardVerified( rewardInfo );
        }
    }

    private static AppLovinMediationErrorCode toAppLovinError(final CBError.CBImpressionError chartboostError)
    {
        if ( chartboostError == CBError.CBImpressionError.INTERNAL )
        {
            return AppLovinMediationErrorCode.NETWORK_UNSPECIFIED;
        }
        if ( chartboostError == CBError.CBImpressionError.INTERNET_UNAVAILABLE )
        {
            return AppLovinMediationErrorCode.NETWORK_NO_CONNECTION;
        }
        if ( chartboostError == CBError.CBImpressionError.TOO_MANY_CONNECTIONS )
        {
            return AppLovinMediationErrorCode.NETWORK_UNSPECIFIED;
        }
        if ( chartboostError == CBError.CBImpressionError.WRONG_ORIENTATION )
        {
            return AppLovinMediationErrorCode.NETWORK_INVALID_STATE;
        }
        if ( chartboostError == CBError.CBImpressionError.FIRST_SESSION_INTERSTITIALS_DISABLED )
        {
            return AppLovinMediationErrorCode.NETWORK_INVALID_STATE;
        }
        if ( chartboostError == CBError.CBImpressionError.NETWORK_FAILURE )
        {
            return AppLovinMediationErrorCode.NETWORK_UNSPECIFIED;
        }
        if ( chartboostError == CBError.CBImpressionError.NO_AD_FOUND )
        {
            return AppLovinMediationErrorCode.NETWORK_NO_FILL;
        }
        if ( chartboostError == CBError.CBImpressionError.SESSION_NOT_STARTED )
        {
            return AppLovinMediationErrorCode.NETWORK_INVALID_STATE;
        }
        if ( chartboostError == CBError.CBImpressionError.IMPRESSION_ALREADY_VISIBLE )
        {
            return AppLovinMediationErrorCode.NETWORK_INVALID_STATE;
        }
        if ( chartboostError == CBError.CBImpressionError.NO_HOST_ACTIVITY )
        {
            return AppLovinMediationErrorCode.NETWORK_DISPLAY_INVALID_STATE;
        }
        if ( chartboostError == CBError.CBImpressionError.USER_CANCELLATION )
        {
            return AppLovinMediationErrorCode.NETWORK_INVALID_STATE;
        }
        if ( chartboostError == CBError.CBImpressionError.INVALID_LOCATION )
        {
            return AppLovinMediationErrorCode.NETWORK_INVALID_STATE;
        }
        if ( chartboostError == CBError.CBImpressionError.VIDEO_UNAVAILABLE )
        {
            return AppLovinMediationErrorCode.NETWORK_NO_FILL;
        }
        if ( chartboostError == CBError.CBImpressionError.VIDEO_ID_MISSING )
        {
            return AppLovinMediationErrorCode.NETWORK_INVALID_STATE;
        }
        if ( chartboostError == CBError.CBImpressionError.ERROR_PLAYING_VIDEO )
        {
            return AppLovinMediationErrorCode.NETWORK_INTERNAL_ERROR;
        }
        if ( chartboostError == CBError.CBImpressionError.INVALID_RESPONSE )
        {
            return AppLovinMediationErrorCode.NETWORK_INVALID_STATE;
        }
        if ( chartboostError == CBError.CBImpressionError.ASSETS_DOWNLOAD_FAILURE )
        {
            return AppLovinMediationErrorCode.NETWORK_NO_CONNECTION;
        }
        if ( chartboostError == CBError.CBImpressionError.ERROR_CREATING_VIEW )
        {
            return AppLovinMediationErrorCode.NETWORK_DISPLAY_UNSPECIFIED;
        }
        if ( chartboostError == CBError.CBImpressionError.ERROR_DISPLAYING_VIEW )
        {
            return AppLovinMediationErrorCode.NETWORK_DISPLAY_UNSPECIFIED;
        }
        if ( chartboostError == CBError.CBImpressionError.INCOMPATIBLE_API_VERSION )
        {
            return AppLovinMediationErrorCode.NETWORK_INVALID_STATE;
        }
        if ( chartboostError == CBError.CBImpressionError.ERROR_LOADING_WEB_VIEW )
        {
            return AppLovinMediationErrorCode.NETWORK_DISPLAY_UNSPECIFIED;
        }
        if ( chartboostError == CBError.CBImpressionError.ASSET_PREFETCH_IN_PROGRESS )
        {
            return AppLovinMediationErrorCode.NETWORK_INVALID_STATE;
        }
        if ( chartboostError == CBError.CBImpressionError.EMPTY_LOCAL_AD_LIST )
        {
            return AppLovinMediationErrorCode.NETWORK_UNSPECIFIED;
        }
        if ( chartboostError == CBError.CBImpressionError.ACTIVITY_MISSING_IN_MANIFEST )
        {
            return AppLovinMediationErrorCode.NETWORK_UNSPECIFIED;
        }
        if ( chartboostError == CBError.CBImpressionError.EMPTY_LOCAL_VIDEO_LIST )
        {
            return AppLovinMediationErrorCode.NETWORK_NO_FILL;
        }
        if ( chartboostError == CBError.CBImpressionError.END_POINT_DISABLED )
        {
            return AppLovinMediationErrorCode.NETWORK_UNSPECIFIED;
        }
        if ( chartboostError == CBError.CBImpressionError.HARDWARE_ACCELERATION_DISABLED )
        {
            return AppLovinMediationErrorCode.NETWORK_UNSPECIFIED;
        }
        if ( chartboostError == CBError.CBImpressionError.PENDING_IMPRESSION_ERROR )
        {
            return AppLovinMediationErrorCode.NETWORK_INVALID_STATE;
        }
        else
        {
            return AppLovinMediationErrorCode.NETWORK_UNSPECIFIED;
        }
    }
}
