package com.atmng.githubsearchapp.model


data class UserSearchResponse(
    val items: List<User> = emptyList()
)

data class User(
    val login: String = "",
    val id: Int = 0,
    val avatarUrl: String = "",
    val gravatarId: String? = null,
    val name: String? = null,
    val followers: Int = 0,
    val following: Int = 0,
    val bio: String? = null,
)

