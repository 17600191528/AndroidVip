package wyj.com.androidvip.account.presenter;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import wyj.com.androidvip.account.model.LoginModel;
import wyj.com.androidvip.account.view.LoginView;
import wyj.com.androidvip.account.view.RegisterView;
import wyj.com.androidvip.base.BasePresenter;
import wyj.com.androidvip.base.RxSchedulerHepler;
import wyj.com.androidvip.entity.LoginBean;
import wyj.com.androidvip.entity.RegisterBean;
import wyj.com.androidvip.entity.TiShiBean;

/**
 * @Description：描述信息
 * @Author：执念
 * @Date：2018/12/17 15:01
 */

public class RegisterPresenter extends BasePresenter<LoginModel, RegisterView> {

    @Override
    protected void getModel() {
        mModel = new LoginModel();
    }

    public void isRegister(String name) {
        mModel.isRegister(name)
//                .compose(RxSchedulerHepler.<TiShiBean>io_main())
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<TiShiBean>() {
                    @Override
                    public void accept(TiShiBean bean) throws Exception {
                        if (bean != null & "0".equals(bean.getStatus())) {
                            iView.onSuccess1(bean);
                        } else {
                            iView.onFailed(new Throwable(bean.getMessage()));
                        }
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        iView.onFailed(new Throwable("网络异常"));
                    }
                });
    }

    public void goToRegister(String name, String pass) {
        mModel.goToRegister(name, pass)
//                .compose(RxSchedulerHepler.<RegisterBean>io_main())
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<RegisterBean>() {
                    @Override
                    public void accept(RegisterBean bean) throws Exception {
                        if (bean != null & "0".equals(bean.getStatus())) {
                            iView.onSuccess2(bean);
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
