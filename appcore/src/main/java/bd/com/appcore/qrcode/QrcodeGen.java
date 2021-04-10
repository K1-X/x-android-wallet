package bd.com.appcore.qrcode;

import android.graphics.Bitmap;

import cn.bingoogolapple.qrcode.zxing.QRCodeEncoder;

/**
 * Created by  on 2017/8/29.
 */

public class QrcodeGen {
    public static Bitmap genQrcodeBitmap(int dpWidth, String content){
        Bitmap bitmap= QRCodeEncoder.syncEncodeQRCode(content, dpWidth);
//        String base64Bmp= BitmapUtil.encode2Base64ByBitmap(bitmap);
        return bitmap;
    }
}
