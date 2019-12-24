package com.example.appfortest.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.view.isGone
import androidx.core.view.isVisible
import androidx.lifecycle.ViewModel
import androidx.recyclerview.widget.RecyclerView
import com.example.appfortest.R
import com.example.appfortest.data.item
import com.example.appfortest.layout.Hunter
import com.example.appfortest.viewModel.hunter
import kotlinx.android.synthetic.main.activity_hunter.view.*
import kotlinx.android.synthetic.main.hunter_item.view.*

class monterAdapter(var item:ArrayList<item>, var context:Hunter, var viewModel: hunter):RecyclerView.Adapter<ViewHolder_MonHun>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder_MonHun {
        var view = LayoutInflater.from(context).inflate(R.layout.hunter_item, parent, false)
        return ViewHolder_MonHun(view)
    }

    override fun getItemCount(): Int = item.size

    override fun onBindViewHolder(holder: ViewHolder_MonHun, position: Int) {
        holder.item.text = item[position].item

        holder.item.setOnClickListener(){
            if (holder.item.text == "Hp+1000"){
                viewModel.HunterHp += 1000
                viewModel.set(context)
                item.removeAt(position)
                notifyDataSetChanged()
            }else{
                viewModel.HunterHp += 100
                viewModel.set(context)
                item.removeAt(position)
                notifyDataSetChanged()
            }
        }
    }
}

class ViewHolder_MonHun(itemView: View):RecyclerView.ViewHolder(itemView) {
    var item = itemView.button

}
