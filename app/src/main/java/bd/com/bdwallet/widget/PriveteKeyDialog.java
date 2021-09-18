package bd.com.bdwallet.widget;

import android.app.Dialog;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.StyleRes;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import bd.com.bdwallet.R;
import bd.com.bdwallet.util.ResourceUtil;

public class PriveteKeyDialog extends Dialog {

    private Context mContext;
    private TextView okTv;
    private String privateKey;
    private TextView privateKeyTv;
    private ImageView mCancelIv;
    public PriveteKeyDialog(@NonNull Context context) {
        super(context, R.style.DialogTranslucentNoTitle);
        mContext = context;
        setContentView(R.layout.dialog_privatekey_info);
        okTv = (TextView) findViewById(R.id.ok_tv);
        privateKeyTv=findViewById(R.id.private_name_tv);
        mCancelIv=findViewById(R.id.cancel_iv);
        setCanceledOnTouchOutside(false);
        setListener();

    }    

    private void setListener() {
        okTv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ResourceUtil.setPrimaryClip(getContext(),privateKeyTv.getText().toString().trim());
                Toast.makeText(getContext(),"",Toast.LENGTH_SHORT).show();
            }
        });
        mCancelIv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismiss();
            }
        });
    }

    public void setPrivateKey(String privateKey) {
        this.privateKey = privateKey;
        privateKeyTv.setText(privateKey);
    }

    public PriveteKeyDialog(@NonNull Context context, @StyleRes int themeResId) {
        super(context, themeResId);
    }
}
