import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import org.jetbrains.compose.ui.tooling.preview.Preview

@OptIn(ExperimentalMaterialApi::class)
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
                Column (modifier = Modifier.weight(3F)) {
                    Row(
                        modifier = Modifier
                            .padding(4.dp)
                    ) {
                        Text(
                            text = "title",
                            modifier = Modifier.weight(2F)
                        )
                        VerticalDivider(modifier = Modifier.weight(1F))
                        Text(
                            text = "artist",
                            modifier = Modifier.weight(2F)
                        )
                        VerticalDivider(modifier = Modifier.weight(1F))
                        Text(
                            text = "album",
                            modifier = Modifier.weight(2F)
                        )
                        VerticalDivider(modifier = Modifier.weight(1F))
                        Text(
                            text = "duration",
                            modifier = Modifier.weight(2F)
                        )
                        VerticalDivider(modifier = Modifier.weight(1F))
                        Text(
                            text = "year",
                            modifier = Modifier.weight(2F)
                        )
                    }
                    Divider()
                    Card(
                        backgroundColor = Color.Cyan,
                        modifier = Modifier
                            .padding(16.dp)
                    ) {
                        currentSelection.fileListView()
                    }
                }
                Card(
                    backgroundColor = Color.Cyan,
                    modifier = Modifier
                        .padding(16.dp)
                        .weight(1F)
                ) {
                    songQueue.songQueueView()
                }
            }
        }
    }
}