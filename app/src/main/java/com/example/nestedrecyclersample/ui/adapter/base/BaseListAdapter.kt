package com.example.nestedrecyclersample.ui.adapter.base

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter

abstract class BaseListAdapter<T>(
    private val itemLayoutRes: Int,
    diffCallback: DiffUtil.ItemCallback<T>,
) : ListAdapter<T, BaseViewHolder<T>>(diffCallback) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder<T> {
        val view = LayoutInflater.from(parent.context).inflate(itemLayoutRes, parent, false)
        return BaseViewHolderImp(view)
    }

    override fun getItemViewType(position: Int): Int {
        return itemLayoutRes
    }

    override fun onBindViewHolder(holder: BaseViewHolder<T>, position: Int) {
        holder.bind(getItem(position), position)
    }

    inner class BaseViewHolderImp(itemView: View) : BaseViewHolder<T>(itemView) {
        override fun bind(item: T, position: Int) {
            this@BaseListAdapter.bind(itemView, item, position, this)
        }
    }

    abstract fun bind(itemView: View, item: T, position: Int, viewHolder: BaseViewHolderImp)
}