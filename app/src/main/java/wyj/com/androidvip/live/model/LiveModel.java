package wyj.com.androidvip.live.model;

import io.reactivex.Observable;
import wyj.com.androidvip.base.IApi;
import wyj.com.androidvip.entity.LiveIndexBean;
import wyj.com.androidvip.utils.HttpUtils;

/**
 * @Description：描述信息
 * @Author：执念
 * @Date：2018/12/17 15:02
 */

public class LiveModel {
    IApi iApi = HttpUtils.getInstance().getIApi();

    public Observable<LiveIndexBean> getLiveIndex() {
        Observable<LiveIndexBean> observable = iApi.getLiveIndex();
        return observable;
    }

//    public Observable<IndexNewsBean> getIndexNews(String news_type) {
//        Observable<IndexNewsBean> observable = iApi.getIndexNews(news_type);
//        return observable;
//    }
}
