package com.bao.groupitemdecoration

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class UserAdapter(private val mData: MutableList<UserBean>) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return UserViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_user, parent, false)
        )
    }

    override fun getItemCount(): Int {
        return mData.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (holder is UserViewHolder) {
            holder.tvName.text = mData[position].name
        }
    }


    /**
     * 判断是否是每一组的头部
     */
    public fun isGroupHead(position: Int): Boolean {
        if (position == 0) {
            return true
        } else {
            val currentGroup = getGroupName(position)
            val preGroup = getGroupName(position - 1)
            return currentGroup != preGroup
        }
    }

    /**
     * 获取组名
     */
    public fun getGroupName(position: Int): String = mData[position].groupName

    inner class UserViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val tvName: TextView = itemView.findViewById(R.id.tv_name)

        init {
        }
    }
}