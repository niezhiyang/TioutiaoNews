package cn.nzy.toutiao.mvp.uidemo;


import android.os.Message;

import com.trello.rxlifecycle2.components.support.RxAppCompatActivity;
import com.trello.rxlifecycle2.components.support.RxFragment;

import java.util.concurrent.TimeUnit;

import cn.nzy.toutiao.Bean.UserBean;
import cn.nzy.toutiao.base.BaseModule;
import io.reactivex.Observable;
import io.reactivex.functions.Consumer;

public class LoginModule extends BaseModule implements LoginContract.ILoginModule {
    LoginLisener mLoginLisener;
    android.os.Handler mHandler = new android.os.Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what) {
                case 1:
                    UserBean textBean = new UserBean("nizhiyang", "123");
                    mLoginLisener.onSuccess(textBean);
                    break;
                case 2:
                    Throwable throwable = new IndexOutOfBoundsException();
                    mLoginLisener.onFail(throwable);
                    break;
            }
        }
    };

    public LoginModule(RxFragment loginAct) {
        super(loginAct);
    }

    public LoginModule(RxAppCompatActivity loginAct) {
        super(loginAct);
    }


    @Override
    public void toLogin(final String name, final String pwd,  final LoginLisener loginLisener) {
        mLoginLisener=loginLisener;
        //网络操作，返回数据
        new Thread()
        {
            @Override
            public void run()
            {
                try
                {
                    Thread.sleep(2000);
                } catch (InterruptedException e)
                {
                    e.printStackTrace();
                }
                //模拟登录成功
                if ("nzy".equals(name) && "pwd".equals(pwd)){
                    Observable.interval(1, TimeUnit.SECONDS)

                            .compose(mObjectLifecycleTransformer)
                            .subscribe(new Consumer<Long>() {
                                @Override
                                public void accept(Long aLong) throws Exception {
                                    mHandler.sendEmptyMessage(1);
                                }
                            });

                } else{

                    mHandler.sendEmptyMessage(2);
                }
            }
        }.start();
    }

}