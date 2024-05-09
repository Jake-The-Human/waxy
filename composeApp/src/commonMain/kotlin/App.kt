import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import org.jetbrains.compose.resources.ExperimentalResourceApi
import org.jetbrains.compose.ui.tooling.preview.Preview

@OptIn(ExperimentalResourceApi::class)
@Composable
@Preview
fun App() {
    val currentProfile = UserProfile()
    val audioVisualizer = AudioVisualizer()
    val currentSelection = UserSelection()
    val songQueue = SongQueue()
    MaterialTheme {
        Column {
            Row {
                currentProfile.userProfileView()
                audioVisualizer.audioVisualizerView()
            }
            Row {
                currentSelection.userSelectionView()
                songQueue.songQueueView()
            }

        }
    }
}