package com.atmng.githubsearchapp.net

import com.atmng.githubsearchapp.model.Repository
import com.atmng.githubsearchapp.model.User
import com.atmng.githubsearchapp.model.UserSearchResponse
import retrofit2.Response
import javax.inject.Inject

interface GitHubSearchApiClient {
    suspend fun searchUsers(query: String): Response<UserSearchResponse>

    suspend fun getUser(userLogin: String): Response<User>

    suspend fun getRepositories(userLogin: String): Response<List<Repository>>
}

class GitHubSearchApiClientImpl @Inject constructor(
    private val gitHubSearchService: GitHubSearchService
) : GitHubSearchApiClient {

    override suspend fun searchUsers(query: String): Response<UserSearchResponse> {
        return gitHubSearchService.searchUsers(query)
    }

    override suspend fun getUser(userLogin: String): Response<User> {
        return gitHubSearchService.getUser(userLogin)
    }

    override suspend fun getRepositories(userLogin: String): Response<List<Repository>> {
        return gitHubSearchService.getRepositories(userLogin)
    }
}