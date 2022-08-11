package com.atmng.githubsearchapp.ui.user_detail

import com.atmng.githubsearchapp.model.Repository
import com.atmng.githubsearchapp.model.User

data class UserDetailUiState(
    val displayUser: User? = null,
    val displayRepos: List<Repository> = emptyList(),
    val loading: Boolean = false,
)
