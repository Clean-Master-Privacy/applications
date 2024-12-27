package ks.cm.antivirus.neweng;

import ks.cm.antivirus.neweng.IApkResult;

interface IScanApkCallBack {
	
	// 体检开始
	void onStart(int totalCount);
	// 体检结束
	void onFinish();
	// 体检停止
	void onStop();
	
    // 一个apk扫描完成
    void onScanOneFinish(in IApkResult result); 
	
}
