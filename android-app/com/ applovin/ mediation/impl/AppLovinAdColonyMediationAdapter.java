    package com.applovin.mediation.impl;

import android.app.Activity;
import android.content.Context;

import com.adcolony.sdk.AdColony;
import com.adcolony.sdk.AdColonyAdOptions;
import com.adcolony.sdk.AdColonyAppOptions;
import com.adcolony.sdk.AdColonyInterstitial;
import com.adcolony.sdk.AdColonyInterstitialListener;
import com.adcolony.sdk.AdColonyReward;
import com.adcolony.sdk.AdColonyRewardListener;
import com.adcolony.sdk.AdColonyZone;
import com.applovin.mediation.AppLovinMediatedAdInfo;
import com.applovin.mediation.AppLovinMediationAdapterConfig;
import com.applovin.mediation.AppLovinMediationDisplayListener;
import com.applovin.mediation.AppLovinMediationErrorCode;
import com.applovin.mediation.AppLovinMediationLoadListener;
import com.applovin.sdk.AppLovinSdk;
import com.applovin.sdk.AppLovinSdkUtils;

import java.util.Map;

public class AppLovinAdColonyMediationAdapter
        extends MediationAdapterBase
{
    private static final String INTER_ZONE_ID  = "inter_zone_id";
    private static final String INCENT_ZONE_ID = "incent_zone_id";

    private AppLovinMediationAdapterConfig configuration;
    private String                         interZoneId;
    private String                         incentZoneId;

    @Override
    public void initialize(final AppLovinMediationAdapterConfig configuration, final AppLovinSdk sdk, final Activity activity) throws Exception
    {
        super.initialize( configuration, sdk, activity );

        checkExistence( AdColony.class );

        this.configuration = configuration;

        interZoneId = configuration.getString( INTER_ZONE_ID, null );
        incentZoneId = configuration.getString( INCENT_ZONE_ID, null );
        if ( !AppLovinSdkUtils.isValidString( interZoneId ) && !AppLovinSdkUtils.isValidString( incentZoneId ) ) throw new IllegalArgumentException( "Unable to initialize AdColony: no zone id found" );

        if ( configuration.getBoolean( KEY_INIT ) )
        {
            if ( activity == null ) throw new IllegalArgumentException( "Unable to initialize AdColony: no activity provided" );

            final String appId = configuration.getString( "app_id", null );
            if ( appId == null ) throw new IllegalArgumentException( "Unable to initialize AdColony: no app id found" );

            final AdColonyAppOptions options = new AdColonyAppOptions();

            final String appVersion = configuration.getString( "app_version", null );
            if ( appVersion != null ) options.setAppVersion( appVersion );

            final Boolean multiWindowEnabled = configuration.getBoolean( "multi_window_enabled", null );
            if ( multiWindowEnabled != null ) options.setMultiWindowEnabled( multiWindowEnabled );

            final String orientation = configuration.getString( "requested_ad_orientation", null );
            if ( orientation != null )
            {
                if ( orientation.equalsIgnoreCase( "portrait" ) )
                {
                    options.setRequestedAdOrientation( AdColonyAppOptions.PORTRAIT );
                }
                else if ( orientation.equalsIgnoreCase( "landscape" ) )
                {
                    options.setRequestedAdOrientation( AdColonyAppOptions.LANDSCAPE );
                }
                else if ( orientation.equalsIgnoreCase( "all" ) )
                {
                    // Temporarily comment out this option, as it is linking against a later JAR than what we have in our local Maven repo
                    // options.setRequestedAdOrientation( AdColonyAppOptions.ALL );
                }
            }

            final String originStore = configuration.getString( "origin_store", null );
            if ( originStore != null ) options.setOriginStore( originStore );

            if ( AdColony.configure( activity, options, appId, interZoneId, incentZoneId ) )
            {
                markEnabled();
            }
            else
            {
                markDisabled();
            }
        }
        else if ( configuration.getBoolean( KEY_ATTACH ) )
        {
            log( "Attaching to already-initialized AdColony SDK" );
            markEnabled();
        }
    }

    @Override
    public String getVersion()
    {
        return AdColony.getSDKVersion();
    }

    @Override
    public void prepareInterstitialAd(final AppLovinMediationAdapterConfig config, final Context context) { }

    @Override
    public void loadInterstitialAd(final AppLovinMediationAdapterConfig config, final Context context, final AppLovinMediationLoadListener loadListener)
    {
        log( "Loading interstitial ad..." );
        loadAd( interZoneId, loadListener );
    }

    @Override
    public void showInterstitialAd(final AppLovinMediatedAdInfo mediatedAd, final AppLovinMediationAdapterConfig config, final Activity activity, final AppLovinMediationDisplayListener displayListener)
    {
        log( "Showing interstitial ad..." );
        showAd( mediatedAd, displayListener );
    }

    @Override
    public void prepareIncentivizedAd(final AppLovinMediationAdapterConfig config, final Context context) { }

    @Override
    public void loadIncentivizedAd(final AppLovinMediationAdapterConfig config, final Context context, final AppLovinMediationLoadListener loadListener)
    {
        log( "Loading incentivized ad..." );
        loadAd( incentZoneId, loadListener );
    }

    @Override
    public void showIncentivizedAd(final AppLovinMediatedAdInfo mediatedAd, final AppLovinMediationAdapterConfig configuration, final Activity activity, final AppLovinMediationDisplayListener displayListener)
    {
        log( "Showing incentivized ad..." );

        AdColony.setRewardListener( new AdColonyRewardListener()
        {
            @Override
            public void onReward(final AdColonyReward adColonyReward)
            {
                if ( adColonyReward.success() )
                {
                    log( "Incentivized ad completed" );
                    final Map<String, String> rewardInfo = createRewardInfo( adColonyReward.getRewardAmount(), adColonyReward.getRewardName(), configuration );
                    displayListener.rewardVerified( mediatedAd, rewardInfo );
                }
                else
                {
                    log( "Incentivized ad rejected" );
                    displayListener.rewardRejected( mediatedAd, createEmptyRewardInfo() );
                }
            }
        } );

        showAd( mediatedAd, displayListener );
    }

    private void loadAd(final String zoneId, final AppLovinMediationLoadListener loadListener)
    {
        final AdColonyAdOptions options = new AdColonyAdOptions();

        final Boolean enableConfirmationDialog = configuration.getBoolean( "enable_confirmation_dialog", null );
        if ( enableConfirmationDialog != null ) options.enableConfirmationDialog( enableConfirmationDialog );
        final Boolean enableResultsDialog = configuration.getBoolean( "enable_results_dialog", null );
        if ( enableResultsDialog != null ) options.enableResultsDialog( enableResultsDialog );

        AdColony.requestInterstitial( zoneId, new AdColonyInterstitialListener()
        {
            @Override
            public void onRequestFilled(final AdColonyInterstitial adColonyInterstitial)
            {
                log( "Ad loaded" );
                loadListener.adLoaded( toMediatedAd( adColonyInterstitial, AdColonyInterstitial.class ) );
            }

            @Override
            public void onRequestNotFilled(final AdColonyZone zone)
            {
                log( "Ad failed to load" );
                loadListener.failedToLoadAd( AppLovinMediationErrorCode.NETWORK_UNSPECIFIED );
            }
        }, options );
    }

    private void showAd(final AppLovinMediatedAdInfo mediatedAd, final AppLovinMediationDisplayListener displayListener)
    {
        AdColonyInterstitial ad = fromMediatedAd( AdColonyInterstitial.class, mediatedAd );
        ad.setListener( new AdColonyInterstitialListener()
        {
            @Override
            public void onRequestFilled(final AdColonyInterstitial adColonyInterstitial)
            {
                // Not called; the ad has already loaded.
            }

            @Override
            public void onOpened(final AdColonyInterstitial ad)
            {
                log( "Ad was displayed" );
                displayListener.adDisplayed( mediatedAd );
            }

            @Override
            public void onClosed(final AdColonyInterstitial ad)
            {
                log( "Ad was hidden" );
                displayListener.adHidden( mediatedAd );
            }

            @Override
            public void onClicked(final AdColonyInterstitial ad)
            {
                log( "Ad was clicked" );
                displayListener.adClicked( mediatedAd );
            }
        } );
        ad.show();
    }
}
    
