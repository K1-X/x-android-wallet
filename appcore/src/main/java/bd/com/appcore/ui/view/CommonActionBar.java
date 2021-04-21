package bd.com.appcore.ui.view;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.os.Build;
import android.support.annotation.DrawableRes;
import android.support.annotation.RequiresApi;
import android.support.annotation.StringRes;
import android.support.annotation.StyleableRes;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import bd.com.appcore.R;


/**
 * 
 */
public class CommonActionBar extends RelativeLayout {
    private ImageView mBackIv;

    private ImageView mMenu1Iv;
    private ImageView mMenu2Iv;
    private TextView mTitleTv;
    private TextView mRightTv;
    private boolean showBack;
    private boolean showMenu1;
    private boolean showMenu2;
    private int backResId = -1;
    private int menu1ResId = -1;
    private int menu2ResId = -1;
    private String title;    
 
    View mCommonDividerV;

    public CommonActionBar(Context context) {
        this(context, null);
    }

    public CommonActionBar(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public CommonActionBar(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        View.inflate(context, R.layout.layout_actionbar_common_merge, this);
        TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.CommonActionBar);
        showBack = a.getBoolean(R.styleable.CommonActionBar_showBack, true);
        showMenu1 = a.getBoolean(R.styleable.CommonActionBar_showMenu1, false);
        showMenu2 = a.getBoolean(R.styleable.CommonActionBar_showMenu2, false);
        backResId = a.getResourceId(R.styleable.CommonActionBar_backSrc, -1);
        menu1ResId = a.getResourceId(R.styleable.CommonActionBar_menu1Src, -1);
        menu2ResId = a.getResourceId(R.styleable.CommonActionBar_menu2Src, -1);
        title = a.getString(R.styleable.CommonActionBar_titleText);
    }
 
}
