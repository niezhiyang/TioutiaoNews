package cn.nzy.toutiao.base;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.trello.rxlifecycle2.components.support.RxAppCompatActivity;

public abstract class BaseActivity<V extends BaseContract.IBaseView,P extends BasePresenter> extends RxAppCompatActivity implements BaseContract.IBaseView {



    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
            presenter= setPresenter();
            presenter.attatchWindow(setModule(),this);
    }

    public P presenter;
    protected abstract P setPresenter();

    protected abstract BaseModule setModule();

    @Override
    protected void onDestroy() {
        super.onDestroy();
        presenter.detachWindow();
    }
}
