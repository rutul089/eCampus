package rutul.com.ecampus;

import android.app.Application;
import android.content.Context;
import android.content.res.Configuration;

import rutul.com.ecampus.webservice.ApiInterface;

public class MainApplication extends Application {
    private static final MainApplication ourInstance = new MainApplication();
    ApiInterface apiInterface;

    public static MainApplication getInstance() {
        return ourInstance;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        //   apiInterface = BaseApiClient.createService(ApiInterface.class);
    }

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
    }


    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
    }

    @Override
    public void onLowMemory() {
        super.onLowMemory();
    }

    public ApiInterface getApiInterface() {
        return apiInterface;
    }

    public void setApiInterface(ApiInterface apiInterface) {
        this.apiInterface = apiInterface;
    }
}
