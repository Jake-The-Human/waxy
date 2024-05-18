import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application

fun main() = application {
    val (openSettings, setOpenSettings) = remember { mutableStateOf(false) }
    val settings by remember { mutableStateOf(Settings()) }
    Window(
        onCloseRequest = ::exitApplication,
        title = "Waxy",
    ) {
        App(setOpenSettings, settings)

        if (openSettings) {
            Window(
                onCloseRequest = { setOpenSettings(false) },
                title = "Settings"
            ) {
                SettingsWindow(settings, onClose = { setOpenSettings(false) }, Modifier)
            }
        }
    }

}
