package com.atmng.githubsearchapp.ui.search_user.component

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.text.KeyboardActionScope
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.tooling.preview.Preview
import com.atmng.githubsearchapp.ui.theme.GitHubSearchAppTheme

@Composable
fun SearchBar(
    modifier: Modifier = Modifier,
    onSearch: (KeyboardActionScope.() -> Unit)?,
) {
    var text by remember { mutableStateOf("") }
    TextField(
        modifier = modifier.fillMaxWidth(),
        value = text,
        onValueChange = { text = it },
        keyboardActions = KeyboardActions(onSearch = onSearch),
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