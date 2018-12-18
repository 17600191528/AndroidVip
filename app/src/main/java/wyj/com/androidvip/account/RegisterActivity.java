package wyj.com.androidvip.account;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import wyj.com.androidvip.R;
import wyj.com.androidvip.account.presenter.RegisterPresenter;
import wyj.com.androidvip.account.view.RegisterView;
import wyj.com.androidvip.base.BaseActivity;
import wyj.com.androidvip.entity.RegisterBean;
import wyj.com.androidvip.utils.Utils;

public class RegisterActivity extends BaseActivity<RegisterPresenter> implements RegisterView<RegisterBean, RegisterBean> {

    @BindView(R.id.activity_register_et_meil)
    EditText activityRegisterEtMeil;
    @BindView(R.id.activity_register_btn_sendCode)
    Button activityRegisterBtnSendCode;
    @BindView(R.id.activity_register_et_code)
    EditText activityRegisterEtCode;
    @BindView(R.id.activity_register_et_pass)
    EditText activityRegisterEtPass;
    @BindView(R.id.activity_register_et_makeSure_pass)
    EditText activityRegisterEtMakeSurePass;
    @BindView(R.id.activity_register_btn_register)
    Button activityRegisterBtnRegister;
    @BindView(R.id.activity_register_et_name)
    EditText activityRegisterEtName;
    private String meil;
    private String pass;
    private String name;

    @OnClick({R.id.activity_register_btn_sendCode, R.id.activity_register_btn_register})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.activity_register_btn_sendCode:

                break;
            case R.id.activity_register_btn_register:
                name = activityRegisterEtName.getText().toString().trim();
                meil = activityRegisterEtMeil.getText().toString().trim();
                String code = activityRegisterEtCode.getText().toString().trim();
                pass = activityRegisterEtPass.getText().toString().trim();
                String makeSurePass = activityRegisterEtMakeSurePass.getText().toString().trim();
                //判空验证
                if (Utils.isEmpty(name) || Utils.isEmpty(meil) || Utils.isEmpty(code) || Utils.isEmpty(pass) || Utils.isEmpty(makeSurePass)) {
                    Toast.makeText(this, "输入不能为空", Toast.LENGTH_SHORT).show();
                } else if (!Utils.isValidEmail(meil)) {
                    Toast.makeText(this, "邮箱格式不正确", Toast.LENGTH_SHORT).show();
                } else if (!pass.equals(makeSurePass)) {
                    Toast.makeText(this, "两次密码输入不正确", Toast.LENGTH_SHORT).show();
                } else {
                    //判断是否注册过
                    presenter.isRegister(name);
                }
                break;
        }
    }

    @Override
    protected int getIdContentView() {
        return R.layout.activity_register;
    }

    @Override
    protected RegisterPresenter getPresenter() {
        return new RegisterPresenter();
    }

    @Override
    public Context context() {
        return this;
    }

    @Override
    protected void initData() {

    }

    @Override
    public void onSuccess1(RegisterBean bean) {
        Toast.makeText(this, bean.getMessage() + "可以注册", Toast.LENGTH_SHORT).show();
        //注册
//        presenter.goToRegister(name, Utils.md5(pass));
    }

    @Override
    public void onSuccess2(RegisterBean bean) {
        Toast.makeText(this, bean.getMessage(), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onFailed(Throwable t) {
        Toast.makeText(this, t.getMessage(), Toast.LENGTH_SHORT).show();
    }

}
