package cn.nzy.toutiao;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.trello.rxlifecycle2.android.ActivityEvent;
import com.trello.rxlifecycle2.components.support.RxAppCompatActivity;

import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;

public class TwoActivity extends RxAppCompatActivity {

    private static final String TAG = "RxLifecycleAndroid";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Log.d(TAG, "onCreate()");

        setContentView(R.layout.activity_main);

        // Specifically bind this until onPause()
        Observable.interval(1, TimeUnit.SECONDS)
                .doOnDispose(new Action() {
                    @Override
                    public void run() throws Exception {
                        Log.i(TAG, "Unsubscribing subscription from onCreate()");
                    }
                })
                .compose(this.<Long>bindUntilEvent(ActivityEvent.DESTROY))
                .subscribe(new Consumer<Long>() {
                    @Override
                    public void accept(Long aLong) throws Exception {
                        Log.i(TAG, "开始于--onCreate, 结束于--DESTROY(): " + aLong);
                    }
                });
    }

    @Override
    protected void onStart() {
        super.onStart();

    }

    @Override
    protected void onResume() {
        super.onResume();

        Log.d(TAG, "onResume()");

        // `this.<Long>` is necessary if you're compiling on JDK7 or below.
        //
        // If you're using JDK8+, then you can safely remove it.
//        Observable.interval(1, TimeUnit.SECONDS)
//                .doOnDispose(new Action() {
//                    @Override
//                    public void run() throws Exception {
//                        Log.i(TAG, "Unsubscribing subscription from onResume()");
//                    }
//                })
//                .compose(this.<Long>bindUntilEvent(ActivityEvent.DESTROY))
//                .subscribe(new Consumer<Long>() {
//                    @Override
//                    public void accept(Long num) throws Exception {
//                        Log.i(TAG, "开始于-- onResume(), 结束于-- onDestroy(): " + num);
//                    }
//                });
    }
    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG, "onPause()");
    }

    @Override
    protected void onStop() {
        super.onStop();

        Log.d(TAG, "onStop()");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        Log.d(TAG, "onDestroy()");
    }

    public void clikck(View view) {
    }
}
