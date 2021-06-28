package bd.com.bdwallet.event;


import android.util.Log;

import de.greenrobot.event.EventBus;

/**
 * EventBus，POSTING（）、MAIN、BACKGROUNDASYNC。
 * 
 * POSTING：POSTING，
 * ，，。
 * PostThread，，ANR。
 * 
 * MAIN：MAIN
 * ，UI。UI，。
 * 
 * BACKGROUND：BACKGROUND，
 * ，,
 * UI，，。。
 * UI。
 * 
 * ASYNC：ASYNC，
 * ，。，UI。
 * 
 * 
	@Subscribe(threadMode = ThreadMode.POSTING)
	public void onMessageEventPostThread(MessageEvent messageEvent) {
	}
	
	@Subscribe(threadMode = ThreadMode.MAIN)
	public void onMessageEventMainThread(MessageEvent messageEvent) {
	}
	
	@Subscribe(threadMode = ThreadMode.BACKGROUND)
	public void onMessageEventBackgroundThread(MessageEvent messageEvent) {
	}
	
	@Subscribe(threadMode = ThreadMode.ASYNC)
	public void onMessageEventAsync(MessageEvent messageEvent) {
	}
 */
public final class BusProvider {


    private static final String TAG = "BusProvider";

	private static EventBus getInstance() {
		return BusProviderHolder.BUS;
	}
}
