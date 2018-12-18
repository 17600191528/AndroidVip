package wyj.com.androidvip.base;


import java.util.function.DoubleUnaryOperator;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;
import wyj.com.androidvip.entity.GanTitlebean;
import wyj.com.androidvip.entity.IndexBannerBean;
import wyj.com.androidvip.entity.IndexNewsBean;
import wyj.com.androidvip.entity.LiveIndexBean;
import wyj.com.androidvip.entity.LoginBean;
import wyj.com.androidvip.entity.RegisterBean;
import wyj.com.androidvip.entity.StudyInfoBean;
import wyj.com.androidvip.entity.StudyXrvBean;
import wyj.com.androidvip.entity.TiShiBean;

/**
 * Created by lenovo on 2018/11/8.
 */

public interface IApi {

    //注册
    @GET("cert/RegisterUser.php")
    Observable<RegisterBean> goToRegister(@Query("user_name") String user_name, @Query("user_pass") String user_pass);

    //是否注册过
    @GET("cert/ISRegisterUser.php")
    Observable<TiShiBean> isRegister(@Query("user_name") String user_name);

    //登录
    @GET("cert/LoginUser.php")
    Observable<LoginBean> goToLogin(@Query("user_name") String user_name, @Query("user_pass") String user_pass);

    //首页轮播图
    @GET("txt/banner_1.txt")
    Observable<IndexBannerBean> getIndexBanner();

    //首页底部文章
    @GET("cert/bw_get_index_news.php")
    Observable<IndexNewsBean> getIndexNews(@Query("news_type") String news_type);

    //学习页面展示
    @GET("txt/study.txt")
    Observable<StudyXrvBean> getStudyXrv();

    //学习页面具体数据展示
    @GET("txt/study_{a}.txt")
    Observable<StudyInfoBean> getStudyInfo(@Path("study_id") String study_id);

    //经典页面标题
    @GET("txt/jingdian_title.txt")
    Observable<GanTitlebean> getGanTitle();

    //经典页面文章内容
    @GET("cert/bw_get_index_news.php")
    Observable<IndexNewsBean> getGanArticle(@Query("news_type") String id);

    //视频页面展示
    @GET("txt/live/video_index.txt")
    Observable<LiveIndexBean> getLiveIndex();
}




