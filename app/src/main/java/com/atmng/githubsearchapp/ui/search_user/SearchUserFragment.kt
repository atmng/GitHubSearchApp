package com.atmng.githubsearchapp.ui.search_user

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
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
import com.atmng.githubsearchapp.R
import com.atmng.githubsearchapp.ui.search_user.component.SearchBar
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
                    SearchUserScreen()
                }
            }
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.searchUser("test")
    }
}

@Composable
fun SearchUserScreen() {
    Scaffold(
        topBar = {
            TopAppBar({ Text(stringResource(R.string.search_user_title)) })
        }
    ) { innerPadding ->
        LazyColumn(modifier = Modifier
            .padding(innerPadding)
            .padding(16.dp)) {
            item {
                SearchBar(onSearch = {})
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
