package bd.com.appcore.ui.view;

import android.app.Dialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;

import bd.com.appcore.R;


public class LoadingDialog {
     private static LoadingDialog mLoading;    

    public static Dialog loadingDialog;

    public static void loadingDialog(Context ct) {
        cancleDialog();
        View view = LayoutInflater.from(ct).inflate(R.layout.loading_dialog, null);
        loadingDialog = new Dialog(ct, R.style.style_loading_dialog);
        loadingDialog.setContentView(view);
        loadingDialog.setCanceledOnTouchOutside(false);
        loadingDialog.show();
    }
}
