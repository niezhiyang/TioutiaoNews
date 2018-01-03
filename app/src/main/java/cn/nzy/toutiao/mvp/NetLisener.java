package cn.nzy.toutiao.mvp;

import cn.nzy.toutiao.Bean.NetDataBean;

/**
 * on 2018/1/2.
 * created by niezhiyang
 */

public interface NetLisener {
    void onSuccess(NetDataBean userBean);
    void onFail(Throwable throwable);
}
