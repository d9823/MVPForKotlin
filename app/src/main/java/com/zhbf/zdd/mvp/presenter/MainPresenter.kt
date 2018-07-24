package com.zhbf.zdd.mvp.presenter

import com.zhbf.zdd.base.BasePresenter
import com.zhbf.zdd.common.untils.LogUntil
import com.zhbf.zdd.mvp.contract.MainContract
import com.zhbf.zdd.mvp.model.MainModel

/**
 * @author Created by ZhiBanQian on 2018/7/4.
 * Congratulations to the pit
 * May God bless you
 */
class MainPresenter : BasePresenter<MainContract.View>(), MainContract.Presenter {
    val TAG = "MainPresenter"
    override fun getdata() {
        model.getCategoryData()
                .subscribe({ bean -> LogUntil.d(TAG, bean.toString()) })

        val disposable = model.getCategoryData()
                .subscribe({ bean ->
                    mRootView?.apply {
                        dismissLoading()
                        LogUntil.d(TAG, bean.toString())
                    }
                }, { t ->
                    //处理异常
                    LogUntil.d(TAG, t.toString())

                })

        addSubscription(disposable)
    }

    private val model: MainModel by lazy {
        MainModel()
    }
}