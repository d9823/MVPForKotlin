package com.zhbf.zdd.common.untils

import android.util.Log

/**
 * @author Created by ZhiBanQian on 2018/7/2.
 * Congratulations to the pit
 * May God bless you
 */
object LogUntil {
    var isDebug = true
    fun i(tag: String, context: String) {
        if (isDebug) {
            Log.i(tag, context)
        }
    }

    fun d(tag: String, context: String) {
        if (isDebug) {
            Log.d(tag, context)
        }
    }

    fun e(tag: String, context: String) {
        if (isDebug) {
            Log.e(tag, context)
        }
    }

    fun w(tag: String, context: String) {
        if (isDebug) {
            Log.w(tag, context)
        }
    }

    fun v(tag: String, context: String) {
        if (isDebug) {
            Log.v(tag, context)
        }
    }
}