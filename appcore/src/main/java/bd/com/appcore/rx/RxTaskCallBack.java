package bd.com.appcore.rx;

import io.reactivex.disposables.Disposable;

/**
 * author:     labixiaoxin
 * date:       2018/5/4
 * email:      labixiaoxin2@qq.cn
 *
 * observeOn(Schedulers.newThread() onComplete，onErrorOnext
 * ，catch，oError。，
 * subscribeOn(Schedulers.newThread())call（）， ，
 * onStart()  subscribe ，，onError。。
 */
public abstract class RxTaskCallBack<T> implements BaseRxTask<T> {
    private Disposable disposable;

    public RxTaskCallBack(){

    }
    @Override
    public void onStart(Disposable disposable) {
        //，，dialog（，，
        // dialog）
        this.disposable=disposable;
    }

    @Override
    public void onComplete() {
        //，dialog
        if(disposable!=null&&!disposable.isDisposed()){
            disposable.dispose();
        }
    }

    @Override
    public void onFailed(LogicException e) {
        //
        //
        if(disposable!=null&&!disposable.isDisposed()){
            disposable.dispose();
        }
    }

    @Override
    public void onSuccess(T t) {

    }

    /**
     * ，，，
     */
    public void cancel(){
        if(disposable!=null){
            disposable.dispose();
        }
    }
}
