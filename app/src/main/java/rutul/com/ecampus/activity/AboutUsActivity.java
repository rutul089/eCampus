package rutul.com.ecampus.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import rutul.com.ecampus.R;
import rutul.com.ecampus.utils.Constants;
import rutul.com.ecampus.utils.HelperMethods;

public class AboutUsActivity extends BaseActivity implements View.OnClickListener {
    private static final String TAG = AboutUsActivity.class.getSimpleName();
    private ImageView ivBack, iv_facebook,
            iv_twitter,
            iv_google,
            iv_youtube;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_us);
    }

    @Override
    public void initComponents() {
        ivBack = findViewById(R.id.ivBack);
        iv_facebook = findViewById(R.id.iv_facebook);
        iv_twitter = findViewById(R.id.iv_twitter);
        iv_google = findViewById(R.id.iv_google);
        iv_youtube = findViewById(R.id.iv_youtube);
    }

    @Override
    public void setListener() {
        ivBack.setOnClickListener(this);
        iv_facebook.setOnClickListener(this);
        iv_twitter.setOnClickListener(this);
        iv_google.setOnClickListener(this);
        iv_youtube.setOnClickListener(this);
    }

    @Override
    public void prepareViews() {
        setHeaderView(R.drawable.main_bg_gray, true, Constants.TAG_ABOUT_US, R.color.colorWhite, false);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.ivBack:
                finish();
                break;
            case R.id.iv_facebook:
                HelperMethods.showToast("Facebook",mContext);
                break;
            case R.id.iv_twitter:
                HelperMethods.showToast("Twitter",mContext);
                break;
            case R.id.iv_google:
                HelperMethods.showToast("Google",mContext);
                break;
            case R.id.iv_youtube:
                HelperMethods.showToast("Youtube",mContext);
                break;
        }
    }
}
