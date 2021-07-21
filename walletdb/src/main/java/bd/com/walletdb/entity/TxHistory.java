package bd.com.walletdb.entity;

import android.os.Parcel;
import android.os.Parcelable;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;


@Entity
public class TxHistory implements Parcelable {

     @Id
    private String pkHash;
    private String blockHash;
    private int blockNumber;
    private String blockTimesStr;
    private String blockGasLimit;
    private String transactionIndex;
    private String transactionFrom;
    private String transactionTo;
    private String value;
    private String gas;
    private String gasPrice;
    private String cumulativeGas;
    private int type;
    private String tokenTransferTo;//
    private String tokenTransfer;//
    private String address;//tokenAddr;
    private String walletAddr;
    private int lastBlockNumber;
    private String chainId;
    private int state;//0 ,1,,2 pengding


    protected TxHistory(Parcel in) {
        pkHash = in.readString();
        blockHash = in.readString();
        blockNumber = in.readInt();
        blockTimesStr = in.readString();
        blockGasLimit = in.readString();
        transactionIndex = in.readString();
        transactionFrom = in.readString();
        transactionTo = in.readString();
        value = in.readString();
        gas = in.readString();
        gasPrice = in.readString();
        cumulativeGas = in.readString();
        type = in.readInt();
        tokenTransferTo = in.readString();
        tokenTransfer = in.readString();
        address = in.readString();
        walletAddr = in.readString();
        lastBlockNumber = in.readInt();
        chainId = in.readString();
        state = in.readInt();
    }

    @Generated(hash = 1200338274)
    public TxHistory(String pkHash, String blockHash, int blockNumber,
            String blockTimesStr, String blockGasLimit, String transactionIndex,
            String transactionFrom, String transactionTo, String value, String gas,
            String gasPrice, String cumulativeGas, int type, String tokenTransferTo,
            String tokenTransfer, String address, String walletAddr,
            int lastBlockNumber, String chainId, int state) {
        this.pkHash = pkHash;
        this.blockHash = blockHash;
        this.blockNumber = blockNumber;
        this.blockTimesStr = blockTimesStr;
        this.blockGasLimit = blockGasLimit;
        this.transactionIndex = transactionIndex;
        this.transactionFrom = transactionFrom;
        this.transactionTo = transactionTo;
        this.value = value;
        this.gas = gas;
        this.gasPrice = gasPrice;
        this.cumulativeGas = cumulativeGas;
        this.type = type;
        this.tokenTransferTo = tokenTransferTo;
        this.tokenTransfer = tokenTransfer;
        this.address = address;
        this.walletAddr = walletAddr;
        this.lastBlockNumber = lastBlockNumber;
        this.chainId = chainId;
        this.state = state;
    }
  
    @Generated(hash = 1772483653)
    public TxHistory() {
    }

    public static final Creator<TxHistory> CREATOR = new Creator<TxHistory>() {
        @Override
        public TxHistory createFromParcel(Parcel in) {
            return new TxHistory(in);
        }

        @Override
        public TxHistory[] newArray(int size) {
            return new TxHistory[size];
        }
    };    

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof TxHistory) {
            return ((TxHistory) obj).pkHash.equals(this.pkHash);
        }
        return super.equals(obj);
    }

    @Override
    public int hashCode() {
        return this.pkHash.hashCode();
    }


    @Override
    public int describeContents() {
        return 0;
    }

}
