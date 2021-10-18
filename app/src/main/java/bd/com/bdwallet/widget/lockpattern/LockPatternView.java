package bd.com.bdwallet.widget.lockpattern;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.HapticFeedbackConstants;
import android.view.MotionEvent;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

import bd.com.bdwallet.R;


public class LockPatternView extends View {

    private float movingX, movingY;
    private boolean isActionMove = false;
    private boolean isActionDown = false;//default action down is false
    private boolean isActionUp = true;//default action up is true

    private int width, height;
    private int cellRadius, cellInnerRadius;
    private int cellBoxWidth, cellBoxHeight;
    //in stealth mode (default is false)
    private boolean mInStealthMode = false;
    //haptic feed back (default is false)
    private boolean mEnableHapticFeedback = false;
    //set delay time
    private long delayTime = 600L;
    //set offset to the boundary
    private int offset = 10;
    //draw view used paint
    private Paint defaultPaint, selectPaint, errorPaint;
    private Path trianglePath;
    private Matrix triangleMatrix;

    private Cell[][] mCells = new Cell[3][3];
    private List<Cell> sCells = new ArrayList<Cell>();
    private OnPatternListener patterListener;

    private static final String TAG = "LockPatternView";
    private static final double CONSTANT_COS_30 = Math.cos(Math.toRadians(30));

    public LockPatternView(Context context) {
        this(context, null);
    }

    public LockPatternView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public LockPatternView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.init();
    }

    private void init() {
        this.initCellSize();
        this.init9Cells();
        this.initPaints();
        this.initPaths();
        this.initMatrixs();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        this.drawToCanvas(canvas);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        getMeasuredHeight();
        this.width = getMeasuredWidth();
        this.height = getMeasuredHeight();
        //Log.e(TAG, "(width: " + width + "  ,  height" + height + ")");
        if (width != height) {
            throw new IllegalArgumentException("the width must be equals height");
        }
        this.initCellSize();
        this.set9CellsSize();
        this.invalidate();
    }    
}
