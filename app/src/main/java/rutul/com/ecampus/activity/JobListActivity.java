package rutul.com.ecampus.activity;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import rutul.com.ecampus.R;
import rutul.com.ecampus.adapter.JobListAdapter;
import rutul.com.ecampus.components.DividerItemDecoration;

public class JobListActivity extends BaseActivity implements View.OnClickListener, JobListAdapter.ItemCommentClickListener {
    private static final String TAG = JobListActivity.class.getSimpleName();
    RecyclerView rv_job_list;
    ImageView ivBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_job_list);
    }

    @Override
    public void initComponents() {
        rv_job_list = findViewById(R.id.rv_job_list);
        ivBack = findViewById(R.id.ivBack);
    }

    @Override
    public void setListener() {
        ivBack.setOnClickListener(this);
    }

    @Override
    public void prepareViews() {
        setHeaderView(R.drawable.main_bg_blue, true, "Job List", R.color.colorWhite, false);
        rv_job_list.setHasFixedSize(true);
        rv_job_list.setLayoutManager(new LinearLayoutManager(mContext, LinearLayoutManager.VERTICAL, false));
        rv_job_list.addItemDecoration(new DividerItemDecoration(dividerDrawable));
        JobListAdapter jobListAdapter = new JobListAdapter(mContext, JobListActivity.this);
        rv_job_list.setAdapter(jobListAdapter);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.ivBack:
                finish();
                break;
        }

    }

    @Override
    public void actionRequest(int position) {
        Log.i(TAG, "actionRequest:JobList " + position);
        startDesireIntent(JobDetailActivity.class, mContext, false, 0, null);
    }
}
