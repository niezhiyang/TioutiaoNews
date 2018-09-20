package cn.nzy.toutiao;

import android.app.Application;

import com.blankj.utilcode.util.Utils;
import com.facebook.stetho.Stetho;
import com.orhanobut.logger.AndroidLogAdapter;
import com.orhanobut.logger.Logger;
import com.squareup.leakcanary.LeakCanary;

/**
 * on 2017/12/25.
 * 类的描述:
 */

public class MyApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        // 初始化LeakCanary
        if (LeakCanary.isInAnalyzerProcess(this)) {
            return;
        }
        LeakCanary.install(this);
        //初始化Stetho   /////////////
        Stetho.initializeWithDefaults(this);
        Utils.init(this);
        Logger.addLogAdapter(new AndroidLogAdapter());
    }
}
