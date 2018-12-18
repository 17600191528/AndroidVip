package wyj.com.androidvip.index.model;

import io.reactivex.Observable;
import wyj.com.androidvip.base.IApi;
import wyj.com.androidvip.entity.IndexBannerBean;
import wyj.com.androidvip.entity.IndexNewsBean;
import wyj.com.androidvip.entity.LoginBean;
import wyj.com.androidvip.entity.RegisterBean;
import wyj.com.androidvip.entity.TiShiBean;
import wyj.com.androidvip.utils.HttpUtils;

/**
 * @Description：描述信息
 * @Author：执念
 * @Date：2018/12/17 15:02
 */

public class IndexModel {
    IApi iApi = HttpUtils.getInstance().getIApi();

    public Observable<IndexBannerBean> getIndexBanner() {
        Observable<IndexBannerBean> observable = iApi.getIndexBanner();
        return observable;
    }

    public Observable<IndexNewsBean> getIndexNews(String news_type) {
        Observable<IndexNewsBean> observable = iApi.getIndexNews(news_type);
        return observable;
    }
}
