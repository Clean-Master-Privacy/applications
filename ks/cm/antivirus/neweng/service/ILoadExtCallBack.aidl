package ks.cm.antivirus.neweng.service;
import ks.cm.antivirus.neweng.IApkResult;

interface ILoadExtCallBack {
	void OnExtLoadFinish(String json,long version, int tags ,boolean bSuccess) ;
}
