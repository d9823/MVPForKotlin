package com.zhbf.zdd.mvp.model

import com.zhbf.zdd.common.net.ApiService
import com.zhbf.zdd.common.net.RetrofitFactory
import com.zhbf.zdd.common.untils.SchedulerUtils
import com.zhbf.zdd.mvp.model.bean.HomeBean
import io.reactivex.Observable

/**
 * @author Created by ZhiBanQian on 2018/7/4.
 * Congratulations to the pit
 * May God bless you
 */
class MainModel {
    fun getCategoryData(): Observable<HomeBean> {
        return RetrofitFactory.instance.create(ApiService::class.java).getData(1)
                .compose(SchedulerUtils.ioToMain())
//        return RetrofitManager.service.getData(1)
//                .compose(SchedulerUtils.ioToMain())
    }
}