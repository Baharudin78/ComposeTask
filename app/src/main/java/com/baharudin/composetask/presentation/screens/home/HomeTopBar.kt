package com.baharudin.composetask.presentation.screens.home

import android.content.Context
import android.content.Intent
import android.net.Uri
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.core.content.ContextCompat
import com.baharudin.composetask.R
import com.baharudin.composetask.ui.theme.AppContentColor
import com.baharudin.composetask.ui.theme.AppThemeColor

@Composable
fun HomeTopBar(
) {
    val context = LocalContext.current
    TopAppBar(
        backgroundColor = MaterialTheme.colors.AppThemeColor,
        title = {
            Text(
                text = stringResource(id = R.string.app_name),
                color = MaterialTheme.colors.AppContentColor,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.fillMaxWidth(),
                style = MaterialTheme.typography.h5
            )
        },
        elevation = 0.dp,
        actions = {
            IconButton(onClick = { showMessage(context) }) {
                Icon(
                    imageVector = Icons.Default.Favorite,
                    contentDescription = "HAHAH",
                    tint = Color.Red
                     )
            }
        }
    )
}
fun showMessage(context: Context) {
    val browserIntent = Intent(
        Intent.ACTION_VIEW,
        Uri.parse("https://github.com/Baharudin78/ComposeTask.git")
    )
    ContextCompat.startActivity(context, browserIntent, null)
}