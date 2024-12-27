// IAdCallback.aidl
package ks.cm.antivirus.ad.remote;

// Declare any non-default types here with import statements

interface IAdCallback {
    void onAdClosed();
    void onAdFailedToLoad(int errorCode);
    void onAdLeftApplication();
    void onAdOpened();
    void onAdLoaded();
    void onAdClicked();
    void onAdImpression();
}
