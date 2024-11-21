package ks.cm.antivirus.scan.packageStopper.accService;

interface IAccCallback {

    /** 授权是否成功
      * isSuccess
    */
    void onAuthorize(boolean isSuccess);

    /**
     * listPkg 即将开始的列表
     * optCode 处理参数
     */
    void onBeginOptimize(in List<String> listPkg,in int optCode);

    void onCurrProcess(String currPkg);
    /**
     * listPkg 即将开始的列表  如果 listPkg 为空则表示 没有需要处理的列表
     * optCode 处理参数
     * result 处理的结果  IAccOptCallback.CALLBACKVALUE_SUCCESS  IAccOptCallback.CALLBACKVALUE_FAILURE,
     * isEnd 是否全部处理完毕
     */
    void onOptimizeProcess(in String pkg, in int optCode, in int result,in boolean isEnd);

    //isInSettingsPage 是否进入过APP详情页面
    void onOptimizeEnd(boolean isInSettingsPage);
}
