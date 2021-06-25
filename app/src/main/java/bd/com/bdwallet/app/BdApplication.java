package bd.com.bdwallet.app;

import android.content.Context;
import android.support.multidex.MultiDex;
import android.text.TextUtils;
import android.util.Log;

import com.tencent.bugly.crashreport.CrashReport;
import com.tencent.smtt.sdk.QbSdk;
import com.yanzhenjie.nohttp.Logger;
import com.yanzhenjie.nohttp.NoHttp;

import bd.com.appcore.CoreApp;
import bd.com.appcore.CustomerException;
import bd.com.appcore.util.AppSettings;
import bd.com.bdwallet.Config;
import bd.com.bdwallet.module.async.BlockNumberAsync;
import bd.com.bdwallet.module.common.AppFilePath;
import bd.com.bdwallet.module.common.lvadapter.AppDataInitor;
import bd.com.bdwallet.module.push.manager.PushManager;
import bd.com.bdwallet.module.transaction.model.EnvModel;
import bd.com.bdwallet.module.user.lockpattern.LockPatternCallback;
import bd.com.bdwallet.module.wallet.ApiConfig;
import bd.com.bdwallet.util.AppCacheUitl;
import bd.com.bdwallet.util.LocationUtils;
import bd.com.bdwallet.util.ProcessUtil;
import bd.com.walletdb.GreendaoFactory;
import cn.jpush.android.api.JPushInterface;


public class BdApplication extends CoreApp {

    @Override
    public void onCreate() {
        super.onCreate();
        AppFilePath.init(this);
        CustomerException.getExceptionControl().init(context);
        AppSettings.getAppSettings().init(this);
        GreendaoFactory.make(this);
        GreendaoFactory.makeTx(this);
        GreendaoFactory.makeContact(this);
        NoHttp.initialize(this);
        Logger.setDebug(true);// NoHttp, 、。
        Logger.setTag("Nohttp");
        resetDB();

        initChanin();
        //jpush
        JPushInterface.setDebugMode(true);    // ,
        JPushInterface.init(this);            //  JPush
        //JPUSH
        PushManager.init(this);
        initBugly();
        AppDataInitor.getInitor().init();
        // CoinService.getService().start();
        BlockNumberAsync.getAsync().init();
        EnvModel.getInstance().init();
        /**
         * 
         */
        registerActivityLifecycleCallbacks(new LockPatternCallback());
        initUmeng();
        QbSdk.initX5Environment(this,null);
        Log.e("location", LocationUtils.sHA1(this));
    }


    private void initUmeng() {
        /**
         * : AndroidManifest.xmlappkeychannel，App
         * （AndroidManifest.xmlappkeychannel，
         * UMConfigure.initappkeychannelnull）。
         */
//        UMConfigure.init(this,   UMConfigure.DEVICE_TYPE_PHONE, null);
//        // AUTO
//        MobclickAgent.setPageCollectionMode(MobclickAgent.PageMode.AUTO);
    }    

    /**
     * bugly
     */
    private void initBugly() {
        Context context = getApplicationContext();
        // 
        String packageName = context.getPackageName();
        // 
        String processName = ProcessUtil.getProcessName(android.os.Process.myPid());
        // 
        CrashReport.UserStrategy strategy = new CrashReport.UserStrategy(context);
        strategy.setUploadProcess(processName == null || processName.equals(packageName));
        // Bugly
        boolean enableBugly = AppSettings.getAppSettings().getEnableBugly();
        CrashReport.initCrashReport(context, Config.BUGLY_APP_ID, true, strategy);
        // “AndroidManifest.xml”APP，
        // CrashReport.initCrashReport(context, strategy

    }
}
