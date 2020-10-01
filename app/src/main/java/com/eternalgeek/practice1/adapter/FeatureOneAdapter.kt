package com.eternalgeek.practice1.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.eternalgeek.practice1.R
import com.eternalgeek.practice1.core.domain.featureOne.Node
import kotlinx.android.synthetic.main.node_item.view.*

class FeatureOneAdapter(val action : (Node) -> Unit) : RecyclerView.Adapter<FeatureOneAdapter.FeatureOneViewHolder>() {


    private val mData = mutableListOf<Node>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FeatureOneViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.node_item,parent,false)
        return FeatureOneViewHolder(view,action)
    }

    override fun getItemCount(): Int = mData.size

    override fun onBindViewHolder(holder: FeatureOneViewHolder, position: Int) {
        holder.bindData(mData[position])
    }


    fun setNewData(node : List<Node>){
        mData.clear()
        mData.addAll(node)
        notifyDataSetChanged()
    }

    class FeatureOneViewHolder(itemView : View, val action : (Node) -> Unit) : RecyclerView.ViewHolder(itemView){
        fun bindData(node : Node){
            itemView.title.text = node.title
            itemView.content.text = node.content
            itemView.setOnClickListener {
                action(node)
            }
        }
    }

}