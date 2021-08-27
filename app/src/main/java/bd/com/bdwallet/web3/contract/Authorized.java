package bd.com.bdwallet.web3.contract;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
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
import rx.Observable;
import rx.functions.Func1;

public class Authorized extends Contract {

    protected Authorized(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    protected Authorized(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, transactionManager, gasPrice, gasLimit);
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

    public RemoteCall<String> authorizedUsers() {
        final Function function = new Function("authorizedUsers", 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Utf8String>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteCall<String> authorizedAddresses() {
        final Function function = new Function("authorizedAddresses", 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Utf8String>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteCall<String> warrantInfo() {
        final Function function = new Function("warrantInfo", 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Utf8String>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteCall<TransactionReceipt> acceptOwnership() {
        final Function function = new Function(
                "acceptOwnership", 
                Arrays.<Type>asList(), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<Boolean> isAuthorizedForPack(String _addr, BigInteger _packType) {
        final Function function = new Function("isAuthorizedForPack", 
                Arrays.<Type>asList(new Address(_addr),
                new Uint256(_packType)),
                Arrays.<TypeReference<?>>asList(new TypeReference<Bool>() {}));
        return executeRemoteCallSingleValueReturn(function, Boolean.class);
    }

    public RemoteCall<TransactionReceipt> grantUserAll(String _addr) {
        final Function function = new Function(
                "grantUserAll", 
                Arrays.<Type>asList(new Address(_addr)),
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<String> owner() {
        final Function function = new Function("owner", 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteCall<TransactionReceipt> grantUser(String _addr, BigInteger _period, String _content, String _docAddress) {
        final Function function = new Function(
                "grantUser", 
                Arrays.<Type>asList(new Address(_addr),
                new Uint256(_period),
                new Utf8String(_content),
                new Address(_docAddress)),
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<String> alias() {
        final Function function = new Function("alias", 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Utf8String>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteCall<TransactionReceipt> removeGrantUserForPack(String _addr, BigInteger _packType) {
        final Function function = new Function(
                "removeGrantUserForPack", 
                Arrays.<Type>asList(new Address(_addr),
                new Uint256(_packType)),
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<TransactionReceipt> grantUserForPack(String _addr, BigInteger _packType) {
        final Function function = new Function(
                "grantUserForPack", 
                Arrays.<Type>asList(new Address(_addr),
                new Uint256(_packType)),
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<String> authorizedUsersForPack() {
        final Function function = new Function("authorizedUsersForPack", 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Utf8String>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteCall<String> newOwner() {
        final Function function = new Function("newOwner", 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteCall<TransactionReceipt> transferOwnership(String _newOwner) {
        final Function function = new Function(
                "transferOwnership", 
                Arrays.<Type>asList(new Address(_newOwner)),
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public static RemoteCall<Authorized> deploy(Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit, String _alias, List<String> _list) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new Utf8String(_alias),
                new org.web3j.abi.datatypes.DynamicArray<Address>(
                        org.web3j.abi.Utils.typeMap(_list, Address.class))));
        return deployRemoteCall(Authorized.class, web3j, credentials, gasPrice, gasLimit, BINARY, encodedConstructor);
    }

    public static RemoteCall<Authorized> deploy(Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit, String _alias, List<String> _list) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new Utf8String(_alias),
                new org.web3j.abi.datatypes.DynamicArray<Address>(
                        org.web3j.abi.Utils.typeMap(_list, Address.class))));
        return deployRemoteCall(Authorized.class, web3j, transactionManager, gasPrice, gasLimit, BINARY, encodedConstructor);
    }

    public static Authorized load(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return new Authorized(contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    public static Authorized load(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return new Authorized(contractAddress, web3j, transactionManager, gasPrice, gasLimit);
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
