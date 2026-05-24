package io.github.funnyphatguy.flicker.feature.swipe

import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import io.github.funnyphatguy.flicker.core.core.Log


@Composable
fun SwipeScreen() {
    LaunchedEffect(Unit) {
        Log.d(
            "Swipe", "feature attached"
        )
    }
    Text(
        "Swipe feature",
        modifier = Modifier.statusBarsPadding()
    )
}