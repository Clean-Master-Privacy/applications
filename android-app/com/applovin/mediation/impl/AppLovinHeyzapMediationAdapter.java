package com.applovin.mediation.impl;

import android.app.Activity;
import android.content.Context;

import com.applovin.mediation.AppLovinMediationAdapterConfig;
import com.applovin.mediation.AppLovinMediationErrorCode;
import com.applovin.sdk.AppLovinSdk;
import com.applovin.sdk.AppLovinSdkUtils;
import com.heyzap.sdk.ads.HeyzapAds;
import com.heyzap.sdk.ads.HeyzapIncentivizedActivity;
import com.heyzap.sdk.ads.HeyzapInterstitialActivity;
import com.heyzap.sdk.ads.IncentivizedAd;
import com.heyzap.sdk.ads.InterstitialAd;

import java.util.Map;

/**
 * This is a mediation adapter for the Heyzap Ad SDK
 * <p>
 * Created by basil on 12/5/16.
 */

public class AppLovinHeyzapMediationAdapter
        extends GlobalListenerAdapterBase
{
    private InterstitialOnStatusListener interstitialOnStatusListener;
    private IncentivizedOnStatusListener incentivizedOnStatusListener;

    @Override
    public void initialize(final AppLovinMediationAdapterConfig configuration, final AppLovinSdk sdk, final Activity activity) throws Exception
    {
        super.initialize( configuration, sdk, activity );

        // Check existence of SDK classes
        checkExistence( HeyzapAds.class, InterstitialAd.class, IncentivizedAd.class );

        // Check existence of SDK activities
        checkActivities( HeyzapInterstitialActivity.class, HeyzapIncentivizedActivity.class );

        interstitialOnStatusListener = new InterstitialOnStatusListener();
        incentivizedOnStatusListener = new IncentivizedOnStatusListener( configuration );

        // If we should automatically initialize the adapter
        if ( configuration.getBoolean( KEY_INIT ) )
        {
            log( "Initializing..." );

            if ( activity == null ) throw new IllegalStateException( "Unable to initialize Heyzap: no activity provided" );

            final String publisherId = configuration.getString( "publisher_id", null );
            if ( publisherId == null ) throw new IllegalStateException( "Unable to initialize Heyzap: no publisher ID provided" );

            final String bundleIdOverride = configuration.getString( "bundle_id_override", null );
            if ( AppLovinSdkUtils.isValidString( bundleIdOverride ) )
            {
                HeyzapAds.setBundleId( bundleIdOverride );
            }

            final Boolean thirdPartyLoggingEnabled = configuration.getBoolean( "third_party_logging_enabled", null );
            if ( thirdPartyLoggingEnabled != null )
            {
                HeyzapAds.setThirdPartyVerboseLogging( thirdPartyLoggingEnabled );
            }

            int flags = 0;
            if ( configuration.getBoolean( "disable_automatic_fetch" ) )
            {
                flags |= HeyzapAds.DISABLE_AUTOMATIC_FETCH;
            }

            if ( configuration.getBoolean( "install_tracking_only" ) )
            {
                flags |= HeyzapAds.INSTALL_TRACKING_ONLY;
            }

            if ( configuration.getBoolean( "amazon" ) )
            {
                flags |= HeyzapAds.AMAZON;
            }

            if ( configuration.getBoolean( "disable_mediation" ) )
            {
                flags |= HeyzapAds.DISABLE_MEDIATION;
            }

            if ( configuration.getBoolean( "native_ads_only" ) )
            {
                flags |= HeyzapAds.NATIVE_ADS_ONLY;
            }

            if ( configuration.getBoolean( "child_directed_advertising" ) )
            {
                flags |= HeyzapAds.CHILD_DIRECTED_ADVERTISING;
            }

            HeyzapAds.start( publisherId, activity, flags );
            markEnabled();
        }
        else if ( configuration.getBoolean( KEY_ATTACH ) )
        {
            log( "Using existing initialization" );

            markEnabled();
        }
    }

    @Override
    public boolean isReady()
    {
        return super.isReady() && HeyzapAds.hasStarted();
    }

    @Override
    public String getVersion()
    {
        return HeyzapAds.getVersion();
    }

    @Override
    protected boolean isInterstitialLoaded()
    {
        return InterstitialAd.isAvailable();
    }

    @Override
    protected boolean isIncentivizedLoaded()
    {
        return IncentivizedAd.isAvailable();
    }

    @Override
    protected void doLoadInterstitialAd(final Context context, final AppLovinMediationAdapterConfig configuration)
    {
        InterstitialAd.setOnStatusListener( interstitialOnStatusListener );
        InterstitialAd.fetch();
    }

    @Override
    protected void doShowInterstitialAd(final AppLovinMediationAdapterConfig configuration, final Activity activity)
    {
        InterstitialAd.setOnStatusListener( interstitialOnStatusListener );
        InterstitialAd.display( activity );
    }

    @Override
    protected void doLoadIncentivizedAd(final Context context, final AppLovinMediationAdapterConfig configuration)
    {
        IncentivizedAd.setOnStatusListener( incentivizedOnStatusListener );
        IncentivizedAd.fetch();
    }

    @Override
    protected void doShowIncentivizedAd(final AppLovinMediationAdapterConfig configuration, final Activity activity)
    {
        IncentivizedAd.setOnStatusListener( incentivizedOnStatusListener );
        IncentivizedAd.setOnIncentiveResultListener( incentivizedOnStatusListener );
        IncentivizedAd.display( activity );
    }

    // ---------- HeyzapAds.OnStatusListener for Interstitial ---------
    private class InterstitialOnStatusListener
            implements HeyzapAds.OnStatusListener
    {
        @Override
        public void onShow(String s)
        {
            log( "Interstitial ad was displayed" );
            markInterstitialAdDisplayed();
        }

        @Override
        public void onClick(String s)
        {
            log( "Interstitial ad was clicked" );
            markInterstitialAdClicked();
        }

        @Override
        public void onHide(String s)
        {
            log( "Interstitial ad was hidden" );
            markInterstitialAdHidden();
        }

        @Override
        public void onFailedToShow(String s)
        {
            log( "Interstitial ad failed to display" );
            markInterstitialAdFailedToDisplay( AppLovinMediationErrorCode.NETWORK_DISPLAY_UNSPECIFIED );
        }

        @Override
        public void onAvailable(String s)
        {
            log( "Interstitial ad loaded" );
            markInterstitialAdLoaded();
        }

        @Override
        public void onFailedToFetch(String s)
        {
            log( "Interstitial ad failed to load" );
            markInterstitialLoadFailed( AppLovinMediationErrorCode.NETWORK_UNSPECIFIED );
        }

        @Override
        public void onAudioStarted() { }

        @Override
        public void onAudioFinished() { }
    }

    // ---------- HeyzapAds.OnStatusListener for Incentivized ---------
    private class IncentivizedOnStatusListener
            implements HeyzapAds.OnStatusListener, HeyzapAds.OnIncentiveResultListener
    {
        private final AppLovinMediationAdapterConfig configuration;

        private IncentivizedOnStatusListener(final AppLovinMediationAdapterConfig configuration)
        {
            this.configuration = configuration;
        }

        @Override
        public void onShow(String s)
        {
            log( "Incentivized ad displayed" );
            markIncentivizedAdDisplayed();
        }

        @Override
        public void onClick(String s)
        {
            log( "Incentivized ad was clicked" );
            markIncentivizedAdClicked();
        }

        @Override
        public void onHide(String s)
        {
            log( "Incentivized ad was hidden" );
            markIncentivizedAdHidden();
        }

        @Override
        public void onFailedToShow(String s)
        {
            log( "Incentivized ad failed to display" );
            markIncentivizedAdFailedToDisplay( AppLovinMediationErrorCode.NETWORK_DISPLAY_UNSPECIFIED );
        }

        @Override
        public void onAvailable(String s)
        {
            log( "Incentivized ad loaded" );
            markIncentivizedAdLoaded();
        }

        @Override
        public void onFailedToFetch(String s)
        {
            log( "Incentivized ad failed to load" );
            markIncentivizedLoadFailed( AppLovinMediationErrorCode.NETWORK_UNSPECIFIED );
        }

        @Override
        public void onAudioStarted() {}

        @Override
        public void onAudioFinished() {}

        @Override
        public void onComplete(final String tag)
        {
            log( "Incentivized ad was completed" );

            final Map<String, String> rewardInfo = createRewardInfo( configuration );
            markIncentivizedRewardVerified( rewardInfo );
        }

        @Override
        public void onIncomplete(final String tag)
        {
            log( "Incentivized ad failed to complete" );

            final Map<String, String> rejectionInfo = createEmptyRewardInfo();
            markIncentivizedRewardRejected( rejectionInfo );
        }
    }
}
