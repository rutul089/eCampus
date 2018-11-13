package rutul.com.ecampus;

import android.os.Bundle;
import android.os.SystemClock;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import rutul.com.ecampus.activity.BaseActivity;
import rutul.com.ecampus.adapter.DashBoardIconAdapter;
import rutul.com.ecampus.adapter.VPDashBoardAdapter;
import rutul.com.ecampus.components.CustomViewPager;
import rutul.com.ecampus.model.DashBoardIconModel;
import rutul.com.ecampus.model.SliderData;
import rutul.com.ecampus.utils.Constants;
import rutul.com.ecampus.utils.HelperMethods;

public class MainActivity extends BaseActivity implements VPDashBoardAdapter.SliderDataCallBack, DashBoardIconAdapter.ItemClickListner {
    public int DELAY_FOR_TIMER = 4000;
    long mLastClickTime = 0;
    VPDashBoardAdapter vpDashBoardAdapter;
    ArrayList<SliderData> sliderDataArrayList = new ArrayList<>();
    Timer timer = new Timer();
    private CustomViewPager vp_dashboard;
    private LinearLayout ll_slide_dot;
    private RelativeLayout rl_main;
    private RecyclerView rv_dash_board;
    private GridLayoutManager lLayout;

    //--
    private int dot_count;
    private ImageView[] dots;
    private float width, height;
    private int currentPageItem = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public void initComponents() {
        vp_dashboard = findViewById(R.id.vp_dashboard);
        ll_slide_dot = findViewById(R.id.ll_slide_dot);
        rl_main = findViewById(R.id.rl_main);
        rv_dash_board = findViewById(R.id.rv_dash_board);

    }

    @Override
    public void setListener() {
        //View pager listener
        vp_dashboard.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                for (int i = 0; i < dot_count; i++) {
                    dots[i].setImageDrawable(ContextCompat.getDrawable(getApplicationContext(), R.drawable.non_active_dot));
                }
                dots[position].setImageDrawable(ContextCompat.getDrawable(getApplicationContext(), R.drawable.active_dot));

            }


            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    @Override
    public void prepareViews() {
        setHeaderView(0, false, Constants.TAG_DASH_BOARD, R.color.colorWhite, false);

        vpDashBoardAdapter = new VPDashBoardAdapter(this, Constants.TAG_DASH_BOARD, getSliderDataArrayList(), MainActivity.this);
        vp_dashboard.setAdapter(vpDashBoardAdapter);

        //--Start Scrolling
        timer.schedule(new MyTimeTask(), DELAY_FOR_TIMER, DELAY_FOR_TIMER);  // timer , delay , period
        //Dot count
        dot_count = vpDashBoardAdapter.getCount();
        dots = new ImageView[dot_count];

        for (int i = 0; i < dot_count; i++) {

            dots[i] = new ImageView(this);
            dots[i].setImageDrawable(ContextCompat.getDrawable(getApplicationContext(), R.drawable.non_active_dot));

            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);

            params.setMargins(8, 0, 8, 0);

            ll_slide_dot.addView(dots[i], params);

        }

        dots[0].setImageDrawable(ContextCompat.getDrawable(getApplicationContext(), R.drawable.active_dot));

