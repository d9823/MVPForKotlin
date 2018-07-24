package com.zhbf.zdd.mvp.ui

import android.os.Bundle
import com.zhbf.zdd.R
import com.zhbf.zdd.base.BaseActivity
import com.zhbf.zdd.common.toast
import com.zhbf.zdd.mvp.contract.MainContract
import com.zhbf.zdd.mvp.presenter.MainPresenter
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : BaseActivity(), MainContract.View {
    private val mPresenter by lazy { MainPresenter() }
    override fun useEventBus(): Boolean = false

    override fun getLayoutId(): Int = R.layout.activity_main

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mPresenter.getdata()
    }

    override fun useBaseLayout(): Boolean = false

    override fun initView() {
        navigation_view.setNavigationItemSelectedListener {
            if (it.itemId == R.id.nav_1) startActivity(MainActivity2::class.java)
            toast(it.title)
            false
        }
    }
}
