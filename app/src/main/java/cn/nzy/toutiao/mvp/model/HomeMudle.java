package cn.nzy.toutiao.mvp.model;

import com.trello.rxlifecycle2.components.support.RxFragment;

import cn.nzy.toutiao.Bean.NetDataBean;
import cn.nzy.toutiao.api.HttpHelper;
import cn.nzy.toutiao.api.RxHelper;
import cn.nzy.toutiao.base.BaseModule;
import cn.nzy.toutiao.mvp.NetLisener;
import cn.nzy.toutiao.mvp.contract.HomeContract;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

/**
 * on 2018/1/2.
 * created by niezhiyang
 */

public class HomeMudle extends BaseModule implements HomeContract.IHomeModule {
    public HomeMudle(RxFragment rxFragment) {
        super(rxFragment);
    }

    @Override
    public void getNetData(String category, String last_refresh_sub_entrance_interval, final NetLisener netLisener) {
        HttpHelper.getDefault().getDataByQuery(category, last_refresh_sub_entrance_interval).compose(RxHelper.handleResult()).subscribe(new Observer<NetDataBean>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(NetDataBean netDataBean) {
                netLisener.onSuccess(netDataBean);
            }

            @Override
            public void onError(Throwable e) {
                netLisener.onFail(e);
            }

            @Override
            public void onComplete() {

            }
        });
    }
}
