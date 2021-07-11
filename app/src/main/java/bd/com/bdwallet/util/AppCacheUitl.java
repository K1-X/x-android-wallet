package bd.com.bdwallet.util;

import android.content.Context;
import android.os.Environment;

import java.io.File;
import java.math.BigDecimal;

import bd.com.appcore.util.AppSettings;
import bd.com.walletdb.manager.TokenManager;
import bd.com.walletdb.manager.TxHistoryDBManager;

public class AppCacheUitl {


    public static void resetDB() {
        TokenManager.getManager().reset();
        TxHistoryDBManager.getManager().reset();
        AppSettings.getAppSettings().setCurrentChainIp("");
        AppSettings.getAppSettings().setCurrentChinId(null);
    }
    
}
