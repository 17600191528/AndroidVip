package wyj.com.androidvip.account.presenter;

import android.util.Log;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import wyj.com.androidvip.account.model.LoginModel;
import wyj.com.androidvip.account.view.LoginView;
import wyj.com.androidvip.base.BasePresenter;
import wyj.com.androidvip.base.IApi;
import wyj.com.androidvip.base.RxSchedulerHepler;
import wyj.com.androidvip.entity.LoginBean;
import wyj.com.androidvip.entity.RegisterBean;
import wyj.com.androidvip.utils.HttpUtils;

/**
 * @Description：描述信息
 * @Author：执念
 * @Date：2018/12/17 15:01
 */

public class LoginPresenter extends BasePresenter<LoginModel, LoginView> {

    @Override
    protected void getModel() {
        mModel = new LoginModel();
    }

    public void goToLogin(String user_name, String user_pass) {
        mModel.goToLogin(user_name, user_pass)
//                .compose(RxSchedulerHepler.<LoginBean>io_main())
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<LoginBean>() {
                    @Override
                    public void accept(LoginBean bean) throws Exception {
                        if (bean != null) {
                            iView.onSuccess(bean);
                        } else {
                            iView.onFailed(new Throwable("服务器无响应"));
                        }
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        iView.onFailed(new Throwable("网络异常"));
                    }
                });
    }

}
