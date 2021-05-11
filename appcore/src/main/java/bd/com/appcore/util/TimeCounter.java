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
}
