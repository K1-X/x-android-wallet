package bd.com.walletdb;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import org.greenrobot.greendao.database.Database;

import bd.com.walletdb.config.Config;
import bd.com.walletdb.greendao.DaoMaster;
import bd.com.walletdb.greendao.DaoSession;
import bd.com.walletdb.helper.DbHelper;

import static bd.com.walletdb.config.Config.BD_WALLET;


public class GreendaoFactory {

    private static final String TAG = "GreendaoFactory";

    private static DaoMaster sMaster;
    private static DaoSession sDaoSession;

    private static DaoMaster sTxMaster;
    private static DaoSession sTxDaoSession;

    private static DaoMaster sContactMaster;
    private static DaoSession sContactDaoSession;    

    public static void make(Context context) {
        Log.i(TAG, "setupDatabase, begin = " + System.currentTimeMillis());
        //

        DbHelper helper = new DbHelper(context, BD_WALLET);
        Database db = helper.getEncryptedWritableDb("bdwallet123");
        // ： DaoMaster， Session 。
//        daoSession = new DaoMaster(a.getEncryptedWritableDb(MY_PWD)).newSession();
//        daoSession.getUserDao().insert(man1);
        sMaster = new DaoMaster(db);
        sDaoSession = sMaster.newSession();
        Log.i(TAG, "setupDatabase, end = " + System.currentTimeMillis());
    }

    public static void makeTx(Context context) {
        //
        DbHelper helper = new DbHelper(context, Config.BD_TRANSACTION);
        SQLiteDatabase db = helper.getWritableDatabase();
        // ： DaoMaster， Session 。
        sTxMaster = new DaoMaster(db);
        sTxDaoSession = sTxMaster.newSession();
        Log.i(TAG, "setupDatabase, end = " + System.currentTimeMillis());
    }

    public static void makeContact(Context context) {
        //
        DbHelper helper = new DbHelper(context, Config.BD_CONTACT);
        SQLiteDatabase db = helper.getWritableDatabase();
        // ： DaoMaster， Session 。
        sContactMaster = new DaoMaster(db);
        sContactDaoSession = sContactMaster.newSession();
        Log.i(TAG, "setupDatabase, end = " + System.currentTimeMillis());
    }

}

