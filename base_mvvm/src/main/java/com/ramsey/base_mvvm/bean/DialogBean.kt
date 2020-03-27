package com.ramsey.base_mvvm.bean

class DialogBean {
    private var isShow: Boolean = false
    private var msg: String? = null

    fun isShow(): Boolean {
        return isShow
    }

    fun setShow(show: Boolean) {
        isShow = show
    }

    fun getMsg(): String? {
        return msg
    }

    fun setMsg(msg: String) {
        this.msg = msg
    }
}