package wyj.com.androidvip.account.model;

import android.content.Context;

import io.reactivex.Observable;
import wyj.com.androidvip.base.IApi;
import wyj.com.androidvip.base.RxSchedulerHepler;
import wyj.com.androidvip.entity.LoginBean;
import wyj.com.androidvip.entity.RegisterBean;
import wyj.com.androidvip.entity.TiShiBean;
import wyj.com.androidvip.utils.HttpUtils;

/**
 * @Description：描述信息
 * @Author：执念
 * @Date：2018/12/17 15:02
 */

public class LoginModel {
    IApi iApi = HttpUtils.getInstance().getIApi();

    public Observable<LoginBean> goToLogin(String user_name, String user_pass) {
        Observable<LoginBean> observable = iApi.goToLogin(user_name, user_pass);
        return observable;
    }

    public Observable<TiShiBean> isRegister(String name) {
        Observable<TiShiBean> observable = iApi.isRegister(name);
        return observable;
    }

    public Observable<RegisterBean> goToRegister(String name, String pass) {
        Observable<RegisterBean> observable = iApi.goToRegister(name, pass);
        return observable;
    }

}
