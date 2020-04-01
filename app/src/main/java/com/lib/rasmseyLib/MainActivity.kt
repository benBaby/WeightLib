package com.lib.rasmseyLib

import androidx.lifecycle.ViewModelProviders
import com.lib.rasmseyLib.databinding.ActivityMainBinding
import com.ramsey.base_mvvm.baseUI.BaseActivity

/**
 *  baseActivity  绑定 ViewModel 和 DataBinding
 */
class MainActivity : BaseActivity<MainViewModel, ActivityMainBinding>() {

    override fun initViewModel(): MainViewModel {
        return ViewModelProviders.of(this).get(MainViewModel::class.java)
    }

    override fun showError(obj: Any) {
    }

    override fun onCreate(): Int {
        return R.layout.activity_main
    }

    override fun initView() {
        dataBinding?.apply {
//            claA.setEditTextShow()
//            claA.setEDRightValue("SSSSSS")
        }
    }

    override fun initData() {
        val testBean = TestBean()
        testBean.message = "SSSSSSSSS"
        dataBinding!!.test = testBean
    }


}
