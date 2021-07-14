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

    @Generated(hash = 658078881)
    public TransactionDetail(String pkHash, String blockHash, long blockNumber,
            String blockTimestamp, String blockGasLimit, String transactionIndex,
            String transactionFrom, String transactionTo, long gas, long gasUsed,
            long gasPrice, long cumulativeGas, String randomId, String inputText,
            long lastBlockNumber, String txCost, String value,
            String tokenTransferTo, String tokenTransfer, int type) {
        this.pkHash = pkHash;
        this.blockHash = blockHash;
        this.blockNumber = blockNumber;
        this.blockTimestamp = blockTimestamp;
        this.blockGasLimit = blockGasLimit;
        this.transactionIndex = transactionIndex;
        this.transactionFrom = transactionFrom;
        this.transactionTo = transactionTo;
        this.gas = gas;
        this.gasUsed = gasUsed;
        this.gasPrice = gasPrice;
        this.cumulativeGas = cumulativeGas;
        this.randomId = randomId;
        this.inputText = inputText;
        this.lastBlockNumber = lastBlockNumber;
        this.txCost = txCost;
        this.value = value;
        this.tokenTransferTo = tokenTransferTo;
        this.tokenTransfer = tokenTransfer;
        this.type = type;
    }

     @Generated(hash = 487738323)
    public TransactionDetail() {
    }

    public String getPkHash() {
        return pkHash;
    }

    public void setPkHash(String pkHash) {
        this.pkHash = pkHash;
    }

    public String getBlockHash() {
        return blockHash;
    }

    public void setBlockHash(String blockHash) {
        this.blockHash = blockHash;
    }

    public long getBlockNumber() {
        return blockNumber;
    }

    public void setBlockNumber(long blockNumber) {
        this.blockNumber = blockNumber;
    }

    public String getBlockTimestamp() {
        return blockTimestamp;
    }

    public void setBlockTimestamp(String blockTimestamp) {
        this.blockTimestamp = blockTimestamp;
    }
}
