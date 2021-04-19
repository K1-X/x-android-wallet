package bd.com.appcore;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.view.Window;
import android.view.WindowManager;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 。，。
 */
public class ActivityManager {

	private Stack<Activity> managedActivityList;
    private Activity currActivity;

    private List<ForeGroundObserver> foreGroundObserverList = new ArrayList<ForeGroundObserver>();
    private boolean isForeGround = false;

    private static ActivityManager instance = new ActivityManager();
    
	private ActivityManager() {
        managedActivityList = new Stack<Activity>();
    }

    public static ActivityManager getInstance() {
        return instance;
    }
}
