package wyj.com.androidvip.study;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import wyj.com.androidvip.R;
import wyj.com.androidvip.base.BaseActivity;
import wyj.com.androidvip.entity.StudyInfoBean;
import wyj.com.androidvip.entity.StudyXrvBean;
import wyj.com.androidvip.study.presenter.StudyPresenter;
import wyj.com.androidvip.study.view.StudyView;

public class StudyInfoActivity extends BaseActivity<StudyPresenter> implements StudyView<StudyXrvBean, StudyInfoBean> {

    @Override
    protected int getIdContentView() {
        return R.layout.activity_study;
    }

    @Override
    protected StudyPresenter getPresenter() {
        return new StudyPresenter();
    }

    @Override
    public Context context() {
        return this;
    }

    @Subscribe(threadMode = ThreadMode.MAIN, sticky = true)
    public void getMsg( String study_id){
        //请求数据
        presenter.getStudyInfo(study_id);
    }
    @Override
    protected void initData() {
        EventBus.getDefault().register(this);
    }

    @Override
    public void onSuccess1(StudyXrvBean bean) {

    }

    @Override
    public void onSuccess2(StudyInfoBean bean) {

    }

    @Override
    public void onFailed(Throwable t) {
        Toast.makeText(this, t.getMessage(), Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }
}
