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
    
}
