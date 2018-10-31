package rutul.com.ecampus.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;

import rutul.com.ecampus.R;
import rutul.com.ecampus.utils.ApplicationSharedPreferences;
import rutul.com.ecampus.utils.FragmentUtil;
import rutul.com.ecampus.utils.runtimepermissionhelper.ActivityManagePermission;

public abstract class BaseActivity extends ActivityManagePermission {
    public Context mContext;
    public BaseActivity mActivity;
    public Bundle mBundle = new Bundle();


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mContext = this;
        mActivity = this;
        mBundle = getIntent().getExtras();
        if (mBundle == null) {
            mBundle = new Bundle();
        }
    }

    @Override
    public void setContentView(@LayoutRes int layoutResID) {
        super.setContentView(layoutResID);
        initComponents();
        setListener();
        prepareViews();
    }

    abstract public void initComponents();

    abstract public void setListener();

    abstract public void prepareViews();

    public void startDesireIntent(final Class activity, final Context context, boolean isActivityResult, int reqCode, @Nullable Bundle bundle) {
        Intent desireIntent = new Intent(context, activity);
        if (bundle != null) {
            desireIntent.putExtras(bundle);
        }
        if (isActivityResult) {
            startActivityForResult(desireIntent, reqCode);
        } else {
            startActivity(desireIntent);
        }
    }

//    public void addFragment(AppCompatActivity activity, Fragment fragment, String fragmentTag, FragmentUtil.ANIMATION_TYPE animationType) {
//        new FragmentUtil().addFragment(activity,
//                R.id.main_container,
//                fragment,
//                fragmentTag,
//                animationType, null);
//    }
//
//    public void replaceFragment(AppCompatActivity activity, Fragment fragment, String fragmentTag, FragmentUtil.ANIMATION_TYPE animationType) {
//        new FragmentUtil().replaceFragment(activity,
//                R.id.main_container,
//                fragment,
//                fragmentTag,
//                animationType, null);
//    }
//
//    public void replaceFragment(AppCompatActivity activity, Fragment fragment, String fragmentTag, FragmentUtil.ANIMATION_TYPE animationType, Bundle bundle) {
//        new FragmentUtil().replaceFragment(activity,
//                R.id.main_container,
//                fragment,
//                fragmentTag,
//                animationType, bundle);
//    }
//
//    public void removeFragment(FragmentActivity activity, FragmentUtil.ANIMATION_TYPE animationType) {
//        new FragmentUtil().removeFragment(activity,
//                R.id.main_container,
//                getCurrentFragment(),
//                animationType);
//    }

    public String getCurrentFragmentTag() {
        FragmentUtil fragmentUtil = new FragmentUtil();
        return fragmentUtil.getCurrentFragment(this).getTag();
    }

    public Fragment getCurrentFragment() {
        FragmentUtil fragmentUtil = new FragmentUtil();
        return fragmentUtil.getCurrentFragment(this);
    }

    public boolean isUserLoggedIn() {
        return ApplicationSharedPreferences.getBooleanValue(getResources().getString(R.string.PREFS_LOGGED_IN), false, mContext);
    }

}
