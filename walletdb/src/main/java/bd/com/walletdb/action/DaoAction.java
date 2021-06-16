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

    /**
     *  Function: loadAllDesc()
     *      ，
     *  Params:
     *      Property... properties, /，ReportEntityDao.Properties.Id
     *
     **/
    public List<T> loadAllDesc(Property... properties);


    /* 
       NOTE: ，（Object value），crash。
       ，BaseDaoAction，。
     */
    public DaoAction<T> eq(Property property, Object value);
    public DaoAction<T> notEq(Property property, Object value);
    public DaoAction<T> like(Property property, String value);
    public DaoAction<T> between(Property property, Object value1, Object value2);
    public DaoAction<T> gt(Property property, Object value);
    public DaoAction<T> lt(Property property, Object value);
    public DaoAction<T> ge(Property property, Object value);
    public DaoAction<T> le(Property property, Object value);
}
