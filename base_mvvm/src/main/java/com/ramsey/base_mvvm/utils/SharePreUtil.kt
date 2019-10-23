package com.ramsey.base_mvvm.utils

import android.content.Context
import android.content.SharedPreferences

import java.io.BufferedReader
import java.io.File
import java.io.FileInputStream
import java.io.InputStreamReader

object SharePreUtil {
    /**
     * 配置文件，文件名
     */
    private val SHARE_NAME = "config"

    /**
     * 存字符串
     *
     * @param context 上下文
     * @param key     键
     * @param values  值
     */
    fun putString(context: Context, key: String, values: String) {
        val sp = context.getSharedPreferences(SHARE_NAME, Context.MODE_PRIVATE)
        sp.edit().putString(key, values).apply()
    }


    /**
     * 取字符串
     *
     * @param context 上下文
     * @param key     键
     * @param values  默认值
     * @return 取出的值
     */
    fun getString(context: Context, key: String, values: String): String? {
        val sp = context.getSharedPreferences(SHARE_NAME, Context.MODE_PRIVATE)
        return sp.getString(key, values)
    }


    /**
     * 存布尔值
     *
     * @param context 上下文
     * @param key     键
     * @param values  值
     */
    fun putBoolean(context: Context, key: String, values: Boolean) {
        val sp = context.getSharedPreferences(SHARE_NAME, Context.MODE_PRIVATE)
        sp.edit().putBoolean(key, values).apply()
    }

    /**
     * 取布尔值
     *
     * @param context 上下文
     * @param key     键
     * @param values  默认值
     * @return true/false
     */
    fun getBoolean(context: Context, key: String, values: Boolean): Boolean {
        val sp = context.getSharedPreferences(SHARE_NAME, Context.MODE_PRIVATE)
        return sp.getBoolean(key, values)
    }

    /**
     * 存int值
     *
     * @param context 上下文
     * @param key     键
     * @param values  值
     */
    fun putInt(context: Context, key: String, values: Int) {
        val sp = context.getSharedPreferences(SHARE_NAME, Context.MODE_PRIVATE)
        sp.edit().putInt(key, values).apply()
    }

    /**
     * 取int值
     *
     * @param context 上下文
     * @param key     键
     * @param values  默认值
     * @return
     */
    fun getInt(context: Context, key: String, values: Int): Int {
        val sp = context.getSharedPreferences(SHARE_NAME, Context.MODE_PRIVATE)
        return sp.getInt(key, values)
    }

    /**
     * 删除一条字段
     *
     * @param context 上下文
     * @param key     键
     */
    fun deleShare(context: Context, key: String) {
        val sp = context.getSharedPreferences(SHARE_NAME, Context.MODE_PRIVATE)
        //单个清理
        sp.edit().remove(key).apply()
    }

    /**
     * 删除全部数据
     *
     * @param context 上下文
     */
    fun deleShareAll(context: Context) {
        val sp = context.getSharedPreferences(SHARE_NAME, Context.MODE_PRIVATE)
        //全部清理
        sp.edit().clear().apply()
    }

    /**
     * 查看SharedPreferences的内容
     */
    fun lookSharePre(context: Context): String {
        try {
            val stream = FileInputStream(File("/data/data/" +
                    context.packageName + "/shared_prefs", "$SHARE_NAME.xml"))
            val bff = BufferedReader(InputStreamReader(stream))
            var line: String
            val sb = StringBuilder()

            do {
                line = bff.readLine()
                if (null != line) {
                    sb.append(line)
                    sb.append("\n")
                } else {
                    break
                }
            } while (true)
            return sb.toString()
        } catch (e: Exception) {
            e.printStackTrace()
        }

        return "未找到当前配置文件！"
    }
}