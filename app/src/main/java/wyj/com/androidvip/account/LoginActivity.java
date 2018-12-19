package wyj.com.androidvip.account;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import wyj.com.androidvip.R;
import wyj.com.androidvip.account.presenter.LoginPresenter;
import wyj.com.androidvip.account.view.LoginView;
import wyj.com.androidvip.base.BaseActivity;
import wyj.com.androidvip.entity.LoginBean;
import wyj.com.androidvip.utils.SharedPreUtils;
import wyj.com.androidvip.utils.SpUtils;
import wyj.com.androidvip.utils.Utils;

public class LoginActivity extends BaseActivity<LoginPresenter> implements LoginView<LoginBean> {

    @BindView(R.id.activity_login_name)
    EditText activityLoginName;
    @BindView(R.id.activity_login_pass)
    EditText activityLoginPass;
    @BindView(R.id.activity_login_cb_remember)
    CheckBox activityLoginCbRemember;
    @BindView(R.id.cb_auto)
    CheckBox cbAuto;
    @BindView(R.id.activity_login_tv_register)
    TextView activityLoginTvRegister;
    @BindView(R.id.activity_login_btn_login)
    Button activityLoginBtnLogin;

    @OnClick({R.id.activity_login_cb_remember, R.id.cb_auto, R.id.activity_login_tv_register, R.id.activity_login_btn_login})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.activity_login_cb_remember:

                break;
            case R.id.cb_auto:
                break;
            case R.id.activity_login_tv_register:
                startActivity(RegisterActivity.class);
                break;
            case R.id.activity_login_btn_login:
                String name = activityLoginName.getText().toString().trim();
                String pass = activityLoginPass.getText().toString();
                if (Utils.isEmpty(name) || Utils.isEmpty(pass)) {
                    Toast.makeText(this, "输入不能为空", Toast.LENGTH_SHORT).show();
                } else {
                    presenter.goToLogin(name, Utils.md5(pass));
                }
                break;
        }
    }

    @Override
    protected int getIdContentView() {
        return R.layout.activity_login;
    }

    @Override
    protected LoginPresenter getPresenter() {
        return new LoginPresenter();
    }

    @Override
    protected void initData() {

    }

    @Override
    public Context context() {
        return this;
    }

    @Override
    public void onSuccess(LoginBean bean) {
        Toast.makeText(this, "登录成功", Toast.LENGTH_SHORT).show();
//        SpUtils.putLoginBean(this, bean);
        SharedPreferences sp = getSharedPreferences("config", MODE_PRIVATE);
        sp.edit()
                .putBoolean("isLogin", true)//登录状态
                .putString("user_hidden", bean.getUser_id())//登录状态
                .putString("head", null)//头像
                .commit();
        finish();
    }

    @Override
    public void onFailed(Throwable t) {
        Toast.makeText(this, t.getMessage(), Toast.LENGTH_SHORT).show();
    }


}
