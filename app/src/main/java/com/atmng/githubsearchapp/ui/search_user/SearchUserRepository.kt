package com.atmng.githubsearchapp.ui.search_user

import com.atmng.githubsearchapp.model.Repository
import com.atmng.githubsearchapp.model.User
import com.atmng.githubsearchapp.model.UserSearchResponse
import com.atmng.githubsearchapp.net.ApiResult
import com.atmng.githubsearchapp.net.GitHubSearchApiClient
import com.atmng.githubsearchapp.net.execute
import javax.inject.Inject

class SearchUserRepository @Inject constructor(
    private val apiClient: GitHubSearchApiClient
) {

    suspend fun searchUser(query: String): ApiResult<UserSearchResponse> {
        return apiClient.searchUsers(query).execute()
    }

    suspend fun getUserDetail(userLogin: String): ApiResult<User> {
        return apiClient.getUser(userLogin).execute()
    }
    suspend fun getRepositories(userLogin: String): ApiResult<List<Repository>> {
        return apiClient.getRepositories(userLogin).execute()
    }
}
