package rutul.com.ecampus.activity;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;

import rutul.com.ecampus.R;
import rutul.com.ecampus.adapter.NotificationAdapter;
import rutul.com.ecampus.components.DividerItemDecoration;
import rutul.com.ecampus.utils.Constants;

public class NotificationActivity extends BaseActivity implements View.OnClickListener {
    private static final String TAG = NotificationActivity.class.getSimpleName();
    private RecyclerView rv_notification;
    private ImageView ivBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification);
    }

    @Override
    public void initComponents() {
        rv_notification = findViewById(R.id.rv_notification);
        ivBack = findViewById(R.id.ivBack);
    }

    @Override
    public void setListener() {
        ivBack.setOnClickListener(this);
    }

    @Override
    public void prepareViews() {
        setHeaderView(R.drawable.main_bg_gray, true, Constants.TAG_NOTIFICATION, R.color.colorWhite, false);
        rv_notification.setHasFixedSize(true);
        rv_notification.setLayoutManager(new LinearLayoutManager(mContext, LinearLayoutManager.VERTICAL, false));
        rv_notification.addItemDecoration(new DividerItemDecoration(dividerDrawable));
        NotificationAdapter notificationAdapter = new NotificationAdapter(mContext);
        rv_notification.setAdapter(notificationAdapter);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.ivBack:
                finish();
                break;
            default:
                break;
        }
    }
}
