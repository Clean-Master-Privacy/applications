package ks.cm.antivirus.notification;
interface INotification {

	void AutoSetNotifyByUpdated(boolean bReboot);
	boolean NotifyCostPower(String title, String content ,String ticker);
	boolean NotifySleepMode(String modeContent);
	boolean NotifyTemp(int tempType);
	
	void ProcessedPCConnecttingOk();
	void ProcessedSleepModeOk();
	void ProcessedPowerOk();
	void ProcessHarassOk();
	void ClearStatusNotify();
}
