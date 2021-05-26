package bd.com.appupdate.util;

import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;

import java.io.File;
import java.io.FileInputStream;
import java.math.BigInteger;
import java.security.MessageDigest;

import bd.com.appupdate.R;
import bd.com.appupdate.customview.AppUpdateDialog;
import bd.com.appupdate.customview.ConfirmDialog;
import bd.com.appupdate.feature.Callback;


public class UpdateAppUtils {

    private OnCancelClicked onCancelClicked;
    private final String TAG = "UpdateAppUtils";
    public static final int CHECK_BY_VERSION_NAME = 1001;
    public static final int CHECK_BY_VERSION_CODE = 1002;
    public static final int DOWNLOAD_BY_APP = 1003;
    public static final int DOWNLOAD_BY_BROWSER = 1004;

    private Activity activity;
    private int checkBy = CHECK_BY_VERSION_CODE;
    private int downloadBy = DOWNLOAD_BY_APP;
    // private int serverVersionCode = 0;
    private String apkPath = "";
    private String serverVersionName = "";
    private boolean isForce = false; //
    private int localVersionCode = 0;
    private String localVersionName = "";
    public static boolean needFitAndroidN = true; // 7.0 false
    public static boolean showNotification = true;
    private String updateInfo = "";
    public static String apkDigest;

    public UpdateAppUtils needFitAndroidN(boolean needFitAndroidN) {
        UpdateAppUtils.needFitAndroidN = needFitAndroidN;
        return this;
    }    

    public UpdateAppUtils setOnCancelClicked(OnCancelClicked onCancelClicked) {
        this.onCancelClicked = onCancelClicked;
        return this;
    }

    private UpdateAppUtils(Activity activity) {
        this.activity = activity;
        getAPPLocalVersion(activity);
    }

    public static UpdateAppUtils from(Activity activity) {
        return new UpdateAppUtils(activity);
    }

    public UpdateAppUtils checkBy(int checkBy) {
        this.checkBy = checkBy;
        return this;
    }

    public UpdateAppUtils apkPath(String apkPath) {
        this.apkPath = apkPath;
        return this;
    }

    public UpdateAppUtils apkDigest(String apkDigest) {
        this.apkDigest = apkDigest;
        return this;
    }

    public UpdateAppUtils downloadBy(int downloadBy) {
        this.downloadBy = downloadBy;
        return this;
    }

    public UpdateAppUtils showNotification(boolean showNotification) {
        this.showNotification = showNotification;
        return this;
    }

    public UpdateAppUtils updateInfo(String updateInfo) {
        this.updateInfo = updateInfo;
        return this;
    }

    public UpdateAppUtils serverVersionName(String serverVersionName) {
        this.serverVersionName = serverVersionName;
        return this;
    }

    public UpdateAppUtils isForce(boolean isForce) {
        this.isForce = isForce;
        showNotification = !isForce;
        return this;
    }

    //apk currentVersionCode
    private void getAPPLocalVersion(Context ctx) {
        PackageManager manager = ctx.getPackageManager();
        try {
            PackageInfo info = manager.getPackageInfo(ctx.getPackageName(), 0);
            localVersionName = info.versionName; // 
            localVersionCode = info.versionCode; // 
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
    }
}
