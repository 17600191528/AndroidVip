package wyj.com.androidvip.base;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.facebook.drawee.backends.pipeline.Fresco;

import butterknife.ButterKnife;

/**
 * Created by lenovo on 2018/10/14.
 */

public abstract class BaseActivity<P extends BasePresenter> extends AppCompatActivity implements IView {
//    public static NetBroadcastReceiver.NetChangeListener listener;
    protected Intent intent;
    protected Bundle bundle;
    protected Activity mContext;
    public P presenter;
//    private NetBroadcastReceiver netBroadcastReceiver;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getIdContentView());
        mContext = this;
        intent = mContext.getIntent();
        if (intent != null) {
            bundle = intent.getExtras();
        }
        ButterKnife.bind(this);
        presenter = getPresenter();
        attachView();
        initData();
        /*listener=this;
        IntentFilter filter = new IntentFilter();
        filter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
        netBroadcastReceiver = new NetBroadcastReceiver();
        //注册广播接收
        registerReceiver(netBroadcastReceiver, filter);*/
    }

    protected abstract int getIdContentView();

    protected abstract P getPresenter();

    protected void attachView(){
        if(presenter != null){
            presenter.attach(this);
        }
    }

    protected abstract void initData();

    public void startActivity(Class<?> clazz) {
        intent = new Intent(mContext, clazz);
        startActivity(intent);
    }

    public void startActivity(Class<?> clazz, Bundle bundle) {
        intent = new Intent(mContext, clazz);
        intent.putExtras(bundle);
        startActivity(intent);
    }

    protected void detachView(){
        if(presenter != null){
            presenter.detach();
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        detachView();
    }

   /* @Override
    public void onChangeListener(int status) {
        if (status==0) {
            Toast.makeText(this, "移动网络", Toast.LENGTH_SHORT).show();
        } else if (status==1) {
            Toast.makeText(this, "无线网络", Toast.LENGTH_SHORT).show();
        } else if (status==-1) {
            Toast.makeText(this, "没有网络", Toast.LENGTH_SHORT).show();
        }
    }*/
}
