import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.ui.Alignment
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import org.jetbrains.compose.resources.ExperimentalResourceApi

@OptIn(ExperimentalResourceApi::class)
class AudioVisualizer {
    @Composable
    fun audioVisualizerView() {
        Card(
            backgroundColor = Color.DarkGray,
            modifier = Modifier.padding(horizontal = 16.dp, vertical = 32.dp).fillMaxWidth()
        ) {
            Text(
                text = "AudioVisualizer",
            )
        }

    }
}