import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import org.jetbrains.compose.resources.ExperimentalResourceApi
import org.jetbrains.compose.ui.tooling.preview.Preview

@OptIn(ExperimentalResourceApi::class)
@Composable
@Preview
fun App() {
    val currentProfile = UserProfileCard()
    val audioVisualizer = AudioVisualizer()
    val currentSelection = UserSelection()
    val songQueue = SongQueue()
    MaterialTheme {
        Column {
            Row {
                Box(
                    modifier = Modifier.weight(1F)
                ) {
                    currentProfile.userProfileView({})
                }
                Box(
                    modifier = Modifier.weight(2F)
                ) {
                    audioVisualizer.audioVisualizerView()
                }
            }
            Row {
                currentSelection.userSelectionView()
                songQueue.songQueueView()
            }
            Row {
                Text(
                    text = getPlatform().name,
                    color = Color.Red
                )
            }
        }
    }
}