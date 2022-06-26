package com.baharudin.composetask.presentation.components

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.baharudin.composetask.R

@Composable
fun ReleaseDateComponent(releaseDate : String) {
    Row(
        modifier = Modifier.fillMaxHeight(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(painter = painterResource(id = R.drawable.calendar),
            contentDescription = null,
            modifier = Modifier.padding(end = 2.dp)
        )
        Text(text = releaseDate, style = MaterialTheme.typography.body2)
    }
}