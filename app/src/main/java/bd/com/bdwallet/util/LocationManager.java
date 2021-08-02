package bd.com.bdwallet.util;


import android.text.TextUtils;
import android.util.Log;

import com.amap.api.location.AMapLocation;
import com.amap.api.location.AMapLocationClient;
import com.amap.api.location.AMapLocationClientOption;
import com.amap.api.location.AMapLocationListener;

import bd.com.bdwallet.app.BdApplication;

public class LocationManager implements ILocation{

    private LocationManager(){}
    private static class SigleTon{
        private static LocationManager location=new LocationManager();
    }

    public static LocationManager getLocation(){
        return SigleTon.location;
    }    

    //
    private AMapLocationClient locationClient = null;
    private String currentCity="";
    private AMapLocationClientOption locationOption = new AMapLocationClientOption();
    @Override
    public void init() {
        //
        initLocation();
    }

    @Override
    public void start() {
        startLocation();
    }

    @Override
    public void stop() {
        stopLocation();
    }
}
