package com.example.appfortest

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    var color = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Log.i("25001","Create")

        button3.setOnClickListener(){
            val intent = Intent(this, Liftcycle::class.java)
            startActivity(intent)
        }

        button.setOnClickListener(){
            startActivity(Intent(this,TestRecycleView::class.java))
        }
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
