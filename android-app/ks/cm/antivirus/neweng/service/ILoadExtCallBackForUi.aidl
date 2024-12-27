package ks.cm.antivirus.neweng.service;
import ks.cm.antivirus.neweng.IApkResult;

interface ILoadExtCallBackForUi {
	void OnExtLoadFinish(in IApkResult result,long version, int tags ,boolean bSuccess) ;
}
