package bd.com.bdwallet.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.widget.ImageView;

import bd.com.bdwallet.R;


public class RatioImageView extends ImageView {

    private float h2wratio = 0;
    private float w2hratio = 0;

    public RatioImageView(Context ctx){
        super(ctx);
    }    

    public RatioImageView(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.init(attrs);
    }

    public RatioImageView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.init(attrs);
    }
}
