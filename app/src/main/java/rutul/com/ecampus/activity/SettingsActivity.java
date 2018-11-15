package rutul.com.ecampus.activity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import rutul.com.ecampus.R;
import rutul.com.ecampus.components.CustomButton;
import rutul.com.ecampus.components.CustomRadioButton;
import rutul.com.ecampus.utils.Constants;

public class SettingsActivity extends BaseActivity implements View.OnClickListener, RadioGroup.OnCheckedChangeListener {
    private static final String TAG = SettingsActivity.class.getSimpleName();
    CustomRadioButton rb_top_yes,
            rb_top_no;
    private LinearLayout ll_terms, ll_change_pwd, ll_block_cpny;
    private CustomButton btn_logout;
    private ImageView ivBack;
    private RadioGroup toogle_notification;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
    }

    @Override
    public void initComponents() {
        ll_terms = findViewById(R.id.ll_terms);
        ll_change_pwd = findViewById(R.id.ll_change_pwd);
        ll_block_cpny = findViewById(R.id.ll_block_cpny);
        ivBack = findViewById(R.id.ivBack);
        btn_logout = findViewById(R.id.btn_logout);
        toogle_notification = findViewById(R.id.toogle_notification);

        rb_top_no = findViewById(R.id.rb_top_no);
        rb_top_yes = findViewById(R.id.rb_top_yes);
    }

    @Override
    public void setListener() {
        btn_logout.setOnClickListener(this);
        ll_terms.setOnClickListener(this);
        ll_change_pwd.setOnClickListener(this);
        ll_block_cpny.setOnClickListener(this);
        ivBack.setOnClickListener(this);
        rb_top_no.setOnClickListener(this);
        rb_top_yes.setOnClickListener(this);
        toogle_notification.setOnCheckedChangeListener(this);
    }


    @Override
    public void prepareViews() {
        setHeaderView(R.drawable.main_bg_gray, true, Constants.TAG_SETTINGS, R.color.colorWhite, false);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_logout:
                logoutFromApp(0);
                break;
            case R.id.ivBack:
                finish();
                break;
            case R.id.ll_change_pwd:
                startDesireIntent(ChangePassword.class, mContext, false, 0, null);
                break;
            case R.id.rb_top_no:
                rb_top_no.setTextColor(Color.WHITE);
                rb_top_yes.setTextColor(Color.BLACK);

                break;
            case R.id.rb_top_yes:
                rb_top_yes.setTextColor(Color.WHITE);
                rb_top_no.setTextColor(Color.BLACK);
                break;
        }
    }

    @Override
    public void onCheckedChanged(RadioGroup radioGroup, int i) {

    }
}
