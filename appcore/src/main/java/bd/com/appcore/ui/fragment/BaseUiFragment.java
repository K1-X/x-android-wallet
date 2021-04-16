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
 /** ，*/
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
  
@Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mPresenter =initPresenter();
        if (mPresenter != null && view != null) {
            mPresenter.onAttachView(view);
        }

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        ViewGroup baseRootView = (ViewGroup) inflater.inflate(R.layout.activity_base,null);
        View contentView =  inflater.inflate(getLayoutId(), null);
        containerView=(ViewGroup) baseRootView.findViewById(R.id.container);
        bottomContainer=baseRootView.findViewById(R.id.bottom_container);
        topContaniner=baseRootView.findViewById(R.id.top_container);
        containerView.addView(contentView);
        initTooBar(baseRootView);
        initContentView(baseRootView);
        //
        view = initView();
        if(view!=null) {
            mPresenter.onAttachView(view);
        }
        return baseRootView;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {

        setListener();
        initData();
    }

    protected void initContentView(ViewGroup contentView){

    }

    protected void initTooBar(ViewGroup rootView) {
        actionBar = (CommonActionBar) rootView.findViewById(R.id.action_bar);
        actionBar.setBackgroundResource(R.color.cyan_normal);
        setTitle("");
    }

    /**
     * 
     * @param text
     */
    protected void setTitle(String text) {
        actionBar.setTitle(text);
    }

    protected void setListener(){

    }

   @Override
    public void onDetach() {
        if (mPresenter != null) {
            mPresenter.onDetachView();
            mPresenter = null;
        }
        hideLoadingDialog();
        super.onDetach();
    }


    protected abstract int getLayoutId();

    @Override
    public void showLoadingDialog() {
        showLoading( true);
    }

    @Override
    public void hideLoadingDialog() {
        showLoading(false);
    }

    public void showLoading(boolean show) {
        if(show){
            showDefaultLoading();
        }else {
            LoadingDialog.cancleDialog();
            dismissDialog();
        }
    }

    /**
     * 
     */
    protected void showErrorView() {
        //view
       // removeExceptionView();
        if(errorView!=null){
            errorView.setVisibility(View.VISIBLE);
            return;
        }
        errorView = View.inflate(getActivity(), R.layout.error_layout, null);
        containerView.addView(errorView);
        errorView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onErroViewClicked();
            }
        });
    }
}
