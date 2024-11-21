package ks.cm.antivirus.api;

interface ICMSecurityAPI
{
    /*
	 * 查询漏洞修复状态
	 * param  [in] byLoopholeType 取值为CMSecurityAPIDefine.LOOPHOLE_TYPE_SYS_*系列
	 * return 返回值为漏洞修复状态，返回值为CMSecurityAPIDefine.RESULT_LOOPHOLE_*系列
	 */
	int QuerySysLoopholeFixState(byte byLoopholeType);
	
	/*
	 * 修复漏洞
	 * param  [in] byLoopholeType 取值为CMSecurityAPIDefine.LOOPHOLE_TYPE_SYS_*系列
	 * return 返回修复结果，返回值为CMSecurityAPIDefine.ERROR_*系列
	 */
	int FixSysLoophole(byte byLoopholeType);
	
	/**
	*  获取防盗 功能状态
    * CMSecurityAPIDefine.ANTI_THEFT_STATE_CLOSE 未开启，CMSecurityAPIDefine.ANTI_THEFT_STATE_OPEN 开启
	*/
	int getAntiTheftState();
}
