package bd.com.appcore.ui.fragment;

import android.app.Activity;

import java.util.concurrent.TimeUnit;

import bd.com.appcore.R;
import bd.com.appcore.ui.view.LoadingDialog;
import bd.com.appcore.ui.view.ToastDialog;
import io.reactivex.Observable;
import io.reactivex.functions.Consumer;


public abstract class BaseDialogFragment extends BaseFragment{
    
 //handler code
    public static final int DISMISS_DIALOG = 1;
    public static final int DIALOG_SHOW_TIME = 2 * 1000;

    private ToastDialog customerDialog;
    /**
     * 
     * @param content    
     * @param cancelable 
     */
    public  void showSuccessToast(final String content, final String contentDes, final boolean cancelable) {
        Observable.timer(200, TimeUnit.MILLISECONDS)
                .subscribe(new Consumer<Long>() {
                    @Override
                    public void accept(Long aLong) throws Exception {
                        startToast(content,contentDes,cancelable);
                    }
                });
    }

    /**
     * 
     * @param content
     * @param contentDes
     * @param cancelable
     */
    private void startToast(final String content, final String contentDes, final boolean cancelable){
        showDialog(getActivity(),content,contentDes,R.mipmap.complete,false,cancelable);
    }
    /**
     * 
     * @param content    
     * @param cancelable 
     */
    public  void showErrorToast( String content, String contentDes, boolean cancelable) {
        showDialog(getActivity(),content,contentDes, R.mipmap.error,false,cancelable);
    }
	/**
     * 
     * @param content    
     * @param cancelable 
     */
    public  void showWarningToast( String content, String contentDes, boolean cancelable) {
        dismissLoading();
        showDialog(getActivity(),content,contentDes,R.mipmap.hint,false,cancelable);
    }

    /**
     * loading
     * @param content    
     * @param cancelable 
     */
    public void showLoading(String content, String contentDes, boolean cancelable) {
        showDialog(getActivity(),content,contentDes,R.mipmap.hint,true,cancelable);
    }
}
