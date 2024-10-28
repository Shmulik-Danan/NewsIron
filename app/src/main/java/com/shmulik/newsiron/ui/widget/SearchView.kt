package com.shmulik.newsiron.ui.widget

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.text.selection.TextSelectionColors
import androidx.compose.material.MaterialTheme.colors
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.graphics.Color


@Composable
fun SearchView(
    onQueryChange: (query: String) -> Unit
) {
    var query by rememberSaveable { mutableStateOf("") }
    val focusRequester = remember { FocusRequester() }

    LaunchedEffect(focusRequester) {
        focusRequester.requestFocus()
    }

    Column {
        TextField(
            modifier = Modifier
                .fillMaxWidth()
                .focusRequester(focusRequester),
            placeholder = {
                Text(text = "Search")
            },
            value = query,
            onValueChange = {
                query = it
                onQueryChange(it)
            },
            singleLine = true,
            maxLines = 1,
            colors = TextFieldDefaults.colors(
                cursorColor = colors.onPrimary,
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent,
                selectionColors = TextSelectionColors(colors.onPrimary, colors.onPrimary),
            )

        )
    }
}
