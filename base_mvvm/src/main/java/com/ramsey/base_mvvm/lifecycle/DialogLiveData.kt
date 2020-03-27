package com.ramsey.base_mvvm.lifecycle

import androidx.lifecycle.MutableLiveData
import com.ramsey.base_mvvm.bean.DialogBean


class DialogLiveData<T> : MutableLiveData<T>() {

    private val bean = DialogBean()

    fun setValue(isShow: Boolean) {
        bean.setShow(isShow)
        bean.setMsg("")
        value = bean as T
    }

    fun setValue(isShow: Boolean, msg: String) {
        bean.setShow(isShow)
        bean.setMsg(msg)
        value = bean as T
    }
}