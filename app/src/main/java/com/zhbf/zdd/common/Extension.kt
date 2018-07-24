package com.zhbf.zdd.common

import android.content.Context
import android.view.View
import android.widget.ImageView
import android.widget.Toast
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.request.RequestOptions
import com.zhbf.zdd.R
import com.zhbf.zdd.base.MyApplication

/**
 * @author Created by ZhiBanQian on 2018/7/10.
 * Congratulations to the pit
 * May God bless you
 */

fun Context.toast(context: Any) = Toast.makeText(MyApplication.context, "$context", Toast.LENGTH_SHORT).show()

/**
 * 扩展加载图片
 */
fun ImageView.loadImgByUrl(context: Context, url: String) =
        Glide.with(context)
                .load(url)
                .apply(RequestOptions()
                        .placeholder(R.mipmap.ic_launcher)
                        .error(R.mipmap.ic_launcher)
                        .diskCacheStrategy(DiskCacheStrategy.ALL))
                .into(this)

/**
 * 扩展点击事件
 */
fun View.onClick(listener: View.OnClickListener): View {
    setOnClickListener(listener)
    return this
}