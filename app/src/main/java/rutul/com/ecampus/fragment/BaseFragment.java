package rutul.com.ecampus.fragment;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.constraint.ConstraintLayout;
import android.view.View;
import android.widget.ImageView;

import rutul.com.ecampus.MainApplication;
import rutul.com.ecampus.R;
import rutul.com.ecampus.activity.BaseActivity;
import rutul.com.ecampus.components.CustomTextView;
import rutul.com.ecampus.utils.ApplicationSharedPreferences;
import rutul.com.ecampus.utils.runtimepermissionhelper.FragmentManagePermission;

public abstract class BaseFragment extends FragmentManagePermission {
    public Context mContext;
    public BaseActivity mActivity;
    public Bundle mBundle = new Bundle();
    private ConstraintLayout clHeaderContainer;
    private ImageView ivHeaderBg, ivBack, ivNotification;
    private CustomTextView tvAppTitle;
    private int mivHeaderBgColor, mHeaderTittleColor;


    public void setHeaderView(@Nullable int ivHeaderBgColor, @Nullable boolean showBackIcon, @Nullable boolean showHeaderTitle,
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
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mContext = getActivity();
        mActivity = (BaseActivity) getActivity();
        mBundle = getArguments();
        if (mBundle == null) {
            mBundle = new Bundle();
        }
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initComponents(view);

        intiHeaderComps(view);
        setListener();
        prepareViews();
    }

    private void intiHeaderComps(View v) {
        clHeaderContainer = v.findViewById(R.id.clHeaderContainer);
        ivHeaderBg = v.findViewById(R.id.ivHeaderBg);
        ivBack = v.findViewById(R.id.ivBack);
        ivNotification = v.findViewById(R.id.ivNotification);
        tvAppTitle = v.findViewById(R.id.tvAppTitle);
        mivHeaderBgColor = R.drawable.main_bg_gray;
        mHeaderTittleColor = R.color.colorWhite;
    }

    abstract public void initComponents(View v);

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
//        new FragmentUtil().addFragment(activity,
//                R.id.main_container,
//                fragment,
//                fragmentTag,
//                animationType, null);
//    }
//
//    public String getCurrentFragmentTag() {
//        FragmentUtil fragmentUtil = new FragmentUtil();
//        return fragmentUtil.getCurrentFragment(mActivity).getTag();
//    }
//
//    public Fragment getCurrentFragment() {
//        FragmentUtil fragmentUtil = new FragmentUtil();
//        return fragmentUtil.getCurrentFragment(mActivity);
//    }
//
//    public void removeFragment(FragmentActivity activity, FragmentUtil.ANIMATION_TYPE animationType) {
//        new FragmentUtil().removeFragment(activity,
//                R.id.main_container,
//                this,
//                animationType);
//    }

    public boolean isUserLoggedIn() {
        return ApplicationSharedPreferences.getBooleanValue(getResources().getString(R.string.PREFS_LOGGED_IN), false, mContext);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (getActivity().equals(MainApplication.getInstance())) {

            // This makes sure that the container activity has implemented
            // the callback interface. If not, it throws an exception

        }
    }

}
