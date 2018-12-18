package wyj.com.androidvip.base;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.facebook.drawee.backends.pipeline.Fresco;

import butterknife.ButterKnife;

/**
 * Created by lenovo on 2018/10/14.
 */

public abstract class BaseFragment<P extends BasePresenter> extends Fragment implements IView {
    public P presenter;
    protected Intent intent;
    protected Bundle bundle;
    protected Activity mContext;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(getContentView(), container, false);
        ButterKnife.bind(this, v);
        mContext = getActivity();
        return v;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        intent = mContext.getIntent();
        if (intent != null) {
            bundle = intent.getExtras();
        }
        presenter = getPresenter();
        attachView();
        initData();
        initListener();
        setMoreAction();
    }

    protected void initListener() {
    }

    protected abstract int getContentView();

    protected abstract P getPresenter();

    protected void attachView() {
        if (presenter != null) {
            presenter.attach(this);
        }
    }

    protected abstract void initData();

    protected void setMoreAction() {
    }

    public void startActivity(Class<?> clazz) {
        intent = new Intent(mContext, clazz);
        startActivity(intent);
    }

    public void startActivity(Class<?> clazz, Bundle bundle) {
        intent = new Intent(mContext, clazz);
        intent.putExtras(bundle);
        startActivity(intent, bundle);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (presenter != null) {
            presenter.detach();
        }
    }
}
