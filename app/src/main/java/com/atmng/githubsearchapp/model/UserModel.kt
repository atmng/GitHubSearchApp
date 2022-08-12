package com.atmng.githubsearchapp.model

import com.google.gson.annotations.SerializedName

data class UserSearchResponse(
    val items: List<User> = emptyList(),
)

data class User(
    val login: String = "",
    val id: Int = 0,
    @SerializedName("avatar_url") val avatarUrl: String = "",
    val name: String? = null,
    val followers: Int = 0,
    val following: Int = 0,
    val bio: String? = null,
)

