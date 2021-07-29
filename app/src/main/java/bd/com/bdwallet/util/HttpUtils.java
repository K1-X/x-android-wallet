package bd.com.bdwallet.util;

import android.util.Log;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;

public class HttpUtils {

    public static OkHttpClient createOkHttpClient() {
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        builder.connectTimeout(15_1000, TimeUnit.MILLISECONDS);
        builder.writeTimeout(15_1000, TimeUnit.MILLISECONDS);
        builder.readTimeout(15_1000, TimeUnit.MILLISECONDS);
        configureLogging(builder);
        return builder.build();
    }    
}
