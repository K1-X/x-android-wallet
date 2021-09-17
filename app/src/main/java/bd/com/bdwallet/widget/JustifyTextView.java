package bd.com.bdwallet.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.widget.TextView;

public class JustifyTextView extends android.support.v7.widget.AppCompatTextView {

    private int mLineY;
    private int mViewWidth;
    public static final String TWO_CHINESE_BLANK = "  ";

    public JustifyTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }    

    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
    }
}
