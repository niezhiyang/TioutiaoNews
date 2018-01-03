package cn.nzy.toutiao;

import android.util.Log;

import java.text.NumberFormat;
import java.util.Locale;

/**
 * on 2017/12/27.
 * created by niezhiyang
 */

public class Text {
    public void useAppContext() throws Exception {
        int data = 2;
        double money = data / 100.0;
        // 想要转换成指定国家的货币格式
        NumberFormat format = NumberFormat.getCurrencyInstance(Locale.CHINA);
        format.setMaximumFractionDigits(2);
        String numString = format.format(money);
        String substring = numString.substring(1);
        Log.i("wwwwwwwww",substring+"---");
        System.out.println(substring+"---");

    }
}
