package bd.com.bdwallet.event;


import org.w3c.dom.Node;
import org.web3j.crypto.Wallet;
import org.web3j.protocol.core.methods.request.Transaction;

public class Event {


    private Event() {

    }



    public static class UpdateTransactionEvent {

        public Transaction transaction;

        public UpdateTransactionEvent(Transaction transaction) {
            this.transaction = transaction;
        }
    }    

    public static class DeleteTransactionEvent {

        public Transaction transaction;

        public DeleteTransactionEvent(Transaction transaction) {
            this.transaction = transaction;
        }
    }

    public static class UpdateSelectedWalletEvent {

        public Wallet walletEntity;

        public UpdateSelectedWalletEvent(Wallet walletEntity) {
            this.walletEntity = walletEntity;
        }
    }

    public static class UpdateSharedWalletUnreadMessageEvent {

        public String contractAddress;
        public boolean hasUnreadMessage;

        public UpdateSharedWalletUnreadMessageEvent(String contractAddress, boolean hasUnreadMessage) {
            this.contractAddress = contractAddress;
            this.hasUnreadMessage = hasUnreadMessage;
        }
    }
 
    public static class UpdateTransactionUnreadMessageEvent {

        public String uuid;
        /**
         * 
         */
        public boolean hasUnread;

        public UpdateTransactionUnreadMessageEvent(String uuid, boolean hasUnread) {
            this.uuid = uuid;
            this.hasUnread = hasUnread;
        }
    }

    public static class UpdateWalletListEvent {

        public UpdateWalletListEvent() {
        }
    }

    public static class UpdateAssetsTabEvent {
        public int tabIndex;

        public UpdateAssetsTabEvent(int tabIndex) {
            this.tabIndex = tabIndex;
        }
    }

    public static class NodeChangedEvent {

        public Node nodeEntity;

        public NodeChangedEvent(Node nodeEntity) {
            this.nodeEntity = nodeEntity;
        }
    }

    public static class UpdateDelegateDetailEvent {

        public UpdateDelegateDetailEvent() {
        }
    }

    public static class UpdateValidatorsDetailEvent {
        public UpdateValidatorsDetailEvent() {
        }
    }

    public static class UpdateDelegateTabEvent {
        public UpdateDelegateTabEvent() {
        }
    }

    public static class UpdateValidatorsTabEvent {
        public UpdateValidatorsTabEvent() {
        }
    }

    public static class UpdateTabChangeEvent {
        public UpdateTabChangeEvent() {

        }
    }

    public static class UpdateRefreshPageEvent {
        public UpdateRefreshPageEvent() {

        }
    }

    /**
     * 
     */
    public static class WalletListOrderChangedEvent {

        public WalletListOrderChangedEvent() {

        }
    }

    public static class SumAccountBalanceChanged {

        public SumAccountBalanceChanged() {
        }
    }
    public static class  MyDelegateGuide{
        public MyDelegateGuide(){

        }
    }

    public static  class  ValidatorsGuide{
        public ValidatorsGuide(){

        }
    }
}
