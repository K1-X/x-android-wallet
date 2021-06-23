package bd.com.walletdb.action;

import org.greenrobot.greendao.query.QueryBuilder;

import bd.com.walletdb.GreendaoFactory;
import bd.com.walletdb.entity.DoubleTxEntity;
import bd.com.walletdb.greendao.DaoSession;
import bd.com.walletdb.greendao.DoubleTxEntityDao;

public class DouTxAction extends BaseDaoAction<DoubleTxEntity, DoubleTxEntityDao> {

    @Override
    protected QueryBuilder<DoubleTxEntity> getQueryBuilder() {
        return getEntityDao().queryBuilder();
    }
}
