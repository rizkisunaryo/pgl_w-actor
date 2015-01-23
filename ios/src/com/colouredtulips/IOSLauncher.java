package com.colouredtulips;

import com.badlogic.gdx.backends.iosrobovm.IOSApplication;
import com.badlogic.gdx.backends.iosrobovm.IOSApplicationConfiguration;

import org.robovm.apple.foundation.NSAutoreleasePool;
import org.robovm.apple.uikit.UIApplication;
import org.robovm.bindings.googleanalytics.GAI;
import org.robovm.bindings.googleanalytics.GAIDictionaryBuilder;
import org.robovm.bindings.googleanalytics.GAIFields;
import org.robovm.bindings.googleanalytics.GAITrackerImpl;

public class IOSLauncher extends IOSApplication.Delegate{
    private GAITrackerImpl tracker;

    @Override
    protected IOSApplication createApplication() {
        IOSApplicationConfiguration config = new IOSApplicationConfiguration();
        config.accelerometerUpdate=0.2f;

        GAI.getSharedInstance().setTrackUncaughtExceptions(true);
        GAI.getSharedInstance().setDispatchInterval(20);

        tracker = GAI.getSharedInstance().getTracker("UA-58774029-1");

        GAI.getSharedInstance().setDefaultTracker(tracker);

        tracker.set(GAIFields.kGAIScreenName, "MyGameName");
        tracker.send(GAIDictionaryBuilder.createAppView().build());

        return new IOSApplication(new Main(tracker), config);
    }

    public static void main(String[] argv) {
        NSAutoreleasePool pool = new NSAutoreleasePool();
        UIApplication.main(argv, null, IOSLauncher.class);
        pool.close();
    }
}