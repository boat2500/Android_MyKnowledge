package com.example.appfortest.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.appfortest.R
import com.example.appfortest.data.MainPageData
import com.example.appfortest.layout.*
import kotlinx.android.synthetic.main.show_manu_on_main_page.view.*

class MainPageAdapter(var item:ArrayList<MainPageData>, var context: MainActivity): RecyclerView.Adapter<ViewHolder_Main>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder_Main {
        val view = LayoutInflater.from(context).inflate(R.layout.show_manu_on_main_page,parent,false)
        return ViewHolder_Main(view)
    }

    override fun getItemCount(): Int {
        return item.size
    }

    override fun onBindViewHolder(holder: ViewHolder_Main, position: Int) {
        holder.manu.setText(item[position].detail)

        holder.manu.setOnClickListener(){
            when(item[position].detail){
                "Monter hunter" -> context.startActivity(Intent(context, Hunter::class.java))
                "Test get json by retrofit" -> context.startActivity(Intent(context, GetRetrofit::class.java))
                "Test recycle view" -> context.startActivity(Intent(context, TestRecycleView::class.java))
                "Test lift cycle" -> context.startActivity(Intent(context, Liftcycle::class.java))
            }
        }
    }
}
class ViewHolder_Main(itemView: View) : RecyclerView.ViewHolder(itemView) {
    var manu = itemView.buttonTitleMainPage
    var title = itemView.layoutTitleMainPage
}