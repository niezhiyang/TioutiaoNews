package cn.nzy.toutiao.api;


import cn.nzy.toutiao.Bean.NetDataBean;
import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * on 2017/12/21.
 * 类的描述:
 */

public interface ApiService {
    @GET("?")
    Observable<NetDataBean> getDataByQuery(@Query("category") String category, @Query("last_refresh_sub_entrance_interval") String last_refresh_sub_entrance_interval);
}
