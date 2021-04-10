package bd.com.appcore.qrcode;



public class QrCodeImportEvent {
    private int type;
    private String result;
    public QrCodeImportEvent(String result, int type) {
        this.result = result;
        this.type=type;
    }

    public String getResult() {
        return result;
    }

    public int getType() {
        return type;
    }
}
