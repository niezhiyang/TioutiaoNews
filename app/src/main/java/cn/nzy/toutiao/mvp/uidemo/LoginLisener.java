package cn.nzy.toutiao.mvp.uidemo;

import cn.nzy.toutiao.Bean.UserBean;

/**
 * on 2017/12/27.
 * created by niezhiyang
 */

public interface LoginLisener {
    void onSuccess(UserBean userBean);
    void onFail(Throwable throwable);
}
