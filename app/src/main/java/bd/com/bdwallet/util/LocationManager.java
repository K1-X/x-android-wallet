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

    @Override
    public void destory() {
        destroyLocation();
    }

    @Override
    public String getLastCity() {
        AMapLocation location = locationClient.getLastKnownLocation();
        if(location==null){
            return "";
        }
        String lastCity=location.getCity();
        String lastProvice=location.getProvince();
        if(TextUtils.isEmpty(lastCity)){
            lastCity="";
        }
        return lastProvice+lastCity;
    }
}
