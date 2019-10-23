package com.ramsey.base_mvvm.baseUI

import android.content.Context
import android.os.Bundle

import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding

/**
 * 没有ViewModel 的activity 类
 * @author
 */
abstract class BaseNoModelActivity<DB : ViewDataBinding> : AppCompatActivity() {

    protected var dataBinding: DB? = null
    protected lateinit var context: Context

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        context = this
        //        ActivityUtil.getInstance().addActivity(this);
        val layoutId = onCreate()
        setContentView(layoutId)
        dataBinding = initDataBinding(layoutId)
        initView()
        initData()
    }

    /**
     * 初始化要加载的布局资源ID
     * 此函数优先执行于onCreate()可以做window操作
     */
    protected abstract fun onCreate(): Int


    /**
     * 初始化DataBinding
     */
    protected open fun initDataBinding(@LayoutRes layoutId: Int): DB {
        return DataBindingUtil.setContentView(this, layoutId)
    }

    /**
     * 初始化视图
     */
    protected abstract fun initView()

    /**
     * 初始化数据
     */
    protected abstract fun initData()

    //    /**
    //     * 显示用户等待框
    //     *
    //     * @param msg 提示信息
    //     */
    //    protected void showDialog(String msg) {
    //        if (loadingDialog != null && loadingDialog.isShowing()) {
    //            loadingDialog.setLoadingMsg(msg);
    //        } else {
    //            loadingDialog = new LoadingDialog(context);
    //            loadingDialog.setLoadingMsg(msg);
    //            loadingDialog.show();
    //        }
    //    }

    //    /**
    //     * 隐藏等待框
    //     */
    //    protected void dismissDialog() {
    //        if (loadingDialog != null && loadingDialog.isShowing()) {
    //            loadingDialog.dismiss();
    //            loadingDialog = null;
    //        }
    //    }

    override fun onDestroy() {
        super.onDestroy()
        if (dataBinding != null) {
            dataBinding!!.unbind()
        }
        //        ActivityUtil.getInstance().removeActivity(this);
    }
}
