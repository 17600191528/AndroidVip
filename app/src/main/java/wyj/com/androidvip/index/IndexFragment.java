package wyj.com.androidvip.index;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Rect;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
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
import wyj.com.androidvip.entity.IndexBannerBean;
import wyj.com.androidvip.entity.IndexNewsBean;
import wyj.com.androidvip.entity.IndexTabBean;
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
    @BindView(R.id.frame_index_tab)
    TabLayout frameIndexTab;
    @BindView(R.id.frame_index_banner_title)
    TextView frameIndexBannerTitle;
    private List<String> bannerList = new ArrayList<>();
    private List<IndexNewsBean.ItemsBean> newsList = new ArrayList<>();
    private IndexNewsAdapter newsAdapter;
    private int NEWS_TYPE = 0;

    @OnClick({R.id.frame_index_banner, R.id.frame_index_xrv})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.frame_index_banner:
                break;
            case R.id.frame_index_xrv:
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
        //tab
        List<IndexTabBean> tabList = new ArrayList<>();
        tabList.add(new IndexTabBean(R.drawable.vip, "vip干货铺", 1));
        tabList.add(new IndexTabBean(R.drawable.live, "每日视频", 2));
        tabList.add(new IndexTabBean(R.drawable.day_vip, "技术博文", 3));
        tabList.add(new IndexTabBean(R.drawable.every, "谈一谈", 4));
        for (IndexTabBean bean : tabList) {
            frameIndexTab.addTab(frameIndexTab.newTab().setText(bean.getTab()).setIcon(bean.getImg()));
        }
        frameIndexTab.setTabMode(TabLayout.GRAVITY_FILL);
        frameIndexTab.setSelectedTabIndicatorHeight(0);
        frameIndexTab.setTabTextColors(Color.BLACK, Color.RED);

        //tab的点击监听
        frameIndexTab.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                NEWS_TYPE = tab.getPosition() + 1;
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {
            }
        });
        //点击事件

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
