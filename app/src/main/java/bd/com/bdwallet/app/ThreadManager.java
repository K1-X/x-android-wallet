package bd.com.bdwallet.app;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ThreadManager
{

    private static final int MAX_SIZE_BACKGROUND_THREAD_POOL = 2;
    private static ThreadManager mInstance = null;
    private Handler mMainHandler = null; //handler
    private Handler mLogicHandler = null; //logichandler，
    private HandlerThread mLogicHandlerThread = null; //logic
    private ExecutorService mWorkThreadPool = null; //，
    private ExecutorService mBgThreadPool = null; //，io    

     private ThreadManager()
    {
        getMainHandler();
        getLogicHandler();
    }

    public static ThreadManager getInstance()
    {
        if (mInstance == null)
        {
            synchronized (ThreadManager.class)
            {
                if (mInstance == null)
                {
                    mInstance = new ThreadManager();
                }
            }
        }
        return mInstance;
    }
}
