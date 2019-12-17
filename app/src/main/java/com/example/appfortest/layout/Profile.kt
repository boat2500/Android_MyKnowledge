package com.example.appfortest.layout

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.appfortest.R
import com.example.appfortest.data.ProfileData
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_profile.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path

class Profile : AppCompatActivity() {
    var user = ""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)
        user = intent.getStringExtra("userName")
        supportActionBar?.setTitle(user)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        callServer(
        networkCallbackListener,user
        )

        button3.setOnClickListener(){
            if (button3.text == "Follow"){
                button3.setText("UnFollow")
                button3.setBackgroundResource(R.color.colorBack)
            }else{
               button3.setText("Follow")
                button3.setBackgroundResource(R.color.colorGreen)
            }
        }
    }
    interface GitHubService {
        @GET("/users/{username}")
        open fun getUser(@Path("username") user: String?): Call<ProfileData?>?
    }
    interface OnNetworkCallbackListener {
        fun onResponse(user: ProfileData?, retrofit: Retrofit?)
        fun onFailure(t: Throwable?)
    }

    var networkCallbackListener: OnNetworkCallbackListener = object : OnNetworkCallbackListener {
        override fun onResponse(user: ProfileData?, retrofit: Retrofit?) { //200
            textView2.setText("@"+user?.login)
            userName_git.setText(user?.name)
            Picasso.get().load(user?.avatarUrl).into(user_image)
            textView3.setText(""+user?.followers+"\nFollowers")
            textView4.setText(""+user?.following+"\nFollowing")
            var M = "Bio: "+user?.bio+"\nLocation: "+user?.location+"\nUrl: "+user?.htmlUrl
            textView5.setText(M)
        }
        override fun onFailure(t: Throwable?) { //fail any course
        }
    }
    fun callServer(listener: OnNetworkCallbackListener?, username: String?) {
        val retrofit = Retrofit.Builder()
            .baseUrl("https://api.github.com")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        val git = retrofit.create(GitHubService::class.java)
        val call = git.getUser(username)
        call?.enqueue(object : Callback<ProfileData?> {
            fun onResponse(response: Response<ProfileData?>?, retrofit: Retrofit?) {}
            fun onFailure(t: Throwable?) {}

            override fun onResponse(call: Call<ProfileData?>, response: Response<ProfileData?>) {
                val user: ProfileData? = response.body()

                if (user != null) {
                    listener!!.onResponse(user, retrofit)
                }
            }

            override fun onFailure(call: Call<ProfileData?>, t: Throwable) {
                listener?.onFailure(t)
            }
        })
    }
    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}
