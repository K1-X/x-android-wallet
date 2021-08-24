package bd.com.walletdb.entity;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;
@Entity
public class DoubleTxEntity {

    @Id
    private String to;
    private String from;
    private long time;

    @Generated(hash = 510195246)
    public DoubleTxEntity(String to, String from, long time) {
        this.to = to;
        this.from = from;
        this.time = time;
    }    
}
