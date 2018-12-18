package wyj.com.androidvip.utils;

import android.content.Context;

import java.io.File;
import java.util.concurrent.TimeUnit;

import okhttp3.Cache;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import wyj.com.androidvip.base.IApi;
import wyj.com.androidvip.base.MyApp;

/**
 * Created by lenovo on 2018/10/14.
 */

public class HttpUtils {

    private static volatile HttpUtils instance;
    private Retrofit retrofit;
    private String BASE_URL = "http://www.abnerming.cn/";
    private IApi iApi;

    public static HttpUtils getInstance() {
        if (instance == null) {
            synchronized (HttpUtils.class) {
                if (instance == null) {
                    instance = new HttpUtils();
                }
            }
        }
        return instance;
    }

    private OkHttpClient buildOkhttpClient() {
        //设置缓存路径
        File httpCacheDirectory = new File(MyApp.getContext().getCacheDir(), "responses");
        //设置缓存 10M
        Cache cache = new Cache(httpCacheDirectory, 10 * 1024 * 1024);

        return new OkHttpClient.Builder()
                .readTimeout(5000, TimeUnit.MILLISECONDS)
                .writeTimeout(5000, TimeUnit.MILLISECONDS)
//                .addInterceptor(new CacheIntercepter())
//                .cache(cache)
                .build();
    }

    public Retrofit getmRetrofit() {
        retrofit = new Retrofit.Builder()
                //设置公共的url部分
                .baseUrl(BASE_URL)
                //配置解析方式为Gson
                .addConverterFactory(GsonConverterFactory.create())
                //retrofit支持RxJava2
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                //配置okhttpClient
                .client(buildOkhttpClient())
                .build();
        return retrofit;
    }

    public IApi getIApi() {
        if (iApi == null) {
            iApi = getmRetrofit().create(IApi.class);
        }
        return iApi;
    }

}
