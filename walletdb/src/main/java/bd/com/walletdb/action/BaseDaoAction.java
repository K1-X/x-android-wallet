package bd.com.walletdb.action;

import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.Property;
import org.greenrobot.greendao.query.QueryBuilder;
import org.greenrobot.greendao.query.WhereCondition;

import java.util.ArrayList;
import java.util.List;

import bd.com.walletdb.greendao.DaoSession;


public abstract class BaseDaoAction<T, G extends AbstractDao> implements DaoAction<T> {

    private static final String TAG = "BaseDaoAction";

    private static int LOGIC_AND  = 1;
    private static int LOGIC_OR = 2;


    protected abstract QueryBuilder<T> getQueryBuilder();

    protected abstract G getEntityDao();

    protected abstract DaoSession getDaoSession();


    /**
     *  Function: insert()
     *  NOTE: ，，
     *      android.database.sqlite.SQLiteConstraintException
     *
     **/
    @Override
    public final long insert(T t){
        G entityDao = getEntityDao();
        if(entityDao == null){
            return 0;
        }

        return entityDao.insert(t);
    }

    @Override
    public void update(T t){
        G entityDao = getEntityDao();
        if(entityDao != null){
            entityDao.update(t);
        }
    }

    /**
     *  Function: insertOrReplace()
     *  NOTE: ，，；
     *      
     *
     **/
    @Override
    public long insertOrReplace(T t){
        G entityDao = getEntityDao();
        if(entityDao == null){
            return 0;
        }

        return entityDao.insertOrReplace(t);

    }    
   
    @Override
    public final long count(){
        G entityDao = getEntityDao();
        if(entityDao == null){
            return 0;
        }

        return entityDao.count();
    }

    @Override
    public final List<T> loadAll(){
        G entityDao = getEntityDao();
        if(entityDao == null){
            return null;
        }

        return entityDao.loadAll();
    }

    @Override
    public final void deleteAll(){
        G entityDao = getEntityDao();
        if(entityDao != null){
            entityDao.deleteAll();
        }
    }

    public final void deleteInTx(List<T> tList){
        G entityDao = getEntityDao();
        if(entityDao != null){
            entityDao.deleteInTx(tList);
        }
    }

    /**
     *  Function: deleteByKey()
     *      
     *  Params:
     *      Object key, 
     *
     **/
    @Override
    public final void deleteByKey(Object key){
        G entityDao = getEntityDao();
        if(entityDao != null){
            entityDao.deleteByKey(key);
        }
    }

    @Override
    public final void deleteByKeyAsync(final Object key){
        new Thread(new Runnable() {
            @Override
            public void run() {
                deleteByKey(key);
            }
        }).start();
    }

    @Override
    public final void deleteAllAsync(){
        new Thread(new Runnable() {
            @Override
            public void run() {
                deleteAll();
            }
        }).start();
    }

    @Override
    public final void insertAsync(final T t){
        new Thread(new Runnable() {
            @Override
            public void run() {
                insert(t);
            }
        }).start();
    }

    @Override
    public final void insertOrReplaceAsync(final T t){
        new Thread(new Runnable() {
            @Override
            public void run() {
                insertOrReplace(t);
            }
        }).start();
    }

    @Override
    public boolean insertOrReplaceInTx(Iterable<T> list) {
        G entityDao = getEntityDao();
        if(entityDao == null){
            return false;
        }
        entityDao.insertOrReplaceInTx(list);
        return true;
    }

    private Property getProperty(String column){
        if(column == null || column.isEmpty()){
            return null;
        }

        G entityDao = getEntityDao();
        Property[] allProperties = entityDao.getProperties();
        for(Property pro : allProperties){
            if(column.toUpperCase().equals(pro.columnName) || column.toLowerCase().equals(pro.columnName)){
                return pro;
            }
        }
        return null;
    }

    public void updateAllAsync(final List<T> list){
        new Thread(new Runnable() {
            @Override
            public void run() {
                deleteAll();

                for(T t : list){
                    insert(t);
                }
            }
        }).start();
    }
}
