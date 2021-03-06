package cn.nzy.toutiao;

import org.junit.Test;

import java.text.NumberFormat;
import java.util.Locale;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    @Test
    public void addition_isCorrect() throws Exception {
        int data = 123463521;
        double money = data / 100.0;
        // 想要转换成指定国家的货币格式
        NumberFormat format = NumberFormat.getCurrencyInstance(Locale.CHINA);
        format.setMaximumFractionDigits(2);
        String numString = format.format(money);
        String substring = numString.substring(1);
        System.out.println(substring+"---");
    }
}