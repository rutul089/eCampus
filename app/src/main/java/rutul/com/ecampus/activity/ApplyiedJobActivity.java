package rutul.com.ecampus.activity;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;

import rutul.com.ecampus.R;
import rutul.com.ecampus.adapter.JobListAdapter;
import rutul.com.ecampus.components.DividerItemDecoration;
import rutul.com.ecampus.utils.Constants;

public class ApplyiedJobActivity extends BaseActivity implements JobListAdapter.ItemCommentClickListener, View.OnClickListener {
    private static final String TAG = ApplyiedJobActivity.class.getSimpleName();
    private RecyclerView rv_appointment;
    private ImageView ivBack, ivNotification;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_applyied_job);
    }

    @Override
    public void initComponents() {
        rv_appointment = findViewById(R.id.rv_appointment);
        ivBack = findViewById(R.id.ivBack);
        ivNotification = findViewById(R.id.ivNotification);
    }

    @Override
    public void setListener() {
        ivNotification.setOnClickListener(this);
        ivBack.setOnClickListener(this);
    }

    @Override
    public void prepareViews() {
        setHeaderView(R.drawable.main_bg_gray, true, Constants.TAG_APPLIED_JOB, R.color.colorWhite, true);
        rv_appointment.setHasFixedSize(true);
        rv_appointment.setLayoutManager(new LinearLayoutManager(mContext, LinearLayoutManager.VERTICAL, false));
        rv_appointment.addItemDecoration(new DividerItemDecoration(dividerDrawable));
        JobListAdapter jobListAdapter = new JobListAdapter(mContext, ApplyiedJobActivity.this);
        rv_appointment.setAdapter(jobListAdapter);
    }

    @Override
    public void actionRequest(int position) {

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
            default:
                break;
        }
    }
}


