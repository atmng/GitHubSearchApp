package com.atmng.githubsearchapp.ui.search_user

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.atmng.githubsearchapp.net.onSuccess
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SearchUserViewModel @Inject constructor(
    private val searchUserRepository: SearchUserRepository
) : ViewModel() {

    var uiState by mutableStateOf(SearchUserUiState())
        private set

    fun searchUser(query: String) = viewModelScope.launch {
        searchUserRepository.searchUser(query)
            .onSuccess {
                uiState = uiState.copy(displayUsers = it.items)
                it.items.forEach { Log.d("GitHubSearch", "User login: ${it.login}") }
            }
    }
}
