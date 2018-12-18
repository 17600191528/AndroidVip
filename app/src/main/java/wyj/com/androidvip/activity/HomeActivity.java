package wyj.com.androidvip.activity;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import wyj.com.androidvip.R;
import wyj.com.androidvip.account.AccountFragment;
import wyj.com.androidvip.gan.GanFragment;
import wyj.com.androidvip.index.IndexFragment;
import wyj.com.androidvip.live.LiveFragment;
import wyj.com.androidvip.study.StudyFragment;

public class HomeActivity extends AppCompatActivity {

    @BindView(R.id.activity_home_index)
    LinearLayout activityHomeIndex;
    @BindView(R.id.activity_home_study)
    LinearLayout activityHomeStudy;
    @BindView(R.id.activity_home_live)
    LinearLayout activityHomeLive;
    @BindView(R.id.activity_home_gan)
    LinearLayout activityHomeGan;
    @BindView(R.id.activity_home_account)
    LinearLayout activityHomeAccount;
    @BindView(R.id.activity_home_frameLayout)
    FrameLayout activityHomeFrameLayout;
    @BindView(R.id.activity_home_img_index)
    ImageView activityHomeImgIndex;
    @BindView(R.id.activity_home_txt_index)
    TextView activityHomeTxtIndex;
    @BindView(R.id.activity_home_img_study)
    ImageView activityHomeImgStudy;
    @BindView(R.id.activity_home_txt_study)
    TextView activityHomeTxtStudy;
    @BindView(R.id.activity_home_img_live)
    ImageView activityHomeImgLive;
    @BindView(R.id.activity_home_txt_live)
    TextView activityHomeTxtLive;
    @BindView(R.id.activity_home_img_gan)
    ImageView activityHomeImgGan;
    @BindView(R.id.activity_home_txt_gan)
    TextView activityHomeTxtGan;
    @BindView(R.id.activity_home_img_account)
    ImageView activityHomeImgAccount;
    @BindView(R.id.activity_home_txt_account)
    TextView activityHomeTxtAccount;
    @BindView(R.id.activity_home_bottom)
    LinearLayout activityHomeBottom;
    @BindView(R.id.activity_home_top)
    TextView activityHomeTop;

    private IndexFragment indexFragment;
    private StudyFragment studyFragment;
    private LiveFragment liveFragment;
    private GanFragment ganFragment;
    private AccountFragment accountFragment;

    @OnClick({R.id.activity_home_index, R.id.activity_home_study, R.id.activity_home_live, R.id.activity_home_gan, R.id.activity_home_account})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.activity_home_index:
                setImageChecked(0);
                getSupportFragmentManager().beginTransaction().replace(R.id.activity_home_frameLayout, indexFragment).commit();
                activityHomeTop.setText("首页");
                break;
            case R.id.activity_home_study:
                setImageChecked(1);
                getSupportFragmentManager().beginTransaction().replace(R.id.activity_home_frameLayout, studyFragment).commit();
                activityHomeTop.setText("学习");
                break;
            case R.id.activity_home_live:
                setImageChecked(2);
                getSupportFragmentManager().beginTransaction().replace(R.id.activity_home_frameLayout, liveFragment).commit();
                activityHomeTop.setText("视频");
                break;
            case R.id.activity_home_gan:
                setImageChecked(3);
                getSupportFragmentManager().beginTransaction().replace(R.id.activity_home_frameLayout, ganFragment).commit();
                activityHomeTop.setText("经典");
                break;
            case R.id.activity_home_account:
                setImageChecked(4);
                getSupportFragmentManager().beginTransaction().replace(R.id.activity_home_frameLayout, accountFragment).commit();
                activityHomeTop.setText("我的");
                break;
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        ButterKnife.bind(this);

        indexFragment = new IndexFragment();
        studyFragment = new StudyFragment();
        liveFragment = new LiveFragment();
        ganFragment = new GanFragment();
        accountFragment = new AccountFragment();

        getSupportFragmentManager().beginTransaction().add(R.id.activity_home_frameLayout, indexFragment).commit();
        setImageChecked(0);
        activityHomeTop.setText("首页");
    }

    private void setImageChecked(int i) {
        activityHomeImgIndex.setImageResource(i == 0 ? R.drawable.index_yes : R.drawable.index_no);
        activityHomeImgStudy.setImageResource(i == 1 ? R.drawable.study_yes : R.drawable.study_no);
        activityHomeImgLive.setImageResource(i == 2 ? R.drawable.live_yes : R.drawable.live_no);
        activityHomeImgGan.setImageResource(i == 3 ? R.drawable.gan_yes : R.drawable.gan_no);
        activityHomeImgAccount.setImageResource(i == 4 ? R.drawable.account_yes : R.drawable.account_no);
        activityHomeTxtIndex.setTextColor(i == 0 ? Color.RED : Color.BLACK);
        activityHomeTxtStudy.setTextColor(i == 1 ? Color.RED : Color.BLACK);
        activityHomeTxtLive.setTextColor(i == 2 ? Color.RED : Color.BLACK);
        activityHomeTxtGan.setTextColor(i == 3 ? Color.RED : Color.BLACK);
        activityHomeTxtAccount.setTextColor(i == 4 ? Color.RED : Color.BLACK);
    }

}
