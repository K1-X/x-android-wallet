package bd.com.walletdb.manager;

import android.text.TextUtils;

import java.util.ArrayList;
import java.util.List;

import bd.com.walletdb.action.TokenAction;
import bd.com.walletdb.action.TxHistoryAction;
import bd.com.walletdb.entity.TxHistory;
import bd.com.walletdb.greendao.TxHistoryDao;


public class TxHistoryDBManager {

    private static TxHistoryDBManager manager = new TxHistoryDBManager();

    private TxHistoryDBManager() {
    }    
}
