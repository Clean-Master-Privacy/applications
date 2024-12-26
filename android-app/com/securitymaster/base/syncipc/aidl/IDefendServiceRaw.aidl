package com.securitymaster.base.syncipc.aidl;
import com.cleanmaster.security.toast.ToastBuilder;
import ks.cm.antivirus.notification.internal.NotificationRemindConfig;

interface IDefendServiceRaw {

	    // 启动防御，调用者只能为 com.ijinshan.duba
    
    	boolean Start(java.lang.String strClientAPKName);
    
    	// 关闭防御，调用者只能为 com.ijinshan.duba
    
    	boolean Stop(java.lang.String strClientAPKName);

    	// 查询防御状态，调用者只能为 com.ijinshan.duba
    	// 如果返回 1 防御正在运行
    	// 如果返回0 防御被停止
    	// 如果返回-1 调用者无效
    
    	int QueryDefendState(java.lang.String strClientAPKName);
    
    	// 恶意应用规则管理
    	boolean PushDefendRule(java.lang.String strPkgName,
    			java.lang.String strAPKSign, java.lang.String rule)
    			;
    
    	boolean IsApkInAdwareRule(java.lang.String strPkgName)
    			;
    
    	// ////////////////
    	// 检查服务是否存在
    
    	java.lang.String CheckAlive() ;
    
    	// ////////////////
    	// 通知服务有新的任务栏通知出现
    
    	java.util.List<java.lang.String> AdGetNotifyInfo(
    			java.lang.String strAPKName, int nId)
    			;
    
    	// 广告的接口
    
    	void AdClearPopCount() ;
    
    	// / 检查是否需要完全重新扫描广告
    
    	boolean CheckNeedReScanAdware() ;
    
    	// / 设置已经进行了广告的完全扫描
    
    	void SetAdwareFullScan(boolean bNeed)
    			;
    
    	// / 主进程升级库完成后的通知
    
    	void NotifyUpdateDataFinish() ;
    
    	// / 被结束进程通知
    	// / 返回1 允许被结束
    	// / 返回0 不允许被结束
    
    	int TerminateNotify(java.lang.String pkgname, int clientPid)
    			;
    
    	boolean IsUrlProtectOpen(java.lang.String pkgName)
    			;
    
    	// 接收到跨域弹框认证攻击
    
    	void UrlProtectAuthLoginHack(java.lang.String pkgName,
    			java.lang.String url, java.lang.String urlHost,
    			java.lang.String authHost) ;

    	// 用户是否打开拦截钓鱼url
    
    	void SetBlockFishUrl(boolean isBlock)
    			;

    	// 通知防御更新全局缓存

        void NotifyRuleChanged(java.lang.String pkgName)
                    			;

    	/************************************************ 通知启动计划任务 */
    	void notifyStartScheduledTask(byte byScheduledTask)
    			;

    	// /< 通知app语言更新

    	void notifyAppLauguageChange() ;

   	// /< copy so
    	// /< @return -1:加载系统默认路径 1:加载mSystemLibPath路径 2:加载自拷贝路径

    	int syncSoFiles(java.lang.String strLibName, in java.util.List<java.lang.String> listDepenceLibNames,
    						   boolean bForceExtract,
    						   boolean bSyncDependentLibs);

    	void setBlockFinancialUrl(boolean isBlock)
    			;
        void setBlockXXXUrl(boolean isBlock)
            	;
    	void setBlockMedicalUrl(boolean isBlock)
    			;

    	java.lang.String dumpThreadStacks() ;


    	void setBlockUrlTrace(boolean isBlock)
    			;
    	
    	void setBlockSensitiveSuggestion(boolean isBlock)
    			;

    	byte[] handleNativeServiceClient(in byte[] req);


    	void setDownloadSafetyScanEnabled(boolean enabled)
    			;
    	// 是否需要 Wifi AP changed 跳起測速頁面
    	void enableSpeedTestPopping(boolean enabled) ;
    
    	void notifyJuheNoti(int notiId, java.lang.String strNotiInfo, boolean enable, in NotificationRemindConfig remindConfig) ;

        // CMSToastManager
        void sendToastConfig(in ToastBuilder config) ;
    
    	void triggerGetIPTask();
    	//////////////*********!!!!!注意!!!!!**********//////////////////
    	/////////////
    	/////////////
    	/////////////
    	////////////  请勿在此新加入接口,需要使用sync ipc的,请查看ServiceManager中相关service的使用
    	/////////////
    	////////////  请勿改动此处接口顺序,造成transaction的index变动,带来风险.
    	////////////
    	////////////
    	//////////////*******************//////////////////




    	//                        //
    	////                      //
    	// //                     //
    	//   //                   //
    	//     //                 //         //////
        //       //               //       //      //
        //         //             //      //        //
        //           //           //      //         //
        //             //         //      //         //
        //               //       //       //       //
        //                 //     //        //      //
        //                   //   //          //////
        //                     // //
        //                       ///
}

