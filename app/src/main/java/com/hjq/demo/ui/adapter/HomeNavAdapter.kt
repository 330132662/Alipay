package com.hjq.demo.ui.adapter

import android.content.Context
import android.view.ViewGroup
import androidx.appcompat.widget.AppCompatImageView
import com.google.android.material.textview.MaterialTextView
import com.hjq.demo.R
import com.hjq.demo.app.AppAdapter

/**
 *    author : Android 轮子哥
 *    github : https://github.com/getActivity/AndroidProject-Kotlin
 *    time   : 2018/11/05
 *    desc   : 可进行拷贝的副本
 */
class HomeNavAdapter constructor(context: Context) : AppAdapter<String>(context) {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder()
    }

    inner class ViewHolder : AppViewHolder(R.layout.item_home_nav) {
        private val tv_home_nav_title: MaterialTextView by lazy { findViewById(R.id.tv_home_nav_title) }
        private val iv_home_nav_icon: AppCompatImageView by lazy { findViewById(R.id.iv_home_nav_icon) }
        override fun onBindView(position: Int) {
            tv_home_nav_title.text = getItem(position)
//            iv_home_nav_icon.setImageResource(R.drawable.ic_home_nav)
        }
    }
}