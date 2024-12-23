package com.applovin.mediation.impl;

import android.app.Activity;
import android.content.Context;

import com.applovin.mediation.AppLovinMediationAdapterConfig;
import com.applovin.mediation.AppLovinMediationErrorCode;
import com.applovin.sdk.AppLovinSdk;
import com.applovin.sdk.AppLovinSdkUtils;
import com.ironsource.mediationsdk.IronSource;
import com.ironsource.mediationsdk.integration.IntegrationHelper;
import com.ironsource.mediationsdk.logger.IronSourceError;
import com.ironsource.mediationsdk.logger.IronSourceLogger;
import com.ironsource.mediationsdk.logger.LogListener;
import com.ironsource.mediationsdk.model.Placement;
import com.ironsource.mediationsdk.sdk.InterstitialListener;
import com.ironsource.mediationsdk.sdk.RewardedVideoListener;
import com.ironsource.sdk.controller.ControllerActivity;
import com.ironsource.sdk.controller.InterstitialActivity;
import com.ironsource.sdk.controller.OpenUrlActivity;
import com.ironsource.sdk.utils.IronSourceSharedPrefHelper;

import java.util.Map;

/**
 * This is a mediation adapter for the IronSource Ad SDK
 * <p>
 * <p>
 * Created by basil on 12/1/16.
 */

