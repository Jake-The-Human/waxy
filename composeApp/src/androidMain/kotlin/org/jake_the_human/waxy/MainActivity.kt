package org.jake_the_human.waxy

import App
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.tooling.preview.Preview

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val (openSettings, setOpenSettings) = remember { mutableStateOf(false) }
            App(setOpenSettings, settings)
        }
    }
}

@Preview
@Composable
fun AppAndroidPreview() {
    val (openSettings, setOpenSettings) = remember { mutableStateOf(false) }
    App(setOpenSettings, settings)
}