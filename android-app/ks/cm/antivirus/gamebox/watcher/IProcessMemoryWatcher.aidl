package ks.cm.antivirus.gamebox.watcher;

import java.util.List;

import ks.cm.antivirus.gamebox.watcher.IProcessMemoryEventListener;
import ks.cm.antivirus.gamebox.watcher.IProcessInfoGeneric;

interface IProcessMemoryWatcher {
	void start();
	void stop();
	void registerEventListener(IProcessMemoryEventListener l);
	void removeEventListener(IProcessMemoryEventListener l);
	List<IProcessInfoGeneric> getKillSuggest(String pkg, int size);
}
