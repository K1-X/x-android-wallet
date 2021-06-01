package bd.com.appupdate.customview;

import android.app.Activity;
import android.app.Dialog;
import android.app.DownloadManager;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.util.Log;
import android.view.Display;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;


import com.liulishuo.filedownloader.BaseDownloadTask;

import java.io.File;
import java.util.concurrent.TimeUnit;


import bd.com.appupdate.R;
import bd.com.appupdate.util.DownLoadCallBack;
import bd.com.appupdate.util.DownloadAppUtils;
import io.reactivex.Flowable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

public class AppUpdateDialog extends Dialog {

    private static final String TAG = "AppUpdateDialog";

    private Context context;

    private TextView tvTitle;
    private TextView tvContent;
    private ImageView tvUpdateCancel;
    private ImageView tvUpdateOk;
    private LinearLayout controller;
    private TextView tvProgress;
    private ProgressBar progressBar;
    private TextView tvVersion;
    private String mVersion;
    private String mUrl;
    private boolean isForce;


    public AppUpdateDialog(@NonNull Context context, int layoutResId) {
        super(context, R.style.CommonDialog);
        setContentView(layoutResId);
        tvTitle = findViewById(R.id.tv_common_dialog_title);
        tvContent = findViewById(R.id.tv_common_dialog_content);
        tvUpdateOk = findViewById(R.id.tv_common_dialog_right_btn);
        tvVersion = findViewById(R.id.tv_common_dialog_version);
        if (layoutResId != R.layout.dialog_app_must_update) {
            tvUpdateCancel = findViewById(R.id.tv_common_dialog_left_btn);
            tvUpdateCancel.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    dismiss();
                }
            });
        } else {
            controller = findViewById(R.id.tv_common_dialog_controller);
            tvProgress = findViewById(R.id.tv_common_dialog_tv_pro);
            progressBar = findViewById(R.id.tv_common_dialog_progress);
        }
        this.context = context;
        tvUpdateOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startDownLoad(mUrl);
                if (!isForce) {
                    dismiss();
                }
            }
        });
        tvTitle.setText("");
    }

        @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Window window = getWindow();
        if (window != null) {
            window.setGravity(Gravity.CENTER);
//            window.setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));
            WindowManager windowManager = ((Activity) context).getWindowManager();
            Display display = windowManager.getDefaultDisplay();
            WindowManager.LayoutParams lp = window.getAttributes();
            lp.width = display.getWidth() * 4 / 5;
            getWindow().setAttributes(lp);
        }
        setCanceledOnTouchOutside(false);


    }

    public AppUpdateDialog content(CharSequence content, String version, String url) {
        this.mVersion = version;
        this.mUrl = url;
        if (tvContent != null) {
            if (TextUtils.isEmpty(content)) {
                tvContent.setText("");
            } else {
                tvContent.setText(content);
            }
        }
        if (tvVersion != null) {
            if (TextUtils.isEmpty(version)) {
                tvVersion.setVisibility(View.GONE);
            } else {
                tvVersion.setVisibility(View.VISIBLE);
                tvVersion.setText("v"+version);
            }
        }
        return this;
    }

    public AppUpdateDialog isForce(boolean isForce) {
        this.isForce = isForce;
        return this;
    }

    private void setControllerVisible(boolean visible) {
        if (visible) {
            if (tvUpdateOk != null) {
                tvUpdateOk.setVisibility(View.GONE);
            }
            if (controller != null) {
                controller.setVisibility(View.VISIBLE);
            }
        } else {
            if (tvUpdateOk != null) {
                tvUpdateOk.setVisibility(View.VISIBLE);
            }
            if (controller != null) {
                controller.setVisibility(View.GONE);
            }
        }
    }
}
