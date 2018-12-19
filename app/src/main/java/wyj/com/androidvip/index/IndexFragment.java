package wyj.com.androidvip.index;

import android.content.Context;
import android.graphics.Rect;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.jcodecraeer.xrecyclerview.XRecyclerView;
import com.youth.banner.Banner;
import com.youth.banner.listener.OnBannerListener;
import com.youth.banner.loader.ImageLoader;

import org.greenrobot.eventbus.EventBus;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import wyj.com.androidvip.R;
import wyj.com.androidvip.base.BaseFragment;
import wyj.com.androidvip.chat.ChatActivity;
import wyj.com.androidvip.entity.IndexBannerBean;
import wyj.com.androidvip.entity.IndexNewsBean;
import wyj.com.androidvip.index.adapter.IndexNewsAdapter;
import wyj.com.androidvip.index.presenter.IndexPresenter;
import wyj.com.androidvip.index.view.IndexView;
import wyj.com.androidvip.info.InFoActivity;

/**
 * @Description：首页
 * @Author：执念
 * @Date：2018/12/15 12:00
 */

public class IndexFragment extends BaseFragment<IndexPresenter> implements IndexView<IndexBannerBean, IndexNewsBean> {
    @BindView(R.id.frame_index_banner)
    Banner frameIndexBanner;
    @BindView(R.id.frame_index_xrv)
    XRecyclerView frameIndexXrv;
    @BindView(R.id.frame_index_banner_title)
    TextView frameIndexBannerTitle;
    @BindView(R.id.frame_index_tab_vip)
    LinearLayout frameIndexTabVip;
    @BindView(R.id.frame_index_tab_video)
    LinearLayout frameIndexTabVideo;
    @BindView(R.id.frame_index_tab_technica1)
    LinearLayout frameIndexTabTechnica1;
    @BindView(R.id.frame_index_tab_talk)
    LinearLayout frameIndexTabTalk;
    private List<String> bannerList = new ArrayList<>();
    private List<IndexNewsBean.ItemsBean> newsList = new ArrayList<>();
    private IndexNewsAdapter newsAdapter;
    private int NEWS_TYPE = 0;

    @OnClick({R.id.frame_index_tab_vip, R.id.frame_index_tab_video, R.id.frame_index_tab_technica1, R.id.frame_index_tab_talk})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.frame_index_tab_vip:
                break;
            case R.id.frame_index_tab_video:
                break;
            case R.id.frame_index_tab_technica1:
                break;
            case R.id.frame_index_tab_talk:
                startActivity(ChatActivity.class);
                break;
        }
    }

    @Override
    public Context context() {
        return getActivity();
    }

    @Override
    protected int getContentView() {
        return R.layout.frame_index;
    }

    @Override
    protected IndexPresenter getPresenter() {
        return new IndexPresenter();
    }

    @Override
    protected void initData() {
        //recycleView数据展示
        LinearLayoutManager manager = new LinearLayoutManager(getActivity());
        frameIndexXrv.setLayoutManager(manager);
        newsAdapter = new IndexNewsAdapter(getActivity(), newsList);
        frameIndexXrv.setAdapter(newsAdapter);
        //条目间距
        frameIndexXrv.addItemDecoration(new RecyclerView.ItemDecoration() {
            @Override
            public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
                super.getItemOffsets(outRect, view, parent, state);
                outRect.set(0, 10, 0, 10);
            }
        });
        //条目点击事件
        newsAdapter.setOnItemClickListener(new IndexNewsAdapter.OnItemClickListener() {
            @Override
            public void itemClick(int position) {
                String link = newsList.get(position).getNews_link();
                EventBus.getDefault().postSticky(link);
                startActivity(InFoActivity.class);
            }
        });
        //上拉下拉
        frameIndexXrv.setPullRefreshEnabled(false);
        frameIndexXrv.setLoadingMoreEnabled(false);
        //请求数据  默认请求首页数据
        presenter.getIndexBanner();
        presenter.getIndexNews(NEWS_TYPE + "");
    }


    @Override
    public void onSuccess1(final IndexBannerBean bean) {
        //轮播图
        for (IndexBannerBean.DataBean bean1 : bean.getData()) {
            bannerList.add(bean1.getImage());
        }
        frameIndexBanner.setImages(bannerList)
                .setImageLoader(new BannerImageLoad())
                .setDelayTime(2000)
                .start();
        //轮播图设置标题
        frameIndexBannerTitle.setText(bean.getData().get(0).getTitle());
        frameIndexBanner.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            }

            @Override
            public void onPageSelected(int position) {
                if (position <= bannerList.size()) {
                    frameIndexBannerTitle.setText(bean.getData().get(position - 1).getTitle());
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {
            }
        });
        //轮播的图片的点击事件
        frameIndexBanner.setOnBannerListener(new OnBannerListener() {
            @Override
            public void OnBannerClick(int position) {
                String link = bean.getData().get(position).getLink();
                EventBus.getDefault().postSticky(link);
                startActivity(InFoActivity.class);
            }
        });

    }

    @Override
    public void onSuccess2(IndexNewsBean bean) {
        newsList.clear();
        newsList.addAll(bean.getItems());
        newsAdapter.notifyDataSetChanged();
    }

    @Override
    public void onFailed(Throwable t) {
        Toast.makeText(getActivity(), t.getMessage(), Toast.LENGTH_SHORT).show();
    }

    public class BannerImageLoad extends ImageLoader {

        @Override
        public void displayImage(Context context, Object path, ImageView imageView) {
            Glide.with(getActivity()).load(path).into(imageView);
        }
    }
}
