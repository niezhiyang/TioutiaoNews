package cn.nzy.toutiao.mvp.uidemo;

import cn.nzy.toutiao.Bean.UserBean;
import cn.nzy.toutiao.base.BaseContract;

public class LoginContract {

    public interface ILoginView extends BaseContract.IBaseView {

        String getName();
        String getPwd();
        void showNetError(Throwable throwable);
        void showSuccess(UserBean userBean);
        void showProgrssbar();
        void hideProgrssbar();

    }

    public interface ILoginPresenter extends BaseContract.IBasePresenter {

    }

    public interface ILoginModule extends BaseContract.IBaseModule {
        void toLogin(String name, String pwd,  LoginLisener loginLisener);
    }
}
