package bd.com.walletdb.entity;

import android.os.Parcel;
import android.os.Parcelable;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.annotation.Index;


@Entity(indexes = {@Index(value = "address,walletAddress", unique = true)})
public class TokenEntity implements Parcelable {

    @Id(autoincrement = true)
    private Long id;
    private String address;
    private String icon;//(bas e64 )
    private String name; //
    private String symbol; //
    private String supplyTotal;  //
    private int decimals; //，:=181token=1000000000000000000
    private String version; //
    private boolean checked; //
    private String publisher;//
    private String chainId;//Id
    private String balance;//
    private String value;// =balance*price
    private String price;//
    private String walletAddress;//    

    protected TokenEntity(Parcel in) {
        if (in.readByte() == 0) {
            id = null;
        } else {
            id = in.readLong();
        }
        address = in.readString();
        icon = in.readString();
        name = in.readString();
        symbol = in.readString();
        supplyTotal = in.readString();
        decimals = in.readInt();
        version = in.readString();
        checked = in.readByte() != 0;
        publisher = in.readString();
        chainId = in.readString();
        balance = in.readString();
        value = in.readString();
        price = in.readString();
        walletAddress = in.readString();
    }
}
