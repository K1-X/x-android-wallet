package bd.com.bdwallet.event;

import android.content.Context;

import org.w3c.dom.Node;
import org.web3j.crypto.Wallet;
import org.web3j.protocol.core.methods.request.Transaction;


public class EventPublisher {

private static final String TAG = "Portal.EventPublisher";

    public static final String ACTION_LOGIN = "com.juzix.wallet.ACTION_LOGIN";

    private Context context;

    private static EventPublisher instance = new EventPublisher();

    private EventPublisher() {
    }

    public static EventPublisher getInstance() {
        return instance;
    }

    public void init(Context context) {
        this.context = context;
    }

    public static String getTag() {
        return TAG;
    }

    public void register(Object obj) {
        BusProvider.register(obj);
    }

    public void unRegister(Object obj) {
        BusProvider.unRegister(obj);
    }



    public void sendUpdateTransactionEvent(Transaction transaction) {
        BusProvider.post(new Event.UpdateTransactionEvent(transaction));
    }  
}
