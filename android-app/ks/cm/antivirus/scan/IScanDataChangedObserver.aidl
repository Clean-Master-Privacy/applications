package ks.cm.antivirus.scan;

interface IScanDataChangedObserver {

	void onInstall(String pkgName);
	
	void onUninstall(String pkgName);
	
	void onWhiteListAdd(String pkgName);
	
	void onWhiteListRemove(String pkgName);

}
