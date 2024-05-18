import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
actual fun SettingsWindow(
    onClose: () -> Unit,
    modifier: Modifier
): Platform {
    Surface(modifier = modifier.fillMaxWidth()) {
        Column(
            modifier = Modifier.padding(16.dp)
        ) {
            Text("Settings", style = MaterialTheme.typography.h6, modifier = Modifier.align(
                Alignment.CenterHorizontally))
            Spacer(modifier = Modifier.height(16.dp))
            // Add your settings options here
            Button(onClick = onClose) {
                Text("Close")
            }
        }
    }
    return getPlatform()
}
