package cn.nzy.toutiao.mvp.uidemo;


import cn.nzy.toutiao.Bean.UserBean;
import cn.nzy.toutiao.LoginAct;
import cn.nzy.toutiao.base.BasePresenter;

public class LoginPresenter extends BasePresenter<LoginModule, LoginAct> implements LoginContract.ILoginPresenter {

    public void toLogin() {
        view.showProgrssbar();
        module.toLogin(view.getName(), view.getPwd(), new LoginLisener() {
            @Override
            public void onSuccess(UserBean userBean) {
                view.hideProgrssbar();
                view.showSuccess(userBean);
            }

            @Override
            public void onFail(Throwable throwable) {
                view.hideProgrssbar();
                view.showNetError(throwable);
            }
        });

    }


}
