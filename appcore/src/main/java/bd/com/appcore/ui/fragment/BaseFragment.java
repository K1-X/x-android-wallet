package bd.com.appcore.ui.fragment;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.os.Looper;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.Toast;


public abstract class BaseFragment extends Fragment {
private static final String TAG = "BaseFragment";
    protected boolean mResumed;
    protected boolean mCreate;
    protected boolean mStopped;
    protected boolean mDestroyed;
	protected boolean mHidden;

	private boolean mResumedForFirstTime;

	@Override
	public void onCreate(@Nullable Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		mDestroyed = false;
		mCreate = true;
		Log.d(TAG, "[" + getClass().getSimpleName() + "]: onCreate, Hidden = " + mHidden);
	}


    @Override
    public void onStart() {
        super.onStart();
        mStopped = false;
		Log.d(TAG, "[" + getClass().getSimpleName() + "]: onStart, Hidden = " + mHidden);
    }

    @Override
    public void onHiddenChanged(boolean hidden) {
        super.onHiddenChanged(hidden);
		mHidden = hidden;
        Log.d(TAG, "[" + getClass().getSimpleName() + "]: onHiddenChanged " + hidden);
    }

	@Override
	public void onResume() {
		super.onResume();
		mResumed = true;
		if(!mResumedForFirstTime) {
			mResumedForFirstTime = true;
		}
		Log.d(TAG, "[" + getClass().getSimpleName() + "]: onResume, Hidden = " + mHidden);
	}

	@Override
	public void onPause() {
		super.onPause();
		mResumed = false;
		Log.d(TAG, "[" + getClass().getSimpleName() + "]: onPause, Hidden = " + mHidden);
	}

	@Override
	public void onStop() {
		super.onStop();
		mStopped = true;
		Log.d(TAG, "[" + getClass().getSimpleName() + "]: onStop, Hidden = " + mHidden);
	}

@Override
	public void onDestroy() {
		super.onDestroy();

		mDestroyed = true;
		mResumedForFirstTime = false;
		Log.d(TAG, "[" + getClass().getSimpleName() + "]: onDestroy, Hidden = " + mHidden);
	}

	@Override
	public void onDetach() {
		super.onDetach();
		Log.d(TAG, "[" + getClass().getSimpleName() + "]: onDetach");
	}
	@Override
	public void onAttach(Activity activity) {
		super.onAttach(activity);
		Log.d(TAG, "[" + getClass().getSimpleName() + "]: onAttach");
	}

	@Nullable
	@Override
	public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
		Log.d(TAG, "[" + getClass().getSimpleName() + "]: onCreateView");
		View view=inflater.inflate(getLayoutId(),null);
		return view;
	}

	@Override
	public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
		super.onViewCreated(view, savedInstanceState);
		initView(view);
		initData();
		Log.d(TAG, "[" + getClass().getSimpleName() + "]: onViewCreated");
	}

	@Override
	public void onActivityCreated(@Nullable Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);
		Log.d(TAG, "[" + getClass().getSimpleName() + "]: onActivityCreated");
	}

	@Override
	public void setUserVisibleHint(boolean isVisibleToUser) {
		super.setUserVisibleHint(isVisibleToUser);
		Log.d(TAG, "[" + getClass().getSimpleName() + "]: setUserVisibleHint " + isVisibleToUser);
	}
}
