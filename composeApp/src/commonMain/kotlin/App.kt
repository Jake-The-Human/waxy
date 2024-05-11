import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import org.jetbrains.compose.resources.ExperimentalResourceApi
import org.jetbrains.compose.ui.tooling.preview.Preview

@OptIn(ExperimentalResourceApi::class)
@Composable
@Preview
fun App() {
    val currentProfile = UserProfileCard()
    val audioVisualizer = AudioVisualizer()
    val currentSelection = FileList()
    val songQueue = SongQueue()
    MaterialTheme {
        Column {
            Row {
                Box(
                    modifier = Modifier.wrapContentSize()
                ) {
                    currentProfile.userProfileView({})
                }
//                Box(
//                    modifier = Modifier.weight(2F)
//                ) {
//                    audioVisualizer.audioVisualizerView()
//                }
            }
            Row {
                ElevatedCard(
                    elevation = CardDefaults.cardElevation(
                        defaultElevation = 6.dp
                    ),
                    modifier = Modifier
                        .padding(16.dp)
                        .weight(3F)
                ) {
                    currentSelection.fileListView()
                }
                ElevatedCard(
                    elevation = CardDefaults.cardElevation(
                        defaultElevation = 6.dp
                    ),
                    modifier = Modifier
                        .padding(16.dp)
                        .weight(1F)
                )  {
                    songQueue.songQueueView()
                }
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