package com.example.appfortest.data

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName


class ProfileData {
    @SerializedName("login")
    @Expose
    var login: String? = null
    @SerializedName("avatar_url")
    @Expose
    var avatarUrl: String? = null
    @SerializedName("html_url")
    @Expose
    var htmlUrl: String? = null
    @SerializedName("name")
    @Expose
    var name: String? = null
    @SerializedName("blog")
    @Expose
    var blog: String? = null
    @SerializedName("location")
    @Expose
    var location: String? = null
    @SerializedName("bio")
    @Expose
    var bio: Any? = null
    @SerializedName("followers")
    @Expose
    var followers: Int? = null
    @SerializedName("following")
    @Expose
    var following: Int? = null

}