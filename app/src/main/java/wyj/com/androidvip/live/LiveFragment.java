package wyj.com.androidvip.live;

import android.content.Context;
import android.graphics.Rect;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.facebook.drawee.view.SimpleDraweeView;
import com.jcodecraeer.xrecyclerview.XRecyclerView;

import org.greenrobot.eventbus.EventBus;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import fm.jiecao.jcvideoplayer_lib.JCVideoPlayerStandard;
import wyj.com.androidvip.R;
import wyj.com.androidvip.base.BaseFragment;
import wyj.com.androidvip.entity.LiveIndexBean;
import wyj.com.androidvip.live.adapter.LiveAdapter;
import wyj.com.androidvip.live.presenter.LivePresenter;
import wyj.com.androidvip.live.view.LiveView;

/**
 * @Description：视频
 * @Author：执念
 * @Date：2018/12/15 12:00
 */

public class LiveFragment extends BaseFragment<LivePresenter> implements LiveView<LiveIndexBean> {
    @BindView(R.id.frame_live_sdv)
    SimpleDraweeView frameLiveSdv;
    @BindView(R.id.frame_live_xrv)
    XRecyclerView frameLiveXrv;
    @BindView(R.id.frame_live_txt)
    TextView frameLiveTxt;
    private LiveAdapter liveAdapter;
    private List<LiveIndexBean.ItemsBean> list = new ArrayList<>();
    private String pos;

    @Override
    public Context context() {
        return getActivity();
    }

    @Override
    protected int getContentView() {
        return R.layout.frame_live;
    }

    @Override
    protected LivePresenter getPresenter() {
        return new LivePresenter();
    }

    @Override
    protected void initData() {
        //xrv
        GridLayoutManager manager = new GridLayoutManager(getActivity(), 2);
        frameLiveXrv.setLayoutManager(manager);
        liveAdapter = new LiveAdapter(getActivity(), list);
        frameLiveXrv.setAdapter(liveAdapter);
        //间距
        frameLiveXrv.addItemDecoration(new RecyclerView.ItemDecoration() {
            @Override
            public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
                super.getItemOffsets(outRect, view, parent, state);
                outRect.set(20,10,20,10);
            }
        });

        //点击事件
        frameLiveSdv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pos = list.get(0).getPosition();
                EventBus.getDefault().postSticky(pos);
                startActivity(LiveInfoActivity.class);
            }
        });
        liveAdapter.setOnItemClickListener(new LiveAdapter.OnItemClickListener() {
            @Override
            public void itemClick(int position) {
                pos = list.get(position).getPosition();
                EventBus.getDefault().postSticky(pos);
                startActivity(LiveInfoActivity.class);
            }
        });
        //请求数据
        presenter.getLiveIndex();
    }

    @Override
    public void onSuccess(LiveIndexBean bean) {
        list.clear();
        list.addAll(bean.getItems());
        liveAdapter.notifyDataSetChanged();

        //大图
        frameLiveSdv.setImageURI(list.get(0).getImage());
        frameLiveTxt.setText(list.get(0).getTitle());
    }

    @Override
    public void onFailed(Throwable t) {
        Toast.makeText(getActivity(), t.getMessage(), Toast.LENGTH_SHORT).show();
    }
}
