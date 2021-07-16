package bd.com.bdwallet.util;

import android.text.TextUtils;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;


public class DateKit {


    /**
     * 
     */
    private final static ThreadLocal<SimpleDateFormat> dateFormat = new ThreadLocal<SimpleDateFormat>() {
        protected SimpleDateFormat initialValue() {
            return new SimpleDateFormat("yyyy-MM-dd");
        }
    };

    /**
     * 
     */
    private final static ThreadLocal<SimpleDateFormat> timeFormat = new ThreadLocal<SimpleDateFormat>() {
        protected SimpleDateFormat initialValue() {
            return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        }
    };

    /**
     * 
     */
    private final static ThreadLocal<SimpleDateFormat> timeMinFormat = new ThreadLocal<SimpleDateFormat>() {
        protected SimpleDateFormat initialValue() {
            return new SimpleDateFormat("yyyy-MM-dd HH:mm");
        }
    };

    /**
     * :Date
     */
    public static Date getDate() {
        return new Date();
    }

    /**
     * :Calendar
     */
    public static Calendar getCal() {
        return Calendar.getInstance();
    }    

    /**
     * :yyyy-MM-dd
     */
    public static String dateToStr(Date date) {
        if (date != null)
            return dateFormat.get().format(date);
        return null;
    }


    /**
     * :yyyy-MM-dd
     */
    public static String dateToStr(String date) {
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
            if (date != null) {
                Date dd = sdf.parse(date);
                return dateFormat.get().format(dd);
            }
        } catch (ParseException e) {

            e.printStackTrace();

        }
        return "";
    }

    /**
     * :yyyyMMdd
     */
    public static String dateToStr2(String date) {
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            if (date != null) {
                Date dd = sdf.parse(date);
                SimpleDateFormat sdf2 = new SimpleDateFormat("yyyyMd");
                return sdf2.format(dd);
            }
        } catch (ParseException e) {

            e.printStackTrace();

        }
        return null;
    }
}
