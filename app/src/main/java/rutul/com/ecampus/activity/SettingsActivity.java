package rutul.com.ecampus.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import rutul.com.ecampus.R;
import rutul.com.ecampus.components.CustomButton;
import rutul.com.ecampus.utils.Constants;

public class SettingsActivity extends BaseActivity implements View.OnClickListener {
    private static final String TAG = SettingsActivity.class.getSimpleName();
    private LinearLayout ll_terms, ll_change_pwd, ll_block_cpny;
    private CustomButton btn_logout;
    private ImageView ivBack;


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
    }

    @Override
    public void setListener() {
        btn_logout.setOnClickListener(this);
        ll_terms.setOnClickListener(this);
        ll_change_pwd.setOnClickListener(this);
        ll_block_cpny.setOnClickListener(this);
        ivBack.setOnClickListener(this);
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
        }
    }
}
