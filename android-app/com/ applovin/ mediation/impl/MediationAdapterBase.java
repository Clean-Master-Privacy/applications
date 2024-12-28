    package com.applovin.mediation.impl;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.text.TextUtils;

import com.applovin.mediation.AppLovinMediatedAdInfo;
import com.applovin.mediation.AppLovinMediationAdapter;
import com.applovin.mediation.AppLovinMediationAdapterConfig;
import com.applovin.sdk.AppLovinLogger;
import com.applovin.sdk.AppLovinSdk;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

/**
 * This is a base class that provides continence methods for mediation adapter implementations
 * <p>
 * Created by basil on 12/9/16.
 */

public abstract class MediationAdapterBase
        implements AppLovinMediationAdapter
{
    /**
     * This key is used to point to the name of the current adapter
     */
    public static final String KEY_ADAPTER = "adapter";

    /**
     * Interstitial placement identifier.
     */
    public static final String KEY_INTERSTITIAL_PLACEMENT_ID = "inter_placement_id";

    /**
     * Incentivized placement identifier.
     */
    public static final String KEY_INCENTIVIZED_PLACEMENT_ID = "incent_placement_id";

    /**
     * Current reward currency.
     */
    public static final String KEY_REWARD_CURRENCY = "currency";

    /**
     * Current reward amount.
     */
    public static final String KEY_REWARD_AMOUNT = "amount";

    /**
     * This key tells if the adapter should initialize automatically or if it is expected to be initialized by the application elsewhere. It is advised to be shared across adapters.
     */
    protected static final String KEY_INIT = "init";

    /**
     * This key tells if the adapter should attach to the existing initialized instance of the third-party SDK
     */
    protected static final String KEY_ATTACH = "attach";

    /**
     * Configuration key that specifies whether to mute ads or not.
     */
    protected static final String KEY_MUTED = "muted";

    /**
     * Configuration key that specifies default reward amount to use
     */
    private static final String KEY_CONFIG_REWARD_AMOUNT = "reward_amount";

    /**
     * Configuration key that specifies default reward currency to use
     */
    private static final String KEY_CONFIG_REWARD_CURRENCY = "reward_currency";

    // Parent objects
    protected final String tag;

    protected AppLovinSdk    sdk;
    protected AppLovinLogger logger;

    // State objects
    protected final AtomicBoolean isEnabled = new AtomicBoolean( false );

    protected MediationAdapterBase()
    {
        tag = this.getClass().getSimpleName();
    }

    @Override
    public void initialize(final AppLovinMediationAdapterConfig configuration, final AppLovinSdk sdk, final Activity activity) throws Exception
    {
        this.sdk = sdk;
        this.logger = sdk.getLogger();
    }

    @Override
    public boolean isReady()
    {
        return isEnabled.get();
    }

    @Override
    public void processIncentivizedAdLoadTimeout() {}

    @Override
    public void processInterstitialAdLoadTimeout() {}

    protected void markEnabled()
    {
        isEnabled.set( true );
    }

    protected void markDisabled()
    {
        isEnabled.set( false );
    }

    protected void log(final String message)
    {
        if ( logger != null ) logger.i( tag, message );
    }

    protected void checkExistence(final Class<?>... classes)
    {
        if ( classes != null && classes.length > 0 )
        {
            for ( Class<?> classType : classes )
            {
                log( "Found: " + classType.getName() );
            }
        }
    }

    protected void checkActivities(final Class<?>... activityClasses)
    {
        if ( activityClasses != null && activityClasses.length > 0 )
        {
            final Context context = sdk.getApplicationContext();

            for ( Class activityClass : activityClasses )
            {

                try
                {
                    final ComponentName component = new ComponentName( context, activityClass );
                    final ActivityInfo activityInfo = context.getPackageManager().getActivityInfo( component, PackageManager.GET_META_DATA );

                    if ( activityInfo != null )
                    {
                        log( "Found defined activity: " + activityClass.getName() );
                    }
                    else
                    {
                        throw new PackageManager.NameNotFoundException( "null_activity_info" );
                    }
                }
                catch ( PackageManager.NameNotFoundException e )
                {
                    log( "No activity found for: " + activityClass );

                    throw new IllegalStateException( "Activity " + activityClass.getName() + " not defined", e );
                }
            }
        }
    }

    protected Map<String, String> createRewardInfo(final AppLovinMediationAdapterConfig config)
    {
        return createRewardInfo( -1, null, config );
    }

    protected Map<String, String> createRewardInfo(final int amount, final String currency, final AppLovinMediationAdapterConfig config)
    {
        final Map<String, String> result = createEmptyRewardInfo();

        // If we have a valid amount
        if ( amount > 0 )
        {
            // Use that
            result.put( KEY_REWARD_AMOUNT, String.valueOf( amount ) );
        }
        // Otherwise (no amount passed)
        else
        {
            // Pull amount from the config
            // TO CONFIRM -> "reward_amount" is an arbitrary key we're putting on our site? Right now it's diff than KEY_REWARD_AMOUNT
            final int defaultAmount = config.getInt( KEY_CONFIG_REWARD_AMOUNT, -1 );
            if ( defaultAmount > 0 )
            {
                result.put( KEY_REWARD_AMOUNT, String.valueOf( defaultAmount ) );
            }
            else
            {
                log( "No reward amount found, using 0" );

                result.put( KEY_REWARD_AMOUNT, "0" );
            }
        }

        // If we have a valid currency
        if ( !TextUtils.isEmpty( currency ) )
        {
            // Use that
            result.put( KEY_REWARD_CURRENCY, currency );
        }
        // Otherwise (no currency passed)
        else
        {
            // Pull currency from the config
            final String defaultCurrency = config.getString( KEY_CONFIG_REWARD_CURRENCY, null );
            if ( !TextUtils.isEmpty( defaultCurrency ) )
            {
                result.put( KEY_REWARD_CURRENCY, defaultCurrency );
            }
            else
            {
                log( "No reward currency found, using ''" );

                result.put( KEY_REWARD_CURRENCY, "" );
            }
        }
        return result;
    }

    protected Map<String, String> createEmptyRewardInfo()
    {
        final Map<String, String> result = new HashMap<String, String>();

        // Always put the current adapter name
        result.put( KEY_ADAPTER, tag );

        return result;
    }

    protected static <T> AppLovinMediatedAdInfo toMediatedAd(final T adObject, final Class<T> objectType)
    {
        // Check input
        if ( adObject == null ) throw new IllegalArgumentException( "No ad object specified" );
        if ( objectType == null ) throw new IllegalArgumentException( "No object type specified" );

        Map<String, Object> adInfo = new HashMap<String, Object>( 1 );
        adInfo.put( objectType.getName(), adObject );
        return new AppLovinMediatedAdInfo( adInfo );
    }

    protected static <T> T fromMediatedAd(final Class<T> objectType, final AppLovinMediatedAdInfo ad)
    {
        // Check input
        if ( objectType == null ) throw new IllegalArgumentException( "No object type specified" );
        if ( ad == null ) return null;

        final Object result = ad.get( objectType.getName() );
        if ( result != null )
        {
            if ( objectType.isInstance( result ) )
            {
                return objectType.cast( result );
            }
            else
            {
                throw new IllegalStateException( result.getClass().getName() + " is not of type " + objectType.getName() );
            }
        }

        return null;
    }
}
    
