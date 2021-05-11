package bd.com.appcore.util;

import android.os.CountDownTimer;
import android.os.Handler;
import android.util.Log;
import android.widget.TextView;

import java.util.HashMap;
import java.util.Map;

/**
 *  , getTimeCounter(tag)，tag
 *
 */
public class TimeCounter {
	
    private static final Map<String, TimeCounter> sCouters = new HashMap<String, TimeCounter>();

	protected static final String TAG = "Counter";
	private long startTime;
	private int mMaxSec;
	private TimeCountListener mListener;

    // tag TimeCounter，tagTimeCounter
	public static TimeCounter getTimeCounter(String tag) {
		TimeCounter tc = sCouters.get(tag);
		if (tc == null) {
			tc = new TimeCounter();
			sCouters.put(tag, tc);
		}
		return tc;
	}

    private TimeCounter() {
	}

	public boolean isRunning() {
		int left = getLeftTime(System.currentTimeMillis());
		return left >= 0 && left <= mMaxSec;
	}


  private int getLeftTime(long current) {
		int count = mMaxSec - (int) ((current - startTime) / 1000.0F);
		return count;
	}

    /**
	 * 
	 * @param maxSec 
	 * @param listener 
	 */
	public void setup(int maxSec, TimeCountListener listener) {
		mMaxSec = maxSec;
		mListener = listener;
	}

}


