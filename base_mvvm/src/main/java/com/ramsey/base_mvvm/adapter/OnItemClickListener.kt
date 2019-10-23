package com.ramsey.base_mvvm.adapter

/**
 * RecyclerView Item 长按、点击事件
 *
 * @author Ramsey
 */

interface OnItemClickListener<Data> {

    /**
     * Item 点击事件
     *
     * @param data     item的数据
     * @param position item的下标
     */
    fun onItemClick(data: Data, position: Int)

    /**
     * Item 长按事件
     *
     * @param data     item的数据
     * @param position item的下标
     */
    fun onItemLongClick(data: Data, position: Int): Boolean

}
