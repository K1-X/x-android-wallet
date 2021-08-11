package bd.com.bdwallet.util;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;


public class ResourceUtil {
    /**
     * id
     *
     * @param context     
     * @param iconResName 
     * @return id
     */
    public static int getDrawbleResIdByName(Context context, String iconResName) {
        int resId = context.getResources().getIdentifier(iconResName, "mipmap", context.getPackageName());
        return resId;
    }

    public static void setPrimaryClip(Context context,String content) {
        //：
        ClipboardManager cm = (ClipboardManager) context.getSystemService(Context.CLIPBOARD_SERVICE);
        // ClipData
        ClipData mClipData = ClipData.newPlainText("Label", content);
        // ClipData。
        cm.setPrimaryClip(mClipData);
    }
}
