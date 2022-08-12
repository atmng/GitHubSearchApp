package com.atmng.githubsearchapp.ui.search_user.component

import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.atmng.githubsearchapp.R

@Composable
fun UserIcon(
    modifier: Modifier = Modifier,
    size: Dp = 40.dp,
    imageUrl: String,
    contentDescription: String?,
) {
    AsyncImage(
        modifier = modifier
            .size(size)
            .clip(CircleShape),
        model = ImageRequest.Builder(LocalContext.current)
            .data(imageUrl)
            .crossfade(true)
            .build(),
        placeholder = painterResource(id = R.drawable.ic_person),
        error = painterResource(id = R.drawable.ic_person),
        contentDescription = contentDescription
    )
}
