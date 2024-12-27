package ks.cm.antivirus.apkscan;

import ks.cm.antivirus.neweng.IApkResult;

interface ISDCardScanUICallback {

	void onSDScanStart();
	void onSDScanRestart();
	
	void onSDScanDone();
	void onSDScanStop();
	void onOneFileScanDone(in IApkResult scanResult, int index, float percent);

}
