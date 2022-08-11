package com.atmng.githubsearchapp.ui.user_detail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.Divider
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
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.fragment.navArgs
import com.atmng.githubsearchapp.R
import com.atmng.githubsearchapp.ui.theme.GitHubSearchAppTheme
import com.atmng.githubsearchapp.ui.user_detail.component.RepositoryItem
import com.atmng.githubsearchapp.ui.user_detail.component.UserHeader
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class UserDetailFragment : Fragment() {

    private val args by navArgs<UserDetailFragmentArgs>()
    private val viewModel by viewModels<UserDetailViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        return ComposeView(requireContext()).apply {
            setViewCompositionStrategy(ViewCompositionStrategy.DisposeOnViewTreeLifecycleDestroyed)
            setContent {
                GitHubSearchAppTheme {
                    UserDetailScreen(
                        viewModel = viewModel,
                    )
                }
            }
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.loadContent(args.userLogin)
    }
}

@Composable
private fun UserDetailScreen(
    viewModel: UserDetailViewModel = viewModel(),
) {
    Scaffold(
        topBar = {
            TopAppBar({ Text(stringResource(R.string.user_detail_title)) })
        }
    ) { innerPadding ->
        LazyColumn(Modifier.padding(innerPadding)) {
            if (viewModel.uiState.displayUser != null) {
                item {
                    UserHeader(viewModel.uiState.displayUser!!)
                }
                itemsIndexed(viewModel.uiState.displayRepos) { index, repo ->
                    RepositoryItem(
                        repository = repo,
                        onClick = {
                        }
                    )
                    if (index < viewModel.uiState.displayRepos.lastIndex) {
                        Divider()
                    }
                }
            }

        }
    }
}

@Preview
@Composable
fun UserDetailScreenPreview() {
    GitHubSearchAppTheme {
        UserDetailScreen()
    }
}