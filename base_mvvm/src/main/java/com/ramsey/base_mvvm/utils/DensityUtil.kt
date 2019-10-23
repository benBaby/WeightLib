package com.ramsey.base_mvvm.utils

import android.content.Context
import android.content.res.TypedArray
import android.util.DisplayMetrics

object DensityUtil {

    /**
     * 获取屏幕宽度（像素）
     *
     * @param context 上下文
     * @return px
     */
    fun getWith(context: Context): Int {
        val dm = context.resources.displayMetrics
        return dm.widthPixels
    }

    /**
     * 获取屏幕高度（像素）
     *
     * @param context 上下文
     * @return px
     */
    fun getHeight(context: Context): Int {
        val dm = context.resources.displayMetrics
        return dm.heightPixels
    }

    /**
     * 获取状态栏的高度
     *
     * @param context 上下文
     * @return px
     */
    fun getStatusBarHeight(context: Context): Int {
        var statusBarHeight = 0
        val resourceId = context.resources.getIdentifier("status_bar_height", "dimen", "android")
        if (resourceId > 0) {
            statusBarHeight = context.resources.getDimensionPixelSize(resourceId)
        }
        return statusBarHeight
    }

    /**
     * 获取标题栏（ActionBar）的高度
     *
     * @param context 上下文
     * @return px
     */
    fun getActionBarHeight(context: Context): Int {
        val values = context.theme.obtainStyledAttributes(intArrayOf(android.R.attr.actionBarSize))
        val actionBarHeight = values.getDimensionPixelSize(0, 0)
        values.recycle()
        return actionBarHeight
    }

    /**
     * 根据手机的分辨率从 dp 的单位 转成为 px(像素)
     */
    fun dip2px(context: Context, dpValue: Float): Int {
        val scale = context.resources.displayMetrics.density
        return (dpValue * scale + 0.5f).toInt()
    }

    /**
     * 根据手机的分辨率从 px(像素) 的单位 转成为 dp
     */
    fun px2dip(context: Context, pxValue: Float): Int {
        val scale = context.resources.displayMetrics.density
        return (pxValue / scale + 0.5f).toInt()
    }
}
