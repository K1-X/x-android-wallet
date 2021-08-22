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
   
}
