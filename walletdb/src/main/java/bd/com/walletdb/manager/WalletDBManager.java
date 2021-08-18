package bd.com.walletdb.manager;

import java.util.List;

import bd.com.walletdb.action.WalletAction;
import bd.com.walletdb.entity.WalletEntity;
import bd.com.walletdb.greendao.WalletEntityDao;


public class WalletDBManager {
    private static WalletDBManager manager = new WalletDBManager();

    public static WalletDBManager getManager() {
        return manager;
    }

    public WalletEntity getWalletEntity(String address) {
        WalletAction action = new WalletAction();
        List<WalletEntity> walletEntities = action.eq(WalletEntityDao.Properties.Address, address).queryAnd();
        if (walletEntities != null && walletEntities.size() > 0) {
            return walletEntities.get(0);
        } else {
            return null;
        }
    }    
}
