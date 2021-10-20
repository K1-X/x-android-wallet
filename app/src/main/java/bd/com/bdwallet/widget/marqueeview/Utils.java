package bd.com.bdwallet.widget.marqueeview;

import android.app.Activity;
import android.content.Context;
import android.util.DisplayMetrics;

import java.util.List;

public class Utils {


    public static <T> boolean notEmpty(List<T> list) {
        return !isEmpty(list);
    }

    public static <T> boolean isEmpty(List<T> list) {
        if (list == null || list.size() == 0) {
            return true;
        }
        return false;
    }    

}
