package com.example.appfortest.adapter

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.recyclerview.widget.RecyclerView
import com.example.appfortest.R
import com.example.appfortest.data.TitleForRetrofitData
import com.example.appfortest.layout.GetRetrofit
import com.example.appfortest.layout.Profile
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.show_user_title.view.*

class TitleForRetrofit(var item:List<TitleForRetrofitData>, var context: GetRetrofit): RecyclerView.Adapter<ViewHolder_GetTitleUser>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder_GetTitleUser {
        val view = LayoutInflater.from(context).inflate(R.layout.show_user_title,parent,false)
        return ViewHolder_GetTitleUser(view)
        Log.i("1234",item[0].login)
    }
    override fun getItemCount(): Int {
        return item.size
    }
    override fun onBindViewHolder(holder: ViewHolder_GetTitleUser, position: Int) {
        holder.textNameUser.text = item[position].login
        Picasso.get().load(item[position].avatarUrl).into(holder.imageUser)
        holder.button.setOnClickListener(){
            if (holder.button.text == "Follow"){
                holder.button.setText("UnFollow")
                holder.button.setBackgroundResource(R.color.colorBack)
            }else{
                holder.button.setText("Follow")
                holder.button.setBackgroundResource(R.color.colorGreen)
            }
        }
        holder.userLayout.setOnClickListener(){
            val intent = Intent(context, Profile::class.java)
            intent.putExtra("userName", holder.textNameUser.text.toString())
            it.context.startActivity(intent)
        }
    }
}
class ViewHolder_GetTitleUser(itemView: View) : RecyclerView.ViewHolder(itemView) {
    var imageUser = itemView.imageUser
    var textNameUser = itemView.textNameUser
    var button = itemView.buttonFollow
    var userLayout = itemView.userLayout
}




