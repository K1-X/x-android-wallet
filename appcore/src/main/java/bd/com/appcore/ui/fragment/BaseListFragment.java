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

  @Override
    protected void initContentView(ViewGroup contentView) {
        super.initContentView(contentView);
        mRecyclerView = contentView.findViewById(R.id.recycler_view);
        mAdapter = createAdapter();
        mRecyclerView.setAdapter(mAdapter);
        mRecyclerView.setLayoutManager(buildLayoutManager());
        List<? extends RecyclerView.ItemDecoration> decorations = buildItemDecorations();
        if (decorations != null && decorations.size() > 0) {
            for (RecyclerView.ItemDecoration itemDecoration : buildItemDecorations()) {
                mRecyclerView.addItemDecoration(itemDecoration);
            }
        }
        mRecyclerView.setLoadingListener(this);

        mRecyclerView.addOnItemTouchListener(new OnRecyclerItemClickListener(mRecyclerView) {

            @Override
            public void onItemClick(RecyclerView.ViewHolder vh) {
                int pos = vh.getAdapterPosition() - mRecyclerView.getHeaders_includingRefreshCount();
                Log.e("BaseList", "pos=" + pos);
                if (pos >= 0 && pos < datas.size()) {
                    onItemViewClick(vh, datas.get(pos));
                }
            }

            @Override
            public void onItemLongClick(RecyclerView.ViewHolder vh) {
                Log.e(ItemTouchHelperCallBack.class.getSimpleName(), "onItemLongClick");

                //，
                if (vh.getLayoutPosition() >= mRecyclerView.getHeaders_includingRefreshCount()) {
                    //
                    // mRecyclerView.setPullRefreshEnabled(false);
                    if (setDrager()) {
                        mItemTouchHelper.startDrag(vh);

                        //
                        Vibrator vib = (Vibrator) getActivity().getSystemService(Service.VIBRATOR_SERVICE);//70
                        vib.vibrate(70);
                    }
                }
            }
        });

        mItemTouchHelper = new ItemTouchHelper(buildItemTouchHelperCallBack());

        if (setDrager()) {
            mItemTouchHelper.attachToRecyclerView(mRecyclerView);
        }

        mRecyclerView.setPullRefreshEnabled(setCanRefresh());
        mRecyclerView.setLoadingMoreEnabled(setCanLoadMore());
        if (setCanRefresh()) {
            mRecyclerView.refresh();
        }

    }

    /**
     * ，false，
     *
     * @return
     */
    protected boolean setCanRefresh() {
        return false;
    }

    /**
     * ，false，
     *
     * @return
     */
    protected boolean setCanLoadMore() {
        return false;
    }

    /**
     * ，false，
     *
     * @return
     */
    protected boolean setDrager() {
        return false;
    }

    /**
     * ,，
     *
     * @param params
     */
    protected void fetchMoreListItems(@NonNull Map<String, Object> params) {
        fetchListItems(params);
    }

     /**
     * 
     *
     * @param params
     */
    protected abstract void fetchListItems(@NonNull Map<String, Object> params);

    /**
     * ，
     *
     * @return
     */
    @NonNull
    protected Map<String, Object> getFetchListItemsParams() {
        Map<String, Object> params = new HashMap<>();
        params.put("pageNumber", pageNumber);
        params.put("pageSize",pageSize);
        return params;
    }

    /**
     * RecyclerView Adapter , Item
     */
    protected abstract CommonAdapter<T> createAdapter();

    public CommonAdapter<T> getAdapter() {
        return mAdapter;
    }


    /**
     * itemtouchhelpercallback，.
     *
     * @return
     */
    protected ItemTouchHelper.Callback buildItemTouchHelperCallBack() {
        return new ItemTouchHelperCallBack(mRecyclerView, datas, getAdapter());
    }

    /**
     * ，。
     *
     * @return
     */
    protected List<? extends RecyclerView.ItemDecoration> buildItemDecorations() {
        return null;
    }

    /**
     * recycle layoutmanager
     *
     * @return
     */
    protected RecyclerView.LayoutManager buildLayoutManager() {
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        return layoutManager;
    }

     /**
     * 
     *
     * @param position
     */
    public void notifyItemChanged(int position) {
        mRecyclerView.notifyItemChanged(position);
    }

    /**
     * 
     *
     * @param data
     * @param position
     */
    public void notifyItemChanged(int position, T data) {
        mRecyclerView.notifyItemChanged(position, data);
    }

    /**
     * 
     *
     * @param position
     * @param newDatas
     */
    public void notifyItemChanged(List<T> newDatas, int position) {
        mRecyclerView.notifyItemInserted(newDatas, position);
    }

    /**
     * ,
     *
     * @param items
     */
    public void loadSuccess(List<T> items) {
        hideLoadingDialog();
        mRecyclerView.refreshComplete();
        removeExceptionView();
        if(items==null||items.size()==0){
            datas.clear();
            mAdapter.notifyDataSetChanged();
            showEmptyView();
            return;
        }

        datas.clear();
        datas.addAll(items);
        pageNumber++;
        mAdapter.notifyDataSetChanged();
    }

    /**
     * 
     *
     * @param msg
     */
    public void loadFailed(String msg) {
        mRecyclerView.refreshComplete();
        hideLoadingDialog();
        showErrorView();
    }

    /**
     * 
     */
    public void loadEmpty() {
        hideLoadingDialog();
        showEmptyView();
    }

    /**
     * 
     *
     * @param moreDatas
     */
    public void loadMoreSuccess(List<T> moreDatas) {
        mRecyclerView.loadMoreComplete();
        if(moreDatas==null||moreDatas.size()==0){
            mRecyclerView.setNoMore(true);
            return;
        }
        datas.addAll(moreDatas);
        mAdapter.notifyDataSetChanged();
        if (moreDatas.size() < pageSize) {
            mRecyclerView.setNoMore(true);
        }
        pageNumber++;
    }

    public void loadMoreFailed() {
        mRecyclerView.loadMoreComplete();
        safetyToast("");
    }
}
