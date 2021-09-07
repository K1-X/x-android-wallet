package bd.com.bdwallet.web3.contract;

import org.web3j.abi.EventEncoder;
import org.web3j.abi.FunctionEncoder;
import org.web3j.abi.TypeReference;
import org.web3j.abi.datatypes.Address;
import org.web3j.abi.datatypes.Bool;
import org.web3j.abi.datatypes.Event;
import org.web3j.abi.datatypes.Function;
import org.web3j.abi.datatypes.Type;
import org.web3j.abi.datatypes.Utf8String;
import org.web3j.abi.datatypes.generated.Uint256;
import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.DefaultBlockParameter;
import org.web3j.protocol.core.RemoteCall;
import org.web3j.protocol.core.methods.request.EthFilter;
import org.web3j.protocol.core.methods.response.Log;
import org.web3j.protocol.core.methods.response.TransactionReceipt;
import org.web3j.tx.Contract;
import org.web3j.tx.TransactionManager;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import rx.Observable;
import rx.functions.Func1;

public class NewPackingBox extends Contract {

    private static final String BINARY = "";

    protected NewPackingBox(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    protected NewPackingBox(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    public List<TransferProxyEventResponse> getTransferProxyEvents(TransactionReceipt transactionReceipt) {
        final Event event = new Event("TransferProxy", 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}, new TypeReference<Address>() {}),
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        List<EventValuesWithLog> valueList = extractEventParametersWithLog(event, transactionReceipt);
        ArrayList<TransferProxyEventResponse> responses = new ArrayList<TransferProxyEventResponse>(valueList.size());
        for (EventValuesWithLog eventValues : valueList) {
            TransferProxyEventResponse typedResponse = new TransferProxyEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse._paddr = (String) eventValues.getIndexedValues().get(0).getValue();
            typedResponse._taddr = (String) eventValues.getIndexedValues().get(1).getValue();
            typedResponse._value = (BigInteger) eventValues.getNonIndexedValues().get(0).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }    

    public Observable<TransferProxyEventResponse> transferProxyEventObservable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        final Event event = new Event("TransferProxy", 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}, new TypeReference<Address>() {}),
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(event));
        return web3j.ethLogObservable(filter).map(new Func1<Log, TransferProxyEventResponse>() {
            @Override
            public TransferProxyEventResponse call(Log log) {
                EventValuesWithLog eventValues = extractEventParametersWithLog(event, log);
                TransferProxyEventResponse typedResponse = new TransferProxyEventResponse();
                typedResponse.log = log;
                typedResponse._paddr = (String) eventValues.getIndexedValues().get(0).getValue();
                typedResponse._taddr = (String) eventValues.getIndexedValues().get(1).getValue();
                typedResponse._value = (BigInteger) eventValues.getNonIndexedValues().get(0).getValue();
                return typedResponse;
            }
        });
    }

    public List<ResponseEventResponse> getResponseEvents(TransactionReceipt transactionReceipt) {
        final Event event = new Event("Response", 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}, new TypeReference<Utf8String>() {}),
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        List<EventValuesWithLog> valueList = extractEventParametersWithLog(event, transactionReceipt);
        ArrayList<ResponseEventResponse> responses = new ArrayList<ResponseEventResponse>(valueList.size());
        for (EventValuesWithLog eventValues : valueList) {
            ResponseEventResponse typedResponse = new ResponseEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse.from = (String) eventValues.getIndexedValues().get(0).getValue();
            typedResponse.errmsg = (byte[]) eventValues.getIndexedValues().get(1).getValue();
            typedResponse.errno = (BigInteger) eventValues.getNonIndexedValues().get(0).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public Observable<ResponseEventResponse> responseEventObservable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        final Event event = new Event("Response", 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}, new TypeReference<Utf8String>() {}),
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(event));
        return web3j.ethLogObservable(filter).map(new Func1<Log, ResponseEventResponse>() {
            @Override
            public ResponseEventResponse call(Log log) {
                EventValuesWithLog eventValues = extractEventParametersWithLog(event, log);
                ResponseEventResponse typedResponse = new ResponseEventResponse();
                typedResponse.log = log;
                typedResponse.from = (String) eventValues.getIndexedValues().get(0).getValue();
                typedResponse.errmsg = (byte[]) eventValues.getIndexedValues().get(1).getValue();
                typedResponse.errno = (BigInteger) eventValues.getNonIndexedValues().get(0).getValue();
                return typedResponse;
            }
        });
    }

    public List<OwnerUpdateEventResponse> getOwnerUpdateEvents(TransactionReceipt transactionReceipt) {
        final Event event = new Event("OwnerUpdate", 
                Arrays.<TypeReference<?>>asList(),
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}, new TypeReference<Address>() {}));
        List<EventValuesWithLog> valueList = extractEventParametersWithLog(event, transactionReceipt);
        ArrayList<OwnerUpdateEventResponse> responses = new ArrayList<OwnerUpdateEventResponse>(valueList.size());
        for (EventValuesWithLog eventValues : valueList) {
            OwnerUpdateEventResponse typedResponse = new OwnerUpdateEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse._prevOwner = (String) eventValues.getNonIndexedValues().get(0).getValue();
            typedResponse._newOwner = (String) eventValues.getNonIndexedValues().get(1).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public Observable<OwnerUpdateEventResponse> ownerUpdateEventObservable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        final Event event = new Event("OwnerUpdate", 
                Arrays.<TypeReference<?>>asList(),
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}, new TypeReference<Address>() {}));
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(event));
        return web3j.ethLogObservable(filter).map(new Func1<Log, OwnerUpdateEventResponse>() {
            @Override
            public OwnerUpdateEventResponse call(Log log) {
                EventValuesWithLog eventValues = extractEventParametersWithLog(event, log);
                OwnerUpdateEventResponse typedResponse = new OwnerUpdateEventResponse();
                typedResponse.log = log;
                typedResponse._prevOwner = (String) eventValues.getNonIndexedValues().get(0).getValue();
                typedResponse._newOwner = (String) eventValues.getNonIndexedValues().get(1).getValue();
                return typedResponse;
            }
        });
    }

    public RemoteCall<String> keyIdentify(BigInteger _pidx) {
        final Function function = new Function("keyIdentify", 
                Arrays.<Type>asList(new Uint256(_pidx)),
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteCall<String> retriveAllEntry(BigInteger _pidx) {
        final Function function = new Function("retriveAllEntry", 
                Arrays.<Type>asList(new Uint256(_pidx)),
                Arrays.<TypeReference<?>>asList(new TypeReference<Utf8String>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteCall<Boolean> isDone(BigInteger _pidx) {
        final Function function = new Function("isDone", 
                Arrays.<Type>asList(new Uint256(_pidx)),
                Arrays.<TypeReference<?>>asList(new TypeReference<Bool>() {}));
        return executeRemoteCallSingleValueReturn(function, Boolean.class);
    }

    public RemoteCall<TransactionReceipt> setTokenOwner(BigInteger _pidx, String _key) {
        final Function function = new Function(
                "setTokenOwner", 
                Arrays.<Type>asList(new Uint256(_pidx),
                new Address(_key)),
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<BigInteger> ownerBlockNumber() {
        final Function function = new Function("ownerBlockNumber", 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteCall<Boolean> isPullDown(BigInteger _pidx) {
        final Function function = new Function("isPullDown", 
                Arrays.<Type>asList(new Uint256(_pidx)),
                Arrays.<TypeReference<?>>asList(new TypeReference<Bool>() {}));
        return executeRemoteCallSingleValueReturn(function, Boolean.class);
    }

    public RemoteCall<TransactionReceipt> kill() {
        final Function function = new Function(
                "kill", 
                Arrays.<Type>asList(), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<TransactionReceipt> appendEntryForBox(BigInteger _peroid, String _detailInfo) {
        final Function function = new Function(
                "appendEntryForBox", 
                Arrays.<Type>asList(new Uint256(_peroid),
                new Utf8String(_detailInfo)),
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<String> authorizedIdentify() {
        final Function function = new Function("authorizedIdentify", 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteCall<String> retriveEntryByPeroid(BigInteger _pidx, BigInteger _peroid) {
        final Function function = new Function("retriveEntryByPeroid", 
                Arrays.<Type>asList(new Uint256(_pidx),
                new Uint256(_peroid)),
                Arrays.<TypeReference<?>>asList(new TypeReference<Utf8String>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteCall<String> categoryIdentify() {
        final Function function = new Function("categoryIdentify", 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteCall<TransactionReceipt> acceptOwnership() {
        final Function function = new Function(
                "acceptOwnership", 
                Arrays.<Type>asList(), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<String> tokenIdentify() {
        final Function function = new Function("tokenIdentify", 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteCall<String> owner() {
        final Function function = new Function("owner", 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteCall<TransactionReceipt> withdrawERC20TokenAndWriteOff(BigInteger _pidx, String _key) {
        final Function function = new Function(
                "withdrawERC20TokenAndWriteOff", 
                Arrays.<Type>asList(new Uint256(_pidx),
                new Address(_key)),
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<BigInteger> getBN() {
        final Function function = new Function("getBN", 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteCall<TransactionReceipt> writeOff(BigInteger _pidx) {
        final Function function = new Function(
                "writeOff", 
                Arrays.<Type>asList(new Uint256(_pidx)),
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<String> retriveAllEntryFromBox() {
        final Function function = new Function("retriveAllEntryFromBox", 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Utf8String>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteCall<BigInteger> productTotal() {
        final Function function = new Function("productTotal", 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteCall<String> newOwner() {
        final Function function = new Function("newOwner", 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteCall<String> archivesIdentify() {
        final Function function = new Function("archivesIdentify", 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteCall<TransactionReceipt> appendEntry(BigInteger _pidx, BigInteger _peroid, String _detailInfo) {
        final Function function = new Function(
                "appendEntry", 
                Arrays.<Type>asList(new Uint256(_pidx),
                new Uint256(_peroid),
                new Utf8String(_detailInfo)),
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<TransactionReceipt> transferOwnership(String _newOwner) {
        final Function function = new Function(
                "transferOwnership", 
                Arrays.<Type>asList(new Address(_newOwner)),
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<TransactionReceipt> withdrawERC20Token(BigInteger _pidx, String _key) {
        final Function function = new Function(
                "withdrawERC20Token", 
                Arrays.<Type>asList(new Uint256(_pidx),
                new Address(_key)),
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public static RemoteCall<NewPackingBox> deploy(Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit, String _archives, String _category, String _token, String _authorized, BigInteger _amount, List<String> _keys) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new Address(_archives),
                new Address(_category),
                new Address(_token),
                new Address(_authorized),
                new Uint256(_amount),
                new org.web3j.abi.datatypes.DynamicArray<Address>(
                        org.web3j.abi.Utils.typeMap(_keys, Address.class))));
        return deployRemoteCall(NewPackingBox.class, web3j, credentials, gasPrice, gasLimit, BINARY, encodedConstructor);
    }

    public static RemoteCall<NewPackingBox> deploy(Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit, String _archives, String _category, String _token, String _authorized, BigInteger _amount, List<String> _keys) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new Address(_archives),
                new Address(_category),
                new Address(_token),
                new Address(_authorized),
                new Uint256(_amount),
                new org.web3j.abi.datatypes.DynamicArray<Address>(
                        org.web3j.abi.Utils.typeMap(_keys, Address.class))));
        return deployRemoteCall(NewPackingBox.class, web3j, transactionManager, gasPrice, gasLimit, BINARY, encodedConstructor);
    }

    public static NewPackingBox load(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return new NewPackingBox(contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    public static NewPackingBox load(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return new NewPackingBox(contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    public static class TransferProxyEventResponse {
        public Log log;

        public String _paddr;

        public String _taddr;

        public BigInteger _value;
    }

    public static class ResponseEventResponse {
        public Log log;

        public String from;

        public byte[] errmsg;

        public BigInteger errno;
    }

    public static class OwnerUpdateEventResponse {
        public Log log;

        public String _prevOwner;

        public String _newOwner;
    }
}
