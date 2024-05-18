import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application

fun main() = application {
    val (openSettings, setOpenSettings) = remember { mutableStateOf(false) }
    Window(
        onCloseRequest = ::exitApplication,
        title = "Waxy",
    ) {
        App(setOpenSettings)

        if (openSettings) {
            Window(
                onCloseRequest = { setOpenSettings(false) },
                title = "Settings"
            ) {
                SettingsWindow(onClose = { setOpenSettings(false) }, Modifier)
            }
        }
    }

}
