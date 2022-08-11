package com.atmng.githubsearchapp.ui.user_detail

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.atmng.githubsearchapp.model.Repository
import com.atmng.githubsearchapp.model.User
import com.atmng.githubsearchapp.net.getValue
import com.atmng.githubsearchapp.ui.search_user.SearchUserRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class UserDetailViewModel @Inject constructor(
    private val searchUserRepository: SearchUserRepository,
) : ViewModel() {

    var uiState by mutableStateOf(UserDetailUiState())
        private set

    fun loadContent(userLogin: String) = viewModelScope.launch {
        uiState = uiState.copy(loading = true)
        uiState = uiState.copy(
            loading = false,
            displayUser = getUserDetail(userLogin),
            displayRepos = getRepositories(userLogin)
        )
    }

    private suspend fun getUserDetail(userLogin: String): User? {
        return searchUserRepository.getUserDetail(userLogin).getValue()
    }

    private suspend fun getRepositories(userLogin: String): List<Repository> {
        return searchUserRepository.getRepositories(userLogin).getValue()
            ?: emptyList()
    }
}
