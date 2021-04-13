package bd.com.appcore.ui.activity;

import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.DrawableRes;
import android.support.annotation.RequiresApi;
import android.support.annotation.StringRes;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import bd.com.appcore.R;
import bd.com.appcore.mvp.IBasePresenter;
import bd.com.appcore.mvp.IBaseView;
import bd.com.appcore.ui.view.CommonActionBar;
import bd.com.appcore.ui.view.LoadingDialog;


public abstract class BaseUiActivity<P extends IBasePresenter<V>, V extends IBaseView> extends BaseCoreActivity implements IBaseView {
    /**
     * ，
     */
    protected CommonActionBar actionBar;
    protected ViewGroup containerView;
    protected ViewGroup bottomContainer;
    protected ViewGroup topContaniner;

    //，
    protected View errorView;
    //，
    protected View emptyView;
    protected P mPresenter;

    protected V view;

    protected abstract P initPresenter();

    protected abstract V initView();

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mPresenter = initPresenter();
        //
        initLayout();
        immerse();
        view = initView();
        if (mPresenter != null && view != null) {
            mPresenter.onAttachView(view);
        }
        setListener();
        initData();

    }

    private void initLayout() {
        ViewGroup baseRootView = (ViewGroup) View.inflate(this, R.layout.activity_base, null);
        View contentView = View.inflate(this, getLayoutId(), null);
        containerView = (ViewGroup) baseRootView.findViewById(R.id.container);
        bottomContainer = baseRootView.findViewById(R.id.bottom_container);
        topContaniner = baseRootView.findViewById(R.id.top_container);
        containerView.addView(contentView);
        setContentView(baseRootView);
        initContentView(containerView);
    }


    protected void initContentView(ViewGroup containerView) {
        initTooBar();
    }

    protected void initTooBar() {
        actionBar = (CommonActionBar) findViewById(R.id.action_bar);
        actionBar.setBackgroundResource(R.color.cyan_normal);
        setTitle("");
        actionBar.setOnBackClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
    }

    /**
     * 
     *
     * @param text
     */
    protected void setTitle(String text) {
        actionBar.setTitle(text);
    }

    protected void setListener() {

    }

    @Override
    protected void onDestroy() {
        if (mPresenter != null) {
            mPresenter.onDetachView();
            mPresenter = null;
        }
        hideLoadingDialog();
        super.onDestroy();
    }

    protected abstract int getLayoutId();

    @Override
    public void showLoadingDialog() {
        showLoading(true);
    }

    @Override
    public void hideLoadingDialog() {
        showLoading(false);
    }

    public void showLoading(boolean show) {

        if (show) {
            LoadingDialog.loadingDialog(this);

        } else {
            LoadingDialog.cancleDialog();

        }
    }

    /**
     * 
     */
    protected void showErrorView(String msg) {
        //view
        removeExceptionView();
        if (TextUtils.isEmpty(msg)) {
            showErrorView();
        } else {
            errorView = View.inflate(this, R.layout.error_layout, null);
            TextView textView=errorView.findViewById(R.id.error_tv);
            textView.setText(msg);
            containerView.addView(errorView);
            errorView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    onErroViewClicked();
                }
            });
        }


    }

    /**
     * 
     */
    protected void showErrorView() {
        //view
        removeExceptionView();
        errorView = View.inflate(this, R.layout.error_layout, null);
        containerView.addView(errorView);
        errorView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onErroViewClicked();
            }
        });
    }

    /**
     * 
     */
    protected void removeExceptionView() {
        containerView.removeView(errorView);
        containerView.removeView(emptyView);
    }

    /**
     * 
     */
    protected void showEmptyView() {
        //removeerrorView
        removeExceptionView();
        emptyView = View.inflate(this, R.layout.empty_layout, null);
        containerView.addView(emptyView);
        emptyView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //，
                //onErroViewClicked();
            }
        });
    }

    public void exit() {
        finish();
    }

    public void showToast(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_LONG).show();
    }

    /**
     * ，errorView 
     */
    protected void onErroViewClicked() {

    }


    /**
     * 
     */
    protected void initData() {
    }
}
