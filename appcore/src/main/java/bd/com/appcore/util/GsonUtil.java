package bd.com.appcore.util;

import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;


public class GsonUtil {

    private static GsonBuilder builder = new GsonBuilder();
    private static Gson gson = builder.create();

    /**
     * @param jsonStr
     * @param type
     * @param <T>
     * @return
     */
    public static <T> T jsonToObject(String jsonStr, Type type) {
        T t = null;
        try {
            t = gson.fromJson(jsonStr, type);
        } catch (Exception e) {
            Log.e("GsonUtil error", "json " + e);
        }
        return t;
    }

    /**
     * :
     * TypeToken<ArrayList<MyItem>> typeToken = new TypeToken<ArrayList<MyItem>>(){};
     * ArrayList<MyItem> arrayList = getArray(typeToken);
     *
     * @param jsonStr
     * @param typeToken
     * @param <T>
     * @return
     */
    public static <T> ArrayList<T> jsonToListObject(String jsonStr, TypeToken typeToken) {
        if (jsonStr != null) {
            try {
                return (ArrayList<T>) gson.fromJson(jsonStr, typeToken.getType());
            } catch (Exception e) {
                Log.e("GsonUtil error", "json " + e);
            }
        }
        return null;
    }    
}
