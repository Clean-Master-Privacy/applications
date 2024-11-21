package ks.cm.antivirus.gamebox.watcher;
import ks.cm.antivirus.gamebox.watcher.IProcessInfoAbnormalPss;

interface IProcessMemoryEventListener {
	void onProcessAbnormalPss(in IProcessInfoAbnormalPss l);
	void onMemoryExceptionScanEnd();
}
