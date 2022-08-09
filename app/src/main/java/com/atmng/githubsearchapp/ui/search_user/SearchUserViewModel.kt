package com.atmng.githubsearchapp.ui.search_user

import android.util.Log
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

    fun searchUser(query: String) = viewModelScope.launch {
        searchUserRepository.searchUser(query)
            .onSuccess {
                it.items.forEach { Log.d("GitHubSearch", "User login: ${it.login}") }
            }
    }
}
