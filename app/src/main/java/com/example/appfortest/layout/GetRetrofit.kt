package com.example.appfortest.layout

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.appfortest.R
import com.example.appfortest.adapter.TitleForRetrofit
import com.example.appfortest.data.TitleForRetrofitData
import kotlinx.android.synthetic.main.activity_get_retrofit.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET


class GetRetrofit : AppCompatActivity() {
    var color = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_get_retrofit)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.title = "Github user"
        callServer(
            networkCallbackListener
        )
    }
    interface GitHubService {
        @GET("/users?since=0")
        open fun getUser(): Call<List<TitleForRetrofitData?>>?
    }
    interface OnNetworkCallbackListener {
        fun onResponse(user: List<TitleForRetrofitData?>?, retrofit: Retrofit?)
        fun onFailure(t: Throwable?)
    }
    var networkCallbackListener: OnNetworkCallbackListener = object : OnNetworkCallbackListener {
        override fun onResponse(user: List<TitleForRetrofitData?>?, retrofit: Retrofit?) {
            GetUserRecycle.adapter = TitleForRetrofit(user as List<TitleForRetrofitData>,this@GetRetrofit)
            GetUserRecycle.layoutManager = LinearLayoutManager(this@GetRetrofit)
        }
        override fun onFailure(t: Throwable?) {
        }
    }
    fun callServer(listener: OnNetworkCallbackListener?) {
        val retrofit = Retrofit.Builder()
            .baseUrl("https://api.github.com")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        val git = retrofit.create(GitHubService::class.java)
        val call = git.getUser()
        call?.enqueue(object : Callback<List<TitleForRetrofitData?>> {
            fun onResponse(response: Response <List<TitleForRetrofitData?>>?, retrofit: Retrofit?) {}
            fun onFailure(t: Throwable?) {}

            override fun onResponse(call: Call<List<TitleForRetrofitData?>>, response: Response<List<TitleForRetrofitData?>>) {
                val user: List<TitleForRetrofitData?>? = response.body()

                if (user != null) {
                    listener!!.onResponse(user, retrofit)
                }
            }
            override fun onFailure(call: Call<List<TitleForRetrofitData?>>, t: Throwable) {
                listener?.onFailure(t)
            }
        })
    }
    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}


