package com.example.appfortest.data

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName


data class TitleForRetrofitData (
    @SerializedName("login")
    @Expose
    var login: String? = null,
    @SerializedName("avatar_url")
    @Expose
    var avatarUrl: String? = null

)