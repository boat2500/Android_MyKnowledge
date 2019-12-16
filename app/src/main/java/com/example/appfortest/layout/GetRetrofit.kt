package com.example.appfortest.layout

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.appfortest.R

class GetRetrofit : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_get_retrofit)
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}
