package cn.nzy.toutiao.base;

import com.trello.rxlifecycle2.LifecycleTransformer;
import com.trello.rxlifecycle2.android.ActivityEvent;
import com.trello.rxlifecycle2.android.FragmentEvent;
import com.trello.rxlifecycle2.components.support.RxAppCompatActivity;
import com.trello.rxlifecycle2.components.support.RxFragment;

public class BaseModule implements BaseContract.IBaseModule {
    public LifecycleTransformer mObjectLifecycleTransformer;

    public BaseModule(RxFragment loginAct) {
        super();
        mObjectLifecycleTransformer = loginAct.bindUntilEvent(FragmentEvent.PAUSE);
    }
    public BaseModule(RxAppCompatActivity loginAct) {
        super();
        mObjectLifecycleTransformer = loginAct.bindUntilEvent(ActivityEvent.PAUSE);
    }
}