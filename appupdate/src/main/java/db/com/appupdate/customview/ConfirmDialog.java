package bd.com.appupdate.customview;

import android.app.Dialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import bd.com.appupdate.R;
import bd.com.appupdate.feature.Callback;

public class ConfirmDialog extends Dialog {

	 Callback callback;
    private TextView content;
    private TextView sureBtn;
    private TextView cancleBtn;

    public ConfirmDialog(Context context, Callback callback) {
        super(context, R.style.CustomDialog);
        this.callback = callback;
        setCustomDialog();
    }
}
