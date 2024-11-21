// IAccService.aidl

package ks.cm.antivirus.scan.packageStopper.accService;
import ks.cm.antivirus.scan.packageStopper.accService.IAccCallback;
import java.util.Map;

interface IAccService {
    /**
     * 判断 Accessibility Service 是否已经系统授权
     * @return
     */
    boolean isAccAuthorized();

    /**
    * 设置处理回调
    * @return
    */
    void setAccCallback(IAccCallback callback);

    /**
     * 执行相关操作
     * @param callback 回调
     * @param optCode 操作码
     * @param listPkg 包名列表
     * @return
     */
    int opt(in Map opList);

    /**
     * 取消操作
     * 如果已经调用了  opt 会立即调用对应的回调
     * @return
     */
    int cancel();

	/**
     * 设置操作完成回调页面
     * @return
     */
	void setReturnActivity(String returnActName);

    /**
     * 执行相关操作
     * @param optCode 操作码
     * @param listPkg 包名列表
     * @return
     */
    int optByList(int optCode, in List<String> listPkg);
}
