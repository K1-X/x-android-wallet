package bd.com.appcore.ui.view;

import android.graphics.Color;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.util.Log;

import com.jcodecraeer.xrecyclerview.XRecyclerView;

import java.util.Collections;
import java.util.List;

import bd.com.appcore.ui.adapter.CommonAdapter;
import bd.com.appcore.ui.adapter.MultiItemTypeAdapter;


public class ItemTouchHelperCallBack<T> extends ItemTouchHelper.Callback {

private final static String TAG=ItemTouchHelperCallBack.class.getSimpleName();
    private XRecyclerView mRecyclerVIew;
    private List<T> datas;
    private MultiItemTypeAdapter<T> adapter;

    public ItemTouchHelperCallBack(XRecyclerView mRecyclerVIew, List<T> datas, MultiItemTypeAdapter<T> adapter) {
        this.mRecyclerVIew = mRecyclerVIew;
        this.datas = datas;
        this.adapter = adapter;
    }

    /**
     *   RecyclerViewUPDOWN，RecyclerViewLEFTRIGHT
     * @param recyclerView
     * @param viewHolder
     * @return
     */
    @Override
    public int getMovementFlags(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder) {
        Log.e(TAG,"getMovementFlags");
        if (recyclerView.getLayoutManager() instanceof GridLayoutManager) {
            final int dragFlags = ItemTouchHelper.UP | ItemTouchHelper.DOWN |
                    ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT;
            final int swipeFlags = 0;
            return makeMovementFlags(dragFlags, swipeFlags);
        } else {
            final int dragFlags = ItemTouchHelper.UP | ItemTouchHelper.DOWN;
            final int swipeFlags = 0;
//                    final int swipeFlags = ItemTouchHelper.START | ItemTouchHelper.END;
            return makeMovementFlags(dragFlags, swipeFlags);
        }
    }
   
}
