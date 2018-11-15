package rutul.com.ecampus.activity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;

import rutul.com.ecampus.R;
import rutul.com.ecampus.components.CustomEditText;
import rutul.com.ecampus.components.labelui.AutoLabelUI;
import rutul.com.ecampus.components.labelui.AutoLabelUISettings;
import rutul.com.ecampus.utils.Constants;
import rutul.com.ecampus.utils.HelperMethods;

public class MyProfile extends BaseActivity implements View.OnClickListener {
    private static final String TAG = MyProfile.class.getSimpleName();
    private AutoLabelUI label_view;
    private ImageView ivBack;
    private ImageButton ib_add_label;
    private CustomEditText et_key_skills;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
//            getWindow().setStatusBarColor(getResources().getColor(R.color.colorStatus));
//        }
        setContentView(R.layout.activity_my_profile);
    }

    @Override
    public void initComponents() {
        ivBack = findViewById(R.id.ivBack);
        label_view = findViewById(R.id.label_view);
        ib_add_label = findViewById(R.id.ib_add_label);
        et_key_skills = findViewById(R.id.et_key_skills);
    }

    @Override
    public void setListener() {
        ivBack.setOnClickListener(this);
        ib_add_label.setOnClickListener(this);
        label_view.setOnLabelsCompletedListener(() -> HelperMethods.showToast("You cant add more then 5 email", mContext));
    }

    @Override
    public void prepareViews() {
        setHeaderView(R.drawable.main_bg_blue, true, Constants.TAG_MY_PROFILE, R.color.colorWhite, false);
        setAutoLabelUISettings();
    }

    private void setAutoLabelUISettings() {
        AutoLabelUISettings autoLabelUISettings =
                new AutoLabelUISettings.Builder()
                        .withBackgroundResource(R.color.default_background_label)
                        .withIconCross(R.drawable.cross)
                        .withMaxLabels(6)
                        .withShowCross(true)
                        .withLabelsClickables(true)
                        .withTextColor(Color.WHITE)
                        .withTextSize(R.dimen.dimen_54px)
                        .withLabelPadding(30)
                        .build();

        label_view.setSettings(autoLabelUISettings);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.ivBack:
                finish();
                break;
            case R.id.ib_add_label:
                addKeySkills();
                break;
        }
    }

    private void addKeySkills() {
        String keySkills = et_key_skills.getText().toString();
        if (HelperMethods.checkForValidString(keySkills)) {
            boolean success = label_view.addLabel(keySkills);
            if (success) {
                et_key_skills.setText(null);
            }
        }
    }
}
