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
    
}
