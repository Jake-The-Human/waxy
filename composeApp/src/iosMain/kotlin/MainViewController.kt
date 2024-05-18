import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.window.ComposeUIViewController

fun MainViewController() = ComposeUIViewController {
    val (openSettings, setOpenSettings) = remember { mutableStateOf(false) }
    App(setOpenSettings)
}