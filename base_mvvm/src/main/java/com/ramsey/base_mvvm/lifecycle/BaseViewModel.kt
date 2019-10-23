package com.ramsey.base_mvvm.lifecycle

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel

import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable

/**
 *
 * @author 阿钟
 */

abstract class BaseViewModel : ViewModel() {

    /**
     * 管理RxJava请求
     */
    private var compositeDisposable: CompositeDisposable? = null
    /**
     * 用来通知 Activity／Fragment 是否显示等待Dialog
     */
    //    protected DialogLiveData<DialogBean> showDialog = new DialogLiveData<>();
    /**
     * 当ViewModel层出现错误需要通知到Activity／Fragment
     */
    protected var error: MutableLiveData<Any>? = MutableLiveData()

    /**
     * 添加 rxJava 发出的请求
     */
    protected fun addDisposable(disposable: Disposable) {
        if (compositeDisposable == null || compositeDisposable!!.isDisposed) {
            compositeDisposable = CompositeDisposable()
        }
        compositeDisposable!!.add(disposable)
    }

    //    public void getShowDialog(LifecycleOwner owner, Observer<DialogBean> observer) {
    //        showDialog.observe(owner, observer);
    //    }

    fun getError(owner: LifecycleOwner, observer: Observer<Any>) {
        error!!.observe(owner, observer)
    }

    /**
     * ViewModel销毁同时也取消请求
     */
    override fun onCleared() {
        super.onCleared()
        if (compositeDisposable != null) {
            compositeDisposable!!.dispose()
            compositeDisposable = null
        }
        //        showDialog = null;
        error = null
    }
}
