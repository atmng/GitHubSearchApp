package com.atmng.githubsearchapp.model

import com.google.gson.annotations.SerializedName

data class Repository(
    val name: String = "",
    val description: String? = null,
    val language: String? = null,
    @SerializedName("stargazers_count") val starCount: Int = 0,
    @SerializedName("html_url") val url: String = "",
    val fork: Boolean = false,
)
