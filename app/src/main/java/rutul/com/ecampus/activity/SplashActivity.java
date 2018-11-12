package rutul.com.ecampus.activity;

import android.os.Bundle;
import android.os.Handler;
import android.view.Window;
import android.view.WindowManager;

import rutul.com.ecampus.MainActivity;
import rutul.com.ecampus.R;
import rutul.com.ecampus.utils.ApplicationSharedPreferences;
import rutul.com.ecampus.utils.Constants;
import rutul.com.ecampus.utils.runtimepermissionhelper.PermissionResult;
import rutul.com.ecampus.utils.runtimepermissionhelper.PermissionUtils;

public class SplashActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_splash);
    }

    @Override
    public void initComponents() {

    }

    @Override
    public void setListener() {

    }

    @Override
    public void prepareViews() {
        new Handler().postDelayed(() -> {
            // This method will be executed once the timer is over
            if (ApplicationSharedPreferences.getBooleanValue(Constants.APPLICATION_OPENED_ONCE, false, mContext)) {
                proceedToTheNextActivity();
            } else {
                askMultiplePermission();
            }
        }, 2500);
    }

    private void askMultiplePermission() {
        ApplicationSharedPreferences.set(Constants.APPLICATION_OPENED_ONCE, true, mContext);
        final String permissionAsk[] = {PermissionUtils.MANIFEST_CAMERA, PermissionUtils.MANIFEST_READ_EXTERNAL_STORAGE, PermissionUtils.MANIFEST_CALL_PHONE,
                PermissionUtils.MANIFEST_ACCESS_FINE_LOCATION, PermissionUtils.MANIFEST_RECORD_AUDIO, PermissionUtils.MANIFEST_READ_PHONE_STATE};
        askCompactPermissions(permissionAsk, new PermissionResult() {
            @Override
            public void permissionGranted() {
                proceedToTheNextActivity();
            }

            @Override
            public void permissionDenied() {
                proceedToTheNextActivity();
            }

            @Override
            public void permissionForeverDenied() {
                proceedToTheNextActivity();
            }
        });
    }

    private void proceedToTheNextActivity() {
        if (isUserLoggedIn()) {
            startDesireIntent(MainActivity.class, mContext, false, 0, null);
            finish();
        } else {
            startDesireIntent(LoginActivity.class, mContext, false, 0, null);
            finish();
        }
    }

}
