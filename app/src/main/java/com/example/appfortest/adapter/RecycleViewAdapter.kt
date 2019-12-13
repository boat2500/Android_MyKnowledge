package com.example.appfortest.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.appfortest.R
import com.example.appfortest.data.RecycleViewData
import kotlinx.android.synthetic.main.show_test_recycle_view.view.*

class MyAdapter (val item: ArrayList<RecycleViewData>,val context: Context): RecyclerView.Adapter<ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        var view = LayoutInflater.from(context).inflate(R.layout.show_test_recycle_view, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return item.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.title.text = item[position].title
        holder.image.setImageResource(item[position].Image)
    }
}
class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    var title = itemView.TextForTestRecycleView
    var image = itemView.imageView
}