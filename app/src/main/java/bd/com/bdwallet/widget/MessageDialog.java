package bd.com.bdwallet.widget;

import android.app.Dialog;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.StyleRes;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import bd.com.bdwallet.R;


public class MessageDialog extends Dialog {

    private TextView titleTv;
    private TextView desTv;
    private TextView accountTv;
    private Context mContext;
    private TextView cancelTv;
    private TextView okTv;
    private OnOkClickListener listener;
    private String pwdStr;    
}
