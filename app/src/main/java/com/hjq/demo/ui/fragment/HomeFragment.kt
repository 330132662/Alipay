package com.hjq.demo.ui.fragment

import android.widget.ImageView
import android.widget.LinearLayout
import com.alibaba.android.arouter.launcher.ARouter
import com.google.android.material.button.MaterialButton
import com.hjq.demo.R
import com.hjq.demo.aop.Permissions
import com.hjq.demo.app.TitleBarFragment
import com.hjq.demo.manager.Router
import com.hjq.demo.ui.activity.HomeActivity
import com.hjq.demo.ui.adapter.HomeNavAdapter
import com.hjq.permissions.Permission
import com.hjq.widget.layout.WrapRecyclerView
import com.kongzue.dialogx.dialogs.MessageDialog
import timber.log.Timber

/**
 *    author : Android 轮子哥
 *    github : https://github.com/getActivity/AndroidProject-Kotlin
 *    time   : 2018/10/18
 *    desc   :  支付宝首页  Fragment
 */
class HomeFragment : TitleBarFragment<HomeActivity>() {

    private var btn_13: MaterialButton? = null;//by lazy { findViewById(R.id.btn_renew) }
    private var btn_dialog: MaterialButton? = null;//by lazy { findViewById(R.id.btn_renew) }
    private var btn_english: MaterialButton? = null;//by lazy { findViewById(R.id.btn_renew) }
    private var list_nav: WrapRecyclerView? = null;

    private var navAdapter: HomeNavAdapter? = null;

    //btn_13
    companion object {
        fun newInstance(): HomeFragment {
            return HomeFragment()
        }
    }

    private var imageView: ImageView? = null

    override fun getLayoutId(): Int {
        return R.layout.home_fragment
    }

    override fun initView() {
        btn_13 = activity?.findViewById(R.id.btn_13);
        list_nav = activity?.findViewById(R.id.list_nav);

        navAdapter = HomeNavAdapter(requireActivity())
        list_nav?.adapter = navAdapter ;
        val navTitle = mutableListOf(
            "转账",
            "余额宝",
            "花呗",
            "信用卡还款",
            "蚂蚁森林",
            "芝麻信用",
            "市民中心",
            "手机充值",
            "生活缴费",
            "医疗健康",
            "支付宝荷包",
            "天天秒杀",
            "我的小程序"
        );
        navAdapter?.setData(navTitle)

        /*setOnClickListener(
            R.id.btn_message_image1,
            R.id.btn_message_image2,
            R.id.btn_message_image3,
            R.id.btn_message_toast,
            R.id.btn_message_permission,
            R.id.btn_message_setting,
            R.id.btn_message_black,
            R.id.btn_message_white,
            R.id.btn_message_tab
        )*/

        btn_english?.setOnClickListener {

        }
        btn_13?.setOnClickListener {
            ARouter.getInstance().build(Router.A13).navigation();
        }
        btn_dialog?.setOnClickListener {
            val dialog = MessageDialog.build().setTitle("是否同意性行为").setMessage("")
                .setOkButton("仅在使用中允许").setOtherButton("本次运行允许")
                .setButtonOrientation(LinearLayout.VERTICAL).setCancelButton("拒绝");
            dialog.show();
        }
        if (getAttachActivity() == null) {
            Timber.e("aaaa");
            return;
        }


    }

    override fun initData() {}


    override fun isStatusBarEnabled(): Boolean {
        // 使用沉浸式状态栏
        return !super.isStatusBarEnabled()
    }

    /*@SingleClick
    override fun onClick(view: View) {
        when (view.id) {
            R.id.btn_message_image1 -> {
                imageView?.let {
                    it.visibility = View.VISIBLE
                    GlideApp.with(this).load("https://www.baidu.com/img/bd_logo.png").into(it)
                }
            }

            R.id.btn_message_image2 -> {
                imageView?.let {
                    it.visibility = View.VISIBLE
                    GlideApp.with(this).load("https://www.baidu.com/img/bd_logo.png").circleCrop()
                        .into(it)
                }
            }

            R.id.btn_message_image3 -> {

                imageView?.let {
                    it.visibility = View.VISIBLE
                    GlideApp.with(this).load("https://www.baidu.com/img/bd_logo.png")
                        .transform(RoundedCorners(resources.getDimension(R.dimen.dp_20).toInt()))
                        .into(it)
                }
            }

            R.id.btn_message_toast -> {

                toast("我是吐司")

            }

            R.id.btn_message_permission -> {

                requestPermission()
            }

            R.id.btn_message_setting -> {

                XXPermissions.startPermissionActivity(this)
            }

            R.id.btn_message_black -> {
            }

            R.id.btn_message_white -> {


            }

            R.id.btn_message_tab -> {

                HomeActivity.start(getAttachActivity()!!, HomeFragment::class.java)
            }
        }
    }*/

    @Permissions(Permission.CAMERA)
    private fun requestPermission() {
        toast("获取摄像头权限成功")
    }
}