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


public class Category extends Contract {


    private static final String BINARY = "606060405234156200000d57fe5b60405162002be738038062002be7833981016040528080518201919060200180518201919050505b5b33600060006101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff1602179055505b81600390805190602001906200009092919062000376565b5060028054806001018281620000a79190620003fd565b916000526020600020900160005b33909190916101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff1602179055505062000116816200011f6401000000000262000686176401000000009004565b5b505062000454565b600060006000600060009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff163373ffffffffffffffffffffffffffffffffffffffff161415156200017f57fe5b600092505b8351831015620002dd5760009150600090505b6002805490508110156200024757600281815481101515620001b557fe5b906000526020600020900160005b9054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1684848151811015156200020757fe5b9060200190602002015173ffffffffffffffffffffffffffffffffffffffff16141562000238576001915062000247565b5b808060010191505062000197565b811515620002ce5760028054806001018281620002659190620003fd565b916000526020600020900160005b86868151811015156200028257fe5b90602001906020020151909190916101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff160217905550505b5b828060010193505062000184565b60405180807f736574417574686f72697a65644c69737420737563636573732e000000000000815250601a01905060405180910390203373ffffffffffffffffffffffffffffffffffffffff167f718cff2f30737c5a051976934736d5025bef9cea6b95e5c682a3d15353e3ab84600160018111156200035957fe5b6040518082815260200191505060405180910390a35b5b50505050565b828054600181600116156101000203166002900490600052602060002090601f016020900481019282601f10620003b957805160ff1916838001178555620003ea565b82800160010185558215620003ea579182015b82811115620003e9578251825591602001919060010190620003cc565b5b509050620003f991906200042c565b5090565b81548183558181151162000427578183600052602060002091820191016200042691906200042c565b5b505050565b6200045191905b808211156200044d57600081600090555060010162000433565b5090565b90565b61278380620004646000396000f300606060405236156100ad576000357c0100000000000000000000000000000000000000000000000000000000900463ffffffff16806306fdde03146100c857806315279260146101615780631ecb0f1a146101b857806352198741146102515780635a709acb146102ea57806373c691d91461038357806379ba50971461041c5780638da5cb5b1461042e578063d4ee1d9014610480578063f2fde38b146104d2578063f8cee9e914610508575b34156100b557fe5b6100c65b600015156100c357fe5b5b565b005b34156100d057fe5b6100d86105e8565b6040518080602001828103825283818151815260200191508051906020019080838360008314610127575b80518252602083111561012757602082019150602081019050602083039250610103565b505050905090810190601f1680156101535780820380516001836020036101000a031916815260200191505b509250505060405180910390f35b341561016957fe5b6101b6600480803590602001908201803590602001908080602002602001604051908101604052809392919081815260200183836020028082843782019150505050505091905050610686565b005b34156101c057fe5b6101c86108cf565b6040518080602001828103825283818151815260200191508051906020019080838360008314610217575b805182526020831115610217576020820191506020810190506020830392506101f3565b505050905090810190601f1680156102435780820380516001836020036101000a031916815260200191505b509250505060405180910390f35b341561025957fe5b610261610c4a565b60405180806020018281038252838181518152602001915080519060200190808383600083146102b0575b8051825260208311156102b05760208201915060208101905060208303925061028c565b505050905090810190601f1680156102dc5780820380516001836020036101000a031916815260200191505b509250505060405180910390f35b34156102f257fe5b6102fa610da1565b6040518080602001828103825283818151815260200191508051906020019080838360008314610349575b80518252602083111561034957602082019150602081019050602083039250610325565b505050905090810190601f1680156103755780820380516001836020036101000a031916815260200191505b509250505060405180910390f35b341561038b57fe5b61039361111c565b60405180806020018281038252838181518152602001915080519060200190808383600083146103e2575b8051825260208311156103e2576020820191506020810190506020830392506103be565b505050905090810190601f16801561040e5780820380516001836020036101000a031916815260200191505b509250505060405180910390f35b341561042457fe5b61042c6117bc565b005b341561043657fe5b61043e61199c565b604051808273ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200191505060405180910390f35b341561048857fe5b6104906119c2565b604051808273ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200191505060405180910390f35b34156104da57fe5b610506600480803573ffffffffffffffffffffffffffffffffffffffff169060200190919050506119e8565b005b341561051057fe5b6105e6600480803590602001908201803590602001908080601f0160208091040260200160405190810160405280939291908181526020018383808284378201915050505050509190803590602001908201803590602001908080601f0160208091040260200160405190810160405280939291908181526020018383808284378201915050505050509190803590602001908201803590602001908080601f01602080910402602001604051908101604052809392919081815260200183838082843782019150505050505091905050611ae5565b005b60038054600181600116156101000203166002900480601f01602080910402602001604051908101604052809291908181526020018280546001816001161561010002031660029004801561067e5780601f106106535761010080835404028352916020019161067e565b820191906000526020600020905b81548152906001019060200180831161066157829003601f168201915b505050505081565b600060006000600060009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff163373ffffffffffffffffffffffffffffffffffffffff161415156106e557fe5b600092505b83518310156108375760009150600090505b6002805490508110156107a65760028181548110151561071857fe5b906000526020600020900160005b9054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16848481518110151561076957fe5b9060200190602002015173ffffffffffffffffffffffffffffffffffffffff16141561079857600191506107a6565b5b80806001019150506106fc565b81151561082957600280548060010182816107c1919061265e565b916000526020600020900160005b86868151811015156107dd57fe5b90602001906020020151909190916101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff160217905550505b5b82806001019350506106ea565b60405180807f736574417574686f72697a65644c69737420737563636573732e000000000000815250601a01905060405180910390203373ffffffffffffffffffffffffffffffffffffffff167f718cff2f30737c5a051976934736d5025bef9cea6b95e5c682a3d15353e3ab84600160018111156108b257fe5b6040518082815260200191505060405180910390a35b5b50505050565b6108d761268a565b60006108e161268a565b600091505b600580549050821015610c44573373ffffffffffffffffffffffffffffffffffffffff1660058381548110151561091957fe5b906000526020600020900160005b9054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff161415610c36576109e3600460003373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200190815260200160002060020160009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16611efc565b9050610b018382604060405190810160405280600181526020017f2600000000000000000000000000000000000000000000000000000000000000815250600460003373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1681526020019081526020016000206003018054600181600116156101000203166002900480601f016020809104026020016040519081016040528092919081815260200182805460018160011615610100020316600290048015610af75780601f10610acc57610100808354040283529160200191610af7565b820191906000526020600020905b815481529060010190602001808311610ada57829003601f168201915b505050505061210a565b9250610c2f83604060405190810160405280600181526020017f2600000000000000000000000000000000000000000000000000000000000000815250600460003373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1681526020019081526020016000206001018054600181600116156101000203166002900480601f016020809104026020016040519081016040528092919081815260200182805460018160011615610100020316600290048015610c145780601f10610be957610100808354040283529160200191610c14565b820191906000526020600020905b815481529060010190602001808311610bf757829003601f168201915b5050505050602060405190810160405280600081525061210a565b9250610c44565b5b81806001019250506108e6565b5b505090565b610c5261268a565b6000600090505b600280549050811015610d9c57600160028054905003811415610ce057610cd982610cd4600284815481101515610c8c57fe5b906000526020600020900160005b9054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16611efc565b61247d565b9150610d8e565b610d8b82610d3e600284815481101515610cf657fe5b906000526020600020900160005b9054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16611efc565b6020604051908101604052806000815250604060405190810160405280600181526020017f240000000000000000000000000000000000000000000000000000000000000081525061210a565b91505b5b8080600101915050610c59565b5b5090565b610da961268a565b6000610db361268a565b600091505b600580549050821015611116573373ffffffffffffffffffffffffffffffffffffffff16600583815481101515610deb57fe5b906000526020600020900160005b9054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16141561110857610eb5600460003373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200190815260200160002060020160009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16611efc565b9050610fd38382604060405190810160405280600181526020017f2600000000000000000000000000000000000000000000000000000000000000815250600460003373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1681526020019081526020016000206003018054600181600116156101000203166002900480601f016020809104026020016040519081016040528092919081815260200182805460018160011615610100020316600290048015610fc95780601f10610f9e57610100808354040283529160200191610fc9565b820191906000526020600020905b815481529060010190602001808311610fac57829003601f168201915b505050505061210a565b925061110183604060405190810160405280600181526020017f2600000000000000000000000000000000000000000000000000000000000000815250600460003373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1681526020019081526020016000206000018054600181600116156101000203166002900480601f0160208091040260200160405190810160405280929190818152602001828054600181600116156101000203166002900480156110e65780601f106110bb576101008083540402835291602001916110e6565b820191906000526020600020905b8154815290600101906020018083116110c957829003601f168201915b5050505050602060405190810160405280600081525061210a565b9250611116565b5b8180600101925050610db8565b5b505090565b61112461268a565b600061112e61268a565b600091505b6005805490508210156117b6576111fc6004600060058581548110151561115657fe5b906000526020600020900160005b9054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200190815260200160002060020160009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16611efc565b90506113558382604060405190810160405280600181526020017f26000000000000000000000000000000000000000000000000000000000000008152506004600060058881548110151561124d57fe5b906000526020600020900160005b9054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1681526020019081526020016000206003018054600181600116156101000203166002900480601f01602080910402602001604051908101604052809291908181526020018280546001816001161561010002031660029004801561134b5780601f106113205761010080835404028352916020019161134b565b820191906000526020600020905b81548152906001019060200180831161132e57829003601f168201915b505050505061210a565b92506114e483604060405190810160405280600181526020017f2600000000000000000000000000000000000000000000000000000000000000815250600460006005878154811015156113a557fe5b906000526020600020900160005b9054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1681526020019081526020016000206001018054600181600116156101000203166002900480601f0160208091040260200160405190810160405280929190818152602001828054600181600116156101000203166002900480156114a35780601f10611478576101008083540402835291602001916114a3565b820191906000526020600020905b81548152906001019060200180831161148657829003601f168201915b5050505050604060405190810160405280600181526020017f260000000000000000000000000000000000000000000000000000000000000081525061210a565b925060016005805490500382141561163e57611637836004600060058681548110151561150d57fe5b906000526020600020900160005b9054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1681526020019081526020016000206000018054600181600116156101000203166002900480601f01602080910402602001604051908101604052809291908181526020018280546001816001161561010002031660029004801561160b5780601f106115e05761010080835404028352916020019161160b565b820191906000526020600020905b8154815290600101906020018083116115ee57829003601f168201915b50505050506020604051908101604052806000815250602060405190810160405280600081525061210a565b92506117a8565b6117a5836004600060058681548110151561165557fe5b906000526020600020900160005b9054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1681526020019081526020016000206000018054600181600116156101000203166002900480601f0160208091040260200160405190810160405280929190818152602001828054600181600116156101000203166002900480156117535780601f1061172857610100808354040283529160200191611753565b820191906000526020600020905b81548152906001019060200180831161173657829003601f168201915b5050505050604060405190810160405280600181526020017f2400000000000000000000000000000000000000000000000000000000000000815250602060405190810160405280600081525061210a565b92505b5b8180600101925050611133565b5b505090565b600160009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff163373ffffffffffffffffffffffffffffffffffffffff161415156118195760006000fd5b7f343765429aea5a34b3ff6a3785a98a5abb2597aca87bfbb58632c173d585373a600060009054906101000a900473ffffffffffffffffffffffffffffffffffffffff16600160009054906101000a900473ffffffffffffffffffffffffffffffffffffffff16604051808373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1681526020018273ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1681526020019250505060405180910390a1600160009054906101000a900473ffffffffffffffffffffffffffffffffffffffff16600060006101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff1602179055506000600160006101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff1602179055505b565b600060009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1681565b600160009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1681565b600060009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff163373ffffffffffffffffffffffffffffffffffffffff16141515611a4157fe5b600060009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff168173ffffffffffffffffffffffffffffffffffffffff1614151515611a9f5760006000fd5b80600160006101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff1602179055505b5b50565b600060006000600060009150600090505b600280549050811015611b89573373ffffffffffffffffffffffffffffffffffffffff16600282815481101515611b2957fe5b906000526020600020900160005b9054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff161415611b7b5760019150611b89565b5b8080600101915050611af6565b811515611b965760006000fd5b600087511480611ba7575060008651145b15611c415760405180807f496e76616c696420506172616d2e000000000000000000000000000000000000815250600e01905060405180910390203373ffffffffffffffffffffffffffffffffffffffff167f718cff2f30737c5a051976934736d5025bef9cea6b95e5c682a3d15353e3ab8460006001811115611c2757fe5b6040518082815260200191505060405180910390a3611ef2565b6080604051908101604052808781526020018881526020013373ffffffffffffffffffffffffffffffffffffffff16815260200186815250600460003373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1681526020019081526020016000206000820151816000019080519060200190611cd492919061269e565b506020820151816001019080519060200190611cf192919061269e565b5060408201518160020160006101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff1602179055506060820151816003019080519060200190611d5592919061269e565b5090505060009350600092505b600580549050831015611df5573373ffffffffffffffffffffffffffffffffffffffff16600584815481101515611d9557fe5b906000526020600020900160005b9054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff161415611de75760019350611df5565b5b8280600101935050611d62565b831515611e615760058054806001018281611e10919061265e565b916000526020600020900160005b33909190916101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff160217905550505b60405180807f75706461746542617365496e666f20737563636573732e000000000000000000815250601701905060405180910390203373ffffffffffffffffffffffffffffffffffffffff167f718cff2f30737c5a051976934736d5025bef9cea6b95e5c682a3d15353e3ab8460016001811115611edc57fe5b6040518082815260200191505060405180910390a35b5b50505050505050565b611f0461268a565b60006000602a604051805910611f175750595b908082528060200260200182016040525b5092507f3000000000000000000000000000000000000000000000000000000000000000836000815181101515611f5b57fe5b9060200101907effffffffffffffffffffffffffffffffffffffffffffffffffffffffffffff1916908160001a9053507f7800000000000000000000000000000000000000000000000000000000000000836001815181101515611fbb57fe5b9060200101907effffffffffffffffffffffffffffffffffffffffffffffffffffffffffffff1916908160001a905350602991505b60028260ff1610151561210257600f8416905060108481151561200f57fe5b049350600a8160ff16101561208a57603081017f010000000000000000000000000000000000000000000000000000000000000002838360ff1681518110151561205557fe5b9060200101907effffffffffffffffffffffffffffffffffffffffffffffffffffffffffffff1916908160001a9053506120f5565b6061600a8203017f010000000000000000000000000000000000000000000000000000000000000002838360ff168151811015156120c457fe5b9060200101907effffffffffffffffffffffffffffffffffffffffffffffffffffffffffffff1916908160001a9053505b5b81600190039150611ff0565b5b5050919050565b61211261268a565b61211a61271e565b61212261271e565b61212a61271e565b61213261271e565b61213a61268a565b61214261271e565b600060008c97508b96508a95508994508451865188518a5101010160405180591061216a5750595b908082528060200260200182016040525b50935083925060009150600090505b875181101561223e5787818151811015156121a157fe5b9060200101517f010000000000000000000000000000000000000000000000000000000000000090047f010000000000000000000000000000000000000000000000000000000000000002838380600101945081518110151561220057fe5b9060200101907effffffffffffffffffffffffffffffffffffffffffffffffffffffffffffff1916908160001a9053505b808060010191505061218a565b600090505b86518110156122f757868181518110151561225a57fe5b9060200101517f010000000000000000000000000000000000000000000000000000000000000090047f01000000000000000000000000000000000000000000000000000000000000000283838060010194508151811015156122b957fe5b9060200101907effffffffffffffffffffffffffffffffffffffffffffffffffffffffffffff1916908160001a9053505b8080600101915050612243565b600090505b85518110156123b057858181518110151561231357fe5b9060200101517f010000000000000000000000000000000000000000000000000000000000000090047f010000000000000000000000000000000000000000000000000000000000000002838380600101945081518110151561237257fe5b9060200101907effffffffffffffffffffffffffffffffffffffffffffffffffffffffffffff1916908160001a9053505b80806001019150506122fc565b600090505b84518110156124695784818151811015156123cc57fe5b9060200101517f010000000000000000000000000000000000000000000000000000000000000090047f010000000000000000000000000000000000000000000000000000000000000002838380600101945081518110151561242b57fe5b9060200101907effffffffffffffffffffffffffffffffffffffffffffffffffffffffffffff1916908160001a9053505b80806001019150506123b5565b8398505b5050505050505050949350505050565b61248561268a565b61248d61271e565b61249561271e565b61249d61268a565b6124a561271e565b6000600088955087945084518651016040518059106124c15750595b908082528060200260200182016040525b50935083925060009150600090505b85518110156125955785818151811015156124f857fe5b9060200101517f010000000000000000000000000000000000000000000000000000000000000090047f010000000000000000000000000000000000000000000000000000000000000002838380600101945081518110151561255757fe5b9060200101907effffffffffffffffffffffffffffffffffffffffffffffffffffffffffffff1916908160001a9053505b80806001019150506124e1565b600090505b845181101561264e5784818151811015156125b157fe5b9060200101517f010000000000000000000000000000000000000000000000000000000000000090047f010000000000000000000000000000000000000000000000000000000000000002838380600101945081518110151561261057fe5b9060200101907effffffffffffffffffffffffffffffffffffffffffffffffffffffffffffff1916908160001a9053505b808060010191505061259a565b8396505b50505050505092915050565b815481835581811511612685578183600052602060002091820191016126849190612732565b5b505050565b602060405190810160405280600081525090565b828054600181600116156101000203166002900490600052602060002090601f016020900481019282601f106126df57805160ff191683800117855561270d565b8280016001018555821561270d579182015b8281111561270c5782518255916020019190600101906126f1565b5b50905061271a9190612732565b5090565b602060405190810160405280600081525090565b61275491905b80821115612750576000816000905550600101612738565b5090565b905600a165627a7a72305820701ed670b16d23664e7c5d81c3cb943ebfd91ec0d75892dea1651056300759680029";

