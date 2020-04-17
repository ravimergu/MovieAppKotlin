package com.example.myapplication.ui.main.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.RequestManager
import com.example.myapplication.R
import com.example.myapplication.data.model.User
import com.example.myapplication.databinding.LayoutListItemBinding

class MainAdapter(
    private val users: ArrayList<User>,
    private val requestManager: RequestManager
) : RecyclerView.Adapter<MainAdapter.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        val listItemBinding = DataBindingUtil.inflate<LayoutListItemBinding>(
            LayoutInflater.from(parent.context),
            R.layout.layout_list_item,
            parent,
            false
        )

        return ViewHolder(listItemBinding)
    }

    override fun getItemCount(): Int {
        return users.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.view.requestManager=requestManager
        holder.view.user = users.get(position)
    }

    fun addUsers(data: List<User>?) {
        this.users.apply {
            clear()
            data?.let { addAll(it) }
        }
    }

    class ViewHolder(val view: LayoutListItemBinding) : RecyclerView.ViewHolder(view.root)

}