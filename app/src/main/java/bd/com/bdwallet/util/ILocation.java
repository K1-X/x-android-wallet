package bd.com.bdwallet.util;


public interface ILocation {
    void init();
    void start();
    void stop();
    void destory();

    String getLastCity();
}
