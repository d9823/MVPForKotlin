package com.zhbf.zdd.base

import android.annotation.TargetApi
import android.app.ActivityOptions
import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.transition.Fade
import android.view.LayoutInflater
import android.view.WindowManager
import com.umeng.analytics.MobclickAgent
import com.zhbf.zdd.R
import com.zhbf.zdd.common.untils.SystemBarTintManager
import kotlinx.android.synthetic.main.activity_base.*
import org.greenrobot.eventbus.EventBus


/**
 * @author Created by ZhiBanQian on 2018/7/2.
 * Congratulations to the pit
 * May God bless you
 *
 */
abstract class BaseActivity : AppCompatActivity(), IBaseView {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        AppManager.instance.addActivity(this)
        if (useBaseLayout()) {
            setContentView(R.layout.activity_base)
            fl_content.addView(LayoutInflater.from(this).inflate(getLayoutId(), fl_content, false))
        } else {
            setContentView(getLayoutId())
        }
        //为空时返回空字符串做参数
        getExtra(intent?.getStringExtra("extra")?: "")
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            setTranslucentStatus(true)
            val tintManager = SystemBarTintManager(this)
            tintManager.setStatusBarTintEnabled(true)
            tintManager.setStatusBarTintResource(R.color.theme)//通知栏所需颜色
        }
        if (useEventBus()) {
            EventBus.getDefault().register(this)
        }
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            window.enterTransition = Fade().setDuration(1000)
            window.exitTransition = Fade().setDuration(1000)
        }
        initView()
    }

    open fun getExtra(extra: String?) {

    }

    abstract fun initView()

    abstract fun getLayoutId(): Int

    abstract fun useEventBus(): Boolean

    open fun useBaseLayout(): Boolean = true

    @TargetApi(19)
    private fun setTranslucentStatus(status: Boolean) {
        val win = window
        val winParams = win.attributes
        val bits = WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS
        if (status) {
            winParams.flags = winParams.flags or bits
        } else {
            winParams.flags = winParams.flags and bits.inv()
        }
        win.attributes = winParams
    }

    fun startActivity(activity: Class<*>) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            startActivity(Intent(this, activity), ActivityOptions.makeSceneTransitionAnimation(this).toBundle())
        } else {
            this.startActivity(Intent(MyApplication.context, activity))
        }
    }

    fun startActivity(activity: Class<*>, extra: String) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            val intent = Intent(this, activity)
            intent.putExtra("extra", extra)
            startActivity(intent, ActivityOptions.makeSceneTransitionAnimation(this).toBundle())
        } else {
            val intent = Intent(MyApplication.context, activity)
            intent.putExtra("extra", extra)
            this.startActivity(intent)
        }
    }

    override fun onResume() {
        super.onResume()
        MobclickAgent.onResume(this)
    }

    override fun onPause() {
        super.onPause()
        MobclickAgent.onPause(this)
    }

    override fun showLoading() {

    }

    override fun dismissLoading() {

    }

    override fun onDestroy() {
        AppManager.instance.finishActivity(this)
        super.onDestroy()
    }
}