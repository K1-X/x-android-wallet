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

    public static TxHistoryDBManager getManager() {
        return manager;
    }

    public void updateTxHistory(TxHistory history) {
        TxHistoryAction action = new TxHistoryAction();
        action.insertOrReplace(history);
    }

    public void insertTxHistory(TxHistory txHistory) {
        TxHistoryAction action = new TxHistoryAction();
        action.insertOrReplace(txHistory);
    }

    public void deleteTxHistoryByHash(String hash) {
        TxHistoryAction action = new TxHistoryAction();
        action.deleteByKey(hash);
    }

    public void insertTxHistoryList(List<TxHistory> histories) {
        TxHistoryAction action = new TxHistoryAction();
        action.insertOrReplaceInTx(histories);
    }

    public void insertTxHistoryListAsync(final List<TxHistory> histories) {
        if (histories == null) {
            return;
        }
        new Thread(new Runnable() {
            @Override
            public void run() {
                TxHistoryAction action = new TxHistoryAction();
                action.insertOrReplaceInTx(histories);
            }
        }).start();

    }

    public List<TxHistory> findTxHistoryList(String address) {
        if (TextUtils.isEmpty(address)) {
            return null;
        }
        TxHistoryAction action = new TxHistoryAction();
        return action.eq(TxHistoryDao.Properties.Address, address).queryAnd();
    }


    public TxHistory findTxHistoryByHash(String hash) {
        if (TextUtils.isEmpty(hash)) {
            return null;
        }
        TxHistoryAction action = new TxHistoryAction();
        List<TxHistory> txHistories = action.eq(TxHistoryDao.Properties.PkHash, hash).queryAnd();
        if (txHistories != null && txHistories.size() > 0) {
            return txHistories.get(0);
        }
        return null;
    }
}
