package cn.nzy.toutiao.mvp.ui;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import java.util.ArrayList;
import java.util.List;

import cn.nzy.toutiao.Bean.CategoryBean;
import cn.nzy.toutiao.base.BaseLazyFragment;

public class HomePagerAdapter extends FragmentStatePagerAdapter {
    private List<HomeLazyFragment> fragmentList = new ArrayList<>();

    public HomePagerAdapter(FragmentManager fm) {
        super(fm);
    }

    public void init(List<CategoryBean> list) {
        fragmentList.clear();
        for (CategoryBean info : list) {
            fragmentList.add(HomeLazyFragment.newInstance(info));
        }
    }

    public void refreshAllFragment(List<CategoryBean> list) {
        for (CategoryBean info : list) {
            for (HomeLazyFragment fragment : fragmentList) {
                //最好使用唯一标示来判定是否刷了正确的Fragment 比如id
                String pageTitle = fragment.getTitle();
                if (pageTitle != null && pageTitle.equals(info.getTitle())) {
                    fragment.refreshData(info);
                }
            }
        }
    }

    @Override
    public int getItemPosition(Object object) {
        return POSITION_NONE;
    }

    @Override
    public Fragment getItem(int position) {
        if (fragmentList != null && position < fragmentList.size()) {
            return fragmentList.get(position);
        }
        return null;
    }

    @Override
    public int getCount() {
        return fragmentList.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        if (getItem(position) instanceof BaseLazyFragment) {
            return ((BaseLazyFragment) getItem(position)).getTitle();
        }
        return super.getPageTitle(position);
    }
}