package com.zhbf.zdd.mvp.contract

import com.zhbf.zdd.base.IBaseView
import com.zhbf.zdd.base.IPresenter

/**
 * @author Created by ZhiBanQian on 2018/7/4.
 * Congratulations to the pit
 * May God bless you
 */
interface MainContract {
    interface View : IBaseView {

    }

    interface Presenter : IPresenter<View> {
        fun getdata()
    }
}