public class AppLovinIronSourceMediationAdapter
        extends GlobalListenerAdapterBase
        implements InterstitialListener, RewardedVideoListener
{

    private AppLovinMediationAdapterConfig configuration;

    // --------- AppLovinMediationAdapter ---------

    @Override
    public void initialize(final AppLovinMediationAdapterConfig configuration, final AppLovinSdk sdk, final Activity activity) throws Exception
    {

        super.initialize( configuration, sdk, activity );

        // Check existence of SDK classes
        checkExistence( IronSource.class, InterstitialListener.class, RewardedVideoListener.class );

        // Check existence of SDK activities
        checkActivities( ControllerActivity.class, InterstitialActivity.class, OpenUrlActivity.class );

        this.configuration = configuration;

        if ( configuration.getBoolean( KEY_INIT ) )
        {
            log( "Initializing..." );

            if ( activity == null ) throw new IllegalStateException( "Unable to initialize IronSource: no activity provided" );

            final String appKey = configuration.getString( "app_key", null );
            if ( appKey == null ) throw new IllegalStateException( "Unable to initialize IronSource: no app key provided" );

            if ( configuration.getBoolean( "log_all" ) )
            {
                IronSource.setLogListener( new LogListener()
                {
                    @Override
                    public void onLog(final IronSourceLogger.IronSourceTag ironSourceTag, final String s, final int i)
                    {
                        log( "<IronSource> : " + s );
                    }
                } );
            }

            if ( configuration.getBoolean( "validate_integration" ) )
            {
                IntegrationHelper.validateIntegration( activity );
            }

            IronSource.setInterstitialListener( this );
            IronSource.setRewardedVideoListener( this );

            IronSource.init( activity, appKey, IronSource.AD_UNIT.INTERSTITIAL, IronSource.AD_UNIT.REWARDED_VIDEO );

            markEnabled();
        }
        else if ( configuration.getBoolean( KEY_ATTACH ) )
        {
            log( "Using existing initialization..." );

            markEnabled();
        }
    }

    @Override
    public String getVersion()
    {
        return IronSourceSharedPrefHelper.getSupersonicPrefHelper().getCurrentSDKVersion();
    }

    @Override
    protected boolean isInterstitialLoaded()
    {
        return IronSource.isInterstitialReady();
    }

    @Override
    protected boolean isIncentivizedLoaded()
    {
        return IronSource.isRewardedVideoAvailable();
    }

    @Override
    protected void doLoadInterstitialAd(final Context context, final AppLovinMediationAdapterConfig configuration)
    {
        IronSource.setInterstitialListener( this );
        IronSource.loadInterstitial();
    }

    @Override
    protected void doShowInterstitialAd(final AppLovinMediationAdapterConfig configuration, final Activity activity)
    {
        IronSource.setInterstitialListener( this );
        IronSource.showInterstitial();
    }

    @Override
    protected void doLoadIncentivizedAd(final Context context, final AppLovinMediationAdapterConfig configuration)
    {
        IronSource.setRewardedVideoListener( this );
    }

    @Override
    protected void doShowIncentivizedAd(final AppLovinMediationAdapterConfig configuration, final Activity activity)
    {
        final String userId = sdk.getUserIdentifier();
        if ( AppLovinSdkUtils.isValidString( userId ) )
        {
            IronSource.setUserId( userId );
        }

        IronSource.setRewardedVideoListener( this );
        IronSource.showRewardedVideo();
    }

    // --------- InterstitialListener ---------

    @Override
    public void onInterstitialAdReady()
    {
        markInterstitialAdLoaded();
    }

    @Override
    public void onInterstitialAdLoadFailed(IronSourceError ironSourceError)
    {
        markInterstitialLoadFailed( toAppLovinError( ironSourceError ) );
    }

    @Override
    public void onInterstitialAdOpened() {}

    @Override
    public void onInterstitialAdClosed()
    {
        markInterstitialAdHidden();
    }

    @Override
    public void onInterstitialAdShowSucceeded()
    {
        markInterstitialAdDisplayed();
    }

    @Override
    public void onInterstitialAdShowFailed(IronSourceError ironSourceError)
    {
        markInterstitialAdFailedToDisplay( toAppLovinError( ironSourceError ) );
    }

    @Override
    public void onInterstitialAdClicked()
    {
        markInterstitialAdClicked();
    }

    // --------- RewardedVideoListener ---------

    @Override
    public void onRewardedVideoAdOpened()
    {
        markIncentivizedAdDisplayed();
    }

    @Override
    public void onRewardedVideoAdClosed()
    {
        markIncentivizedAdHidden();
    }

    @Override
    public void onRewardedVideoAvailabilityChanged(boolean available)
    {
        if ( available )
        {
            markInterstitialAdLoaded();
        }
        else
        {
            markIncentivizedLoadFailed( AppLovinMediationErrorCode.NETWORK_UNSPECIFIED );
        }
    }

    @Override
    public void onRewardedVideoAdStarted() {}

    @Override
    public void onRewardedVideoAdEnded() {}

    @Override
    public void onRewardedVideoAdRewarded(Placement placement)
    {
        final Map<String, String> rewardInfo = createRewardInfo( placement.getRewardAmount(), placement.getRewardName(), configuration );
        markIncentivizedRewardVerified( rewardInfo );
    }

    @Override
    public void onRewardedVideoAdShowFailed(IronSourceError ironSourceError)
    {
        markIncentivizedAdFailedToDisplay( toAppLovinError( ironSourceError ) );
    }

    private static AppLovinMediationErrorCode toAppLovinError(final IronSourceError ironSourceError)
    {
        final int code = ironSourceError != null ? ironSourceError.getErrorCode() : 0;

        if ( code == IronSourceError.ERROR_CODE_NO_CONFIGURATION_AVAILABLE )
        {
            return AppLovinMediationErrorCode.NETWORK_INVALID_CONFIGURATION;
        }
        else if ( code == IronSourceError.ERROR_CODE_USING_CACHED_CONFIGURATION )
        {
            return AppLovinMediationErrorCode.NETWORK_INVALID_CONFIGURATION;
        }
        else if ( code == IronSourceError.ERROR_CODE_KEY_NOT_SET )
        {
            return AppLovinMediationErrorCode.NETWORK_INVALID_CONFIGURATION;
        }
        else if ( code == IronSourceError.ERROR_CODE_INVALID_KEY_VALUE )
        {
            return AppLovinMediationErrorCode.NETWORK_INVALID_CONFIGURATION;
        }
        else if ( code == IronSourceError.ERROR_CODE_INIT_FAILED )
        {
            return AppLovinMediationErrorCode.NETWORK_INVALID_STATE;
        }
        else if ( code == IronSourceError.ERROR_CODE_NO_ADS_TO_SHOW )
        {
            return AppLovinMediationErrorCode.NETWORK_NO_FILL;
        }
        else if ( code == IronSourceError.ERROR_CODE_GENERIC )
        {
            return AppLovinMediationErrorCode.NETWORK_INTERNAL_ERROR;
        }
        else if ( code == IronSourceError.ERROR_NO_INTERNET_CONNECTION )
        {
            return AppLovinMediationErrorCode.NETWORK_NO_CONNECTION;
        }
        else if ( code == IronSourceError.ERROR_REACHED_CAP_LIMIT )
        {
            return AppLovinMediationErrorCode.NETWORK_NO_FILL;
        }
        else
        {
            return AppLovinMediationErrorCode.NETWORK_UNSPECIFIED;
        }
    }
}
