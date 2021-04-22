package bd.com.appcore.ui.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.annotation.StringRes;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import bd.com.appcore.R;


/**
 * Created by  on 2017/8/17.
 */

public class CommonLineTextView extends RelativeLayout {
	private TextView mContentTv;
    private TextView mTitleTv;    

    private ImageView rightIv;
    private View lineView, topLine, bottomLine;
    private String title;
    private String content;
    private boolean showLeftIcon;
    private boolean showRightIcon;
    private boolean showTextLine;
    private boolean showTopLine;
    private boolean showBottomLine;
    private int leftSrc;
    private int rightSrc;
}
