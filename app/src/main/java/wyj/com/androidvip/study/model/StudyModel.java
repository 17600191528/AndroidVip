package wyj.com.androidvip.study.model;

import io.reactivex.Observable;
import wyj.com.androidvip.base.IApi;
import wyj.com.androidvip.entity.IndexBannerBean;
import wyj.com.androidvip.entity.IndexNewsBean;
import wyj.com.androidvip.entity.StudyInfoBean;
import wyj.com.androidvip.entity.StudyXrvBean;
import wyj.com.androidvip.utils.HttpUtils;

/**
 * @Description：描述信息
 * @Author：执念
 * @Date：2018/12/17 15:02
 */

public class StudyModel {
    IApi iApi = HttpUtils.getInstance().getIApi();

    public Observable<StudyXrvBean> getStudyXrv() {
        Observable<StudyXrvBean> observable = iApi.getStudyXrv();
        return observable;
    }

    public Observable<StudyInfoBean> getStudyInfo(String study_id) {
        Observable<StudyInfoBean> observable = iApi.getStudyInfo(study_id);
        return observable;
    }
}
