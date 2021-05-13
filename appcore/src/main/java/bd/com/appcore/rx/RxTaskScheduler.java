package bd.com.appcore.rx;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class RxTaskScheduler {

    /**
     * ，
     * onStart：
     * onSuccess：,UI
     * onFailed：，UI
     * onComplete：，UI
     * @param rxTaskCallBack
     * @param <T>             Scheduler。 CPU ， I/O ，
     *                       。 Scheduler ， CPU 。
     *                        I/O  computation() ， I/O  CPU。
     */
    public static <T> void postLogicMainTask(final RxTaskCallBack<T> rxTaskCallBack) {
        Observable.create(new ObservableOnSubscribe<T>() {
            @Override
            public void subscribe(ObservableEmitter<T> e) throws Exception {
                T t = rxTaskCallBack.doWork();
                if (t != null) {
                    e.onNext(t);
                } else {
                    postUiTask(new RxTaskCallBack<Boolean>() {
                        @Override
                        public Boolean doWork() {
                            rxTaskCallBack.onSuccess(null);
                            return true;
                        }
                    });
                }
                e.onComplete();
            }
        })
                .subscribeOn(Schedulers.computation())
                .observeOn(AndroidSchedulers.mainThread())
                .safeSubscribe(new Observer<T>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        rxTaskCallBack.onStart(d);
                    }

                    @Override
                    public void onNext(T t) {
                        rxTaskCallBack.onSuccess(t);
                    }

                    @Override
                    public void onError(Throwable e) {
                        rxTaskCallBack.onFailed(new LogicException(e,-1));
                    }

                    @Override
                    public void onComplete() {
                        rxTaskCallBack.onComplete();
                    }
                });
    }

    /**
     * I/O （、、） Scheduler。
     *
     * ，
     * onStart：
     * onSuccess：,UI
     * onFailed：，UI
     * onComplete：，UI
     * @param rxTaskCallBack
     * @param <T>
     */
    public static <T> void postIoMainTask(final RxTaskCallBack<T> rxTaskCallBack) {
        Observable.create(new ObservableOnSubscribe<T>() {
            @Override
            public void subscribe(ObservableEmitter<T> e) throws Exception {
                T t = rxTaskCallBack.doWork();
                if (t != null) {
                    e.onNext(t);
                } else {
                    postUiTask(new RxTaskCallBack<Boolean>() {
                        @Override
                        public Boolean doWork() {
                            rxTaskCallBack.onSuccess(null);
                            return true;
                        }
                    });
                }
                e.onComplete();
            }
        })
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .safeSubscribe(new Observer<T>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        rxTaskCallBack.onStart(d);
                    }

                    @Override
                    public void onNext(T t) {
                        rxTaskCallBack.onSuccess(t);
                    }

                    @Override
                    public void onError(Throwable e) {
                        if(e instanceof LogicException){
                            rxTaskCallBack.onFailed((LogicException) e);
                        }else {
                            rxTaskCallBack.onFailed(new LogicException(e, -1));
                        }
                    }

                    @Override
                    public void onComplete() {
                        rxTaskCallBack.onComplete();
                    }
                });
    }
}

