package cn.nzy.toutiao;


import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.widget.Toast;

import cn.nzy.toutiao.Bean.UserBean;
import cn.nzy.toutiao.base.BaseActivity;
import cn.nzy.toutiao.base.BaseModule;
import cn.nzy.toutiao.mvp.uidemo.LoginContract;
import cn.nzy.toutiao.mvp.uidemo.LoginModule;
import cn.nzy.toutiao.mvp.uidemo.LoginPresenter;

public class LoginAct extends BaseActivity<LoginContract.ILoginView, LoginPresenter> implements LoginContract.ILoginView {
    private static final String TAG = "LoginAct";
    private ProgressDialog mProgressDialog;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        presenter.toLogin();
    }


    @Override
    protected BaseModule setModule() {
        return new LoginModule(this);
    }


    @Override
    protected LoginPresenter setPresenter() {
        return new LoginPresenter();
    }

    @Override
    public String getName() {
        return "nzy";
    }

    @Override
    public String getPwd() {
        return "pwd";
    }

    @Override
    public void showNetError(Throwable throwable) {
        Log.i("----","错误了");
        Toast.makeText(this, "错误了", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showSuccess(UserBean userBean) {
        Log.i("----","成功了");
        Toast.makeText(this, userBean.toString(), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showProgrssbar() {
        mProgressDialog = new ProgressDialog(this);
        mProgressDialog.setTitle("登陆中...");
        mProgressDialog.show();
    }

    @Override
    public void hideProgrssbar() {
        if (mProgressDialog != null) {
            mProgressDialog.dismiss();
        }
    }

}