package bd.com.walletdb.manager;

import android.text.TextUtils;

import java.util.List;

import bd.com.walletdb.action.DouTxAction;
import bd.com.walletdb.entity.DoubleTxEntity;
import bd.com.walletdb.greendao.DoubleTxEntityDao;

public class DoubleTxManager {

    private DoubleTxManager() {
        if (Singleton.manager != null) {
            throw new IllegalStateException();
        }
    }    

    private static class Singleton {
        private static DoubleTxManager manager = new DoubleTxManager();
    }

    public static DoubleTxManager getManager() {
        return Singleton.manager;
    }
}
