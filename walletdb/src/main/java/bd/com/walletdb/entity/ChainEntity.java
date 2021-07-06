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

    @Generated(hash = 268069400)
    public ChainEntity(String name, String chainId, String explorUrl,
            boolean selected) {
        this.name = name;
        this.chainId = chainId;
        this.explorUrl = explorUrl;
        this.selected = selected;
    }

    @Generated(hash = 97016054)
    public ChainEntity() {
    }

    public static final Creator<ChainEntity> CREATOR = new Creator<ChainEntity>() {
        @Override
        public ChainEntity createFromParcel(Parcel in) {
            return new ChainEntity(in);
        }

        @Override
        public ChainEntity[] newArray(int size) {
            return new ChainEntity[size];
        }
    };

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getChainId() {
        return chainId;
    }
}
