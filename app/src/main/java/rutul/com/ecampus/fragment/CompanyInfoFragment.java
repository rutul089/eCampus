package rutul.com.ecampus.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import rutul.com.ecampus.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class CompanyInfoFragment extends BaseFragment {


    public CompanyInfoFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_company_info, container, false);
    }

    @Override
    public void initComponents(View v) {

    }

    @Override
    public void setListener() {

    }

    @Override
    public void prepareViews() {

    }
}
