package cn.nzy.toutiao.api;


import cn.nzy.toutiao.Bean.TextBean;
import io.reactivex.Observable;
import retrofit2.http.GET;

/**
 * on 2017/12/21.
 * 类的描述:
 */

public interface ApiService {

    @GET("/article/list/text")
    Observable<TextBean> getDataByQuery();
}
