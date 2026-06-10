package io.github.funnyphatguy.flicker

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import io.github.funnyphatguy.flicker.core.ui.kit.FlickerTheme
import io.github.funnyphatguy.flicker.feature.swipe.SwipeScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            FlickerTheme {
                SwipeScreen()
            }
        }
    }
}