package rutul.com.ecampus.activity;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.support.constraint.ConstraintLayout;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.view.View;
import android.widget.ImageView;

import rutul.com.ecampus.R;
import rutul.com.ecampus.components.CustomTextView;
import rutul.com.ecampus.utils.ApplicationSharedPreferences;
import rutul.com.ecampus.utils.FragmentUtil;
import rutul.com.ecampus.utils.runtimepermissionhelper.ActivityManagePermission;

public abstract class BaseActivity extends ActivityManagePermission {
    public Context mContext;
    public BaseActivity mActivity;
    public Bundle mBundle = new Bundle();
    private ConstraintLayout clHeaderContainer;
    private ImageView ivHeaderBg, ivBack, ivNotification;
    private CustomTextView tvAppTitle;
    private int mivHeaderBgColor, mHeaderTittleColor;
    protected Drawable dividerDrawable;

    public void setHeaderView(@Nullable int ivHeaderBgColor, @Nullable boolean showBackIcon,
                              @Nullable String headerTitle, @Nullable int headerTitleColor, @Nullable boolean showNotificationIcon) {
        mivHeaderBgColor = ivHeaderBgColor;
        mHeaderTittleColor = headerTitleColor;
        ivHeaderBg.setImageResource(mivHeaderBgColor);
        ivBack.setVisibility(showBackIcon ? View.VISIBLE : View.GONE);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            tvAppTitle.setTextColor(getResources().getColor(mHeaderTittleColor, null));
        } else {
            tvAppTitle.setTextColor(getResources().getColor(mHeaderTittleColor));
        }
        tvAppTitle.setText(headerTitle);
        ivNotification.setVisibility(showNotificationIcon ? View.VISIBLE : View.GONE);

    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mContext = this;
        mActivity = this;
        mBundle = getIntent().getExtras();
        if (mBundle == null) {
            mBundle = new Bundle();
        }
        dividerDrawable = ContextCompat.getDrawable(mContext, R.drawable.item_decoration_divider);
    }

    @Override
    public void setContentView(@LayoutRes int layoutResID) {
        super.setContentView(layoutResID);
        initComponents();
        intiHeaderComps();
        setListener();
        prepareViews();
    }

    abstract public void initComponents();

    abstract public void setListener();

    abstract public void prepareViews();

    private void intiHeaderComps() {
        clHeaderContainer = findViewById(R.id.clHeaderContainer);
        ivHeaderBg = findViewById(R.id.ivHeaderBg);
        ivBack = findViewById(R.id.ivBack);
        ivNotification = findViewById(R.id.ivNotification);
        tvAppTitle = findViewById(R.id.tvAppTitle);
        mivHeaderBgColor = R.drawable.main_bg_gray;
        mHeaderTittleColor = R.color.colorWhite;
    }

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
