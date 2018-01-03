package cn.nzy.toutiao.mvp.presenter;

import cn.nzy.toutiao.Bean.NetDataBean;
import cn.nzy.toutiao.base.BasePresenter;
import cn.nzy.toutiao.mvp.NetLisener;
import cn.nzy.toutiao.mvp.contract.HomeContract;
import cn.nzy.toutiao.mvp.model.HomeMudle;
import cn.nzy.toutiao.mvp.ui.HomeLazyFragment;

/**
 * on 2018/1/2.
 * created by niezhiyang
 */

public class HomePresenter extends BasePresenter<HomeMudle, HomeLazyFragment> implements HomeContract.IHomePresenter  {
    public void  getNetData(String category, String last_refresh_sub_entrance_interval){

            module.getNetData(category, last_refresh_sub_entrance_interval, new NetLisener() {
                @Override
                public void onSuccess(NetDataBean netData) {
                    view.showRecyclerView();
                    view.hideProgressBar();
                    view.showData(netData);
                }

                @Override
                public void onFail(Throwable throwable) {
                    view.showNetError();
                }
            });
    };
}
