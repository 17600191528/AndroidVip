package wyj.com.androidvip.utils;

import android.os.Handler;
import android.os.Message;
import android.support.annotation.NonNull;
import android.util.Log;


import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

/**
 * author:AbnerMing
 * date:2018/10/25
 */
public class OkHttpUtils {

    //get请求
    public OkHttpUtils get(String url) {
        try {
            OkHttpClient client = getOkHttpClient();
            Request request = new Request.Builder()
                    .url(url)
                    .build();
            Call call = client.newCall(request);
            doCall(call);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return this;
    }

    //post请求
    public OkHttpUtils post(String url, RequestBody body) {
        try {
            OkHttpClient client = getOkHttpClient();
            Request request = new Request.Builder()
                    .post(body)
                    .url(url)
                    .build();
            Call call = client.newCall(request);
            doCall(call);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return this;
    }

    @NonNull
    private OkHttpClient getOkHttpClient() throws IOException {
        return new OkHttpClient.Builder().
                addInterceptor(new Interceptor() {
                    @Override
                    public Response intercept(Chain chain) throws IOException {
                        Request request = chain.request();
                        String mehod = request.method();
                        String host = request.url().host();
                        Log.i("intercept", mehod + "==" + host);
                        return chain.proceed(request);
                    }
                }).
                build();
    }

    private void doCall(Call call) throws IOException {
        final Message message = Message.obtain();
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                message.what = 101;
                message.obj = e.getMessage();
                handler.sendMessage(message);
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                message.what = 100;
                message.obj = response.body().string();
                handler.sendMessage(message);
            }
        });
    }

    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what) {
                case 100://成功
                    String data = (String) msg.obj;
                    listener.success(data);
                    break;
                case 101://失败
                    String error = (String) msg.obj;
                    listener.fail(error);
                    break;
            }
        }
    };

    private HttpListener listener;

    //传递接口
    public void result(HttpListener listenre) {
        this.listener = listenre;
    }

    public interface HttpListener {
        void success(String data);

        void fail(String error);
    }
}
