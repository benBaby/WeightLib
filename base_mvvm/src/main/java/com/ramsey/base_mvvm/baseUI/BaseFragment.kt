package com.ramsey.base_mvvm.baseUI

import android.view.LayoutInflater
import android.view.ViewGroup

import androidx.databinding.ViewDataBinding
import androidx.lifecycle.Observer

import com.ramsey.base_mvvm.lifecycle.BaseViewModel


/**
 * ViewModel、ViewDataBinding都需要的基类
 * @author Ramsey
 */

abstract class BaseFragment<VM : BaseViewModel, DB : ViewDataBinding> : BaseNoModelFragment<DB>() {

    protected var viewModel: VM? = null

    override fun initDataBinding(inflater: LayoutInflater, layoutId: Int, container: ViewGroup?): DB {
        val db = super.initDataBinding(inflater, layoutId, container)
        /**
         * 将这两个初始化函数插在[BaseFragment.initDataBinding]
         */
        viewModel = initViewModel()
        initObserve()
        return db
    }

    /**
     * 初始化ViewModel
     */
    protected abstract fun initViewModel(): VM

    /**
     * 监听当前ViewModel中 showDialog和error的值
     */
    private fun initObserve() {
//        if (viewModel == null) return
//        viewModel!!.getShowDialog(this, Observer<Any> { bean ->
//            if (bean.isShow()) {
//                showDialog(bean.getMsg())
//            } else {
//                dismissDialog()
//            }
//        })
//        viewModel!!.getError(this, Observer { obj -> showError(obj) })
    }

    /**
     * ViewModel层发生了错误
     */
    protected abstract fun showError(obj: Any)
}
