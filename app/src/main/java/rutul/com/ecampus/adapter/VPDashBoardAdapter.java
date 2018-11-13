package rutul.com.ecampus.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import rutul.com.ecampus.R;
import rutul.com.ecampus.model.SliderData;

public class VPDashBoardAdapter extends PagerAdapter {
    private Context mContext;

    private LayoutInflater layoutInflater;
    private String viewName;
    private ArrayList<SliderData> sliderDataArrayList;
    private SliderDataCallBack callBack = null;
    private int count = 0;


    public VPDashBoardAdapter(Context mContext, String viewName, ArrayList<SliderData> sliderDataArrayList, SliderDataCallBack callBack) {
        this.mContext = mContext;
        this.viewName = viewName;
        this.sliderDataArrayList = sliderDataArrayList;
        this.callBack = callBack;
    }

    @Override
    public int getCount() {
        count = sliderDataArrayList.size();
        if (count < 5)
            return sliderDataArrayList.size();
        else
            return 5;
    }

    @Override
    public Object instantiateItem(ViewGroup container, final int position) {

        layoutInflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = layoutInflater.inflate(R.layout.row_event_news, null);


        TextView tv_date,
                tv_description;

        ImageView iv_slider_img;


        iv_slider_img = view.findViewById(R.id.iv_slider_img);
        tv_date = view.findViewById(R.id.tv_date);
        tv_description = view.findViewById(R.id.tv_description);

        SliderData newsModel = sliderDataArrayList.get(position);
        tv_date.setText(newsModel.getSliderDate());
        tv_description.setText(newsModel.getSliderDescription());
        iv_slider_img.setImageResource(newsModel.getSliderImg());

        ViewPager vp = (ViewPager) container;
        vp.addView(view, 0);

        iv_slider_img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                callBack.onSliderImageClicked(sliderDataArrayList.get(position));
            }
        });

        return view;

    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {

        ViewPager vp = (ViewPager) container;
        View view = (View) object;
        vp.removeView(view);

    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == object;
    }


    public interface SliderDataCallBack {

        void onSliderImageClicked(SliderData sliderDataModel);
    }
}
