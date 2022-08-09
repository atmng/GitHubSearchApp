package com.atmng.githubsearchapp.model


data class UserSearchResponse(
    val items: List<User> = emptyList()
)

data class User(
    val login: String,
    val id: Int,
    val avatarUrl: String,
    val gravatarId: String?,
    val url: String,
    val name: String?,
    val followers: Int,
    val following: Int
)

