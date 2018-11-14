package rutul.com.ecampus.activity;

import android.os.Build;
import android.os.Bundle;
import android.view.View;

import rutul.com.ecampus.MainActivity;
import rutul.com.ecampus.R;
import rutul.com.ecampus.RegisterActivity;
import rutul.com.ecampus.components.CustomButton;
import rutul.com.ecampus.components.CustomEditText;
import rutul.com.ecampus.components.CustomTextView;
import rutul.com.ecampus.utils.ApplicationSharedPreferences;
import rutul.com.ecampus.utils.HelperMethods;

public class LoginActivity extends BaseActivity implements View.OnClickListener {
    public static final String TAG = LoginActivity.class.getSimpleName();
    CustomEditText et_username,
            et_password;
    CustomButton bt_sign_in;
    CustomTextView tv_forgot_password,
            tv_sign_up;

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            getWindow().setStatusBarColor(getResources().getColor(R.color.colorDarkGreen));
        }
        setContentView(R.layout.activity_login);
    }

    @Override
    public void initComponents() {
        et_username = findViewById(R.id.et_username);
        et_password = findViewById(R.id.et_password);
        bt_sign_in = findViewById(R.id.bt_sign_in);
        tv_forgot_password = findViewById(R.id.tv_forgot_password);
        tv_sign_up = findViewById(R.id.tv_sign_up);
    }

    @Override
    public void setListener() {
        bt_sign_in.setOnClickListener(this);
        tv_forgot_password.setOnClickListener(this);
        tv_sign_up.setOnClickListener(this);
    }

    @Override
    public void prepareViews() {

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.bt_sign_in:
                if (checkForValidation()) {
                    userLogin();
                }
                break;
            case R.id.tv_sign_up:
                startDesireIntent(RegisterActivity.class, mContext, false, 0, null);
                break;
            case R.id.tv_forgot_password:
                break;
        }
    }

    private void userLogin() {
        ApplicationSharedPreferences.set(getResources().getString(R.string.PREFS_LOGGED_IN), true, mContext);
        //startDesireIntent(MainActivity.class, mContext, false, 0, null);
        startDesireIntent(WelcomeActivity.class, mContext, false, 0, null);
        finish();
    }

    private boolean checkForValidation() {
        String userName = et_username.getText().toString();
        String password = et_password.getText().toString();
        if (!HelperMethods.isValidEmail(userName)) {
            et_username.requestFocus();
            et_username.setError(getResources().getString(R.string.err_mail));
        } else if (!HelperMethods.checkForValidString(password)) {
            et_password.requestFocus();
            et_password.setError(getResources().getString(R.string.err_password));
        } else {
            return true;
        }
        return false;
    }
}
