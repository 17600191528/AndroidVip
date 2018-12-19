package wyj.com.androidvip.live.presenter;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import wyj.com.androidvip.base.BasePresenter;
import wyj.com.androidvip.base.RxSchedulerHepler;
import wyj.com.androidvip.entity.IndexBannerBean;
import wyj.com.androidvip.entity.IndexNewsBean;
import wyj.com.androidvip.entity.LiveIndexBean;
import wyj.com.androidvip.entity.LiveInfoBean;
import wyj.com.androidvip.live.model.LiveModel;
import wyj.com.androidvip.live.view.LiveView;

/**
 * @Description：描述信息
 * @Author：执念
 * @Date：2018/12/17 15:01
 */

public class LivePresenter extends BasePresenter<LiveModel, LiveView> {

    @Override
    protected void getModel() {
        mModel = new LiveModel();
    }

    public void getLiveIndex() {
        mModel.getLiveIndex()
//                .compose(RxSchedulerHepler.<LiveIndexBean>io_main())
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<LiveIndexBean>() {
                    @Override
                    public void accept(LiveIndexBean bean) throws Exception {
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

    public void getLiveInFo(String position) {
        mModel.getLiveInFo(position)
//                .compose(RxSchedulerHepler.<LiveIndexBean>io_main())
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<LiveInfoBean>() {
                    @Override
                    public void accept(LiveInfoBean bean) throws Exception {
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

    public void getLiveVideo(String video_url) {
        mModel.getLiveVideo(video_url)
//                .compose(RxSchedulerHepler.<LiveIndexBean>io_main())
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<LiveInfoBean>() {
                    @Override
                    public void accept(LiveInfoBean bean) throws Exception {
                        if (bean != null) {
                            iView.onSuccess3(bean);
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
