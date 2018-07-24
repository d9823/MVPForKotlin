package com.zhbf.zdd.base

import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable

/**
 * @author Created by ZhiBanQian on 2018/7/3.
 * Congratulations to the pit
 * May God bless you
 */
open class BasePresenter<T : IBaseView> : IPresenter<T> {
    var mRootView: T? = null
        private set

    private var compositeDisposable = CompositeDisposable()


    override fun detachView() {
        mRootView = null

        //保证activity结束时取消所有正在执行的订阅
        if (!compositeDisposable.isDisposed) {
            compositeDisposable.clear()
        }
    }
    override fun attachView(mRootView: T) {
        this.mRootView = mRootView
    }

    fun addSubscription(disposable: Disposable) {
        compositeDisposable.add(disposable)
    }
}