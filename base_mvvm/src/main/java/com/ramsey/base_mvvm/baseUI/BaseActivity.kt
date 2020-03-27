package com.ramsey.base_mvvm.baseUI

import androidx.databinding.ViewDataBinding
import androidx.lifecycle.Observer

import com.ramsey.base_mvvm.lifecycle.BaseViewModel

abstract class BaseActivity<VM : BaseViewModel, DB : ViewDataBinding> : BaseNoModelActivity<DB>() {

    protected var viewModel: VM? = null

    override fun initDataBinding(layoutId: Int): DB {
        val db = super.initDataBinding(layoutId)
        /**
         * 将这两个初始化函数插在[BaseActivity.initDataBinding]
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
        if (viewModel == null) return
                viewModel?.getShowDialog(this, Observer { bean ->
                    if (bean.isShow()) {

                    } else {

                    }
                });
        viewModel!!.getError(this, Observer { obj -> showError(obj) })
    }

    /**
     * ViewModel层发生了错误
     */
    protected abstract fun showError(obj: Any)

}
