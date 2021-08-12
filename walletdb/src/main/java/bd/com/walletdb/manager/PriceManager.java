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

    public Price getPriceByMarketName(String marketName) {
        if (TextUtils.isEmpty(marketName)) {
            return null;
        }
        PriceAction action = new PriceAction();
        List<Price> priceList = action.eq(PriceDao.Properties.MarketName, marketName).queryAnd();
        if (priceList != null && priceList.size() > 0) {
            return priceList.get(0);
        }
        return null;
    }

     public Price getPrice(String tokenAddr, String chainId) {
        if (TextUtils.isEmpty(tokenAddr)||TextUtils.isEmpty(chainId)) {
            return null;
        }
        PriceAction action = new PriceAction();
        List<Price> priceList = action.eq(PriceDao.Properties.Address,tokenAddr).eq(PriceDao.Properties.ChainId,chainId).queryAnd();
        if (priceList != null && priceList.size() > 0) {
            return priceList.get(0);
        }
        return null;
    }

    public void insertPrice(Price price) {
        if (price == null) {
            return;
        }
        PriceAction action = new PriceAction();
        action.insertOrReplace(price);
    }

    public void insertPriceList(List<Price> priceList) {
        if (priceList == null || priceList.size() == 0) {
            return;
        }
        PriceAction action = new PriceAction();
        action.insertOrReplaceInTx(priceList);
    }

    public List<Price> loadAll() {
        PriceAction action = new PriceAction();
        return action.loadAll();
    }
}
