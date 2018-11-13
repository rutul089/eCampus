package rutul.com.ecampus.activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.widget.ImageView;
import android.widget.RatingBar;

import rutul.com.ecampus.R;
import rutul.com.ecampus.adapter.TabLayoutAdapter;
import rutul.com.ecampus.components.BadgedTabLayout;
import rutul.com.ecampus.components.CustomButton;
import rutul.com.ecampus.components.CustomTextView;
import rutul.com.ecampus.components.CustomViewPager;
import rutul.com.ecampus.fragment.CompanyInfoFragment;
import rutul.com.ecampus.fragment.JobInfoFragment;
import rutul.com.ecampus.fragment.ReviewFragment;
import rutul.com.ecampus.utils.Constants;

public class JobDetailActivity extends BaseActivity {

    private ImageView iv_logo;
    private CustomTextView tv_company_name, tv_address;
    private RatingBar rating;
    private BadgedTabLayout tl_job_detail;
    private CustomViewPager vp_job_detail;
    private CustomButton bt_apply;
    private TabLayoutAdapter tabLayoutAdapter;


    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_job_detail);
    }

    @Override
    public void initComponents() {
        iv_logo = findViewById(R.id.iv_logo);
        tv_address = findViewById(R.id.tv_address);
        tv_company_name = findViewById(R.id.tv_company_name);
        rating = findViewById(R.id.rating);
        tl_job_detail = findViewById(R.id.tl_job_detail);
        vp_job_detail = findViewById(R.id.vp_job_detail);
        bt_apply = findViewById(R.id.bt_apply);
    }

    @Override
    public void setListener() {

    }

    @Override
    public void prepareViews() {
        setHeaderView(R.drawable.main_bg_blue, true, "Job Detail", R.color.colorWhite, false);
        tabLayoutAdapter = new TabLayoutAdapter(getSupportFragmentManager());
        settingUpViewPager();
    }

    private void settingUpViewPager() {
        Fragment fragment;
        fragment = new JobInfoFragment();
        tabLayoutAdapter.addFragment(fragment, Constants.TAG_JOB_INFO);
        fragment = new CompanyInfoFragment();
        tabLayoutAdapter.addFragment(fragment, Constants.TAG_CPNY_INFO);
        fragment = new ReviewFragment();
        tabLayoutAdapter.addFragment(fragment, Constants.TAG_REVIEW);
        int limit = (tabLayoutAdapter.getCount() > 1 ? tabLayoutAdapter.getCount() : 1);
        vp_job_detail.setOffscreenPageLimit(limit);
        vp_job_detail.setAdapter(tabLayoutAdapter);
        tl_job_detail.setupWithViewPager(vp_job_detail);
        tl_job_detail.setBadgeText(2, "45");
    }
}
