package cn.nzy.toutiao.base;

import com.trello.rxlifecycle2.LifecycleTransformer;

public class BasePresenter<M extends BaseModule, V extends BaseContract.IBaseView> {
    public  LifecycleTransformer mLifecycleTransformer;
    public M module;

    public V view;

    void attatchWindow(M m, V v) {
        this.module = m;
        this.view = v;
    }

    void detachWindow() {
        this.module = null;
        this.view = null;
    }

}
