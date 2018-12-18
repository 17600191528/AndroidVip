package wyj.com.androidvip.base;

import android.app.Application;
import android.content.Context;

import com.facebook.drawee.backends.pipeline.Fresco;

/**
 * Created by lenovo on 2018/11/7.
 */

public class MyApp extends Application {

//    private static String APP_ID = "wxb3852e6a6b7d9516";
//
    private static Context context;
    // IWXAPI 是第三方app和微信通信的openApi接口
//    public static IWXAPI api;

    @Override
    public void onCreate() {
        super.onCreate();
        Fresco.initialize(this);
        context = getApplicationContext();
//        regToWx();
//        initXGPush();
    }

    public static Context getContext() {
        return context;
    }

//    private void regToWx() {
//        // 通过WXAPIFactory工厂，获取IWXAPI的实例
//        api = WXAPIFactory.createWXAPI(this, APP_ID, true);
//
//        // 将应用的appId注册到微信
//        api.registerApp(APP_ID);
//    }

//    @Override
//    protected void attachBaseContext(Context base) {
//        super.attachBaseContext(base);
//        MultiDex.install(this);
//    }

//    private void initXGPush() {
//        XGPushConfig.enableDebug(this, true);
//        XGPushManager.registerPush(this, new XGIOperateCallback() {
//            @Override
//            public void onSuccess(Object data, int flag) {
//                //token在设备卸载重装的时候有可能会变
//                Log.e("TPush","注册成功，设备token为："+ data);
//            }
//            @Override
//            public void onFail(Object data, int errCode, String msg) {
//                Log.e("TPush", "注册失败，错误码：" + errCode + ",错误信息：" + msg);
//            }
//        });
//        //设置账号
//        XGPushManager.registerPush(getApplicationContext(), "XINGE");
//        // 设置标签XGPushManager.setTag(this,"XINGE");
//        XGPushManager.setTag(this, "XINGE");
//    }
}
