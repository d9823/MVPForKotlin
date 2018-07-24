package com.zhbf.zdd.common.net

import com.zhbf.zdd.mvp.model.bean.HomeBean
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * @author Created by ZhiBanQian on 2018/7/4.
 * Congratulations to the pit
 * May God bless you
 */
interface ApiService {
    @GET("v2/feed?")
    fun getData(@Query("num") num:Int): Observable<HomeBean>
}