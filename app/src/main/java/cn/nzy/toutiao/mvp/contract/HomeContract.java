package cn.nzy.toutiao.mvp.contract;


import cn.nzy.toutiao.Bean.NetDataBean;
import cn.nzy.toutiao.base.BaseContract;
import cn.nzy.toutiao.mvp.NetLisener;

/**
 * on 2018/1/2.
 * created by niezhiyang
 */

public class HomeContract {
    public interface IHomePresenter extends BaseContract.IBasePresenter  {

    }

    public interface IHomeView extends BaseContract.IBaseView {
        void showNetError();
        void showData(NetDataBean data);
        void hideProgressBar();
        void showRecyclerView();
        void goActivity();
        void reFresh();
        void loadMore();
    }
    public interface IHomeModule extends BaseContract.IBaseModule {
        void getNetData(String category, String last_refresh_sub_entrance_interval,  NetLisener netLisener);
    }
}
