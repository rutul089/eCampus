package rutul.com.ecampus.activity;

import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import rutul.com.ecampus.R;
import rutul.com.ecampus.utils.Constants;

public class MyProfile extends BaseActivity implements View.OnClickListener {
    private static final String TAG = MyProfile.class.getSimpleName();
    private ImageView ivBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
//            getWindow().setStatusBarColor(getResources().getColor(R.color.colorStatus));
//        }
        setContentView(R.layout.activity_my_profile);
    }

    @Override
    public void initComponents() {
        ivBack = findViewById(R.id.ivBack);
    }

    @Override
    public void setListener() {
        ivBack.setOnClickListener(this);
    }

    @Override
    public void prepareViews() {
        setHeaderView(R.drawable.main_bg_blue, true, Constants.TAG_MY_PROFILE, R.color.colorWhite, false);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.ivBack:
                finish();
                break;
        }
    }
}
