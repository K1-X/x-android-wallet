package bd.com.walletdb.helper;

import android.content.Context;
import android.util.Log;

import org.greenrobot.greendao.database.Database;

import bd.com.walletdb.config.Config;
import bd.com.walletdb.greendao.DaoMaster;
import bd.com.walletdb.greendao.DaoSession;
import bd.com.walletdb.greendao.WalletEntityDao;



public class DbHelper extends DaoMaster.OpenHelper {

    private static DaoMaster daoMaster;
    private static DaoSession daoSession;



    public DbHelper(Context context, String DBNAME){
        super(context,DBNAME,null);
    }    

    @Override
    public void onUpgrade(Database db, int oldVersion, int newVersion) {
        super.onUpgrade(db, oldVersion, newVersion);
        Log.i("version", oldVersion + "------" + newVersion);
        if (oldVersion < newVersion) {
            Log.i("version", oldVersion + "------" + newVersion);
            DbUpgradeHelper.getInstance().migrate(db, WalletEntityDao.class);
            //()   UserDao   XXDao.class 
//             DbUpgradeHelper.getInstance().migrate(db, UserDao.class,XXDao.class);
        }
    }
}
