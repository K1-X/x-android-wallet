package bd.com.walletdb.entity;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;


@Entity
public class WalletEntity implements Parcelable {

    @Id
    private String address;
    private String privateKey;
    private String publicKey;
    private String password;
    private String keystore;
    private String name;
    private String iconStr;
    private String balance;    

    protected WalletEntity(Parcel in) {
        address = in.readString();
        privateKey = in.readString();
        publicKey = in.readString();
        password = in.readString();
        keystore = in.readString();
        name = in.readString();
        iconStr = in.readString();
    }
}
