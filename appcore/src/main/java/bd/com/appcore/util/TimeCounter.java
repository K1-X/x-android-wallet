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


    // 
	// FIXME: ，activity，，,
	// Activity，quit()
	public void startTick() {
		long current = System.currentTimeMillis();
		if (!isRunning()) {
			startTime = current;
		}
		mHandler.removeCallbacksAndMessages(null);
		mHandler.post(new Runnable() {
			@Override
			public void run() {
				// TODO Auto-generated method stub
				long current = System.currentTimeMillis();
				int count = getLeftTime(current);
				Log.d(TAG, "handleMessage " + count + ", current=" + current + ", startTime=" + startTime);
				if (count >= 0 && count <= mMaxSec) {
					mHandler.postDelayed(this, 1000);
					if (mListener != null) {
						mListener.onTicked(count);
					}
				}
			}
		});
	}
	
	// tick，
	public void quit(){
		mHandler.removeCallbacksAndMessages(null);
	}

	public interface TimeCountListener {
		void onTicked(int count);
	}


	public static void timerBack(final TextView textView, long totalTime, long intervalTime) {
		CountDownTimer timer = new CountDownTimer(totalTime, intervalTime) {

			@Override
			public void onTick(long millisUntilFinished) {
				textView.setEnabled(false);
				textView.setText(millisUntilFinished / 1000 + "s");
			}

			@Override
			public void onFinish() {
				textView.setEnabled(true);
				textView.setText("");

			}
		};
		timer.start();
	}
}


