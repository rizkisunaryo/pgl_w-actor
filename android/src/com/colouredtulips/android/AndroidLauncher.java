package com.colouredtulips.android;

import android.os.Bundle;

import com.badlogic.gdx.backends.android.AndroidApplication;
import com.badlogic.gdx.backends.android.AndroidApplicationConfiguration;
import com.colouredtulips.Main;
import com.colouredtulips.util.ThirdPartyUtil;
import com.google.android.gms.analytics.GoogleAnalytics;
import com.google.android.gms.analytics.HitBuilders;
import com.google.android.gms.analytics.Tracker;

public class AndroidLauncher extends AndroidApplication implements ThirdPartyUtil {
    private GoogleAnalyticsApplication googleAnalyticsApplication;
    private Tracker tracker;
    private Tracker globalTracker;
    
	@Override
	protected void onCreate (Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		AndroidApplicationConfiguration config = new AndroidApplicationConfiguration();

        googleAnalyticsApplication = (GoogleAnalyticsApplication) getApplication();
        tracker = googleAnalyticsApplication.getTracker(GoogleAnalyticsApplication.TrackerName.APP_TRACKER);
        globalTracker = googleAnalyticsApplication.getTracker(GoogleAnalyticsApplication.TrackerName.GLOBAL_TRACKER);
        
		initialize(new Main(this), config);
	}

    @Override
    public void onStart() {
        super.onStart();
        GoogleAnalytics.getInstance(this).reportActivityStart(this);
        // ...
    }

    @Override
    public void onStop() {
        super.onStop();
        // ...
        GoogleAnalytics.getInstance(this).reportActivityStop(this);
    }

    @Override
    public void sendGATrackerScreenName(String path) {
        globalTracker.setScreenName(path);
        globalTracker.send(new HitBuilders.AppViewBuilder().build());
    }
}
