package bd.com.walletdb.action;

import org.greenrobot.greendao.Property;

import java.util.List;


public interface DaoAction<T> {
    /*  */
    /**
     *  Function: insert()
     *  NOTE: ，，
     *      android.database.sqlite.SQLiteConstraintException
     *
     **/
    public long insert(T t);

    public void update(T t);


    /**
     *  Function: insertOrReplace()
     *  NOTE: ，，；
     *      
     *
     **/
    public long insertOrReplace(T t);

    /**
     *  func: 
     *
     **/
    public long count();   

    /**
     *  func: 
     *
     **/
    public List<T> loadAll();

    public void deleteAll();

    /**
     *  Function: deleteByKey()
     *      
     *  Params:
     *      Object key, 
     *
     **/
    public void deleteByKey(Object key);

    /**
     *  Function: loadAllAsc()
     *      ，
     *  Params:
     *      Property... properties, /，ReportEntityDao.Properties.Id
     *
     **/
    public List<T> loadAllAsc(Property... properties);  // 
}
