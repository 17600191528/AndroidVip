package wyj.com.androidvip.study.presenter;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import wyj.com.androidvip.base.BasePresenter;
import wyj.com.androidvip.base.RxSchedulerHepler;
import wyj.com.androidvip.entity.IndexBannerBean;
import wyj.com.androidvip.entity.IndexNewsBean;
import wyj.com.androidvip.entity.StudyInfoBean;
import wyj.com.androidvip.entity.StudyXrvBean;
import wyj.com.androidvip.study.model.StudyModel;
import wyj.com.androidvip.study.view.StudyView;

/**
 * @Description：描述信息
 * @Author：执念
 * @Date：2018/12/17 15:01
 */

public class StudyPresenter extends BasePresenter<StudyModel, StudyView> {

    @Override
    protected void getModel() {
        mModel = new StudyModel();
    }

    public void getStudyXrv() {
        mModel.getStudyXrv()
//                .compose(RxSchedulerHepler.<StudyXrvBean>io_main())
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<StudyXrvBean>() {
                    @Override
                    public void accept(StudyXrvBean bean) throws Exception {
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

    public void getStudyInfo(String study_id) {
        mModel.getStudyInfo(study_id)
//                .compose(RxSchedulerHepler.<StudyInfoBean>io_main())
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<StudyInfoBean>() {
                    @Override
                    public void accept(StudyInfoBean bean) throws Exception {
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
