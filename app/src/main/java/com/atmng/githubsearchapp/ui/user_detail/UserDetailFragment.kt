package com.atmng.githubsearchapp.ui.user_detail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.platform.ViewCompositionStrategy
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.atmng.githubsearchapp.R
import com.atmng.githubsearchapp.ui.search_user.SearchUserScreen
import com.atmng.githubsearchapp.ui.search_user.SearchUserViewModel
import com.atmng.githubsearchapp.ui.theme.GitHubSearchAppTheme

class UserDetailFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        return ComposeView(requireContext()).apply {
            setViewCompositionStrategy(ViewCompositionStrategy.DisposeOnViewTreeLifecycleDestroyed)
            setContent {
                GitHubSearchAppTheme {
                }
            }
        }
    }
}

@Composable
private fun UserDetailScreen() {
    Scaffold(
        topBar = {
            TopAppBar({ Text(stringResource(R.string.user_detail_title)) })
        }
    ) { innerPadding ->
        Column(modifier = Modifier.padding(innerPadding)) {
        }
    }
}

@Preview
@Composable
private fun UserDetailScreenPreview() {
    GitHubSearchAppTheme {
        UserDetailScreen()
    }
}