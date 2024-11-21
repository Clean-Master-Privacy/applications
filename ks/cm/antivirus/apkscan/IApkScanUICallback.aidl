package ks.cm.antivirus.apkscan;
import ks.cm.antivirus.neweng.IApkResult;
interface IApkScanUICallback {

	void onApkScanStart(int apkCnt);
	void onApkScanRestart();
	void onApkScanDone();
	void onApkScanStop();
	
	void onOneApkScanStart(String pkgName);
	void onOneApkScanDone(in IApkResult scanResult);
	
}
