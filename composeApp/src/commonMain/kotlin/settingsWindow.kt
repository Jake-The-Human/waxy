import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
expect fun settingsWindow(settings: Settings, onClose: () -> Unit, modifier: Modifier) : Platform