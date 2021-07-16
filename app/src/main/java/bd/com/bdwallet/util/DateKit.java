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

    public static String dateToStr3(String date) {
        if (TextUtils.isEmpty(date)) {
            return "";
        }
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            if (date != null) {
                Date dd = sdf.parse(date);

                return sdf.format(dd);
            }
        } catch (ParseException e) {

            e.printStackTrace();

        }
        return null;
    }

    /**
     * :yyyy-MM-dd HH:mm:ss
     */
    public static String timeToStr(Date date) {
        if (date != null)
            return timeFormat.get().format(date);
        return null;
    }

    /**
     * :yyyy-MM-dd
     */
    public static Date strToDate(String str) {
        Date date = null;
        try {
            date = dateFormat.get().parse(str);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return date;
    }

    /**
     * :yyyy-MM-dd HH:mm:ss
     */
    public static Date strToTime(String str) {
        Date date = null;
        try {
            date = timeFormat.get().parse(str);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return date;
    }

    public static String transformDate(String str) {
        Date date = strToDate(str);
        if (date == null)
            return ":)";
        String time = new SimpleDateFormat("MMdd").format(date);
        return time;
    }

    /**
     * :
     * ：；
     * <p>
     * ：f ；
     * <p>
     * ：h ；
     * <p>
     * ：d ；
     * <p>
     * ：12-27 22:33；
     * <p>
     * ：2014-12-03 22:33；
     */
    public static String friendlyFormat(String str) {
        Date date = strToTime(str);
        if (date == null)
            return ":)";
        Calendar now = getCal();
        String time = new SimpleDateFormat("HH:mm").format(date);

        // ，
        String curDate = dateFormat.get().format(now.getTime());//
        String paramDate = dateFormat.get().format(date);//
        if (curDate.equals(paramDate)) {//
            int hour = (int) ((now.getTimeInMillis() - date.getTime()) / 3600000);
            if (hour > 0)
                return hour + "";
            int minute = (int) ((now.getTimeInMillis() - date.getTime()) / 60000);
            if (minute < 1)
                return "";
            return minute + "";
        }

        // ，
        int days = (int) ((getBegin(getDate()).getTime() - getBegin(date).getTime()) / 86400000);
        int hour = (int) ((now.getTimeInMillis() - date.getTime()) / 3600000);
        if (hour > 0 && hour < 24)
            return hour + "";
        if (days < 30 && days > 0)
            return days + "";
        if (days >= 30 && days < 365)
            return dateToStr(date).substring(5);
        return dateToStr(date);
    }
}
