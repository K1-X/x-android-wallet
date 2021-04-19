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

	public void addForeGroundObserver(ForeGroundObserver o) {
        this.foreGroundObserverList.add(o);
    }

	public void removeForeGroundObserver(ForeGroundObserver o) {
        this.foreGroundObserverList.remove(o);
    }

    public void addManagedActivity(Activity act) {
        managedActivityList.push(act);
    }

    public void removeManagedActivity(Activity act) {
        managedActivityList.remove(act);
    }

    public void setCurrActivity(Activity act) {
        currActivity = act;
    }
    
    public void setIsForeGround(boolean isForeGround) {
        this.isForeGround = isForeGround;
        if (isForeGround) {
            // ，removeObserver，。
            List<ForeGroundObserver> tmpList = new ArrayList<ForeGroundObserver>();
            for (ForeGroundObserver o : foreGroundObserverList) {
                tmpList.add(o);
            }

            for (ForeGroundObserver o : tmpList) {
                o.notifyForeGround();
            }
        }
    }


   public boolean isForeGround() {
        return this.isForeGround;
    }

    public void setActivityAttribute(Activity act) {
        act.requestWindowFeature(Window.FEATURE_NO_TITLE); // 
        act.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN | WindowManager.LayoutParams.SOFT_INPUT_ADJUST_RESIZE);// 
        act.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT); // 
    }

    public Activity getCurrActivity() {
        return this.currActivity;
    }

    public boolean contains(Activity act) {
        return managedActivityList.contains(act);
    }
}
