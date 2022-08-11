package com.atmng.githubsearchapp.ui.search_user.component

import android.R
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.atmng.githubsearchapp.model.User
import com.atmng.githubsearchapp.ui.theme.GitHubSearchAppTheme

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun UserItem(
    modifier: Modifier = Modifier,
    user: User,
    onClick: () -> Unit,
) {
    Surface(
        color = Color.White,
        onClick = onClick
    ) {
        Row(
            modifier = modifier
                .fillMaxWidth()
                .height(72.dp)
                .padding(start = 8.dp, end = 16.dp),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Image(
                modifier = Modifier.size(40.dp),
                painter = painterResource(R.drawable.ic_input_add),
                contentDescription = user.name
            )
            Spacer(Modifier.size(width = 16.dp, height = 0.dp))
            Text(
                modifier = Modifier.fillMaxWidth(),
                text = user.login
            )
        }
    }
}

@Preview
@Composable
fun UserItemPreview() {
    GitHubSearchAppTheme {
        UserItem(
            user = User(
                login = "atmng",
                name = "Akiko T",
                bio = "Hello!",
                id = 0,
                avatarUrl = "https://avatars.githubusercontent.com/u/6967515?v=4",
                followers = 10,
                following = 20
            ),
            onClick = {}
        )
    }
}
