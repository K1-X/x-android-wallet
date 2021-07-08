package bd.com.walletdb.entity;

import android.os.Parcel;
import android.os.Parcelable;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;

@Entity
public class ContactEntity implements Parcelable {

    @Id
    private String address;
    private String name;
    private String remark;


    protected ContactEntity(Parcel in) {
        address = in.readString();
        name = in.readString();
        remark = in.readString();
    }    

    @Generated(hash = 792408862)
    public ContactEntity(String address, String name, String remark) {
        this.address = address;
        this.name = name;
        this.remark = remark;
    }

    @Generated(hash = 393979869)
    public ContactEntity() {
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(address);
        dest.writeString(name);
        dest.writeString(remark);
    }
}
