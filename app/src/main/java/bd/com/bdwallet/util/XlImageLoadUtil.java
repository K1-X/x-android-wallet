package bd.com.bdwallet.util;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions;
import com.bumptech.glide.request.target.SimpleTarget;
import com.bumptech.glide.request.transition.Transition;

import bd.com.bdwallet.app.BdApplication;

public class XlImageLoadUtil {

    private static boolean checkNull(Context context) {
        if (context == null) {
            return true;
        } else if (context instanceof Activity) {
            Activity activity = (Activity) context;
            if (Build.VERSION.SDK_INT >= 17 && activity.isDestroyed()) {
                return true;
            }
        }

        return false;
    }



    /**
     * 
     */
    public interface OnBlurImageListener {
        void onBlurReady();
    }

    /**
     * 
     *
     * @param url
     */
    public static void blurImageUrl(String url, final ImageView imageView) {
        //bitmap，
        Glide.with(BdApplication.context)
                .asBitmap()
                .load(url)
                .into(new SimpleTarget<Bitmap>(1000, 1000) {

                    @Override
                    public void onResourceReady(@NonNull Bitmap resource, @Nullable Transition<? super Bitmap> transition) {
                        blur(resource, imageView);
                    }
                });

    }    

    public static void blurImageUrl(String url, int placeHolder, final ImageView imageView) {
        //bitmap，
        Glide.with(BdApplication.context)
                .asBitmap()
                .load(url)
                .into(new SimpleTarget<Bitmap>(1000, 1000) {

                    @Override
                    public void onResourceReady(@NonNull Bitmap resource, @Nullable Transition<? super Bitmap> transition) {
                        blur(resource, imageView);
                    }
                });

    }

    /**
     * 
     *
     * @param url
     * @param imageView
     * @param onBlurImageListener
     */
    public static void blurImageUrl(String url, final ImageView imageView, final OnBlurImageListener onBlurImageListener) {
        //bitmap，
        Glide.with(BdApplication.context)
                .asBitmap()
                .load(url)
                .into(new SimpleTarget<Bitmap>(1000, 1000) {

                    @Override
                    public void onResourceReady(@NonNull Bitmap resource, @Nullable Transition<? super Bitmap> transition) {
                        blur(resource, imageView);
                        if (onBlurImageListener != null) {
                            onBlurImageListener.onBlurReady();
                        }
                    }
                });

    }

    public static void blur(Bitmap bkg, ImageView view) {
        float radius = 3;
        float scaleFactor = 10;
        int bitmapWidth = bkg.getWidth();
        int bitmapHeight = bkg.getHeight();
        Bitmap overlay = Bitmap.createBitmap((int) (bitmapWidth / scaleFactor),
                (int) (bitmapHeight / scaleFactor), Bitmap.Config.ARGB_8888);
        Matrix matrix = new Matrix();
        matrix.postScale(1 / scaleFactor, 1 / scaleFactor);
        Canvas canvas = new Canvas(overlay);
        canvas.drawBitmap(bkg, matrix, null);
        overlay = doBlur(overlay, (int) radius, true);
        view.setImageDrawable(new BitmapDrawable(BdApplication.context.getResources(), overlay));
    }

