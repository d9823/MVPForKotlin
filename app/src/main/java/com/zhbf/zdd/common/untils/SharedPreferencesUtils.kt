package com.zhbf.zdd.common.untils

import android.app.Activity
import com.zhbf.zdd.base.MyApplication
import com.zhbf.zdd.common.Constants

/**
 * @author Created by ZhiBanQian on 2018/7/4.
 * Congratulations to the pit
 * May God bless you
 */
class SharedPreferencesUtils private constructor() {


    companion object {
        val instance by lazy { MyApplication.context.getSharedPreferences(Constants.SP_NAME, Activity.MODE_PRIVATE) }
    }

    fun putStringSet(key: String, value: Set<String>): Boolean {
        val editor = instance.edit()

        editor.putStringSet(key, value)
        return editor.commit()
    }

    fun getStringSet(key: String) = {
        val set: Set<String>? = null
        instance.getStringSet(key, set)
    }

    fun putString(key: String, value: String): Boolean {
        val editor = instance.edit()
        editor.putString(key, value)
        return editor.commit()
    }

    fun getString(key: String) = instance.getString(key, "")

    fun putInt(key: String, value: Int): Boolean {
        val editor = instance.edit()
        editor.putInt(key, value)
        return editor.commit()
    }

    fun getInt(key: String) = instance.getInt(key, 0)

    fun putBoolean(key: String, value: Boolean): Boolean {
        val editor = instance.edit()
        editor.putBoolean(key, value)
        return editor.commit()
    }

    fun getBoolean(key: String) = instance.getBoolean(key, false)

    fun remove(key: String): Boolean {
        val editor = instance.edit()
        editor.remove(key)
        return editor.commit()
    }

    fun clear(): Boolean {
        val editor = instance.edit()
        editor.clear()
        return editor.commit()
    }


}
