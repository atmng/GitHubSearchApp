package com.atmng.githubsearchapp.ui.search_user.component

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.tooling.preview.Preview
import com.atmng.githubsearchapp.R
import com.atmng.githubsearchapp.ui.theme.GitHubSearchAppTheme

@Composable
fun SearchBar(
    modifier: Modifier = Modifier,
    onSearch: ((String) -> Unit),
) {
    var text by remember { mutableStateOf("") }
    TextField(
        modifier = modifier.fillMaxWidth(),
        value = text,
        label = { Text(text = stringResource(id = R.string.search_user_hint)) },
        onValueChange = { text = it },
        keyboardActions = KeyboardActions(
            onSearch = { onSearch(text) }
        ),
        keyboardOptions = KeyboardOptions(imeAction = ImeAction.Search)
    )
}

@Preview
@Composable
fun SearchBarPreview() {
    GitHubSearchAppTheme {
        SearchBar(onSearch = {})
    }
}