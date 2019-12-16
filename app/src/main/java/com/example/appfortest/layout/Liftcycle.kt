package com.example.appfortest.layout

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.appfortest.R
import kotlinx.android.synthetic.main.activity_liftcycle.*

class Liftcycle : AppCompatActivity() {

    var color = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_liftcycle)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        button2.setOnClickListener(){
            if(button2.text == "True"){
                button2.setText("False")
                button2.setBackgroundResource(R.color.colorBack)
                color = 1
            }else{
                button2.setText("True")
                button2.setBackgroundResource(R.color.colorGreen)
                color = 1
            }
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.apply {
            putString("button2_text",button2.text.toString())
            putInt("button2_color",color)
        }
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        button2.apply {
            setText(savedInstanceState.getString("button2_text"))

            if (savedInstanceState.getInt("button2_color") == 0) {
                button2.setBackgroundResource(R.color.colorGreen)
                color = 0
            } else {
                button2.setBackgroundResource(R.color.colorBack)
                color = 1
            }
        }
    }
    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}
