import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
expect fun SettingsWindow(onClose: () -> Unit, modifier: Modifier) : Platform