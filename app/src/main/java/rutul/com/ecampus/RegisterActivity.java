package rutul.com.ecampus;

import android.os.Build;
import android.os.Bundle;

import rutul.com.ecampus.activity.BaseActivity;

public class  RegisterActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            getWindow().setStatusBarColor(getResources().getColor(R.color.colorDarkGreen));
        }
        setContentView(R.layout.activity_register);
    }

    @Override
    public void initComponents() {

    }

    @Override
    public void setListener() {

    }

    @Override
    public void prepareViews() {

    }
}
