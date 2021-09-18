package bd.com.bdwallet.widget.lockpattern;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

import java.util.List;

import bd.com.bdwallet.R;


public class LockPatternIndicator extends View {

    private int width, height;
    private int cellBoxWidth, cellBoxHeight;
    private int radius;
    private int offset = 2;
    private Paint defaultPaint, selectPaint;
    private IndicatorCell[][] mIndicatorCells = new IndicatorCell[3][3];

    private static final String TAG = "LockPatternIndicator";

    public LockPatternIndicator(Context context) {
        this(context, null);
    }

    public LockPatternIndicator(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public LockPatternIndicator(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.init();
    }    

    private void init() {
        //initViewSize(context, attrs);
        initRadius();
        initPaint();
        init9IndicatorCells();
    }

    /**
     * init view size
     *
     * @param context
     * @param attrs
     */
    @Deprecated
    private void initViewSize(Context context, AttributeSet attrs) {
        for (int i = 0; i < attrs.getAttributeCount(); i++) {
            String name = attrs.getAttributeName(i);
            if ("layout_width".equals(name)) {
                String value = attrs.getAttributeValue(i);
                this.width = LockPatternUtil.changeSize(context, value);
                //Log.e(TAG, "layout_width:" + value);
            }
            if ("layout_height".equals(attrs.getAttributeName(i))) {
                String value = attrs.getAttributeValue(i);
                this.height = LockPatternUtil.changeSize(context, value);
                //Log.e(TAG, "layout_height:" + value);
            }
        }
        //check the width is or not equals height
        //if not throw exception
        if (this.width != this.height) {
            throw new IllegalArgumentException("the width must be equals height");
        }
    }

    private void initRadius() {
        this.radius = (this.width - offset * 2) / 4 / 2;
        this.cellBoxHeight = (this.height - offset * 2) / 3;
        this.cellBoxWidth = (this.width - offset * 2) / 3;
    }

    private void initPaint() {
        defaultPaint = new Paint();
        defaultPaint.setColor(getResources().getColor(R.color.cyan_normal));
        defaultPaint.setStrokeWidth(3.0f);
        defaultPaint.setStyle(Paint.Style.STROKE);
        defaultPaint.setAntiAlias(true);

        selectPaint = new Paint();
        selectPaint.setColor(getResources().getColor(R.color.cyan_click));
        selectPaint.setStrokeWidth(3.0f);
        selectPaint.setStyle(Paint.Style.FILL);
        selectPaint.setAntiAlias(true);
    }

    /**
     * initialize nine cells
     */
    private void init9IndicatorCells() {
        int distance = this.cellBoxWidth + this.cellBoxWidth / 2 - this.radius;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                mIndicatorCells[i][j] = new IndicatorCell(distance * j + radius + offset, distance * i + radius + offset, 3 * i + j + 1);
            }
        }
    }

    /**
     * set nine indicator cells size
     */
    private void set9IndicatorCellsSize() {
        int distance = this.cellBoxWidth + this.cellBoxWidth / 2 - this.radius;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                mIndicatorCells[i][j].setX(distance * j + radius + offset);
                mIndicatorCells[i][j].setY(distance * i + radius + offset);
            }
        }
    }

}
