package com.atmng.githubsearchapp.ui.user_detail.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.atmng.githubsearchapp.R
import com.atmng.githubsearchapp.model.User
import com.atmng.githubsearchapp.ui.theme.GitHubSearchAppTheme

@Composable
fun UserHeader(
    user: User,
    modifier: Modifier = Modifier,
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(start = 8.dp, end = 16.dp),
    ) {
        Image(
            modifier = Modifier
                .size(40.dp)
                .clip(CircleShape),
            painter = painterResource(R.drawable.ic_person),
            contentDescription = user.name,
        )
        Spacer(Modifier.size(width = 16.dp, height = 0.dp))
        Column(
            modifier = Modifier.fillMaxWidth(),
        ) {
            if (!user.name.isNullOrEmpty()) {
                Text(
                    text = user.name,
                    style = MaterialTheme.typography.body1
                )
            }
            Text(
                text = user.login,
                style = MaterialTheme.typography.subtitle1
            )
            Row {
                Text(stringResource(id = R.string.user_detail_following, user.following))
                Spacer(modifier = Modifier.size(8.dp))
                Text(stringResource(id = R.string.user_detail_followers, user.followers))
            }
        }
    }
}

@Preview
@Composable
fun UserHeaderPreview() {
    GitHubSearchAppTheme {
        UserHeader(
            user = User(
                login = "atmng",
                name = "Akiko T",
                following = 1234,
                followers = 7
            )
        )
    }
}
