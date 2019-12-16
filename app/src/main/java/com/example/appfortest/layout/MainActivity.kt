package com.example.appfortest.layout

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.appfortest.R
import com.example.appfortest.adapter.MainPageAdapter
import com.example.appfortest.data.MainPageData
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    var recycleMainData = ArrayList<MainPageData>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Log.i("25001","Create")


        recycleMainData.add(MainPageData("Test lift cycle"))
        recycleMainData.add(MainPageData("Test recycle view"))
        recycleMainData.add(MainPageData("Test get json by retrofit"))


        RecycleMain.adapter = MainPageAdapter(recycleMainData,this)
        RecycleMain.layoutManager = LinearLayoutManager(this)
    }
    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.apply {
        }
    }
    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        Log.i("250011","Restoer"+savedInstanceState.getString("boat1"))
    }
}
