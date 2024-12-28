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
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.InterstitialAd;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.reward.RewardItem;
import com.google.android.gms.ads.reward.RewardedVideoAd;
import com.google.android.gms.ads.reward.RewardedVideoAdListener;
import com.google.android.gms.common.GoogleApiAvailability;

import java.util.Map;

/**
 * This is a mediation adapter for Google Play Services
 * <p>
 * Created by basil on 12/7/16.
 */

public class AppLovinGoogleMediationAdapter
        extends MediationAdapterBase
{
    private static final String INTER_AD_UNIT_ID  = "inter_ad_unit_id";
    private static final String INCENT_AD_UNIT_ID = "incent_ad_unit_id";

    private Activity rootActivity;

    @Override
    public void initialize(final AppLovinMediationAdapterConfig configuration, final AppLovinSdk sdk, Activity activity) throws Exception
    {
        super.initialize( configuration, sdk, activity );

        // Check existence of SDK classes
        checkExistence( InterstitialAd.class, RewardedVideoAd.class, AdListener.class );

        if ( configuration.getBoolean( KEY_INIT ) || configuration.getBoolean( KEY_ATTACH ) )
        {
            // Check input
            if ( activity == null ) throw new IllegalArgumentException( "No activity specified" );
            this.rootActivity = activity;

            final String appId = configuration.getString( "app_id", null );
            if ( appId == null ) throw new IllegalArgumentException( "Unable to initialize Google: no app id found" );

            final String interstitialAdUnitId = configuration.getString( INTER_AD_UNIT_ID, null );
            final String incentivizedUnitId = configuration.getString( INCENT_AD_UNIT_ID, null );
            if ( !AppLovinSdkUtils.isValidString( interstitialAdUnitId ) && !AppLovinSdkUtils.isValidString( incentivizedUnitId ) ) throw new IllegalArgumentException( "Unable to initialize Google: no ad unit id found" );

            MobileAds.initialize( activity, appId );

            markEnabled();
        }
    }

    @Override
    public String getVersion()
    {
        return String.valueOf( GoogleApiAvailability.GOOGLE_PLAY_SERVICES_VERSION_CODE );
    }

    @Override
    public void prepareInterstitialAd(final AppLovinMediationAdapterConfig configuration, final Context context) {}

    @Override
    public void loadInterstitialAd(final AppLovinMediationAdapterConfig configuration, final Context context, final AppLovinMediationLoadListener loadListener)
    {
        log( "Loading interstitial ad..." );

        final String adUnitId = configuration.getString( INTER_AD_UNIT_ID, null );
        if ( !AppLovinSdkUtils.isValidString( adUnitId ) ) throw new IllegalArgumentException( "Unable to initialize Google: no ad unit id found" );

        rootActivity.runOnUiThread( new Runnable()
        {
            @Override
            public void run()
            {
                try
                {
                    final InterstitialAd interstitialAd = new InterstitialAd( sdk.getApplicationContext() );
                    interstitialAd.setAdUnitId( adUnitId );
                    interstitialAd.setAdListener( new AdListener()
                    {
                        @Override
                        public void onAdFailedToLoad(int errorCode)
                        {
                            super.onAdFailedToLoad( errorCode );

                            log( "Interstitial ad failed to load" );

                            if ( loadListener != null ) loadListener.failedToLoadAd( toAppLovinError( errorCode ) );
                        }

                        @Override
                        public void onAdLoaded()
                        {
                            super.onAdLoaded();

                            log( "Interstitial ad loaded" );

                            if ( loadListener != null ) loadListener.adLoaded( toMediatedAd( interstitialAd, InterstitialAd.class ) );
                        }
                    } );

                    final AdRequest adRequest = createAdRequest( configuration );
                    interstitialAd.loadAd( adRequest );
                }
                catch ( Throwable th )
                {
                    logger.e( tag, "Unable to load Google SDK ad", th );

                    markDisabled();
                }
            }
        } );
    }


    @Override
    public void showInterstitialAd(final AppLovinMediatedAdInfo adInfo, final AppLovinMediationAdapterConfig configuration, final Activity activity, final AppLovinMediationDisplayListener displayListener)
    {
        log( "Showing interstitial ad..." );

        final InterstitialAd interstitialAd = fromMediatedAd( InterstitialAd.class, adInfo );
        if ( interstitialAd != null )
        {
            if ( interstitialAd.isLoaded() )
            {
                interstitialAd.setAdListener( new AdListener()
                {
                    @Override
                    public void onAdClosed()
                    {
                        super.onAdClosed();

                        log( "Interstitial ad was hidden" );

                        if ( displayListener != null ) displayListener.adHidden( adInfo );
                    }

                    @Override
                    public void onAdOpened()
                    {
                        super.onAdOpened();

                        log( "Interstitial ad was displayed" );

                        if ( displayListener != null ) displayListener.adDisplayed( adInfo );
                    }


                    @Override
                    public void onAdLeftApplication()
                    {
                        super.onAdLeftApplication();

                        log( "Interstitial ad was clicked" );

                        if ( displayListener != null ) displayListener.adClicked( adInfo );
                    }
                } );
                updateMuteState( configuration );
                interstitialAd.show();
            }
            else
            {
                log( "Unable to show Google ad: interstitial not loaded" );

                // Ad load failed
                if ( displayListener != null ) displayListener.failedToDisplayAd( adInfo, AppLovinMediationErrorCode.NETWORK_DISPLAY_INVALID_STATE );
            }
        }
        else
        {
            log( "Unable to show Google ad: no interstitial provided" );

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
        if ( !AppLovinSdkUtils.isValidString( adUnitId ) ) throw new IllegalArgumentException( "Unable to initialize Google: no ad unit id found" );

        final RewardedVideoAd rewardBasedVideoAd = MobileAds.getRewardedVideoAdInstance( sdk.getApplicationContext() );

        if ( rewardBasedVideoAd.isLoaded() )
        {
            log( "Incentivized already loaded" );

            if ( loadListener != null ) loadListener.adLoaded( toMediatedAd( rewardBasedVideoAd, RewardedVideoAd.class ) );
        }
        else
        {
            rewardBasedVideoAd.setRewardedVideoAdListener( new RewardedVideoAdListenerAdapter()
            {
                @Override
                public void onRewardedVideoAdLoaded()
                {
                    super.onRewardedVideoAdLoaded();

                    log( "Incentivized ad loaded" );

                    if ( loadListener != null ) loadListener.adLoaded( toMediatedAd( rewardBasedVideoAd, RewardedVideoAd.class ) );
                }

                @Override
                public void onRewardedVideoAdFailedToLoad(int errorCode)
                {
                    super.onRewardedVideoAdFailedToLoad( errorCode );

                    log( "Incentivized ad failed to load" );

                    if ( loadListener != null ) loadListener.failedToLoadAd( toAppLovinError( errorCode ) );
                }
            } );

            final AdRequest adRequest = createAdRequest( configuration );
            rewardBasedVideoAd.loadAd( adUnitId, adRequest );
        }
    }

    @Override
    public void showIncentivizedAd(final AppLovinMediatedAdInfo ad, final AppLovinMediationAdapterConfig configuration, final Activity activity, final AppLovinMediationDisplayListener displayListener)
    {
        log( "Showing incentivized ad..." );

        final RewardedVideoAd rewardedAd = fromMediatedAd( RewardedVideoAd.class, ad );
        if ( rewardedAd != null )
        {
            if ( rewardedAd.isLoaded() )
            {
                rewardedAd.setRewardedVideoAdListener( new RewardedVideoAdListenerAdapter()
                {
                    @Override
                    public void onRewardedVideoAdOpened()
                    {
                        super.onRewardedVideoAdOpened();

                        log( "Incentivized ad displayed" );

                        if ( displayListener != null ) displayListener.adDisplayed( ad );
                    }

                    @Override
                    public void onRewardedVideoAdClosed()
                    {
                        super.onRewardedVideoAdClosed();

                        log( "Incentivized ad hidden" );

                        if ( displayListener != null ) displayListener.adHidden( ad );
                    }

                    @Override
                    public void onRewardedVideoAdLeftApplication()
                    {
                        super.onRewardedVideoAdLeftApplication();

                        log( "Incentivized ad clicked" );

                        if ( displayListener != null ) displayListener.adClicked( ad );
                    }

                    @Override
                    public void onRewarded(RewardItem rewardItem)
                    {
                        super.onRewarded( rewardItem );

                        log( "Incentivized ad completed" );

                        final Map<String, String> rewardInfo = createRewardInfo( rewardItem.getAmount(), rewardItem.getType(), configuration );
                        if ( displayListener != null ) displayListener.rewardVerified( ad, rewardInfo );
                    }

                    @Override
                    public void onRewardedVideoAdFailedToLoad(final int errorCode)
                    {
                        super.onRewardedVideoAdFailedToLoad( errorCode );

                        log( "Incentivized ad failed to display" );

                        if ( displayListener != null ) displayListener.failedToDisplayAd( ad, toAppLovinError( errorCode ) );
                    }

                    @Override
                    public void onRewardedVideoStarted()
                    {
                        super.onRewardedVideoStarted();
                    }
                } );
                updateMuteState( configuration );
                rewardedAd.show();
            }
            else
            {
                log( "Unable to show Google ad: interstitial not loaded" );

                // Ad load failed
                if ( displayListener != null ) displayListener.failedToDisplayAd( ad, AppLovinMediationErrorCode.NETWORK_DISPLAY_INVALID_STATE );
            }
        }
        else
        {
            log( "Unable to show Google ad: no interstital provided" );

            // Ad load failed
            if ( displayListener != null ) displayListener.failedToDisplayAd( ad, AppLovinMediationErrorCode.NETWORK_DISPLAY_INVALID_STATE );
        }
    }

    private void updateMuteState(final AppLovinMediationAdapterConfig configuration)
    {
        Boolean shouldMute = configuration.getBoolean( KEY_MUTED, null );
        if ( shouldMute != null )
        {
            MobileAds.setAppMuted( shouldMute );
        }
    }

    private static AppLovinMediationErrorCode toAppLovinError(final int errorCode)
    {
        if ( errorCode == AdRequest.ERROR_CODE_INTERNAL_ERROR )
        {
            return AppLovinMediationErrorCode.NETWORK_UNSPECIFIED;
        }
        else if ( errorCode == AdRequest.ERROR_CODE_INVALID_REQUEST )
        {
            return AppLovinMediationErrorCode.NETWORK_BAD_REQUEST;
        }
        else if ( errorCode == AdRequest.ERROR_CODE_NETWORK_ERROR )
        {
            return AppLovinMediationErrorCode.NETWORK_NO_CONNECTION;
        }
        else if ( errorCode == AdRequest.ERROR_CODE_NO_FILL )
        {
            return AppLovinMediationErrorCode.NETWORK_NO_FILL;
        }
        else
        {
            return AppLovinMediationErrorCode.NETWORK_UNSPECIFIED;
        }
    }

    private static AdRequest createAdRequest(final AppLovinMediationAdapterConfig configuration)
    {
        final AdRequest.Builder builder = new AdRequest.Builder();

        final Boolean isDesignedForFamilies = configuration.getBoolean( "is_designed_for_families", null );
        if ( isDesignedForFamilies != null )
        {
            builder.setIsDesignedForFamilies( isDesignedForFamilies );
        }

        final Boolean childDirectedTreatment = configuration.getBoolean( "child_directed_treatment", null );
        if ( childDirectedTreatment != null )
        {
            builder.tagForChildDirectedTreatment( childDirectedTreatment );
        }

        final String testDevicesString = configuration.getString( "test_device_ids", null );
        if ( AppLovinSdkUtils.isValidString( testDevicesString ) )
        {
            final String[] testDeviceList = testDevicesString.split( "," );
            for ( String deviceId : testDeviceList )
            {
                builder.addTestDevice( deviceId );
            }
        }

        return builder.build();
    }

    private static class RewardedVideoAdListenerAdapter
            implements RewardedVideoAdListener
    {
        @Override
        public void onRewardedVideoAdLoaded() {}

        @Override
        public void onRewardedVideoAdOpened() {}

        @Override
        public void onRewardedVideoStarted() {}

        @Override
        public void onRewardedVideoAdClosed() {}

        @Override
        public void onRewarded(RewardItem rewardItem) {}

        @Override
        public void onRewardedVideoAdLeftApplication() {}

        @Override
        public void onRewardedVideoAdFailedToLoad(int i) {}
    }
}
    
