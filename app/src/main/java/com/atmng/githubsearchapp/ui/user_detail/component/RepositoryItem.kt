package com.atmng.githubsearchapp.ui.user_detail.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.atmng.githubsearchapp.R
import com.atmng.githubsearchapp.model.Repository
import com.atmng.githubsearchapp.ui.theme.GitHubSearchAppTheme

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun RepositoryItem(
    repository: Repository,
    onClick: () -> Unit,
) {
    Card(
        modifier = Modifier.padding(horizontal = 16.dp, vertical = 4.dp),
        onClick = onClick,
        elevation = 2.dp
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp, vertical = 12.dp)
        ) {
            Text(
                text = repository.name,
                fontSize = 24.sp
            )
            Text(
                modifier = Modifier.padding(top = 8.dp),
                text = repository.description ?: "",
                color = Color.DarkGray,
                maxLines = 3,
                overflow = TextOverflow.Ellipsis,
            )
            Row(
                modifier = Modifier.padding(top = 8.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                // lang
                if (repository.language != null) {
                    Box(
                        modifier = Modifier
                            .border(width = 1.dp, color = Color.LightGray, shape = RoundedCornerShape(8.dp))
                            .padding(4.dp)
                            .height(16.dp)
                    ) {
                        Text(
                            text = repository.language,
                            fontSize = 12.sp,
                        )
                    }
                    Spacer(modifier = Modifier.size(8.dp))
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
            repository = Repository(
                name = "Repository Name",
                description = "This is my test repository with description!",
                language = "Java",
                starCount = 1234,
            ),
            onClick = {}
        )
    }
}
