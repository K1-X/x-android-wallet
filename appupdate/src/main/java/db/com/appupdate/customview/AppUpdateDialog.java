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

}
