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
    

}
