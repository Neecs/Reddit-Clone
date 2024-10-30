package com.neecs.redditclone

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.tooling.preview.Preview
import com.neecs.redditclone.ui.theme.PostList
import com.neecs.redditclone.ui.theme.RedditCloneTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val composeView = findViewById<ComposeView>(R.id.compose_view)
        composeView.setContent {
            RedditCloneTheme {
                RedditCloneApp()
            }
        }
    }
}

@Composable
fun RedditCloneApp() {
    PostList()
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    RedditCloneTheme {
        RedditCloneApp()
    }
}