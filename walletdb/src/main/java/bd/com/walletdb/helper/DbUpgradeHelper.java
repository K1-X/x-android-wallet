package bd.com.walletdb.helper;

import android.database.Cursor;
import android.text.TextUtils;
import android.util.Log;

import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.internal.DaoConfig;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import bd.com.walletdb.greendao.DaoMaster;



public class DbUpgradeHelper {

    private static final String CONVERSION_CLASS_NOT_FOUND_EXCEPTION = "MIGRATION HELPER - CLASS DOESN'T MATCH WITH THE CURRENT PARAMETERS";
    private static DbUpgradeHelper instance;

    public static DbUpgradeHelper getInstance() {
        if(instance == null) {
            instance = new DbUpgradeHelper();
        }
        return instance;
    }    
}
