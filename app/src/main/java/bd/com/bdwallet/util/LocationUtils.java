/**
 * 
 */
package bd.com.bdwallet.util;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.text.TextUtils;

import com.amap.api.location.AMapLocation;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;
import java.util.Locale;

public class LocationUtils {
    /**
	 *  
	 */
	public final static int MSG_LOCATION_START = 0;
	/**
	 * 
	 */
	public final static int MSG_LOCATION_FINISH = 1;
	/**
	 * 
	 */
	public final static int MSG_LOCATION_STOP= 2;
	
	public final static String KEY_URL = "URL";
	public final static String URL_H5LOCATION = "file:///android_asset/location.html";	
}
