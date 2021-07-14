package bd.com.walletdb.entity;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;

@Entity
public class TransactionDetail {

    @Id
    private String pkHash;
    private String blockHash;
    private long blockNumber;
    private String blockTimestamp;
    private String blockGasLimit;
    private String transactionIndex;
    private String transactionFrom;
    private String transactionTo;
    private long gas;
    private long gasUsed;
    private long gasPrice;
    private long cumulativeGas;
    private String randomId;
    private String inputText;
    private long lastBlockNumber;
    private String txCost;
    private String value;
    private String tokenTransferTo;
    private String tokenTransfer;
    private int type;    
}
