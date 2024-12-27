package ks.cm.antivirus.remotedata;

import ks.cm.antivirus.remotedata.IVirusDataVersion;
import ks.cm.antivirus.neweng.IApkResult;
import ks.cm.antivirus.neweng.service.ILoadExtCallBack;
import ks.cm.antivirus.remotedata.IVirusUpdateCallBack;
import ks.cm.antivirus.neweng.IApkResult;

interface IRemoteDataBinder {
	
    /************************************************* 公共部分 ***********************************************/
	void 			LoadExtAsy(String pkgName,String signMd5,in ILoadExtCallBack callback,int tags);
	
    /************************************************* 广告部分 ***********************************************/
	
	boolean 		IsAdMonitorOn();   										/// 广告监控开关是否打开
	void 			SetAdMonitorOn(boolean bMonitor);   					/// 设置广告监控开关
	void registerUpdateCall(IVirusDataVersion updateVersion);
	void notifyUpdate();
	
	void virusDatabaseCheck(IVirusUpdateCallBack virusUpdateCallBack);//手动更新病毒库
	void virusDataCheckCancel();
	void virusDatabaseUpdate();
	void virusDataUpdateCancel();
	void virusCancel();
	
	/************************************************* 上传灰样本 **********************************************/
	void reportUnknowAppWithList(boolean isCancel, in List<IApkResult> unknownList, in List<String> ticketList);
	
	/************************************************* GCM注册 **********************************************/
	void gcmRegist();
	void gcmUnRegist();
	void gcmSwitchEmail(String newEmail);
	void gcmSwithcCancel();
	void lockScreen(String phone);
	void unLockScreen();
	//以下是获取云端文案接口
	String getCloudCfgStringValue(String key, String subKey, String defValue);
}
