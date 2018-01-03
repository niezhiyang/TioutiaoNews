package cn.nzy.toutiao.mvp.ui;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import com.blankj.utilcode.util.ToastUtils;

import java.util.ArrayList;
import java.util.List;

import cn.nzy.toutiao.Bean.CategoryBean;
import cn.nzy.toutiao.Bean.NetDataBean;
import cn.nzy.toutiao.R;
import cn.nzy.toutiao.adater.NewsAdapter;
import cn.nzy.toutiao.base.BaseLazyFragment;
import cn.nzy.toutiao.base.BaseModule;
import cn.nzy.toutiao.mvp.contract.HomeContract;
import cn.nzy.toutiao.mvp.model.HomeMudle;
import cn.nzy.toutiao.mvp.presenter.HomePresenter;

/**
 * on 2018/1/2.
 * created by niezhiyang
 */

public class HomeLazyFragment extends BaseLazyFragment<HomeContract.IHomeView, HomePresenter> implements HomeContract.IHomeView {
    private ProgressBar progressBar;
    private RecyclerView mRecyclerView;
    private CategoryBean info;
    private NewsAdapter mNewsAdapter;
    private static final String ARG_INFO_ENTITY = "arg_info_entity";
    private List<NetDataBean.DataBean> mDataBeanList;

    public HomeLazyFragment() {
    }

    public static HomeLazyFragment newInstance(CategoryBean categoryBean) {
        HomeLazyFragment fragment = new HomeLazyFragment();
        Bundle args = new Bundle();
        args.putSerializable(ARG_INFO_ENTITY, categoryBean);
        fragment.setArguments(args);
        if (categoryBean != null) {
            fragment.setTitle(categoryBean.getTitle());
        }
        return fragment;
    }

    @Override
    protected HomePresenter setPresenter() {
        return new HomePresenter();
    }

    @Override
    protected BaseModule setModule() {
        return new HomeMudle(this);
    }

    @Override
    public void initVariables(Bundle bundle) {
        info = (CategoryBean) bundle.getSerializable(ARG_INFO_ENTITY);

    }

    @Override
    protected View initViews(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_main, container, false);
        progressBar = (ProgressBar) rootView.findViewById(R.id.progress_bar);
        mRecyclerView = (RecyclerView) rootView.findViewById(R.id.recyclerView);

        return rootView;
    }

    @Override
    protected void initData() {
        mDataBeanList = new ArrayList<>();
        mNewsAdapter = new NewsAdapter(mDataBeanList, this);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false));
        mRecyclerView.setAdapter(mNewsAdapter);

        String category = info.getCategory();
        presenter.getNetData(category, System.currentTimeMillis() + "");
    }

    public void refreshData(CategoryBean categoryBean) {
        if (categoryBean != null) {
            info = categoryBean;

            Bundle args = getArguments();
            if (args != null) {
                args.putSerializable(ARG_INFO_ENTITY, info);
            }

            if (mRecyclerView != null) {
                mRecyclerView.setVisibility(View.GONE);
            }
            if (progressBar != null) {
                progressBar.setVisibility(View.VISIBLE);
            }

            if (isFragmentVisible()) {
                initData();
            } else {
                setForceLoad(true);
            }
        }
    }

    @Override
    protected void setDefaultFragmentTitle(String title) {
    }

    @Override
    public void showNetError() {
        ToastUtils.showShort("网络错误，请检查网络");
    }

    @Override
    public void showData(NetDataBean data) {
        List<NetDataBean.DataBean> dataList = data.getData();
        mDataBeanList.addAll(dataList);
        mNewsAdapter.notifyDataSetChanged();

    }

    @Override
    public void hideProgressBar() {
        progressBar.setVisibility(View.GONE);
    }

    @Override
    public void showRecyclerView() {
        mRecyclerView.setVisibility(View.VISIBLE);
    }

    @Override
    public void goActivity() {

    }

    @Override
    public void reFresh() {

    }

    @Override
    public void loadMore() {

    }
}
