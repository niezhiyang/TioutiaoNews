package cn.nzy.toutiao;

import android.support.test.runner.AndroidJUnit4;
import android.util.Log;

import org.junit.Test;
import org.junit.runner.RunWith;

import java.text.NumberFormat;
import java.util.Locale;

/**
 * Instrumented test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class ExampleInstrumentedTest {
    @Test
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
