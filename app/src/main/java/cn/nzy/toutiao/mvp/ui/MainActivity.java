package cn.nzy.toutiao.mvp.ui;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.blankj.utilcode.util.ConvertUtils;

import java.util.ArrayList;
import java.util.List;

import cn.nzy.toutiao.Bean.CategoryBean;
import cn.nzy.toutiao.R;
import cn.nzy.toutiao.view.TopTabLayout;

public class MainActivity extends AppCompatActivity {

    private HomePagerAdapter mHomePagerAdapter;

    private ViewPager mViewPager;

    private List<CategoryBean> infoEntities = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mHomePagerAdapter = new HomePagerAdapter(getSupportFragmentManager());
        infoEntities.add(new CategoryBean("热点", "news_hot"));
        infoEntities.add(new CategoryBean("视频", "video"));
        infoEntities.add(new CategoryBean("段子", "essay_joke"));
        infoEntities.add(new CategoryBean("社会", "news_society"));
        infoEntities.add(new CategoryBean("娱乐", "news_entertainment"));
        infoEntities.add(new CategoryBean("问答", "question_and_answer"));
        infoEntities.add(new CategoryBean("图片", "组图"));
        infoEntities.add(new CategoryBean("科技", "news_tech"));
        infoEntities.add(new CategoryBean("汽车", "news_car"));
        infoEntities.add(new CategoryBean("体育", "news_sport"));
        infoEntities.add(new CategoryBean("财经", "news_finance"));
        infoEntities.add(new CategoryBean("军事", "news_military"));
        infoEntities.add(new CategoryBean("国际", "news_world"));
        infoEntities.add(new CategoryBean("趣图", "image_funny"));
        mHomePagerAdapter.init(infoEntities);

        mViewPager = (ViewPager) findViewById(R.id.container);
        mViewPager.setAdapter(mHomePagerAdapter);
        mViewPager.setOffscreenPageLimit(infoEntities.size());
        final TopTabLayout tab = (TopTabLayout) findViewById(R.id.tabs);
        tab.setupWithViewPager(mViewPager);
        tab.setTabPaddingLeftAndRight( ConvertUtils.dp2px(10), ConvertUtils.dp2px(10));
        tab.setupWithViewPager(mViewPager);
    }


}
