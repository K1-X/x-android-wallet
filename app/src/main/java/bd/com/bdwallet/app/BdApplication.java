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

    
}
