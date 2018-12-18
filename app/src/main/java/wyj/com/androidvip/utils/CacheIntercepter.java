package wyj.com.androidvip.utils;

import android.text.TextUtils;
import android.util.Log;

import java.io.IOException;

import okhttp3.CacheControl;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by pfy on 2018/12/12.
 */

public class CacheIntercepter implements Interceptor {
    @Override
    public Response intercept(Chain chain) throws IOException {
        Request request = chain.request();
        request = request.newBuilder()
                .cacheControl(CacheControl.FORCE_CACHE)
                .build();
        Response response = chain.proceed(request);

        int maxStale = 60 * 60 * 24; // 无网络时，设置超时为1天
        Log.d("aaa", "has maxStale=" + maxStale);
        response.newBuilder()
                .header("Cache-Control", "public, only-if-cached, max-stale=" + maxStale)
                .removeHeader("Pragma")
                .build();
        return response;
    }
};

