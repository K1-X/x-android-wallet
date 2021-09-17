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
}
