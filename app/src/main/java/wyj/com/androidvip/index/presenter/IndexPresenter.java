package wyj.com.androidvip.index.presenter;

import android.util.Log;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import wyj.com.androidvip.base.BasePresenter;
import wyj.com.androidvip.base.RxSchedulerHepler;
import wyj.com.androidvip.entity.IndexBannerBean;
import wyj.com.androidvip.entity.IndexNewsBean;
import wyj.com.androidvip.entity.LoginBean;
import wyj.com.androidvip.index.model.IndexModel;
import wyj.com.androidvip.index.view.IndexView;

/**
 * @Description：描述信息
 * @Author：执念
 * @Date：2018/12/17 15:01
 */

public class IndexPresenter extends BasePresenter<IndexModel, IndexView> {

    @Override
    protected void getModel() {
        mModel = new IndexModel();
    }

    public void getIndexBanner() {
        mModel.getIndexBanner()
//                .compose(RxSchedulerHepler.<IndexBannerBean>io_main())
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<IndexBannerBean>() {
                    @Override
                    public void accept(IndexBannerBean bean) throws Exception {
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

    public void getIndexNews(String news_type) {
        mModel.getIndexNews(news_type)
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
