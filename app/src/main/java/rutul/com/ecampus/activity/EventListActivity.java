package rutul.com.ecampus.activity;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;

import rutul.com.ecampus.R;
import rutul.com.ecampus.adapter.EventListAdapter;
import rutul.com.ecampus.adapter.JobListAdapter;
import rutul.com.ecampus.components.DividerItemDecoration;
import rutul.com.ecampus.utils.Constants;

public class EventListActivity extends BaseActivity implements EventListAdapter.ItemCommentClickListener, View.OnClickListener {
    private static final String TAG = EventListActivity.class.getSimpleName();
    RecyclerView rv_event;
    ImageView ivBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_list);
    }

    @Override
    public void initComponents() {
        rv_event = findViewById(R.id.rv_event);
        ivBack = findViewById(R.id.ivBack);
    }

    @Override
    public void setListener() {
    ivBack.setOnClickListener(this);
    }

    @Override
    public void prepareViews() {
        setHeaderView(R.drawable.main_bg_gray, true, Constants.TAG_EVENT_NEWS, R.color.colorWhite, false);
        rv_event.setHasFixedSize(true);
        rv_event.setLayoutManager(new LinearLayoutManager(mContext, LinearLayoutManager.VERTICAL, false));
        rv_event.addItemDecoration(new DividerItemDecoration(dividerDrawable));
        EventListAdapter eventListAdapter = new EventListAdapter(mContext, EventListActivity.this);
        rv_event.setAdapter(eventListAdapter);
    }

    @Override
    public void actionRequest(int position) {
        startDesireIntent(EventDetailActivity.class, mContext, false, 0, null);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.ivBack:
                finish();
                break;
        }
    }
}
