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

    /**
     * 0:2012-07-07 20:20:20 --> 2012-07-07 00:00:00
     */
    public static Date getBegin(Date date) {
        return strToTime(dateToStr(date) + " 00:00:00");
    }

    public static void main(String[] args) {
        System.err.println(friendlyFormat("2013-09-16 11:27:19"));
    }

    public static final long DAY = 86400000;


    public static String getHMTime(String date) {
        try {
            String str = date.toString().trim();
            return str.substring(11, 16);
        } catch (Exception e) {
            return date;
        }
    }

    public static boolean isRightDate(String dataStr) {
        try {
            Date nowdate = new Date();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd", Locale.CHINA);
            Date d = sdf.parse(dataStr);

            boolean flag = d.before(nowdate);
            return flag;
        } catch (Exception e) {
            return false;
        }

    }

    public static boolean isRightDate3(String dataStr) {
        if (TextUtils.isEmpty(dataStr)) return false;

        if (dataStr.length() < 12) {
            dataStr = dataStr + " 23:59:59";
        }
        try {
            Date nowdate = new Date();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.CHINA);
            Date d = sdf.parse(dataStr);

            boolean flag = d.before(nowdate);
            return flag;
        } catch (Exception e) {
            return false;
        }

    }

    public static boolean isRightDate2(String dataStr) {
        try {
            Date nowdate = new Date();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM", Locale.CHINA);
            Date d = sdf.parse(dataStr);

            boolean flag = d.before(nowdate);
            return flag;
        } catch (Exception e) {
            return false;
        }

    }

    /**
     * 
     *
     * @param seconds 
     * @param format
     * @return
     */
    public static String timeStamp2Date(String seconds, String format) {
        if (seconds == null || seconds.isEmpty() || seconds.equals("null")) {
            return "";
        }
        if (format == null || format.isEmpty()) {
            format = "yyyy-MM-dd HH:mm:ss";
        }
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        return sdf.format(new Date(Long.valueOf(seconds + "000")));
    }

    /**
     * 
     *
     * @param seconds 
     * @return
     */
    public static String timeStampDate(long seconds) {
        String format = "yyyy-MM-dd";
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        return sdf.format(new Date(Long.valueOf(seconds)));
    }

    /**
     * 
     *
     * @param date_str   
     * @param format ：yyyy-MM-dd HH:mm:ss
     * @return
     */
    public static String date2TimeStamp(String date_str, String format) {
        try {
            SimpleDateFormat sdf = new SimpleDateFormat(format);
            return String.valueOf(sdf.parse(date_str).getTime() / 1000);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }

    /**
     * （）
     *
     * @return
     */
    public static String timeStamp() {
        long time = System.currentTimeMillis();
        String t = String.valueOf(time / 1000);
        return t;
    }
}
