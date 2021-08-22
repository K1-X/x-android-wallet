package bd.com.bdwallet.web3;

import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.Web3jFactory;
import org.web3j.protocol.core.methods.response.EthGasPrice;
import org.web3j.protocol.http.HttpService;
import org.web3j.tx.ChainId;
import org.web3j.tx.RawTransactionManager;
import org.web3j.tx.response.NoOpProcessor;
import org.web3j.tx.response.TransactionReceiptProcessor;
import org.web3j.utils.Convert;

import java.io.IOException;
import java.math.BigDecimal;
import java.math.BigInteger;

import bd.com.appcore.util.AppSettings;
import bd.com.bdwallet.module.wallet.ApiConfig;
import bd.com.bdwallet.util.HttpUtils;
import bd.com.bdwallet.web3.contract.NulsStandardToken;
import bd.com.bdwallet.web3.contract.SuperConductToken;
import bd.com.walletdb.entity.TokenEntity;
import bd.com.walletdb.entity.WalletEntity;
import bd.com.walletdb.manager.WalletDBManager;


public class Web3Proxy {

    //private String contractaddress = "0x0f46a24b42923aae949cd82b78b90b21e990cbad";
    private String contractaddress = "0x0f46a24b42923aae949cd82b78b90b21e990cbad";
    public static final String SCT_CONTRACT_ADDRESS = "0xsctcontractaddress";
    //    public static final BigInteger GAS_PRICE = BigInteger.valueOf(10000000000L);
//    public static BigInteger GAS_LIMIT = BigInteger.valueOf(2000000);
    public static BigInteger GAS_PRICE = BigInteger.valueOf(22_000_000_000L);
    //public static  BigInteger GAS_LIMIT = BigInteger.valueOf(2200000);
    public static BigInteger GAS_LIMIT = BigInteger.valueOf(60000);
    public static BigInteger DEPLOY_GAS_LIMIT = BigInteger.valueOf(2000000);
    public static BigInteger PACK_SOSO_GAS_LIMIT = BigInteger.valueOf(1_000_010_000L);
    private static Web3Proxy web3Proxy = new Web3Proxy();

    private Web3Proxy() {
    }   
}
