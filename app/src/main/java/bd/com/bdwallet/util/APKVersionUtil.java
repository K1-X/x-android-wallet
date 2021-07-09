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
}
