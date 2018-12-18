package wyj.com.androidvip.gan.model;

import io.reactivex.Completable;
import io.reactivex.Observable;
import wyj.com.androidvip.base.IApi;
import wyj.com.androidvip.entity.GanTitlebean;
import wyj.com.androidvip.entity.IndexNewsBean;
import wyj.com.androidvip.entity.StudyInfoBean;
import wyj.com.androidvip.entity.StudyXrvBean;
import wyj.com.androidvip.utils.HttpUtils;

/**
 * @Description：描述信息
 * @Author：执念
 * @Date：2018/12/17 15:02
 */

public class GanModel {
    IApi iApi = HttpUtils.getInstance().getIApi();

    public Observable<GanTitlebean> getGanTitle() {
        Observable<GanTitlebean> observable = iApi.getGanTitle();
        return observable;
    }

    public Observable<IndexNewsBean> getGanArticle(String id) {
        Observable<IndexNewsBean> observable = iApi.getGanArticle(id);
        return observable;
    }

}
