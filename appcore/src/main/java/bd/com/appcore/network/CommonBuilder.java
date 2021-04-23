package bd.com.appcore.network;

import android.text.TextUtils;
import android.util.Log;

import com.yanzhenjie.nohttp.NoHttp;
import com.yanzhenjie.nohttp.RequestMethod;
import com.yanzhenjie.nohttp.rest.Request;
import com.yanzhenjie.nohttp.rest.Response;
import com.yanzhenjie.nohttp.rest.SimpleResponseListener;

import org.json.JSONObject;

import java.lang.reflect.ParameterizedType;
import java.util.Map;

import bd.com.appcore.base.ModelCallBack;
import bd.com.appcore.util.GsonUtil;

public abstract class CommonBuilder<T> {

private String TAG = CommonBuilder.class.getSimpleName();

    public abstract String getUrl();

    public abstract RequestMethod getMethod();

     private Map<String, String> headers;
    private Object reqBean;

    public CommonBuilder<T> addHeader(Map<String, Object> headers) {
        headers.putAll(headers);
        return this;
    }    
    
    public CommonBuilder<T> addBody(Object reqBean) {
        this.reqBean = reqBean;
        return this;
    }

}
