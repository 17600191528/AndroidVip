package wyj.com.androidvip.study;

import android.content.Context;
import android.graphics.Rect;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import com.jcodecraeer.xrecyclerview.XRecyclerView;

import org.greenrobot.eventbus.EventBus;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import wyj.com.androidvip.R;
import wyj.com.androidvip.base.BaseFragment;
import wyj.com.androidvip.entity.StudyInfoBean;
import wyj.com.androidvip.entity.StudyXrvBean;
import wyj.com.androidvip.study.adapter.StudyAdapter;
import wyj.com.androidvip.study.presenter.StudyPresenter;
import wyj.com.androidvip.study.view.StudyView;

/**
 * @Description：学习
 * @Author：执念
 * @Date：2018/12/15 12:00
 */

public class StudyFragment extends BaseFragment<StudyPresenter> implements StudyView<StudyXrvBean, StudyInfoBean> {
    @BindView(R.id.frame_study_xrv)
    XRecyclerView frameStudyXrv;
    private List<StudyXrvBean.ItemsBean> list = new ArrayList<>();
    private StudyAdapter studyAdapter;

    @Override
    public Context context() {
        return getActivity();
    }

    @Override
    protected int getContentView() {
        return R.layout.frame_study;
    }

    @Override
    protected StudyPresenter getPresenter() {
        return new StudyPresenter();
    }

    @Override
    protected void initData() {
        //recycleView数据展示
        LinearLayoutManager manager = new LinearLayoutManager(getActivity());
        frameStudyXrv.setLayoutManager(manager);
        studyAdapter = new StudyAdapter(getActivity(), list);
        frameStudyXrv.setAdapter(studyAdapter);
        //条目间距
        frameStudyXrv.addItemDecoration(new RecyclerView.ItemDecoration() {
            @Override
            public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
                super.getItemOffsets(outRect, view, parent, state);
                outRect.set(20,10,10,20);
            }
        });
        //上拉下拉
        frameStudyXrv.setPullRefreshEnabled(false);
        frameStudyXrv.setLoadingMoreEnabled(false);
        //条目点击事件
        studyAdapter.setOnItemClickListener(new StudyAdapter.OnItemClickListener() {
            @Override
            public void itemClick(int position) {
                String study_id = list.get(position).getStudy_id();
                EventBus.getDefault().postSticky(study_id);
                startActivity(StudyInfoActivity.class);
            }
        });

        //请求数据
        presenter.getStudyXrv();
    }

    @Override
    public void onSuccess1(StudyXrvBean bean) {
        list.clear();
        list.addAll(bean.getItems());
        studyAdapter.notifyDataSetChanged();
    }

    @Override
    public void onFailed(Throwable t) {
        Toast.makeText(getActivity(), t.getMessage(), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onSuccess2(StudyInfoBean studyInfoBean) {

    }
}
