// IInterstitialAdBinder.aidl
package ks.cm.antivirus.ad.remote;

// Declare any non-default types here with import statements

import ks.cm.antivirus.ad.remote.IAdCallback;

interface IInterstitialAdBinder {
    void loadAd(String ticket, String adUnitId, IAdCallback callback);
    void setTicket(String ticket);
    void setAdUnitId(String adUnitId);
    void setAdListener(IAdCallback callback);
    void show(String ticket);
    void destroy(String ticket);
    boolean isLoaded(String ticket);
    boolean isLoading(String ticket);
}
