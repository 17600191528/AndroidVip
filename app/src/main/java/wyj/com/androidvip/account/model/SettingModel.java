package wyj.com.androidvip.account.model;

import java.io.File;
import java.lang.reflect.Field;

import io.reactivex.Observable;
import wyj.com.androidvip.base.IApi;
import wyj.com.androidvip.entity.LoginBean;
import wyj.com.androidvip.entity.RegisterBean;
import wyj.com.androidvip.entity.TiShiBean;
import wyj.com.androidvip.utils.HttpUtils;

/**
 * @Description：描述信息
 * @Author：执念
 * @Date：2018/12/17 15:02
 */

public class SettingModel {
    IApi iApi = HttpUtils.getInstance().getIApi();

    public Observable<TiShiBean> changeHead(String user_hidden, File file) {
        Observable<TiShiBean> observable = iApi.changeHead(user_hidden, file);
        return observable;
    }


}
