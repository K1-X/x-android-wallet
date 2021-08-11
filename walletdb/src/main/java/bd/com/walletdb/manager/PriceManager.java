package bd.com.walletdb.manager;

import android.provider.SyncStateContract;
import android.text.TextUtils;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import bd.com.walletdb.action.PriceAction;
import bd.com.walletdb.action.TokenAction;
import bd.com.walletdb.entity.Price;
import bd.com.walletdb.entity.TokenEntity;
import bd.com.walletdb.greendao.PriceDao;
import bd.com.walletdb.greendao.TokenEntityDao;


public class PriceManager {

    private static PriceManager manager = new PriceManager();

    private PriceManager() {
    }

    public static PriceManager getManager() {
        return manager;
    }    
}
