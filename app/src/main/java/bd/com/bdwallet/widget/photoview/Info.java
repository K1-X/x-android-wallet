package bd.com.bdwallet.widget.photoview;

import android.graphics.PointF;
import android.graphics.RectF;
import android.widget.ImageView;


class Info {

    // 
    RectF mRect = new RectF();

    // 
    RectF mImgRect = new RectF();

    RectF mWidgetRect = new RectF();

    RectF mBaseRect = new RectF();

    PointF mScreenCenter = new PointF();

    float mScale;

    float mDegrees;

    ImageView.ScaleType mScaleType;
    
}
