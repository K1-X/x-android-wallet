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

    public Handler getMainHandler()
    {
        if (mMainHandler == null)
        {
            synchronized (this)
            {
                if (mMainHandler == null)
                {
                    mMainHandler = new Handler(Looper.getMainLooper());
                }
            }
        }
        return mMainHandler;
    }

    public void postUITask(Runnable runnable)
    {
        postDelayedUITask(runnable, 0);
    }

    public void postDelayedUITask(Runnable runnable, long delayTime)
    {
        if (mMainHandler != null)
        {
            mMainHandler.postDelayed(runnable, delayTime);
        }
    }

    public void postFrontUITask(Runnable runnable)
    {
        if (mMainHandler != null)
        {
            mMainHandler.postAtFrontOfQueue(runnable);
        }
    }

    public void removeUITask(Runnable runnable)
    {
        if (mMainHandler != null)
        {
            mMainHandler.removeCallbacks(runnable);
        }
    }

    public Handler getLogicHandler()
    {
        if (mLogicHandler == null)
        {
            synchronized (this)
            {
                if (mLogicHandler == null)
                {
                    mLogicHandlerThread = new HandlerThread("HD_LOGIC_THREAD");
                    mLogicHandlerThread.start();
                    mLogicHandler = new Handler(mLogicHandlerThread.getLooper());
                }
            }
        }
        return mLogicHandler;
    }

    public void postLogicTask(Runnable runnable)
    {
        postDelayedLogicTask(runnable, 0);
    }

    public void postDelayedLogicTask(Runnable runnable, long delayTime)
    {
        if (mLogicHandler != null)
        {
            mLogicHandler.postDelayed(runnable, delayTime);
        }
    }
}
