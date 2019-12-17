package com.example.appfortest.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.appfortest.layout.Liftcycle
import com.example.appfortest.layout.MainActivity
import com.example.appfortest.R
import com.example.appfortest.layout.TestRecycleView
import com.example.appfortest.data.MainPageData
import com.example.appfortest.layout.GetRetrofit
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
            if (item[position].detail == "Test lift cycle"){
                it.context.startActivity(Intent(context, Liftcycle::class.java))
            }
            else if (item[position].detail == "Test recycle view"){
                it.context.startActivity(Intent(context, TestRecycleView::class.java))
            }
            else if (item[position].detail == "Test get json by retrofit"){
                it.context.startActivity(Intent(context, GetRetrofit::class.java))
            }
        }
    }
}
class ViewHolder_Main(itemView: View) : RecyclerView.ViewHolder(itemView) {
    var manu = itemView.buttonTitleMainPage
    var title = itemView.layoutTitleMainPage
}