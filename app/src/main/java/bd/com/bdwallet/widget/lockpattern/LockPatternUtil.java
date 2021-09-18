package bd.com.bdwallet.widget.lockpattern;

import android.content.Context;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.List;


public class LockPatternUtil {

    @Deprecated
    public static int changeSize(Context context, String value) {
        if (value.contains("dip")) {
            float dip = Float.valueOf(value.substring(0, value.indexOf("dip")));
            return LockPatternUtil.dip2px(context, dip);
        } else if (value.contains("px")) {
            float px = Float.valueOf(value.substring(0, value.indexOf("px")));
            return (int) px;
        } else if (value.contains("@")) {
            float px = context.getResources().getDimension(Integer.valueOf(value.replace("@", "")));
            return (int) px;
        } else {
            throw new IllegalArgumentException("can not use wrap_content " +
                "or match_parent or fill_parent or others' illegal parameter");
        }
    }
    

    /**
     * dip to px
     *
     * @param context
     * @param dpValue
     * @return
     */
    public static int dip2px(Context context, float dpValue) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (dpValue * scale + 0.5f);
    }

    /**
     * check the touch cell is or not in the circle
     *
     * @param sx
     * @param sy
     * @param r      the radius of circle
     * @param x      the x position of circle's center point
     * @param y      the y position of circle's center point
     * @param offset the offset to the frame of the circle
     *               (if offset > 0 : the offset is inside the circle; if offset < 0 : the offset is outside the circle)
     * @return
     */
    public static boolean checkInRound(float sx, float sy, float r, float x, float y, float offset) {
        return Math.sqrt((sx - x + offset) * (sx - x + offset) + (sy - y + offset) * (sy - y + offset)) < r;
    }
}
