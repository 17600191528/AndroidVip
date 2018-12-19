package wyj.com.androidvip.account;

import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.io.FileOutputStream;
import java.util.Date;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import wyj.com.androidvip.R;
import wyj.com.androidvip.account.presenter.SettingPresenter;
import wyj.com.androidvip.account.view.SettingView;
import wyj.com.androidvip.base.BaseActivity;
import wyj.com.androidvip.entity.TiShiBean;

public class MySettingActivity extends BaseActivity<SettingPresenter> implements SettingView<TiShiBean> {

    @BindView(R.id.activity_setting_img_tx)
    ImageView activitySettingImgTx;
    @BindView(R.id.activity_setting_tx)
    RelativeLayout activitySettingTx;
    @BindView(R.id.activity_setting_txt_nickname)
    TextView activitySettingTxtNickname;
    @BindView(R.id.activity_setting_nickname)
    RelativeLayout activitySettingNickname;
    @BindView(R.id.activity_setting_txt_sex)
    TextView activitySettingTxtSex;
    @BindView(R.id.activity_setting_sex)
    RelativeLayout activitySettingSex;
    @BindView(R.id.activity_setting_txt_age)
    TextView activitySettingTxtAge;
    @BindView(R.id.activity_setting_age)
    RelativeLayout activitySettingAge;
    @BindView(R.id.activity_setting_txt_address)
    TextView activitySettingTxtAddress;
    @BindView(R.id.activity_setting_address)
    RelativeLayout activitySettingAddress;
    @BindView(R.id.activity_setting_txt_company)
    TextView activitySettingTxtCompany;
    @BindView(R.id.activity_setting_company)
    RelativeLayout activitySettingCompany;
    @BindView(R.id.activity_setting_txt_occupation)
    TextView activitySettingTxtOccupation;
    @BindView(R.id.activity_setting_occupation)
    RelativeLayout activitySettingOccupation;
    @BindView(R.id.activity_setting_txt_phone)
    TextView activitySettingTxtPhone;
    @BindView(R.id.activity_setting_phone)
    RelativeLayout activitySettingPhone;
    @BindView(R.id.activity_setting_txt_mail)
    TextView activitySettingTxtMail;
    @BindView(R.id.activity_setting_mail)
    RelativeLayout activitySettingMail;
    @BindView(R.id.activity_setting_img_changepass)
    ImageView activitySettingImgChangepass;
    @BindView(R.id.activity_setting_changepass)
    RelativeLayout activitySettingChangepass;
    @BindView(R.id.activity_setting_btn_exit_login)
    Button activitySettingBtnExitLogin;
    private AlertDialog alertDialog;
    private File imgRoot;
    private Intent intent;
    private Uri uri;
    private View viewTx;
    private View viewNickName;
    private View viewSex;
    private View viewAge;
    private String user_hidden;


