package com.example.ocrdemo

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

/**
 * created by hsf
 * date:2019/12/6
 * description:
 */
class Adapter(var context: Context, var dataList: List<GeneralBean.WordsResultBean>) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    private var mInflater: LayoutInflater

    init {
        mInflater = LayoutInflater.from(context)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view = mInflater.inflate(R.layout.item_layout,null)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if(holder is ViewHolder){
            val bean = dataList.get(position)
            holder.tv.setText(bean.words)
        }
    }

    override fun getItemCount(): Int {
        return dataList.size
    }

    internal class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val tv:TextView = itemView.findViewById(R.id.tv)
    }


}