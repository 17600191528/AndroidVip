package wyj.com.androidvip.live;

import android.content.Context;
import android.graphics.Rect;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import fm.jiecao.jcvideoplayer_lib.JCVideoPlayerStandard;
import wyj.com.androidvip.R;
import wyj.com.androidvip.base.BaseActivity;
import wyj.com.androidvip.base.BaseFragment;
import wyj.com.androidvip.entity.LiveIndexBean;
import wyj.com.androidvip.entity.LiveInfoBean;
import wyj.com.androidvip.index.adapter.IndexNewsAdapter;
import wyj.com.androidvip.live.adapter.LiveInfoAdapter;
import wyj.com.androidvip.live.presenter.LivePresenter;
import wyj.com.androidvip.live.view.LiveView;

public class LiveInfoActivity extends BaseActivity<LivePresenter> implements LiveView<LiveIndexBean, LiveInfoBean, LiveInfoBean> {

    @BindView(R.id.activity_live_img_back)
    ImageView activityLiveImgBack;
    @BindView(R.id.activity_live_title)
    TextView activityLiveTitle;
    @BindView(R.id.activity_live_jcv)
    JCVideoPlayerStandard activityLiveJcv;
    @BindView(R.id.activity_live_dec)
    TextView activityLiveDec;
    @BindView(R.id.activity_live_rv)
    RecyclerView activityLiveRv;
    private List<LiveInfoBean.VideoListBean> videoList = new ArrayList<>();
    private LiveInfoAdapter liveInfoAdapter;

    @Override
    protected int getIdContentView() {
        return R.layout.activity_live_info;
    }

    @Override
    protected LivePresenter getPresenter() {
        return new LivePresenter();
    }

    @Subscribe(threadMode = ThreadMode.MAIN, sticky = true)
    public void getMsg(String pos) {
        presenter.getLiveInFo(pos);
    }

    @Override
    protected void initData() {
        EventBus.getDefault().register(this);
        //设置播放器的x >  按钮不可见
        activityLiveJcv.backButton.setVisibility(View.INVISIBLE);
        activityLiveJcv.tinyBackImageView.setVisibility(View.INVISIBLE);
        //视频列表
        GridLayoutManager manager = new GridLayoutManager(this, 2);
        activityLiveRv.setLayoutManager(manager);
        liveInfoAdapter = new LiveInfoAdapter(this, videoList);
        activityLiveRv.setAdapter(liveInfoAdapter);
        activityLiveRv.addItemDecoration(new RecyclerView.ItemDecoration() {
            @Override
            public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
                super.getItemOffsets(outRect, view, parent, state);
                outRect.set(20,10,20,10);
            }
        });
    }

    @Override
    public Context context() {
        return this;
    }

    @Override
    public void onFailed(Throwable t) {
        Toast.makeText(this, t.getMessage(), Toast.LENGTH_SHORT).show();
    }

    //单个视频流
    @Override
    public void onSuccess3(LiveInfoBean bean) {

    }

    //视频详情
    @Override
    public void onSuccess2(LiveInfoBean bean) {
        activityLiveTitle.setText(bean.getTitle());
//        presenter.getLiveVideo(bean.getVideo_url());
        activityLiveDec.setText(bean.getVideo_desc());
        videoList.clear();
        videoList.addAll(bean.getVideo_list());
        liveInfoAdapter.notifyDataSetChanged();
    }

    //全部的视频列表
    @Override
    public void onSuccess1(LiveIndexBean bean) {

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }
}
