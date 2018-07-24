package com.zhbf.zdd.base

import android.app.Application
import android.content.Context
import android.content.pm.ApplicationInfo
import com.umeng.analytics.AnalyticsConfig
import com.umeng.commonsdk.UMConfigure
import com.zhbf.zdd.common.Constants.APP_KEY
import com.zhbf.zdd.common.untils.LogUntil
import kotlin.properties.Delegates


/**
 * @author Created by ZhiBanQian on 2018/7/2.
 * Congratulations to the pit
 * May God bless you
 */
class MyApplication : Application() {
    companion object {
        var context: Context by Delegates.notNull()
            private set
    }

    override fun onCreate() {
        super.onCreate()
        context = applicationContext
        val channel = AnalyticsConfig.getChannel(this)
        UMConfigure.init(this, APP_KEY, channel, UMConfigure.DEVICE_TYPE_PHONE, "")
        LogUntil.isDebug = isApkInDebug(this)
    }

    //判断当前应用是否是debug状态
    fun isApkInDebug(context: Context): Boolean {
        try {
            val info = context.getApplicationInfo()
            return info.flags and ApplicationInfo.FLAG_DEBUGGABLE != 0
        } catch (e: Exception) {
            return false
        }
    }

}