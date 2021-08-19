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
}
