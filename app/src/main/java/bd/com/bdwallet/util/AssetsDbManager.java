package bd.com.bdwallet.util;

import android.content.res.AssetManager;
import android.util.Log;

import com.google.gson.reflect.TypeToken;

import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import bd.com.appcore.util.GsonUtil;
import bd.com.bdwallet.app.BdApplication;
import bd.com.bdwallet.module.news.domain.News;


public class AssetsDbManager {
 
    private static final String BANNER_LIST = "banner.json";
    private static final String NEWS_LIST = "news.json";
    public static final String JSON_LIST_KEY = "list";

    private static String TAG = AssetsDbManager.class.getSimpleName(); // for LogCat    

    public static List<News> getNewsList() {
        try {
            //JSONobject
            JSONObject jsonObject = new JSONObject(getJsonFromAssets(NEWS_LIST));
            String jsonArray = jsonObject.getString(JSON_LIST_KEY);
            TypeToken<ArrayList<News>> typeToken = new TypeToken<ArrayList<News>>() {
            };
            return GsonUtil.jsonToListObject(jsonArray, typeToken);
        } catch (Exception e) {
            Log.e(TAG, "json parse error msg::" + e.getMessage());
            return null;
        }

    }

    public static List<News> getBannerList() {
        try {
            //JSONobject
            JSONObject jsonObject = new JSONObject(getJsonFromAssets(BANNER_LIST));
            String jsonArray = jsonObject.getString(JSON_LIST_KEY);
            TypeToken<ArrayList<News>> typeToken = new TypeToken<ArrayList<News>>() {
            };
            return GsonUtil.jsonToListObject(jsonArray, typeToken);
        } catch (Exception e) {
            Log.e(TAG, "getGuidInfos json prase error msg::" + e.getMessage());
            return null;
        }

    }
}
