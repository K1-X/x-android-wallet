package bd.com.appcore.ui.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import bd.com.appcore.R;
import bd.com.appcore.mvp.IBasePresenter;
import bd.com.appcore.mvp.IBaseView;
import bd.com.appcore.ui.view.CommonActionBar;
import bd.com.appcore.ui.view.LoadingDialog;


public abstract class BaseUiFragment<P extends IBasePresenter<V>,V extends IBaseView> extends BaseDialogFragment implements IBaseView {
  
}
