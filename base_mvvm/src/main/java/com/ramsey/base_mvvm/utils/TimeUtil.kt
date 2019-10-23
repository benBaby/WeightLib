package com.ramsey.base_mvvm.utils

import java.text.SimpleDateFormat
import java.util.Date

object TimeUtil {

    /**
     * 将时间戳转换为时间
     *
     * @param time
     * @return
     */
    fun yyyyMMdd(time: Long): String {
        if (time == 0L) {
            return ""
        }
        val format = SimpleDateFormat("yyyy-MM-dd")
        val date = Date(time)
        return format.format(date)
    }

    /***
     * 时间戳转换为时间
     *
     * @param time
     * @return
     */
    fun HHmmss(time: Long): String {
        if (time == 0L) {
            return ""
        }
        val format = SimpleDateFormat("HH:mm:ss")
        val date = Date(time)
        return format.format(date)
    }

    /***
     * 时间戳转换为时间
     *
     * @param time
     * @return
     */
    fun yyyyMMddHHmm(time: Long): String {
        if (time == 0L) {
            return ""
        }
        val format = SimpleDateFormat("yyyy-MM-dd HH:mm")
        val date = Date(time)
        return format.format(date)
    }

    /***
     * 时间戳转换为时间
     *
     * @param time
     * @return
     */
    fun yyyyMMddHHmmss(time: Long): String {
        if (time == 0L) {
            return ""
        }
        val format = SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
        val date = Date(time)
        return format.format(date)
    }

    /***
     * 时间戳转换为时间
     *
     * @param time
     * @return
     */
    fun MMddHHmm(time: Long): String {
        if (time == 0L) {
            return ""
        }
        val format = SimpleDateFormat("MM-dd HH:mm")
        val date = Date(time)
        return format.format(date)
    }

    /***
     * 时间戳转换为时间
     *
     * @param time
     * @return
     */
    fun MMddHHmmss(time: Long): String {
        if (time == 0L) {
            return ""
        }
        val format = SimpleDateFormat("MM-dd HH:mm:ss")
        val date = Date(time)
        return format.format(date)
    }

    /***
     * 时间戳转换为时间
     *
     * @param time
     * @return
     */
    fun byPattern(time: Long, pattern: String): String {
        if (time == 0L) {
            return ""
        }
        val format = SimpleDateFormat(pattern)
        val date = Date(time)
        return format.format(date)
    }
}