        rl_main.post(new Runnable() {

            @Override
            public void run() {

                height = rl_main.getMeasuredHeight() / 3;
                width = rl_main.getMeasuredWidth() / 3;


                List<DashBoardIconModel> rowListItem = getAllItemList();
                lLayout = new GridLayoutManager(MainActivity.this, 3);

                rv_dash_board.setHasFixedSize(true);
                rv_dash_board.setLayoutManager(lLayout);


                DashBoardIconAdapter rcAdapter = new DashBoardIconAdapter(rowListItem, mContext, width, height, MainActivity.this);

                rv_dash_board.setAdapter(rcAdapter);

            }
        });
    }

    private ArrayList<SliderData> getSliderDataArrayList() {
        sliderDataArrayList = new ArrayList<>();
        sliderDataArrayList.add(new SliderData(0, R.drawable.bg1, "", "Corporate", "Gateway NiNtec's New Office in The Netherlands", "20 April 2018", "HR"));
        sliderDataArrayList.add(new SliderData(1, R.drawable.bg2, "", "General", "Introducing AutoDap:\nData Accuracy Platform", "11 June 2018", "Admin"));
        sliderDataArrayList.add(new SliderData(3, R.drawable.banner2, "", "General", "While there's life , there is hople", "11 June 2018", "Admin"));
        sliderDataArrayList.add(new SliderData(4, R.drawable.bg1, "", "General", "All things are difficult before they are easy", "11 June 2018", "Admin"));
        return sliderDataArrayList;
    }

    @Override
    public void onSliderImageClicked(SliderData sliderDataModel) {
    }


    private List<DashBoardIconModel> getAllItemList() {
        List<DashBoardIconModel> allItems = new ArrayList<DashBoardIconModel>();
        allItems.add(new DashBoardIconModel(Constants.SCREEN.MYPROFILE, "My Profile", R.drawable.ic_profile));
        allItems.add(new DashBoardIconModel(Constants.SCREEN.JOBFORYOU, "Job For You", R.drawable.ic_jobs));
        allItems.add(new DashBoardIconModel(Constants.SCREEN.APPOITMENT, "Appoitment", R.drawable.ic_appoitment));
        allItems.add(new DashBoardIconModel(Constants.SCREEN.ABOUTCOLLAGE, "About Us", R.drawable.ic_contact));
        allItems.add(new DashBoardIconModel(Constants.SCREEN.EVENTSANDNEWS, "Event and News", R.drawable.ic_event));
        allItems.add(new DashBoardIconModel(Constants.SCREEN.DOYOUKNOW, "Do You Know ", R.drawable.ic_guide_line));
        allItems.add(new DashBoardIconModel(Constants.SCREEN.NOTIFICATION, "Notification", R.drawable.ic_notification_big));
        allItems.add(new DashBoardIconModel(Constants.SCREEN.TERMSOFUSER, "Terms and Condition", R.drawable.ic_terms_condition));
        allItems.add(new DashBoardIconModel(Constants.SCREEN.SETTINGS, "Settings", R.drawable.ic_settings));


        return allItems;
    }

    @Override
    public void actionRequest(Constants.SCREEN SCREEN, int position) {
        if (SystemClock.elapsedRealtime() - mLastClickTime < 1000) {
            return;
        }

        mLastClickTime = SystemClock.elapsedRealtime();
        switch (SCREEN) {
            case MYPROFILE:
                HelperMethods.showToast("MYPROFILE", mContext);
                break;
            case JOBFORYOU:
                HelperMethods.showToast("JOBFORYOU", mContext);
                break;
            case APPOITMENT:
                HelperMethods.showToast("APPOITMENT", mContext);
                break;
            case ABOUTCOLLAGE:
                HelperMethods.showToast("ABOUTCOLLAGE", mContext);
                break;
            case EVENTSANDNEWS:
                HelperMethods.showToast("EVENTSANDNEWS", mContext);
                break;
            case DOYOUKNOW:
                HelperMethods.showToast("DOYOUKNOW", mContext);
                break;
            case NOTIFICATION:
                HelperMethods.showToast("NOTIFICATION", mContext);
                break;
            case TERMSOFUSER:
                HelperMethods.showToast("TERMSOFUSER", mContext);
                break;
            case SETTINGS:
                HelperMethods.showToast("SETTINGS", mContext);
                break;
            default:
                break;
        }
    }

    /**
     * Timer for ViewPager auto slide
     **/
    public class MyTimeTask extends TimerTask {
        @Override
        public void run() {
            currentPageItem++;
            if (currentPageItem >= vpDashBoardAdapter.getCount()) {
                currentPageItem = 0;
            }

            MainActivity.this.runOnUiThread(new Runnable() {
                @Override
                public void run() {

                    vp_dashboard.setCurrentItem(currentPageItem, true);
                }
            });
        }
    }
}
