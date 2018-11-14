package rutul.com.ecampus.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import rutul.com.ecampus.R;

public class EventDetailActivity extends BaseActivity implements View.OnClickListener {
    ImageView ivBack, ivNotification;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_detail);
    }

    @Override
    public void initComponents() {
        ivBack = findViewById(R.id.ivBack);
        ivNotification = findViewById(R.id.ivNotification);
    }

    @Override
    public void setListener() {
        ivBack.setOnClickListener(this);
        ivNotification.setOnClickListener(this);
    }

    @Override
    public void prepareViews() {
        setHeaderView(R.drawable.main_bg_gray, true, "Event Detail", R.color.colorWhite, true);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.ivBack:
                finish();
                break;
            case R.id.ivNotification:
                startDesireIntent(NotificationActivity.class, mContext, false, 0, mBundle);
                break;
        }

    }
}
