package wyj.com.androidvip.gan.presenter;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import wyj.com.androidvip.base.BasePresenter;
import wyj.com.androidvip.base.RxSchedulerHepler;
import wyj.com.androidvip.entity.GanTitlebean;
import wyj.com.androidvip.entity.IndexNewsBean;
import wyj.com.androidvip.gan.model.GanModel;
import wyj.com.androidvip.gan.view.GanView;

/**
 * @Description：描述信息
 * @Author：执念
 * @Date：2018/12/17 15:01
 */

public class GanPresenter extends BasePresenter<GanModel, GanView> {

    @Override
    protected void getModel() {
        mModel = new GanModel();
    }


    public void getGanTitle() {
        mModel.getGanTitle()
//                .compose(RxSchedulerHepler.<GanTitlebean>io_main())
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<GanTitlebean>() {
                    @Override
                    public void accept(GanTitlebean bean) throws Exception {
                        if (bean != null) {
                            iView.onSuccess1(bean);
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

    public void getGanArticle(String id) {
        mModel.getGanArticle(id)
//                .compose(RxSchedulerHepler.<IndexNewsBean>io_main())
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<IndexNewsBean>() {
                    @Override
                    public void accept(IndexNewsBean bean) throws Exception {
                        if (bean != null) {
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
