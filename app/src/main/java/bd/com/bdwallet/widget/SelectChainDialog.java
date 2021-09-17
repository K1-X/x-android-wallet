package bd.com.bdwallet.widget;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.StyleRes;
import android.text.Editable;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import bd.com.bdwallet.R;
import bd.com.bdwallet.module.common.TextWatcherProxy;
import bd.com.bdwallet.module.common.lvadapter.BaseHolder;
import bd.com.bdwallet.module.common.lvadapter.SelectChainHolder;
import bd.com.bdwallet.module.common.lvadapter.SuperAdapter;
import bd.com.walletdb.entity.ChainEntity;

public class SelectChainDialog extends Dialog {

    private ListView listView;
    private TextView titleTv;
    private TextView titleDesTv;
    private TextView cancelTv;
    private TextView sureTv;
    private EditText searchEt;
    private List<ChainEntity> mwalletNames = new ArrayList<>();
    private List<ChainEntity> originalData = new ArrayList<>();
    private Context mContext;
    private String title;
    private String titleDes;
    private MyAdapter adapter;
    private AdapterView.OnItemClickListener listener;    

    //tech
    AdapterView<?> parent;
    View view;
    int position;
    long id;

    public SelectChainDialog(@NonNull Context context) {
        super(context, R.style.DialogTranslucentNoTitle);
        mContext = context;
        setContentView(R.layout.dialog_select_wallet_layout);
        listView = (ListView) findViewById(R.id.user_lv);
        titleTv = (TextView) findViewById(R.id.title_tv);
        titleDesTv = (TextView) findViewById(R.id.title_des_tv);
        searchEt = (EditText) findViewById(R.id.search_et);
        cancelTv = (TextView) findViewById(R.id.cancel_tv);
        sureTv = findViewById(R.id.sure_tv);
        setCanceledOnTouchOutside(false);
    }

    public void setData(List<ChainEntity> mwalletNames, String title, String titleDes) {
        this.mwalletNames.clear();
        this.mwalletNames.addAll(mwalletNames);
        originalData.addAll(mwalletNames);
        this.title = title;
        this.titleDes = titleDes;
        titleTv.setText(title);
        titleDesTv.setText(titleDes);
        adapter = new MyAdapter(mwalletNames);
        listView.setAdapter(adapter);
        setListener();
    }
}
