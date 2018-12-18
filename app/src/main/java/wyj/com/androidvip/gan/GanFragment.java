package wyj.com.androidvip.gan;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Rect;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.jcodecraeer.xrecyclerview.XRecyclerView;

import org.greenrobot.eventbus.EventBus;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import wyj.com.androidvip.R;
import wyj.com.androidvip.base.BaseFragment;
import wyj.com.androidvip.entity.GanTitlebean;
import wyj.com.androidvip.entity.IndexNewsBean;
import wyj.com.androidvip.gan.adapter.GanAdapter;
import wyj.com.androidvip.gan.presenter.GanPresenter;
import wyj.com.androidvip.gan.view.GanView;
import wyj.com.androidvip.index.adapter.IndexNewsAdapter;

/**
 * @Description：经典
 * @Author：执念
 * @Date：2018/12/15 12:00
 */

public class GanFragment extends BaseFragment<GanPresenter> implements GanView<GanTitlebean, IndexNewsBean> {
    @BindView(R.id.frame_gan_tab)
    TabLayout frameGanTab;
    @BindView(R.id.frame_gan_xrv)
    XRecyclerView frameGanXrv;
    private List<Fragment> frameList;
    private List<GanTitlebean.TitlesBean> tabList = new ArrayList<>();
    private List<IndexNewsBean.ItemsBean> list = new ArrayList<>();
    private GanAdapter ganAdapter;

    @Override
    public Context context() {
        return getActivity();
    }

    @Override
    protected int getContentView() {
        return R.layout.frame_gan;
    }

    @Override
    protected GanPresenter getPresenter() {
        return new GanPresenter();
    }

    @Override
    protected void initData() {
        //请求数据
        presenter.getGanTitle();
        //tab
        frameList = new ArrayList<>();
        for (GanTitlebean.TitlesBean bean : tabList) {
            frameGanTab.addTab(frameGanTab.newTab().setText(bean.getName()));
        }
        frameGanTab.setTabMode(TabLayout.MODE_SCROLLABLE);
        frameGanTab.setTabTextColors(Color.BLACK, Color.RED);

        //recycleView数据展示
        LinearLayoutManager manager = new LinearLayoutManager(getActivity());
        frameGanXrv.setLayoutManager(manager);
        ganAdapter = new GanAdapter(getActivity(), list);
        frameGanXrv.setAdapter(ganAdapter);
        //条目间距
        frameGanXrv.addItemDecoration(new RecyclerView.ItemDecoration() {
            @Override
            public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
                super.getItemOffsets(outRect, view, parent, state);
                outRect.set(0,10,0,10);
            }
        });
        //上拉下拉
        frameGanXrv.setPullRefreshEnabled(false);
        frameGanXrv.setLoadingMoreEnabled(false);

        //tab的点击监听
        frameGanTab.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                int position = tab.getPosition();
                presenter.getGanArticle(position+1+"");
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {
            }
        });
    }

    @Override
    public void onSuccess1(GanTitlebean ganTitlebean) {
        tabList.clear();
        tabList.addAll(ganTitlebean.getTitles());
    }

    @Override
    public void onFailed(Throwable t) {
        Toast.makeText(getActivity(), t.getMessage() + "", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onSuccess2(IndexNewsBean bean) {
        list.clear();
        list.addAll(bean.getItems());
        ganAdapter.notifyDataSetChanged();
    }

}
