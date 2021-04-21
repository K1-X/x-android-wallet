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
}
