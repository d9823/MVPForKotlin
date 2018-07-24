package com.zhbf.zdd.base

/**
 * @author Created by ZhiBanQian on 2018/7/3.
 * Congratulations to the pit
 * May God bless you
 */
interface IPresenter<in V: IBaseView> {

    fun attachView(mRootView: V)

    fun detachView()

}