    @OnClick({R.id.activity_setting_tx, R.id.activity_setting_nickname, R.id.activity_setting_sex, R.id.activity_setting_age, R.id.activity_setting_address, R.id.activity_setting_company, R.id.activity_setting_occupation, R.id.activity_setting_phone, R.id.activity_setting_mail, R.id.activity_setting_changepass, R.id.activity_setting_btn_exit_login})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.activity_setting_tx:
                //上传头像
                viewTx = getAlert(R.layout.dialog_change_changehead);
                viewTx.findViewById(R.id.dialog_changehead_takephotos).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        File f = new File(imgRoot, new Date().getTime() + ".jpg");
                        uri = Uri.fromFile(f);
                        intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                        intent.putExtra(MediaStore.EXTRA_OUTPUT, uri);
                        startActivityForResult(intent, 0);
                    }
                });
                viewTx.findViewById(R.id.dialog_changehead_album).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        intent = new Intent(intent.ACTION_PICK);
                        intent.setType("image/*");
                        startActivityForResult(intent, 1);
                    }
                });
                viewTx.findViewById(R.id.dialog_changehead_dismiss).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        alertDialog.dismiss();
                    }
                });
                break;
            case R.id.activity_setting_nickname:
                //修改昵称
                viewNickName = getAlert(R.layout.dialog_change_nickname);
                break;
            case R.id.activity_setting_sex:
                //修改性别
                viewSex = getAlert(R.layout.dialog_change_sex);
                break;
            case R.id.activity_setting_age:
                //修改年龄
                viewAge = getAlert(R.layout.dialog_change_age);
                break;
            case R.id.activity_setting_address:
                break;
            case R.id.activity_setting_company:
                break;
            case R.id.activity_setting_occupation:
                break;
            case R.id.activity_setting_phone:
                break;
            case R.id.activity_setting_mail:
                break;
            case R.id.activity_setting_changepass:
                break;
            case R.id.activity_setting_btn_exit_login:
                break;
        }
    }

    @Override
    protected int getIdContentView() {
        return R.layout.activity_my_setting;
    }

    @Override
    protected SettingPresenter getPresenter() {
        return new SettingPresenter();
    }

    @Override
    public Context context() {
        return this;
    }

    @Override
    protected void initData() {
        // 第一步 ： 判断SD卡是否可用 ,可用的话,创建照片存储的目录
        if (Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED)) {
            // SD卡根目录
            File rootSD = Environment.getExternalStorageDirectory();
            // 创建存储的路径
            imgRoot = new File(rootSD.getAbsolutePath() + File.separator + "imgs");
            // 判断目录是否存在，不存在就创建
            if (!imgRoot.exists()) {
                imgRoot.mkdirs();
            }
        }
        //获取用户id
        SharedPreferences sp = getSharedPreferences("config", MODE_PRIVATE);
        user_hidden = sp.getString("user_hidden", null);
    }

    @Override
    public void onSuccess(TiShiBean bean) {

    }

    @Override
    public void onFailed(Throwable t) {
        Toast.makeText(this, t.getMessage(), Toast.LENGTH_SHORT).show();
    }

    private View getAlert(int item_alert) { //item_alert引入的布局
        View v = this.getLayoutInflater().inflate(item_alert, null, false);
        alertDialog =  new AlertDialog.Builder(this).setView(v).create();
        alertDialog.setCanceledOnTouchOutside(false);
        alertDialog.show();
        return v;
    }

    //将本地图片资源转换成File
    private File getFile(Bitmap bmp) {
        String defaultPath = getApplicationContext().getFilesDir().getAbsolutePath() + "/defaultGoodInfo";
        File file = new File(defaultPath);
        if (!file.exists()) {
            file.mkdirs();
        }
        String defaultImgPath = defaultPath + "/messageImg.jpg";
        file = new File(defaultImgPath);
        try {
            file.createNewFile();
            FileOutputStream fOut = new FileOutputStream(file);
            bmp.compress(Bitmap.CompressFormat.PNG, 20, fOut);
            fOut.flush();
            fOut.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return file;
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        // TODO Auto-generated method stub
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 0) {
            // 从系统相机返回的值
            intent = crop(uri);
            startActivityForResult(intent, 2);

        } else if (requestCode == 1) {
            // 从相册中返回的值
            uri = data.getData();
            intent = crop(uri);
            startActivityForResult(intent, 2);

        } else if (requestCode == 2) {
            // 从返回值中直接获取bitmap
            Bitmap bmp = (Bitmap) data.getExtras().get("data");
            //上传文件
//            Log.i("111", user_hidden+""+getFile(bmp));
            //abner13321/data/data/wyj.com.androidvip/files/defaultGoodInfo/messageImg.jpg
            presenter.changeHead(user_hidden, getFile(bmp));
        }
    }

    private Intent crop(Uri uri) {
        // 隐式Intent，调用系统的裁剪
        Intent intent = new Intent("com.android.camera.action.CROP");
        // 设置裁剪的数据源和数据类型
        intent.setDataAndType(uri, "image/*");
        intent.putExtra("crop", "true");// 可裁剪
        // 裁剪的宽高比例
        intent.putExtra("aspectX", 1); // 裁剪的宽比例
        intent.putExtra("aspectY", 1); // 裁剪的高比例

        // 裁剪的宽度和高度
        intent.putExtra("outputX", 300); // 裁剪的宽度
        intent.putExtra("outputY", 300); // 裁剪的高度
        // 可省略
//    intent.putExtra("scale", true); // 支持缩放
        // 裁剪之后保存的路径
        intent.putExtra(MediaStore.EXTRA_OUTPUT, Uri.parse(uri.getPath() + ".bak")); // 将裁剪的结果输出到指定的Uri
        // 必须加，否则返回值中找不到返回的值
        intent.putExtra("return-data", true); // 若为true则表示返回数据
        // 可以省略
//    intent.putExtra("outputFormat", Bitmap.CompressFormat.JPEG.toString());// 裁剪成的图片的格式
        // intent.putExtra("noFaceDetection", true); //启用人脸识别
        return intent;
    }

}
