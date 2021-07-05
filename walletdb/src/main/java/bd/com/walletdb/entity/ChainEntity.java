package bd.com.walletdb.entity;

import android.os.Parcel;
import android.os.Parcelable;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;

@Entity
public class ChainEntity implements Parcelable {

     private String name;
    @Id
    private String chainId;
    private String explorUrl;
    private boolean selected;    

    protected ChainEntity(Parcel in) {
        name = in.readString();
        chainId = in.readString();
        explorUrl = in.readString();
        selected = in.readByte() != 0;
    }
}