    /**
     * 
     *
     * @param sentBitmap       
     * @param radius           ，PS
     * @param canReuseInBitmap 
     * @return
     */
    public static Bitmap doBlur(Bitmap sentBitmap, int radius, boolean canReuseInBitmap) {
        Bitmap bitmap;
        //
        if (canReuseInBitmap) {
            bitmap = sentBitmap;
        } else {//
            bitmap = sentBitmap.copy(sentBitmap.getConfig(), true);
        }

        if (radius < 1) {//1
            return (null);
        }

        int w = bitmap.getWidth();
        int h = bitmap.getHeight();

        //
        int[] pix = new int[w * h];
        /*
         *
         *、
         *      ：
         *
         *：pixels[]，，width，
         *w（width < w ）．(stride，)．
         *，pixels.length >= stride * height,ArrayIndexOutOfBoundsException　
         *stride > width，pixels[]，．
         *
         *X
         *Y
         *            ：X
         *
         */
        bitmap.getPixels(pix, 0, w, 0, 0, w, h);

        int wm = w - 1;
        int hm = h - 1;
        int wh = w * h;
        int div = radius + radius + 1;

        int r[] = new int[wh];
        int g[] = new int[wh];
        int b[] = new int[wh];
        int rsum, gsum, bsum, x, y, i, p, yp, yi, yw;
        int vmin[] = new int[Math.max(w, h)];

        int divsum = (div + 1) >> 1;
        divsum *= divsum;
        int dv[] = new int[256 * divsum];
        for (i = 0; i < 256 * divsum; i++) {
            dv[i] = (i / divsum);
        }

        yw = yi = 0;

        int[][] stack = new int[div][3];
        int stackpointer;
        int stackstart;
        int[] sir;
        int rbs;
        int r1 = radius + 1;
        int routsum, goutsum, boutsum;
        int rinsum, ginsum, binsum;

        for (y = 0; y < h; y++) {
            rinsum = ginsum = binsum = routsum = goutsum = boutsum = rsum = gsum = bsum = 0;
            for (i = -radius; i <= radius; i++) {
                p = pix[yi + Math.min(wm, Math.max(i, 0))];
                sir = stack[i + radius];
                sir[0] = (p & 0xff0000) >> 16;
                sir[1] = (p & 0x00ff00) >> 8;
                sir[2] = (p & 0x0000ff);
                rbs = r1 - Math.abs(i);
                rsum += sir[0] * rbs;
                gsum += sir[1] * rbs;
                bsum += sir[2] * rbs;
                if (i > 0) {
                    rinsum += sir[0];
                    ginsum += sir[1];
                    binsum += sir[2];
                } else {
                    routsum += sir[0];
                    goutsum += sir[1];
                    boutsum += sir[2];
                }
            }
            stackpointer = radius;

            for (x = 0; x < w; x++) {

                r[yi] = dv[rsum];
                g[yi] = dv[gsum];
                b[yi] = dv[bsum];

                rsum -= routsum;
                gsum -= goutsum;
                bsum -= boutsum;

                stackstart = stackpointer - radius + div;
                sir = stack[stackstart % div];

                routsum -= sir[0];
                goutsum -= sir[1];
                boutsum -= sir[2];

                if (y == 0) {
                    vmin[x] = Math.min(x + radius + 1, wm);
                }
                p = pix[yw + vmin[x]];

                sir[0] = (p & 0xff0000) >> 16;
                sir[1] = (p & 0x00ff00) >> 8;
                sir[2] = (p & 0x0000ff);

                rinsum += sir[0];
                ginsum += sir[1];
                binsum += sir[2];

                rsum += rinsum;
                gsum += ginsum;
                bsum += binsum;

                stackpointer = (stackpointer + 1) % div;
                sir = stack[(stackpointer) % div];

                routsum += sir[0];
                goutsum += sir[1];
                boutsum += sir[2];

                rinsum -= sir[0];
                ginsum -= sir[1];
                binsum -= sir[2];

                yi++;
            }
            yw += w;
        }
        for (x = 0; x < w; x++) {
            rinsum = ginsum = binsum = routsum = goutsum = boutsum = rsum = gsum = bsum = 0;
            yp = -radius * w;
            for (i = -radius; i <= radius; i++) {
                yi = Math.max(0, yp) + x;

                sir = stack[i + radius];

                sir[0] = r[yi];
                sir[1] = g[yi];
                sir[2] = b[yi];

                rbs = r1 - Math.abs(i);

                rsum += r[yi] * rbs;
                gsum += g[yi] * rbs;
                bsum += b[yi] * rbs;

                if (i > 0) {
                    rinsum += sir[0];
                    ginsum += sir[1];
                    binsum += sir[2];
                } else {
                    routsum += sir[0];
                    goutsum += sir[1];
                    boutsum += sir[2];
                }

                if (i < hm) {
                    yp += w;
                }
            }
            yi = x;
            stackpointer = radius;
            for (y = 0; y < h; y++) {
                // Preserve alpha channel: ( 0xff000000 & pix[yi] )
                pix[yi] = (0xff000000 & pix[yi]) | (dv[rsum] << 16) | (dv[gsum] << 8) | dv[bsum];

                rsum -= routsum;
                gsum -= goutsum;
                bsum -= boutsum;

                stackstart = stackpointer - radius + div;
                sir = stack[stackstart % div];

                routsum -= sir[0];
                goutsum -= sir[1];
                boutsum -= sir[2];

                if (x == 0) {
                    vmin[y] = Math.min(y + r1, hm) * w;
                }
                p = x + vmin[y];

                sir[0] = r[p];
                sir[1] = g[p];
                sir[2] = b[p];

                rinsum += sir[0];
                ginsum += sir[1];
                binsum += sir[2];

                rsum += rinsum;
                gsum += ginsum;
                bsum += binsum;

                stackpointer = (stackpointer + 1) % div;
                sir = stack[stackpointer];

                routsum += sir[0];
                goutsum += sir[1];
                boutsum += sir[2];

                rinsum -= sir[0];
                ginsum -= sir[1];
                binsum -= sir[2];

                yi += w;
            }
        }

        bitmap.setPixels(pix, 0, w, 0, 0, w, h);

        return (bitmap);
    }


    public static int dip2px(Context context, float dpValue) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (dpValue * scale + 0.5f);
    }
}
