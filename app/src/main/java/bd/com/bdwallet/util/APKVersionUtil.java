package bd.com.bdwallet.util;

import android.content.Context;
import android.content.pm.PackageManager;

import bd.com.bdwallet.Config;
import bd.com.bdwallet.app.BdApplication;


public class APKVersionUtil {

    /**
     * apk
     *
     * @param mContext
     * @return
     */
    public static int getVersionCode(Context mContext) {
        int versionCode = 0;
        try {
            //，AndroidManifest.xmlandroid:versionCode
            versionCode = mContext.getPackageManager().
                    getPackageInfo(mContext.getPackageName(), 0).versionCode;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        return versionCode;
    }    

    /**
     * 
     *
     * @param context 
     * @return
     */
    public static String getVerName(Context context) {
        String verName = "";
        try {
            verName = context.getPackageManager().
                    getPackageInfo(context.getPackageName(), 0).versionName;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        return verName;
    }

    public static String getDownLoadUrl() {
        int code = getVersionCode(BdApplication.context);
        String versionName = getVerName(BdApplication.context);
        String url = "http://116.62.160.218/" + code + "/app_versionCode_" + code + "_versionName_" + versionName + ".apk";
        return url;
    }
}
