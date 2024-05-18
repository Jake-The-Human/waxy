import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.window.ComposeUIViewController

@Composable
fun MainViewController() {
    val (openSettings, setOpenSettings) = remember { mutableStateOf(false) }
    ComposeUIViewController {
        App(setOpenSettings, settings)
    }
}