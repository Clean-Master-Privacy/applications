package ks.cm.antivirus.apkscan;

import ks.cm.antivirus.neweng.IApkResult;

interface IApkScanTimeCallback {

    void onScanPloyCloud(boolean isCloudPloy);

	void onRemainTimeMillis(long timeMillis);
	
}
