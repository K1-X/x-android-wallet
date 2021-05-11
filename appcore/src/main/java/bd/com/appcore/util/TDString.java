package bd.com.appcore.util;


import bd.com.appcore.CoreApp;

/**
 * ，Application
 */
public class TDString {

    public static String getStr(int resId) {
        return CoreApp.getAppInstance().getResources().getString(resId);
    }

}
