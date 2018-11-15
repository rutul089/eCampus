package rutul.com.ecampus.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import rutul.com.ecampus.R;
import rutul.com.ecampus.components.CustomButton;
import rutul.com.ecampus.components.CustomCheckBox;
import rutul.com.ecampus.components.CustomEditText;

public class ChangePassword extends BaseActivity implements View.OnClickListener {
    private static final String TAG = ChangePassword.class.getSimpleName();
    private CustomEditText et_password,
            et_new_passwprd,
            et_conform_password;
    private CustomCheckBox ch_type;
    private CustomButton btn_change;
    private ImageView ivBack, ivNotification;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_password);
    }

    @Override
    public void initComponents() {
        et_password = findViewById(R.id.et_password);
        et_new_passwprd = findViewById(R.id.et_new_passwprd);
        et_conform_password = findViewById(R.id.et_conform_password);
        ch_type = findViewById(R.id.ch_type);
        btn_change = findViewById(R.id.btn_change);
        ivBack = findViewById(R.id.ivBack);
        ivNotification = findViewById(R.id.ivNotification);
    }

    @Override
    public void setListener() {
        btn_change.setOnClickListener(this);
        ivBack.setOnClickListener(this);
        ivNotification.setOnClickListener(this);
    }

    @Override
    public void prepareViews() {
        setHeaderView(R.drawable.main_bg_gray, true, "Change Password", R.color.colorWhite, true);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.ivBack:
                finish();
                break;
            case R.id.ivNotification:
                startDesireIntent(NotificationActivity.class, mContext, false, 0, null);
                break;
        }
    }
}
