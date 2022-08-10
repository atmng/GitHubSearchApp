package com.atmng.githubsearchapp.ui.search_user

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.platform.ViewCompositionStrategy
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.viewmodel.compose.viewModel
import com.atmng.githubsearchapp.R
import com.atmng.githubsearchapp.ui.search_user.component.SearchBar
import com.atmng.githubsearchapp.ui.search_user.component.UserItem
import com.atmng.githubsearchapp.ui.theme.GitHubSearchAppTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SearchUserFragment : Fragment() {

    companion object {
        fun newInstance() = SearchUserFragment()
    }

    private val viewModel by viewModels<SearchUserViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        return ComposeView(requireContext()).apply {

            setViewCompositionStrategy(ViewCompositionStrategy.DisposeOnViewTreeLifecycleDestroyed)
            setContent {
                GitHubSearchAppTheme {
                    SearchUserScreen(
                        viewModel = viewModel
                    )
                }
            }
        }
    }
}

@Composable
fun SearchUserScreen(
    viewModel: SearchUserViewModel = viewModel(),
) {
    Scaffold(
        topBar = {
            TopAppBar({ Text(stringResource(R.string.search_user_title)) })
        }
    ) { innerPadding ->
        Column(Modifier.padding(innerPadding)) {
            SearchBar(
                modifier = Modifier.padding(16.dp),
                onSearch = { query ->
                    viewModel.searchUser(query)
                }
            )
            LazyColumn {
                items(viewModel.uiState.displayUsers) { item ->
                    UserItem(
                        user = item,
                        onClick = {
                            // TODO navigate user page
                        }
                    )
                }
            }
        }
    }
}

@Preview
@Composable
fun SearchUserScreenPreview() {
    GitHubSearchAppTheme {
        SearchUserScreen()
    }
}
