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
}
