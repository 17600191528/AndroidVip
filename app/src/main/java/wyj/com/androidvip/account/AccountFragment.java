package wyj.com.androidvip.account;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.facebook.drawee.view.SimpleDraweeView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import wyj.com.androidvip.R;
import wyj.com.androidvip.base.BaseFragment;
import wyj.com.androidvip.base.BasePresenter;
import wyj.com.androidvip.utils.SharedPreUtils;
import wyj.com.androidvip.utils.SpUtils;

import static android.content.Context.MODE_PRIVATE;

/**
 * @Description：个人信息
 * @Author：执念
 * @Date：2018/12/15 12:00
 */

public class AccountFragment extends BaseFragment {
    @BindView(R.id.frame_account_head)
    SimpleDraweeView frameAccountHead;
    @BindView(R.id.frame_account_txt_login)
    TextView frameAccountTxtLogin;
    @BindView(R.id.account_goto_login)
    LinearLayout accountGotoLogin;
    @BindView(R.id.frame_account_myAbout)
    RelativeLayout frameAccountMyAbout;
    @BindView(R.id.frame_account_aboutMe)
    RelativeLayout frameAccountAboutMe;
    @BindView(R.id.frame_account_myShare)
    RelativeLayout frameAccountMyShare;
    @BindView(R.id.frame_account_myPost)
    RelativeLayout frameAccountMyPost;
    @BindView(R.id.frame_account_myTan)
    RelativeLayout frameAccountMyTan;
    @BindView(R.id.frame_account_mySetting)
    RelativeLayout frameAccountMySetting;
    private boolean isLogin = false;
//    private int status = 1;

    @OnClick({R.id.account_goto_login, R.id.frame_account_myAbout, R.id.frame_account_aboutMe, R.id.frame_account_myShare, R.id.frame_account_myPost, R.id.frame_account_myTan, R.id.frame_account_mySetting})
    public void onViewClicked(View view) {
        if (!isLogin) {
            Toast.makeText(getActivity(), "您还没登录呢，先去登录吧", Toast.LENGTH_SHORT).show();
        } else {
            switch (view.getId()) {
                case R.id.account_goto_login:
                    break;
                case R.id.frame_account_myAbout:
                    startActivity(MySettingActivity.class);
                    break;
                case R.id.frame_account_aboutMe:
                    startActivity(MySettingActivity.class);
                    break;
                case R.id.frame_account_myShare:
                    startActivity(MySettingActivity.class);
                    break;
                case R.id.frame_account_myPost:
                    startActivity(MySettingActivity.class);
                    break;
                case R.id.frame_account_myTan:
                    startActivity(MySettingActivity.class);
                    break;
                case R.id.frame_account_mySetting:
                    startActivity(MySettingActivity.class);
                    break;
            }
        }
    }

    @Override
    public Context context() {
        return getActivity();
    }

    @Override
    protected int getContentView() {
        return R.layout.frame_account;
    }

    @Override
    protected BasePresenter getPresenter() {
        return null;
    }

    @Override
    protected void initData() {

    }

    @Override
    public void onFailed(Throwable t) {

    }

    @Override
    protected void initListener() {
        super.initListener();
        //登录
        accountGotoLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!isLogin) {
                    startActivity(LoginActivity.class);
                }else{
                    Toast.makeText(getActivity(), "您已经登录啦，别点啦！！！", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    @Override
    public void onResume() {
        super.onResume();
        //获取登录状态 判断是否登录
        SharedPreferences sp = getActivity().getSharedPreferences("config", MODE_PRIVATE);
        isLogin = sp.getBoolean("isLogin", false);
//        int status = SpUtils.getLoginBean(getActivity()).getStatus();
        if (!isLogin) {
            frameAccountHead.setImageResource(R.drawable.default_tx);
            frameAccountTxtLogin.setText("登录");
        } else {
            frameAccountHead.setImageResource(R.drawable.default_tx);
            frameAccountTxtLogin.setText("");
        }
    }

}
