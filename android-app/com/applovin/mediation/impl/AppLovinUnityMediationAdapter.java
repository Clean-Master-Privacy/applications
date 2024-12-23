package com.applovin.mediation.impl;

import android.app.Activity;
import android.content.Context;

import com.applovin.mediation.AppLovinMediationAdapterConfig;
import com.applovin.mediation.AppLovinMediationErrorCode;
import com.applovin.sdk.AppLovinSdk;
import com.applovin.sdk.AppLovinSdkUtils;
import com.unity3d.ads.IUnityAdsListener;
import com.unity3d.ads.UnityAds;
import com.unity3d.ads.adunit.AdUnitActivity;
import com.unity3d.ads.adunit.AdUnitSoftwareActivity;
import com.unity3d.ads.mediation.IUnityAdsExtendedListener;

import java.util.Map;

/**
 * This is a mediation adapter for the Unity Ads SDK
 * <p>
 * Created by basil on 12/11/16.
 */

public class AppLovinUnityMediationAdapter
        extends GlobalListenerAdapterBase
        implements IUnityAdsExtendedListener
{
    private String interstitialPlacementId;
    private String incentivizedPlacementId;

    private AppLovinMediationAdapterConfig configuration;

    @Override
    public void initialize(final AppLovinMediationAdapterConfig configuration, final AppLovinSdk sdk, final Activity activity) throws Exception
    {
        super.initialize( configuration, sdk, activity );

        // Check existence of SDK classes
        checkExistence( UnityAds.class, IUnityAdsListener.class );

        // Check existence of SDK activities
        checkActivities( AdUnitActivity.class, AdUnitSoftwareActivity.class );

        this.interstitialPlacementId = configuration.getString( KEY_INTERSTITIAL_PLACEMENT_ID, "" );
        this.incentivizedPlacementId = configuration.getString( KEY_INCENTIVIZED_PLACEMENT_ID, "" );

        this.configuration = configuration;

        // If we should automatically initialize the adapter
        if ( configuration.getBoolean( KEY_INIT ) )
        {
            if ( activity == null ) throw new IllegalStateException( "Unable to initialize UnityAds: no game ID provided" );

            final String gameId = configuration.getString( "game_id", null );
            if ( gameId == null ) throw new IllegalStateException( "Unable to initialize UnityAds: no game ID provided" );

            if ( !AppLovinSdkUtils.isValidString( incentivizedPlacementId ) && !AppLovinSdkUtils.isValidString( incentivizedPlacementId ) )
            {
                throw new IllegalStateException( "Unable to initialize UnityAds: neither interstitial nor incentivized placement ID provided" );
            }

            log( "Initializing..." );

            UnityAds.initialize( activity, gameId, this );

            markEnabled();
        }
        else if ( configuration.getBoolean( KEY_ATTACH ) )
        {
            log( "Using existing initialization" );

            // Make us the main listener
            UnityAds.setListener( this );

            markEnabled();
        }
    }

    @Override
    public boolean isReady()
    {
        return super.isReady() && UnityAds.isInitialized();
    }

    @Override
    public String getVersion()
    {
        return UnityAds.getVersion();
    }

    @Override
    protected boolean isInterstitialLoaded()
    {
        return UnityAds.isReady( interstitialPlacementId );
    }

    @Override
    protected void doLoadInterstitialAd(final Context context, final AppLovinMediationAdapterConfig configuration)
    {
        UnityAds.setListener( this );
    }

    @Override
    protected void doShowInterstitialAd(final AppLovinMediationAdapterConfig configuration, final Activity activity)
    {
        UnityAds.show( activity, interstitialPlacementId );
    }

    @Override
    protected boolean isIncentivizedLoaded()
    {
        return UnityAds.isReady( incentivizedPlacementId );
    }

    @Override
    protected void doLoadIncentivizedAd(final Context context, final AppLovinMediationAdapterConfig configuration)
    {
        UnityAds.setListener( this );
    }

    @Override
    protected void doShowIncentivizedAd(final AppLovinMediationAdapterConfig configuration, final Activity activity)
    {
        UnityAds.show( activity, incentivizedPlacementId );
    }

    // ----- IUnityAdsListener -----

    @Override
    public void onUnityAdsReady(String placement)
    {
        log( "Unity ad loaded for " + placement );

        if ( interstitialPlacementId.equals( placement ) )
        {
            markInterstitialAdLoaded();
        }
        else if ( incentivizedPlacementId.equals( placement ) )
        {
            markIncentivizedAdLoaded();
        }
        else
        {
            log( "Unity ad loaded for unrecognized placement" );
        }
    }

    @Override
    public void onUnityAdsStart(String placement)
    {
        log( "Unity ad started for " + placement );

        if ( interstitialPlacementId.equals( placement ) )
        {
            markInterstitialAdDisplayed();
        }
        else if ( incentivizedPlacementId.equals( placement ) )
        {
            markIncentivizedAdDisplayed();
        }
        else
        {
            log( "Unity ad started for unrecognized placement" );
        }
    }

    @Override
    public void onUnityAdsClick(final String placement)
    {
        log( "Unity ad clicked for " + placement );

        if ( interstitialPlacementId.equals( placement ) )
        {
            markInterstitialAdClicked();
        }
        else if ( incentivizedPlacementId.equals( placement ) )
        {
            markIncentivizedAdClicked();
        }
        else
        {
            log( "Unity ad started for unrecognized placement" );
        }
    }

    @Override
    public void onUnityAdsFinish(String placement, UnityAds.FinishState finishState)
    {
        log( "Unity ad finished for " + placement );

        if ( interstitialPlacementId.equals( placement ) )
        {
            markInterstitialAdHidden();
        }
        else if ( incentivizedPlacementId.equals( placement ) )
        {
            if ( finishState == UnityAds.FinishState.COMPLETED )
            {
                final Map<String, String> rewardInfo = createRewardInfo( configuration );
                markIncentivizedRewardVerified( rewardInfo );
            }
            else
            {
                final Map<String, String> rejectionInfo = createEmptyRewardInfo();
                rejectionInfo.put( "finish_state", String.valueOf( finishState ) );

                markIncentivizedRewardRejected( rejectionInfo );
            }

            markIncentivizedAdHidden();
        }
        else
        {
            log( "Unity ad finished for unrecognized placement" );
        }
    }

    @Override
    public void onUnityAdsError(UnityAds.UnityAdsError unityAdsError, String placement)
    {
        log( "Ad load error: " + unityAdsError + " - " + placement );

        if ( interstitialPlacementId.equals( placement ) )
        {
            markInterstitialLoadFailed( toAppLovinError( unityAdsError ) );
        }
        else if ( incentivizedPlacementId.equals( placement ) )
        {
            markIncentivizedLoadFailed( toAppLovinError( unityAdsError ) );
        }
        else
        {
            log( "Unity ad error'd out for unrecognized placement" );
        }
    }

    private AppLovinMediationErrorCode toAppLovinError(final UnityAds.UnityAdsError unityAdsError)
    {
        if ( unityAdsError == UnityAds.UnityAdsError.NOT_INITIALIZED )
        {
            return AppLovinMediationErrorCode.NETWORK_INVALID_STATE;
        }
        else if ( unityAdsError == UnityAds.UnityAdsError.INITIALIZE_FAILED )
        {
            return AppLovinMediationErrorCode.NETWORK_INTERNAL_ERROR;
        }
        else if ( unityAdsError == UnityAds.UnityAdsError.INVALID_ARGUMENT )
        {
            return AppLovinMediationErrorCode.NETWORK_INVALID_STATE;
        }
        else if ( unityAdsError == UnityAds.UnityAdsError.VIDEO_PLAYER_ERROR )
        {
            return AppLovinMediationErrorCode.NETWORK_INTERNAL_ERROR;
        }
        else if ( unityAdsError == UnityAds.UnityAdsError.INIT_SANITY_CHECK_FAIL )
        {
            return AppLovinMediationErrorCode.NETWORK_INVALID_STATE;
        }
        else if ( unityAdsError == UnityAds.UnityAdsError.AD_BLOCKER_DETECTED )
        {
            return AppLovinMediationErrorCode.NETWORK_BAD_REQUEST;
        }
        else if ( unityAdsError == UnityAds.UnityAdsError.FILE_IO_ERROR )
        {
            return AppLovinMediationErrorCode.NETWORK_INTERNAL_ERROR;
        }
        else if ( unityAdsError == UnityAds.UnityAdsError.DEVICE_ID_ERROR )
        {
            return AppLovinMediationErrorCode.NETWORK_INTERNAL_ERROR;
        }
        else if ( unityAdsError == UnityAds.UnityAdsError.SHOW_ERROR )
        {
            return AppLovinMediationErrorCode.NETWORK_DISPLAY_INVALID_STATE;
        }
        else if ( unityAdsError == UnityAds.UnityAdsError.INTERNAL_ERROR )
        {
            return AppLovinMediationErrorCode.NETWORK_INTERNAL_ERROR;
        }
        else
        {
            return AppLovinMediationErrorCode.NETWORK_UNSPECIFIED;
        }
    }
}
