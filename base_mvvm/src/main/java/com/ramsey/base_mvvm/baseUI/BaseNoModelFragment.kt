package com.ramsey.base_mvvm.baseUI

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity

/**
 *
 * 描述:     不需要ViewModel的页面基类
 * @author  Ramsey
 */

abstract class BaseNoModelFragment<DB : ViewDataBinding> : Fragment() {

    protected var dataBinding: DB? = null
    //    private LoadingDialog loadingDialog;

    override fun onAttach(context: Context) {
        super.onAttach(context)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        dataBinding = initDataBinding(inflater, onCreate(), container)
        return dataBinding!!.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        initView()
        initData()
    }

    /**
     * 初始化要加载的布局资源ID
     */
    protected abstract fun onCreate(): Int


    /**
     * 初始化DataBinding
     */
    protected open fun initDataBinding(inflater: LayoutInflater, @LayoutRes layoutId: Int, container: ViewGroup?): DB {
        return DataBindingUtil.inflate(inflater, layoutId, container, false)
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
    }
}
