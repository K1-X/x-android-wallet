package bd.com.walletdb.entity;

import android.os.Parcel;
import android.os.Parcelable;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.annotation.Index;

@Entity(indexes = {@Index(value = "address,chainId", unique = true)})
public class Price implements Parcelable {

    @Id(autoincrement = true)
    private Long id;
    private String marketName;
    private String asks;
    private String bids;
    private String unit;
    private String address;
    private String chainId;


    protected Price(Parcel in) {
        if (in.readByte() == 0) {
            id = null;
        } else {
            id = in.readLong();
        }
        marketName = in.readString();
        asks = in.readString();
        bids = in.readString();
        unit = in.readString();
        address = in.readString();
        chainId = in.readString();
    }    
}
