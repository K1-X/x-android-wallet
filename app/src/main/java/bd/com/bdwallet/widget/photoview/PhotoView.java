package bd.com.bdwallet.widget.photoview;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.app.Activity;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.PointF;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.support.v4.app.ActivityCompat;
import android.support.v7.widget.AppCompatImageView;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.widget.ImageView;
import android.widget.OverScroller;
import android.widget.Scroller;


public class PhotoView extends AppCompatImageView {

    private final static int MIN_ROTATE = 35;
    private final static int ANIMA_DURING = 340;
    private final static float MAX_SCALE = 2.5f;

    private int mMinRotate;
    private int mAnimaDuring;
    private float mMaxScale;

    private int MAX_OVER_SCROLL = 0;
    private int MAX_FLING_OVER_SCROLL = 0;
    private int MAX_OVER_RESISTANCE = 0;
    private int MAX_ANIM_FROM_WAITE = 500;

    private Matrix mBaseMatrix = new Matrix();
    private Matrix mAnimaMatrix = new Matrix();
    private Matrix mSynthesisMatrix = new Matrix();
    private Matrix mTmpMatrix = new Matrix();

    private RotateGestureDetector mRotateDetector;
    private GestureDetector mDetector;
    private ScaleGestureDetector mScaleDetector;
    private OnClickListener mClickListener;

    private ScaleType mScaleType;

    private boolean hasMultiTouch;
    private boolean hasDrawable;
    private boolean isKnowSize;
    private boolean hasOverTranslate;
    private boolean isEnable = false;
    private boolean isInit;
    private boolean mAdjustViewBounds;
    // 
    private boolean isZoomUp;
    private boolean canRotate;

    private boolean imgLargeWidth;
    private boolean imgLargeHeight;

    private float mRotateFlag;
    private float mDegrees;
    private float mScale = 1.0f;
    private int mTranslateX;
    private int mTranslateY;

    private float mHalfBaseRectWidth;
    private float mHalfBaseRectHeight;

    private RectF mWidgetRect = new RectF();
    private RectF mBaseRect = new RectF();
    private RectF mImgRect = new RectF();
    private RectF mTmpRect = new RectF();
    private RectF mCommonRect = new RectF();

    private PointF mScreenCenter = new PointF();
    private PointF mScaleCenter = new PointF();
    private PointF mRotateCenter = new PointF();

    private Transform mTranslate = new Transform();

    private RectF mClip;
    private Info mFromInfo;
    private long mInfoTime;
    private Runnable mCompleteCallBack;

    private OnLongClickListener mLongClick;

    //pull down transform like WeChat
    boolean touchDown = false;
    boolean canTransform = false;
    float moveX = 0, moveY = 0;
    float distanceX = 0, distanceY = 0;
    float pullDownScale = 1F;
    float bgAlpha = 1F;
    long downTimestamp;    

    public PhotoView(Context context) {
        super(context);
        init();
    }

    public PhotoView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public PhotoView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }
}
