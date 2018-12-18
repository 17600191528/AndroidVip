package wyj.com.androidvip.account;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
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

/**
 * @Description：个人信息
 * @Author：执念
 * @Date：2018/12/15 12:00
 */

public class AccountFragment extends BaseFragment {
    @BindView(R.id.account_head)
    SimpleDraweeView accountHead;
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
    private boolean isLogin;

    @OnClick({R.id.account_goto_login, R.id.frame_account_myAbout, R.id.frame_account_aboutMe, R.id.frame_account_myShare, R.id.frame_account_myPost, R.id.frame_account_myTan, R.id.frame_account_mySetting})
    public void onViewClicked(View view) {
        if (isLogin) {
            Toast.makeText(getActivity(), "您已经登录了，不能点了", Toast.LENGTH_SHORT).show();
        } else {
            switch (view.getId()) {
                case R.id.account_goto_login:
                    startActivity(LoginActivity.class);
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
    public void onFailed(Throwable t) {

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
    public void onResume() {
        super.onResume();
        //获取登录状态 判断是否登录
        isLogin = SharedPreUtils.getBoolean(getActivity(), "isLogin", false);
        if (!isLogin) {
            accountHead.setImageResource(R.drawable.default_tx);
        } else {

        }
    }

}
