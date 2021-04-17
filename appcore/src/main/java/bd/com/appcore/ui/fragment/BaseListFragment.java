package bd.com.appcore.ui.fragment;

import android.app.Service;
import android.os.Vibrator;
import android.support.annotation.NonNull;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.view.animation.LayoutAnimationController;
import android.widget.FrameLayout;

import com.jcodecraeer.xrecyclerview.ProgressStyle;
import com.jcodecraeer.xrecyclerview.XRecyclerView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import bd.com.appcore.R;
import bd.com.appcore.mvp.IBasePresenter;
import bd.com.appcore.mvp.IBaseView;
import bd.com.appcore.ui.adapter.CommonAdapter;
import bd.com.appcore.ui.view.ItemTouchHelperCallBack;
import bd.com.appcore.ui.view.OnRecyclerItemClickListener;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import rx.schedulers.Schedulers;


public abstract class BaseListFragment<P extends IBasePresenter<V>, V extends IBaseView, T> extends BaseUiFragment<P, V> implements XRecyclerView.LoadingListener {
    private static final String TAG = BaseListFragment.class.getSimpleName();
    protected XRecyclerView mRecyclerView;
    protected CommonAdapter mAdapter;

    protected List<T> datas = new ArrayList<>();
    private ItemTouchHelper mItemTouchHelper;
    //，offset limit，
    protected int pageNumber = 1;
    protected int pageSize=10;    

    @Override
    protected int getLayoutId() {
        return R.layout.base_list_layout;
    }
}
