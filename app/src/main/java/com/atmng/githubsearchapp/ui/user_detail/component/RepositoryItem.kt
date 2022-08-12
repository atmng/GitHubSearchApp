package com.atmng.githubsearchapp.ui.user_detail.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.atmng.githubsearchapp.R
import com.atmng.githubsearchapp.model.Repository
import com.atmng.githubsearchapp.ui.theme.GitHubSearchAppTheme

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun RepositoryItem(
    repository: Repository,
    onClick: () -> Unit,
) {
    Surface(
        color = Color.White,
        onClick = onClick
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            Text(text = repository.name)
            Text(text = repository.description ?: "", maxLines = 3, overflow = TextOverflow.Ellipsis)
            Row {
                // lang
                if (repository.language != null) {
                    Text(text = repository.language)
                    Spacer(modifier = Modifier.size(24.dp))
                }
                // star
                Image(
                    painter = painterResource(id = R.drawable.ic_star),
                    contentDescription = "stars"
                )
                Text(text = stringResource(R.string.user_detail_stars, repository.starCount))
            }
        }
    }
}

@Composable
@Preview
fun RepositoryItemPreview() {
    GitHubSearchAppTheme {
        RepositoryItem(
            repository = Repository(),
            onClick = {}
        )
    }
}
