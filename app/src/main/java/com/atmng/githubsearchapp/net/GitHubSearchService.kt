package com.atmng.githubsearchapp.net

import com.atmng.githubsearchapp.model.Repository
import com.atmng.githubsearchapp.model.User
import com.atmng.githubsearchapp.model.UserSearchResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface GitHubSearchService {

    @GET("/search/users")
    suspend fun searchUsers(
        @Query("q") query: String
    ): Response<UserSearchResponse>

    @GET("/users/{user_name}")
    suspend fun getUser(
        @Path("user_name") userName: String
    ): Response<User>

    @GET("/users/{user_name}/repos")
    suspend fun getRepositories(
        @Path("user_name") userName: String,
    ): Response<List<Repository>>
}