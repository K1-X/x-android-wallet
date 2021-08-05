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

    /**
	 * 
	 * @param location
	 * @return
	 */
	public synchronized static String getLocationStr(AMapLocation location){
		if(null == location){
			return null;
		}
		StringBuffer sb = new StringBuffer();
		//errCode0，，
		if(location.getErrorCode() == 0){
			sb.append("" + "\n");
			sb.append(": " + location.getLocationType() + "\n");
			sb.append("        : " + location.getLongitude() + "\n");
			sb.append("        : " + location.getLatitude() + "\n");
			sb.append("        : " + location.getAccuracy() + "" + "\n");
			sb.append("    : " + location.getProvider() + "\n");
			
			sb.append("        : " + location.getSpeed() + "/" + "\n");
			sb.append("        : " + location.getBearing() + "\n");
			// 
			sb.append("        : " + location.getSatellites() + "\n");
			sb.append("        : " + location.getCountry() + "\n");
			sb.append("            : " + location.getProvince() + "\n");
			sb.append("            : " + location.getCity() + "\n");
			sb.append(" : " + location.getCityCode() + "\n");
			sb.append("            : " + location.getDistrict() + "\n");
			sb.append("    : " + location.getAdCode() + "\n");
			sb.append("        : " + location.getAddress() + "\n");
			sb.append("    : " + location.getPoiName() + "\n");
			//
			sb.append(": " + formatUTC(location.getTime(), "yyyy-MM-dd HH:mm:ss") + "\n");
		} else {
			//
			sb.append("" + "\n");
			sb.append(":" + location.getErrorCode() + "\n");
			sb.append(":" + location.getErrorInfo() + "\n");
			sb.append(":" + location.getLocationDetail() + "\n");
		}
		//
		sb.append(": " + formatUTC(System.currentTimeMillis(), "yyyy-MM-dd HH:mm:ss") + "\n");
		return sb.toString();
	}

    private static SimpleDateFormat sdf = null;
	public synchronized static String formatUTC(long l, String strPattern) {
		if (TextUtils.isEmpty(strPattern)) {
			strPattern = "yyyy-MM-dd HH:mm:ss";
		}
		if (sdf == null) {
			try {
				sdf = new SimpleDateFormat(strPattern, Locale.CHINA);
			} catch (Throwable e) {
			}
		} else {
			sdf.applyPattern(strPattern);
		}
		return sdf == null ? "NULL" : sdf.format(l);
	}
    public static String sHA1(Context context){
		try {
			PackageInfo info = context.getPackageManager().getPackageInfo(
					context.getPackageName(), PackageManager.GET_SIGNATURES);
			byte[] cert = info.signatures[0].toByteArray();
			MessageDigest md = MessageDigest.getInstance("SHA1");
			byte[] publicKey = md.digest(cert);
			StringBuffer hexString = new StringBuffer();
			for (int i = 0; i < publicKey.length; i++) {
				String appendString = Integer.toHexString(0xFF & publicKey[i])
						.toUpperCase(Locale.US);
				if (appendString.length() == 1)
					hexString.append("0");
				hexString.append(appendString);
				hexString.append(":");
			}
			String result=hexString.toString();
			return result.substring(0, result.length()-1);
		} catch (PackageManager.NameNotFoundException e) {
			e.printStackTrace();
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		return null;
	}
}
