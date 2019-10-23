package com.ramsey.base_mvvm.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup

import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView

import java.util.ArrayList

/**
 * 结合dataBinding的RecyclerView Adapter
 * @author Ramsey
 */

abstract class BaseDBRVAdapter<Data, DB : ViewDataBinding> : RecyclerView.Adapter<BaseDBRVHolder> {

    private var data: MutableList<Data>? = null
    private var itemId: Int = 0
    protected lateinit var context: Context
    protected var variableId: Int = 0
    protected var listener: OnItemClickListener<Data>? = null


    constructor(@LayoutRes itemId: Int, variableId: Int) {
        this.itemId = itemId
        this.variableId = variableId
        data = ArrayList()
    }

    constructor(data: MutableList<Data>?, @LayoutRes itemId: Int, variableId: Int) {
        this.data = data ?: ArrayList()
        this.itemId = itemId
        this.variableId = variableId
    }


    override fun onCreateViewHolder(parent: ViewGroup, position: Int): BaseDBRVHolder {
        this.context = parent.context
        val inflater = LayoutInflater.from(context)
        val binding = DataBindingUtil.inflate<DB>(inflater, itemId, parent, false)
        return BaseDBRVHolder(binding.root)
    }

    override fun onBindViewHolder(holder: BaseDBRVHolder, position: Int) {
        val binding = DataBindingUtil.getBinding<DB>(holder.itemView)
        val itemData = data!![position]
        binding!!.setVariable(variableId, itemData)
        onBindViewHolder(itemData, binding, position)
        //迫使数据立即绑定
        binding.executePendingBindings()
        //设置点击事件
        if (listener != null) {
            holder.itemView.setOnClickListener { listener!!.onItemClick(itemData, position) }
            holder.itemView.setOnLongClickListener { listener!!.onItemLongClick(itemData, position) }
        }
    }


    override fun getItemCount(): Int {
        return data!!.size
    }

    /**
     * 绑定数据
     */
    protected fun onBindViewHolder(data: Data, binding: DB, position: Int) {}

    /**
     * 设置新数据
     *
     * @param data
     */
    fun setNewData(data: List<Data>) {
        this.data!!.clear()
        this.data!!.addAll(data)
        notifyDataSetChanged()
    }

    /**
     * 添加数据
     *
     * @param data
     */
    fun addData(data: Data) {
        this.data!!.add(data)
        notifyDataSetChanged()
    }

    /**
     * 添加数据
     *
     * @param data
     */
    fun addData(data: List<Data>) {
        this.data!!.addAll(data)
        notifyDataSetChanged()
    }

    /**
     * 设置Item 长按、点击事件
     */
    fun setOnItemListener(listener: OnItemClickListener<Data>) {
        this.listener = listener
    }
}
