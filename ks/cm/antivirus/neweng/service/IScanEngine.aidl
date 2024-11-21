package ks.cm.antivirus.neweng.service;

import ks.cm.antivirus.neweng.IApkResult;
import ks.cm.antivirus.neweng.service.IScanServiceReadyCallBack;
import ks.cm.antivirus.neweng.service.ILoadExtCallBackForUi;
import ks.cm.antivirus.neweng.IScanApkCallBack;
import ks.cm.antivirus.apkscan.IApkScanTimeCallback;
import ks.cm.antivirus.apkscan.IApkScanUICallback;
import ks.cm.antivirus.apkscan.ISDCardScanUICallback;
import ks.cm.antivirus.scan.IScanDataChangedObserver;

interface IScanEngine {
	void setReadyCallback(String className, IScanServiceReadyCallBack callback) ;

	// ------------------- 查询部分 ------------------------
	IApkResult QueryByPkgName(String pkgName);

		/*
		IApkResult ScanByPkgName(String pkgName);
		*/

	// 体检后的所有apk结果
	List<IApkResult> getAllApkResult();
	
	// ------------------- ext部分 ------------------------
	void LoadExtAsyn(String pkgName , ILoadExtCallBackForUi callback , int tag ) ;
	
		// ------------------- 处理部分 ------------------------
		/*
		void startDeal();
		void stopDeal();

		void denyVirusList(in List<String> pkgNameList);
		void denyMalwareList(in List<String> pkgNameList);
		*/

		// 禁止广告
		/*
		IApkResult denyAd(String pkgName);
		void denyAdList(in List<String> pkgName) ;
		// 取消禁止广告
		IApkResult cancleDenyAd(String pkgName);
		*/
	
		/*
		// 禁止隐私
		IApkResult denyPrivacy(String pkgName);
		IApkResult denyPri(String pkgName ,inout int[] types) ;
		void denyPriList(in List<String> pkgName) ;
		// 取消禁止隐私
		IApkResult cancelDenyPri(String pkgName ,inout int[] types) ;
		*/
	
	// 恶意应用加入白名单
	IApkResult addToWhiteList(String PkgName);		
	// 恶意应用删除白名单
	IApkResult removeFromWhiteList(String PkgName);	
	
		// pc 扫描部分
		/*
		void startScan(IScanApkCallBack scanApkCallback);
		void pasueScan() ;
		void resumeScan() ;
		void stopScan();
		*/
	
	
	// --------------------- bind 计数 部分 --------------------------
	void notifyBind(String className) ;
	void notifyUnbind(String className) ;
	
	// --------------------- 安装监控部分 -----------------------------
	
	void notifyInstall(String pkgName ,String installerPkgName, boolean replaced);
	void notifyUninstall(String pkgName, boolean isReplaced);
	
	// --------------------- 樣本鑑定更新 -----------------------------
	void notifyCleanScanCache(in List<String> pkgNames);
	
	// --------------------- NEW -----------------------------
	
	// --------------------- ScanService 数据变化 -----------------------------
	void registerDataChangedObserver(String key, IScanDataChangedObserver observer);
	void unregisterDataChangedObserver(String key);
	
	// --------------------- 安装监控 -----------------------------
	void clearInstallMonitorNotifyCallbackMap(int notifyId, int notifyRollingId);
	
	// --------------------- Apk 扫描 -----------------------------
	void setApkScanTimeCallback(IApkScanTimeCallback callback);
	void setApkScanUICallback(IApkScanUICallback callback);
	void startApkScan();
	void stopApkScan();

	// --------------------- 定时扫描 -----------------------------
	void setScheduleScanUICallback(IApkScanUICallback callback);
	void startScheduleScan();
	void stopScheduleScan();
	 
	// --------------------- SD卡扫描 -----------------------------
	void setSDScanUICallback(ISDCardScanUICallback callback);
	void startSDCardScan();
	void startFileScan(in String[] files);
	void stopSDCardScan();

	// --------------------- file cloud scan -----------------------------
	void setFileCloudScanUICallback(ISDCardScanUICallback callback);
	void startFileCloudScan(in String[] files);
	void stopFileCloudScan();
	
	// --------------------- 更新缓存 -----------------------------
	// 通知 ScanService 应该更新缓存（ 由 DefendService 常驻进程检查是否该更新了） 
	void notifyScanServiceUpdateCache(IApkScanUICallback callback);
	
	// --------------------- 语言更换 -----------------------------
	void notifyAppLauguageChange();
	
	
	// --------------------- bind ex 计数 部分 --------------------------
	void notifyBindEx(String className, String strCallingProcessName, long lCallingProcessStartTimeMS) ;
	void notifyUnbindEx(String className, String strCallingProcessName, long lCallingProcessStartTimeMS) ;
	
	String dumpThreadStacks();
}
