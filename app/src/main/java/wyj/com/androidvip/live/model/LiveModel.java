package wyj.com.androidvip.live.model;

import io.reactivex.Observable;
import wyj.com.androidvip.base.IApi;
import wyj.com.androidvip.entity.LiveIndexBean;
import wyj.com.androidvip.entity.LiveInfoBean;
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

    public Observable<LiveInfoBean> getLiveInFo(String position) {
        Observable<LiveInfoBean> observable = iApi.getLiveInFo(position);
        return observable;
    }

    public Observable<LiveInfoBean> getLiveVideo(String video_url) {
        Observable<LiveInfoBean> observable = iApi.getLiveVideo(video_url);
        return observable;
    }
}
