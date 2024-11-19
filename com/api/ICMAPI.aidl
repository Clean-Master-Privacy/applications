package com.cleanmaster.api;

import com.cleanmaster.model.AppInfo;
interface ICMAPI {
	//获取数据库里面所有App打开监控数据
	List<AppInfo> 	getAppOpenFrequency();
	//调用锁屏杀进程功能
	void 			callScreenOffMemClean(int source);
	//判断锁屏杀进程功能是否已经开启
	boolean 		isScreenOffMemCleanEnabled();
	//设置锁屏杀进程功能开启关闭
	boolean			setScreenOffMemCleanSwitch(boolean enabled);
	//判断CM是否曾经运行过
	boolean			isCmFirstRun();
	//后台启动cm
	//source = 1	电池医生渠道
	boolean			startCmBackground(int source);
	
	///< 提供给cms的调用接口，将cms的数据传到cm的时光墙展现，数据格式为json，详细见SecurityTimeWallExportDefine.java
	boolean         addTimeWallData(String strJson);
	///< 提供给cms的调用接口，cms删除某条数据时也要通知cm删除对应的数据，详细见SecurityTimeWallExportDefine.java
	boolean         delTimeWallData(long lSysTimeMS, int nClassType);
	///< 支持多条数据删除，使用json格式，详细见SecurityTimeWallExportDefine.java
	boolean         delTimeWallDatas(String strJson);

    /******************************  11/14 游戏盒子添加 ******************************************************/
	/** 提供给CMS的接口，用于推荐游戏盒子 **/
	//  获取用户安装的游戏个数
	int getUserGameCount();

	//  桌面是否存在游戏盒子的快捷方式
	// @param considerHistory  是否依赖之前的创建标识
	boolean hasCreatedGameBoxShortcut(boolean considerHistory);

    // 是否打开游戏加速
	boolean hasOpenedGameBoost();

    // 首次游戏扫描是否结束
	boolean hasFinishedGameScanning();

    // 异步打开游戏加速
	void openGameBoostAsync(int boostSource);

    // 异步创建游戏盒子快捷方式
	void createGameBoxShortcutAsync(int createSource);

    // 打开游戏盒子页面
    void startGameBoxActivity(int source);
    // 返回加速百分比
    int canBoostPercent();
    // 显示创建游戏盒子的动画
    void startGameBoxDialog(int source);

    List<String> getGameList(int source);
}
