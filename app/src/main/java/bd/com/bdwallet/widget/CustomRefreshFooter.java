package bd.com.bdwallet.widget;

import android.content.Context;
import android.graphics.drawable.AnimationDrawable;
import android.support.annotation.NonNull;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.scwang.smartrefresh.layout.api.RefreshFooter;
import com.scwang.smartrefresh.layout.api.RefreshKernel;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.constant.RefreshState;
import com.scwang.smartrefresh.layout.constant.SpinnerStyle;

import bd.com.bdwallet.R;

/**
 * footer
 */
public class CustomRefreshFooter extends LinearLayout implements RefreshFooter {

    private ImageView imageView;
    private TextView textView;
    private AnimationDrawable mAnimPull;
    private AnimationDrawable mAnimRefresh;

    private RotateAnimation mRotateAnimation;
    private Runnable mRunnable;
    private static final String TAG = "CustomRefreshFooter";

    public CustomRefreshFooter(Context context) {
        this(context, null, 0);
    }    

    public CustomRefreshFooter(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public CustomRefreshFooter(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        View view = View.inflate(context, R.layout.layout_refresh_header, this);
        imageView = view.findViewById(R.id.iv_loading);
        textView = view.findViewById(R.id.tv_loading);
    }

    @NonNull
    @Override
    public View getView() {
        return this;
    }

    @NonNull
    @Override
    public SpinnerStyle getSpinnerStyle() {
        return SpinnerStyle.Translate;
    }

    @Override
    public void setPrimaryColors(int... colors) {

    }
}
