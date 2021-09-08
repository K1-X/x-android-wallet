package bd.com.bdwallet.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.support.annotation.DrawableRes;
import android.support.annotation.StringRes;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import bd.com.bdwallet.R;


public class CommonItemView extends RelativeLayout {

    private TextView mDesTv;
    private TextView mValueTv;

    private ImageView mIcon;
    private ImageView mRightImageView;

    private String des;
    private String vaue;
    private boolean showLeftIcon;
    private boolean showRightIcon;
    private boolean showValRightIcon;


    private int leftSrc;
    private int rightSrc;

    public CommonItemView(Context context) {
        this(context, null);
    }

    public CommonItemView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }    

    public CommonItemView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        View.inflate(context, R.layout.item_common_line_text_layout, this);
        TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.CommonItemView);

        des = a.getString(R.styleable.CommonItemView_textDes);
        vaue = a.getString(R.styleable.CommonItemView_textValue);
        showLeftIcon = a.getBoolean(R.styleable.CommonItemView_isLeftIconShow, false);
        showRightIcon = a.getBoolean(R.styleable.CommonItemView_showmTextRightIcon, true);
        leftSrc = a.getResourceId(R.styleable.CommonItemView_LeftIcon, -1);
        rightSrc = a.getResourceId(R.styleable.CommonItemView_text_right_src, -1);
        showValRightIcon = a.getBoolean(R.styleable.CommonItemView_showValRightIcon, true);
    }
}
