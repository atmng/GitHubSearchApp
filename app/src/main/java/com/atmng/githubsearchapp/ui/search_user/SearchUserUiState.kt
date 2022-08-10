package com.atmng.githubsearchapp.ui.search_user

import com.atmng.githubsearchapp.model.User

data class SearchUserUiState(
    val displayUsers: List<User> = emptyList(),
    val loading: Boolean = false,
)
