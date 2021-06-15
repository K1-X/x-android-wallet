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
   
}
