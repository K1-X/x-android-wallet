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

    /**
     *  Function: limit()
     *      。
     *  Params:
     *      int limit，
     **/
    public DaoAction<T> limit(int limit);

    /**
     *  Function: offset()
     *      。
     *  Params:
     *      int offset，，0。offset
     **/
    public DaoAction<T> offset(int offset);

    /**
     *  Function: dump()
     *      ，，，，。
     *
     **/
    public DaoAction<T> dump();

    /**
     *  Function: queryAnd()
     *      DaoAction，
     *      。，。
     *
     **/
    public List<T> queryAnd();

    /**
     *  Function: queryOr()
     *      DaoAction，
     *      。，。
     *
     **/
    public List<T> queryOr();

    /**
     *  Function: queryAndWithAsc()
     *      ，。
     *
     *  Params:
     *      Property... properties, /，ReportEntityDao.Properties.Id
     *
     **/
    public List<T> queryAndWithAsc(Property... properties);

    /**
     *  Function: queryAndWithAsc()
     *      ，。
     *
     *  Params:
     *      Property... properties, /，ReportEntityDao.Properties.Id
     *
     **/
    public List<T> queryAndWithDesc(Property... properties);

    public List<T> queryOrWithAsc(Property... properties);
    public List<T> queryOrWithDesc(Property... properties);

    public long getQueryAndCount();
    public long getQueryOrCount();

    /*  */
    public void deleteAllAsync();

    public void updateAllAsync(List<T> list);

    public void insertAsync(T t);

    boolean insertOrReplaceInTx(Iterable<T> list);

    public void insertOrReplaceAsync(T t);

    public void deleteByKeyAsync(Object key);

//    public void queryAndWithAscAsync();
//    public void queryOrWithDescAsync();

//    public void queryAndAsync(Map<String, String> map, AsyncDaoCallback<T> callback);
//
//    public void queryOrAsync(final Map<String, String> map, final AsyncDaoCallback<T> callback);

    public interface AsyncDaoCallback<T>{
        public void onResult(List<T> list);
    }
}
