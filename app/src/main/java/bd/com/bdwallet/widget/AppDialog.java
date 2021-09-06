package bd.com.bdwallet.widget;

import android.app.Dialog;
import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.cunoraz.gifview.library.GifView;

import java.util.concurrent.TimeUnit;


import bd.com.bdwallet.R;
import io.reactivex.Observable;
import io.reactivex.functions.Action;


public class AppDialog extends Dialog {

    private AppDialog(Context context, @LayoutRes int layoutRes, int width, int height) {
        this(context, layoutRes, width, height, Gravity.CENTER, context.getResources().getDimensionPixelSize(R.dimen.app_dialog_margin));
    }

    private AppDialog(Context context, @LayoutRes int layoutRes, int width, int height, int gravity, int y) {
        super(context, R.style.AppDialog2);
        // set content
        setContentView(layoutRes);

        Window window = getWindow();
        if (window != null) {
            WindowManager.LayoutParams params = window.getAttributes();
            if (width > 0) {
                params.width = width;
            } else {
                params.width = WindowManager.LayoutParams.WRAP_CONTENT;
            }
            if (height > 0) {
                params.height = height;
            } else {
                params.height = WindowManager.LayoutParams.WRAP_CONTENT;
            }
            params.gravity = gravity;
            params.y = y;

            window.setAttributes(params);
        }
    }    

    public void showLoadingDialog() {
        setContentView(R.layout.dialog_loading2);
        startLoadingAnim();
        show();
    }

    @Override
    public void dismiss() {
        GifView ivRotate = findViewById(R.id.ivRotate);
        if (ivRotate != null) {
            ivRotate.pause();
        }
        super.dismiss();
    }

    public void setAppDialogBackground(int resourceId) {
        View view = findViewById(R.id.app_dialog_bg);
        if (view != null) {
            view.setBackgroundResource(resourceId);
        }
    }

    public void showLoadingDialog(String text) {
        setContentView(R.layout.dialog_loading2);
        TextView view = (TextView) findViewById(R.id.tv_loading);
        view.setText(text);
        view.setVisibility(View.VISIBLE);
        startLoadingAnim();
        show();
    }

    public void showLoadingDialogDismiss(String text,long time) {
        setContentView(R.layout.dialog_loading2);
        TextView view = (TextView) findViewById(R.id.tv_loading);
        view.setText(text);
        view.setVisibility(View.VISIBLE);
        startLoadingAnim();
        show();
        Observable.timer(time, TimeUnit.SECONDS)
                .doOnComplete(new Action() {
                    @Override
                    public void run() throws Exception {
                        dismiss();
                    }
                }).subscribe();
    }
}
