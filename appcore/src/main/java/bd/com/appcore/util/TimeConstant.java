package bd.com.appcore.util;


import java.util.ArrayList;
import java.util.List;

import bd.com.appcore.R;


public class TimeConstant {

    /** */
    public static List<String> times = new ArrayList<>();
    public static List<GestureTime> timeObjs = new ArrayList<>();    

    public static List<String> onlineTimes = new ArrayList<>();
    public static List<GestureTime> onlineTimeObjs = new ArrayList<>();

    public static final long min_10=10*60*1000;
    public static final long min_30=30*60*1000;
    public static final long one_hour=60*60*1000;
    public static final long six_hour=6*60*60*1000;
    public static final long one_day=24*60*60*1000;
    public static final long three_day=3*24*60*60*1000;
    public static final long seven_day=7*24*60*60*1000;
    public static final long day_30=30*24*60*60*1000;
}
