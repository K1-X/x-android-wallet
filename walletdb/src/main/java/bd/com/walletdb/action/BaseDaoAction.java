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
}