    protected Category(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    protected Category(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
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

    public RemoteCall<String> name() {
        final Function function = new Function("name", 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Utf8String>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteCall<TransactionReceipt> setAuthorizedList(List<String> _list) {
        final Function function = new Function(
                "setAuthorizedList", 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.DynamicArray<Address>(
                        org.web3j.abi.Utils.typeMap(_list, Address.class))),
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<String> getTechnology() {
        final Function function = new Function("getTechnology", 
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

    public RemoteCall<String> getMaterial() {
        final Function function = new Function("getMaterial", 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Utf8String>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteCall<String> getCategoryInfo() {
        final Function function = new Function("getCategoryInfo", 
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

    public RemoteCall<String> owner() {
        final Function function = new Function("owner", 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}));
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

    public RemoteCall<TransactionReceipt> updateBaseInfo(String _technology, String _material, String _operatorName) {
        final Function function = new Function(
                "updateBaseInfo", 
                Arrays.<Type>asList(new Utf8String(_technology),
                new Utf8String(_material),
                new Utf8String(_operatorName)),
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public static RemoteCall<Category> deploy(Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit, String _name, List<String> _list) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new Utf8String(_name),
                new org.web3j.abi.datatypes.DynamicArray<Address>(
                        org.web3j.abi.Utils.typeMap(_list, Address.class))));
        return deployRemoteCall(Category.class, web3j, credentials, gasPrice, gasLimit, BINARY, encodedConstructor);
    }

    public static RemoteCall<Category> deploy(Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit, String _name, List<String> _list) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new Utf8String(_name),
                new org.web3j.abi.datatypes.DynamicArray<Address>(
                        org.web3j.abi.Utils.typeMap(_list, Address.class))));
        return deployRemoteCall(Category.class, web3j, transactionManager, gasPrice, gasLimit, BINARY, encodedConstructor);
    }

    public static Category load(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return new Category(contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    public static Category load(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return new Category(contractAddress, web3j, transactionManager, gasPrice, gasLimit);
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
