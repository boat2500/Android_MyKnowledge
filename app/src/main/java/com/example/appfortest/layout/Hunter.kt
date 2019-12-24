package com.example.appfortest.layout

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.View
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.appfortest.R
import com.example.appfortest.adapter.monterAdapter
import com.example.appfortest.viewModel.hunter
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_hunter.*

class Hunter : AppCompatActivity() {

    private lateinit var viewModel: hunter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_hunter)

        item_recycle.visibility = View.GONE
        buy_layout.visibility = View.GONE

        viewModel = ViewModelProviders.of(this).get(hunter::class.java)

        viewModel.set(this)

        item_recycle.adapter = monterAdapter(viewModel.monhun,this,viewModel)
        item_recycle.layoutManager = LinearLayoutManager(this)

        upHp.setOnClickListener(){
            buy_layout.visibility = View.GONE
            viewModel.up_hp(item_recycle,buy_layout,this)
        }

        buyItem.setOnClickListener(){
            item_recycle.visibility = View.GONE
           viewModel.buyItem(buy_layout)
        }
        counter.setOnClickListener() {
            viewModel.hit(this)
        }

        button12.setOnClickListener(){
            viewModel.buy100(this)
        }
        button13.setOnClickListener(){
            viewModel.buy1000(this)
        }
    }
}
