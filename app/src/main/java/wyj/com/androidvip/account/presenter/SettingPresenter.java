package wyj.com.androidvip.account.presenter;

import java.io.File;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import wyj.com.androidvip.account.model.LoginModel;
import wyj.com.androidvip.account.model.SettingModel;
import wyj.com.androidvip.account.view.LoginView;
import wyj.com.androidvip.account.view.SettingView;
import wyj.com.androidvip.base.BasePresenter;
import wyj.com.androidvip.entity.LoginBean;
import wyj.com.androidvip.entity.TiShiBean;

/**
 * @Description：描述信息
 * @Author：执念
 * @Date：2018/12/17 15:01
 */

public class SettingPresenter extends BasePresenter<SettingModel, SettingView> {

    @Override
    protected void getModel() {
        mModel = new SettingModel();
    }

    public void changeHead(String user_hidden, File file) {
        mModel.changeHead(user_hidden, file)
//                .compose(RxSchedulerHepler.<LoginBean>io_main())
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<TiShiBean>() {
                    @Override
                    public void accept(TiShiBean bean) throws Exception {
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
