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
import com.facebook.ads.Ad;
import com.facebook.ads.AdError;
import com.facebook.ads.AdSettings;
import com.facebook.ads.BuildConfig;
import com.facebook.ads.InterstitialAd;
import com.facebook.ads.InterstitialAdActivity;
import com.facebook.ads.InterstitialAdListener;

import java.util.Arrays;
import java.util.List;


/**
 * This is a mediation adapter for Facebook Audience Network SDK
 * <p>
 * Created by basil on 12/13/16.
 */

public class AppLovinFacebookMediationAdapter
        extends MediationAdapterBase
{
    private Activity rootActivity;

    @Override
    public void initialize(final AppLovinMediationAdapterConfig configuration, final AppLovinSdk sdk, final Activity activity) throws Exception
    {
        super.initialize( configuration, sdk, activity );

        // Check existence of SDK classes
        checkExistence( InterstitialAd.class, InterstitialAdListener.class, AdSettings.class );

        // Check existence of SDK activities
        checkActivities( InterstitialAdActivity.class );

        if ( configuration.getBoolean( KEY_INIT ) || configuration.getBoolean( KEY_ATTACH ) )
        {
            log( "Initializing..." );

            // Check input
            if ( activity == null ) throw new IllegalArgumentException( "No activity specified" );

            rootActivity = activity;

            updateAdSettings( configuration );

            markEnabled();
        }
    }

    @Override
    public String getVersion()
    {
        return BuildConfig.VERSION_NAME;
    }

    @Override
    public void prepareInterstitialAd(final AppLovinMediationAdapterConfig configuration, final Context context) {}

    @Override
    public void loadInterstitialAd(final AppLovinMediationAdapterConfig configuration, final Context context, final AppLovinMediationLoadListener loadListener)
    {
        log( "Loading interstitial ad..." );

        // First, figure out the placement ID
        final String placementId = configuration.getString( KEY_INTERSTITIAL_PLACEMENT_ID, null );
        if ( placementId == null ) throw new IllegalArgumentException( "No placement ID defined" );

        rootActivity.runOnUiThread( new Runnable()
        {
            @Override
            public void run()
            {
                try
                {
                    updateAdSettings( configuration );

                    final InterstitialAd interstitialAd = new InterstitialAd( context, placementId );
                    interstitialAd.setAdListener( new InterstitialAdListenerAdapter()
                    {
                        @Override
                        public void onAdLoaded(Ad ad)
                        {
                            log( "Interstitial ad was loaded" );
                            if ( loadListener != null ) loadListener.adLoaded( toMediatedAd( interstitialAd, InterstitialAd.class ) );
                        }

                        @Override
                        public void onError(Ad ad, AdError adError)
                        {
                            log( "Interstitial ad failed to load" );
                            if ( loadListener != null ) loadListener.failedToLoadAd( toAppLovinError( adError ) );
                        }
                    } );
                    interstitialAd.loadAd();
                }
                catch ( Throwable th )
                {
                    logger.e( tag, "Unable to load Facebook SDK ad", th );

                    markDisabled();
                }
            }
        } );
    }

    @Override
    public void showInterstitialAd(final AppLovinMediatedAdInfo adInfo, final AppLovinMediationAdapterConfig configuration, final Activity activity, final AppLovinMediationDisplayListener displayListener)
    {
        final InterstitialAd interstitialAd = fromMediatedAd( InterstitialAd.class, adInfo );
        if ( interstitialAd != null )
        {
            log( "Showing interstitial ad..." );
            if ( interstitialAd.isAdLoaded() )
            {
                interstitialAd.setAdListener( new InterstitialAdListenerAdapter()
                {
                    @Override
                    public void onError(Ad fbAd, AdError adError)
                    {
                        log( "Interstitial failed to display" );
                        if ( displayListener != null ) displayListener.failedToDisplayAd( adInfo, toAppLovinError( adError ) );
                    }

                    @Override
                    public void onInterstitialDismissed(Ad fbAd)
                    {
                        log( "Interstitial was hidden" );
                        if ( displayListener != null ) displayListener.adHidden( adInfo );
                    }

                    @Override
                    public void onInterstitialDisplayed(Ad fbAd)
                    {
                        log( "Interstitial was displayed" );
                        if ( displayListener != null ) displayListener.adDisplayed( adInfo );
                    }

                    @Override
                    public void onAdClicked(Ad fbAd)
                    {
                        log( "Interstitial was clicked" );
                        if ( displayListener != null ) displayListener.adClicked( adInfo );
                    }
                } );
                interstitialAd.show();
            }
            else
            {
                log( "Unable to show Facebook ad: interstitial not loaded" );

                // Ad load failed
                if ( displayListener != null ) displayListener.failedToDisplayAd( adInfo, AppLovinMediationErrorCode.NETWORK_DISPLAY_INVALID_STATE );
            }
        }
        else
        {
            log( "Unable to show Facebook ad: no interstitial provided" );

            // Ad load failed
            if ( displayListener != null ) displayListener.failedToDisplayAd( adInfo, AppLovinMediationErrorCode.NETWORK_DISPLAY_INVALID_STATE );
        }
    }

    @Override
    public void prepareIncentivizedAd(final AppLovinMediationAdapterConfig configuration, final Context context)
    {
        log( "Facebook incentivized ads not supported" );
    }

    @Override
    public void loadIncentivizedAd(final AppLovinMediationAdapterConfig configuration, final Context context, final AppLovinMediationLoadListener loadListener)
    {
        log( "Facebook incentivized ads not supported" );

        if ( loadListener != null ) loadListener.failedToLoadAd( AppLovinMediationErrorCode.ADAPTER_CONFIGURATION_ERROR );
    }

    @Override
    public void showIncentivizedAd(final AppLovinMediatedAdInfo ad, final AppLovinMediationAdapterConfig configuration, final Activity activity, final AppLovinMediationDisplayListener displayListener)
    {
        log( "Facebook incentivized ads not supported" );

        if ( displayListener != null ) displayListener.failedToDisplayAd( ad, AppLovinMediationErrorCode.ADAPTER_CONFIGURATION_ERROR );
    }

    private void updateAdSettings(final AppLovinMediationAdapterConfig configuration)
    {
        final Boolean videoAutoplay = configuration.getBoolean( "video_autoplay", null );
        if ( videoAutoplay != null )
        {
            AdSettings.setVideoAutoplay( videoAutoplay );
        }

        final Boolean isChildDirected = configuration.getBoolean( "child_directed_treatment", null );
        if ( isChildDirected != null )
        {
            AdSettings.setIsChildDirected( isChildDirected );
        }

        final String testDevicesString = configuration.getString( "test_device_ids", null );
        if ( AppLovinSdkUtils.isValidString( testDevicesString ) )
        {
            final List<String> testDeviceList = Arrays.asList( testDevicesString.split( "," ) );

            AdSettings.addTestDevices( testDeviceList );
        }
    }

    private static AppLovinMediationErrorCode toAppLovinError(final AdError adError)
    {
        if ( adError == AdError.NETWORK_ERROR )
        {
            return AppLovinMediationErrorCode.NETWORK_NO_CONNECTION;
        }
        else if ( adError == AdError.NO_FILL )
        {
            return AppLovinMediationErrorCode.NETWORK_NO_FILL;
        }
        else if ( adError == AdError.LOAD_TOO_FREQUENTLY )
        {
            return AppLovinMediationErrorCode.NETWORK_NO_FILL;
        }
        else if ( adError == AdError.SERVER_ERROR )
        {
            return AppLovinMediationErrorCode.NETWORK_SERVER_ERROR;
        }
        else if ( adError == AdError.INTERNAL_ERROR )
        {
            return AppLovinMediationErrorCode.NETWORK_INTERNAL_ERROR;
        }
        else
        {
            return AppLovinMediationErrorCode.NETWORK_UNSPECIFIED;
        }
    }

    private static class InterstitialAdListenerAdapter
            implements InterstitialAdListener
    {
        @Override
        public void onInterstitialDisplayed(Ad ad) {}

        @Override
        public void onInterstitialDismissed(Ad ad) {}

        @Override
        public void onError(Ad ad, AdError adError) {}

        @Override
        public void onAdLoaded(Ad ad) {}

        @Override
        public void onAdClicked(Ad ad) {}
    }
}
    
