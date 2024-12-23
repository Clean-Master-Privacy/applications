package com.applovin.mediation.impl;

import android.app.Activity;
import android.content.Context;

import com.applovin.mediation.AppLovinMediatedAdInfo;
import com.applovin.mediation.AppLovinMediationAdapterConfig;
import com.applovin.mediation.AppLovinMediationDisplayListener;
import com.applovin.mediation.AppLovinMediationErrorCode;
import com.applovin.mediation.AppLovinMediationLoadListener;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * This is a base class that should be used for mediation networks that assume a global listener for all of the ads
 * <p>
 * Created by basil on 12/5/16.
 */

abstract class GlobalListenerAdapterBase
        extends MediationAdapterBase
{
    // By default global listener-based adapters do not have an ad
    private static final AppLovinMediatedAdInfo DEFAULT_AD = null;

    // Controlled objects
    private final Object loadLock = new Object();

    // State objects
    private Set<AppLovinMediationLoadListener> interstitialLoadListeners = new HashSet<AppLovinMediationLoadListener>(); // Guarded by loadLock
    private volatile AppLovinMediationDisplayListener lastInterstitialDisplayListener;       // Not guarded

    private Set<AppLovinMediationLoadListener> incentivizedLoadListeners = new HashSet<AppLovinMediationLoadListener>(); // Guarded by loadLock
    private volatile AppLovinMediationDisplayListener lastIncentivizedDisplayListener;       // Not guarded

    @Override
    public void prepareInterstitialAd(final AppLovinMediationAdapterConfig configuration, final Context context)
    {
        // If we don't have an ad yet
        if ( !isInterstitialLoaded() )
        {
            // Load it
            log( "Preparing interstitial..." );
            doLoadInterstitialAd( context, configuration );
        }
    }

    @Override
    public void loadInterstitialAd(final AppLovinMediationAdapterConfig configuration, final Context context, final AppLovinMediationLoadListener loadListener)
    {
        log( "Loading interstitial..." );

        // If we have an interstitial ready
        if ( isInterstitialLoaded() )
        {
            log( "Interstitial is already loaded" );

            // If so, return the ad at once
            if ( loadListener != null ) loadListener.adLoaded( null );
        }
        // Otherwise (we should load the next ad)
        else
        {
            // Add ourself to the listeners
            synchronized ( loadLock )
            {
                if ( loadListener != null )
                {
                    interstitialLoadListeners.add( loadListener );
                }
            }

            // Load the next interstitial
            doLoadInterstitialAd( context, configuration );
        }
    }

    @Override
    public void processInterstitialAdLoadTimeout()
    {
        super.processInterstitialAdLoadTimeout();
        log( "Interstitial ad load did time out..." );

        synchronized ( loadLock )
        {
            // Clear all of the listeners
            interstitialLoadListeners.clear();
        }
    }

    @Override
    public void showInterstitialAd(final AppLovinMediatedAdInfo adInfo, final AppLovinMediationAdapterConfig configuration, final Activity activity, final AppLovinMediationDisplayListener displayListener)
    {
        log( "Showing interstitial..." );

        if ( isInterstitialLoaded() )
        {
            lastInterstitialDisplayListener = displayListener;
            doShowInterstitialAd( configuration, activity );
        }
        else
        {
            log( "Interstitial is not loaded" );
            markInterstitialAdFailedToDisplay( AppLovinMediationErrorCode.NETWORK_DISPLAY_INVALID_STATE );
        }
    }

    @Override
    public void prepareIncentivizedAd(final AppLovinMediationAdapterConfig configuration, final Context context)
    {
        // If we don't have an ad yet
        if ( !isIncentivizedLoaded() )
        {
            // Load the next ad
            log( "Preparing incentivized..." );
            doLoadIncentivizedAd( context, configuration );
        }
    }

    @Override
    public void loadIncentivizedAd(final AppLovinMediationAdapterConfig configuration, final Context context, final AppLovinMediationLoadListener loadListener)
    {
        log( "Loading incentivized..." );

        // If we have an interstitial ready
        if ( isIncentivizedLoaded() )
        {
            log( "Incentivized is already loaded" );

            // If so, return the ad at once
            if ( loadListener != null ) loadListener.adLoaded( null );
        }
        // Otherwise (we should load the next ad)
        else
        {
            // Add ourself to the listeners
            synchronized ( loadLock )
            {
                if ( loadListener != null )
                {
                    incentivizedLoadListeners.add( loadListener );
                }
            }

            // Load the next interstitial
            doLoadIncentivizedAd( context, configuration );
        }
    }

    @Override
    public void processIncentivizedAdLoadTimeout()
    {
        super.processIncentivizedAdLoadTimeout();
        log( "Incentivized ad load did time out..." );

        synchronized ( loadLock )
        {
            // Clear all of the listeners
            incentivizedLoadListeners.clear();
        }
    }

    @Override
    public void showIncentivizedAd(final AppLovinMediatedAdInfo ad, final AppLovinMediationAdapterConfig configuration, final Activity activity, final AppLovinMediationDisplayListener displayListener)
    {
        log( "Showing incentivized..." );

        if ( isIncentivizedLoaded() )
        {
            lastIncentivizedDisplayListener = displayListener;
            doShowIncentivizedAd( configuration, activity );
        }
        else
        {
            log( "Incentivized is not loaded" );
            markIncentivizedAdFailedToDisplay( AppLovinMediationErrorCode.NETWORK_DISPLAY_INVALID_STATE );
        }
    }

    /**
     * Check if an interstitial ad is immediately available (i.e. loaded)
     *
     * @return <code>true</code> if an interstitial ad is available immediately.
     */
    protected abstract boolean isInterstitialLoaded();

    /**
     * Trigger loading of an interstitial ad
     *
     * @param context       Current application context.
     * @param configuration
     */
    protected abstract void doLoadInterstitialAd(final Context context, final AppLovinMediationAdapterConfig configuration);

    /**
     * Show last loaded interstitial ad. This method will be called only if <code>isInterstitialLoaded()</code> has returned <code>true</code>.
     *
     * @param configuration Current adapter configuration
     * @param activity
     */
    protected abstract void doShowInterstitialAd(final AppLovinMediationAdapterConfig configuration, final Activity activity);

    /**
     * Check if an incentivized ad is immediately available (i.e. loaded)
     *
     * @return <code>true</code> if an incentivized ad is available immediately.
     */
    protected abstract boolean isIncentivizedLoaded();

    /**
     * Trigger loading of an incentivized ad
     *
     * @param context       Current application context.
     * @param configuration Current adapter configuration
     */
    protected abstract void doLoadIncentivizedAd(final Context context, final AppLovinMediationAdapterConfig configuration);

    /**
     * Show last loaded incentivized ad. This method will be called only if <code>isIncentivizedLoaded()</code> has returned <code>true</code>.
     *
     * @param configuration Current adapter configuration
     * @param activity
     */
    protected abstract void doShowIncentivizedAd(final AppLovinMediationAdapterConfig configuration, final Activity activity);

    /**
     * This method should be called when the adapter has loaded an ad
     */
    protected void markInterstitialAdLoaded()
    {
        markAdLoaded( interstitialLoadListeners );
    }

    /**
     * This method should be called when adapter has failed to load an ad
     *
     * @param errorCode Error code returned by the adapter
     */
    protected void markInterstitialLoadFailed(final AppLovinMediationErrorCode errorCode)
    {
        markLoadFailed( interstitialLoadListeners, errorCode );
    }

    /**
     * This method should be called when an interstitial ad was displayed
     */
    protected void markInterstitialAdDisplayed()
    {
        markAdDisplayed( lastInterstitialDisplayListener );
    }

    /**
     * This method should be called when an interstitial ad was hidden
     */
    protected void markInterstitialAdHidden()
    {
        markAdHidden( lastInterstitialDisplayListener );
    }

    /**
     * This method should be called when an interstitial ad was clicked by the user
     */
    protected void markInterstitialAdClicked()
    {
        markAdClicked( lastInterstitialDisplayListener );
    }

    /**
     * This method should be called when an interstitial ad has failed to display
     *
     * @param errorCode Error code with the reason for failure
     */
    protected void markInterstitialAdFailedToDisplay(final AppLovinMediationErrorCode errorCode)
    {
        markAdFailedtoDisplay( lastInterstitialDisplayListener, errorCode );
    }

    /**
     * This method should be called when the adapter has loaded an ad
     */
    protected void markIncentivizedAdLoaded()
    {
        markAdLoaded( incentivizedLoadListeners );
    }

    /**
     * This method should be called when adapter has failed to load an ad
     *
     * @param errorCode Error code returned by the adapter
     */
    protected void markIncentivizedLoadFailed(final AppLovinMediationErrorCode errorCode)
    {
        markLoadFailed( incentivizedLoadListeners, errorCode );
    }

    /**
     * This method should be called when an incentivized ad was displayed
     */
    protected void markIncentivizedAdDisplayed()
    {
        markAdDisplayed( lastIncentivizedDisplayListener );
    }

    /**
     * This method should be called when an incentivized ad was hidden
     */
    protected void markIncentivizedAdHidden()
    {
        markAdHidden( lastIncentivizedDisplayListener );
    }

    /**
     * This method should be called when an incentivized ad was clicked by the user
     */
    protected void markIncentivizedAdClicked()
    {
        markAdClicked( lastIncentivizedDisplayListener );
    }

    /**
     * This method should be called when an incentivized ad's reward was validated
     */
    protected void markIncentivizedRewardVerified(final Map<String, String> rewardInfo)
    {
        markIncentivizedRewardVerified( lastIncentivizedDisplayListener, rewardInfo );
    }

    /**
     * This method should be called when an incentivized ad's reward was rejected
     */
    protected void markIncentivizedRewardRejected(final Map<String, String> rejectionInfo)
    {
        markIncentivizedRewardRejected( lastIncentivizedDisplayListener, rejectionInfo );
    }

    /**
     * This method should be called when an incentivized ad has failed to display
     *
     * @param errorCode Error code with the reason for failure
     */
    protected void markIncentivizedAdFailedToDisplay(final AppLovinMediationErrorCode errorCode)
    {
        markAdFailedtoDisplay( lastIncentivizedDisplayListener, errorCode );
    }

    private void markAdLoaded(final Set<AppLovinMediationLoadListener> listeners)
    {
        // Notify all listeners of the success
        final Set<AppLovinMediationLoadListener> listenersToNotify;
        synchronized ( loadLock )
        {
            listenersToNotify = new HashSet<AppLovinMediationLoadListener>( listeners );
            listeners.clear();
        }

        for ( AppLovinMediationLoadListener listener : listenersToNotify )
        {
            listener.adLoaded( null );
        }
    }

    private void markLoadFailed(final Set<AppLovinMediationLoadListener> listeners, final AppLovinMediationErrorCode errorCode)
    {
        // Notify all listeners of the failure
        final Set<AppLovinMediationLoadListener> listenersToNotify;
        synchronized ( loadLock )
        {
            listenersToNotify = new HashSet<AppLovinMediationLoadListener>( listeners );
            listeners.clear();
        }

        for ( AppLovinMediationLoadListener listener : listenersToNotify )
        {
            listener.failedToLoadAd( errorCode );
        }
    }

    private void markAdDisplayed(final AppLovinMediationDisplayListener listener)
    {
        if ( listener != null ) listener.adDisplayed( DEFAULT_AD );
    }

    private void markAdHidden(final AppLovinMediationDisplayListener listener)
    {
        if ( listener != null ) listener.adHidden( DEFAULT_AD );
    }

    private void markAdClicked(final AppLovinMediationDisplayListener listener)
    {
        if ( listener != null ) listener.adClicked( DEFAULT_AD );
    }

    private void markIncentivizedRewardVerified(final AppLovinMediationDisplayListener listener, final Map<String, String> rewardInfo)
    {
        if ( listener != null ) listener.rewardVerified( DEFAULT_AD, rewardInfo );
    }

    private void markIncentivizedRewardRejected(final AppLovinMediationDisplayListener listener, final Map<String, String> rejectionInfo)
    {
        if ( listener != null ) listener.rewardRejected( DEFAULT_AD, rejectionInfo );
    }

    private void markAdFailedtoDisplay(final AppLovinMediationDisplayListener listener, final AppLovinMediationErrorCode errorCode)
    {
        if ( listener != null ) listener.failedToDisplayAd( DEFAULT_AD, errorCode );
    }
}
