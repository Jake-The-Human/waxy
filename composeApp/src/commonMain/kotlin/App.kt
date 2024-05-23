import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun App(openSettings: (Boolean) -> Unit, settings: Settings) {
    val currentProfile by remember { mutableStateOf(UserProfile.waxyProfile) }
    val songQueue = remember { mutableStateListOf<Api.OSSSong>() }
    var currentSong: Api.OSSSong by remember { mutableStateOf(Api.OSSSong(id = "", isDir = false, title = "", type = "")) }

    MaterialTheme (colors = settings.getTheme()) {
        Surface {
            Column {
                Row {
                    Box(
                        modifier = Modifier.wrapContentSize()
                    ) {
                        Column {
                            userProfileView(currentProfile)
                            Button(
                                onClick = { openSettings(true) },
                                modifier = Modifier
                                    .padding(8.dp)
                            ) {
                                Text(text = "Settings")
                            }
                        }
                    }
//                Box(
//                    modifier = Modifier.weight(2F)
//                ) {
//                    audioVisualizerView()
//                }
                }
                Row {
                    Column(modifier = Modifier.weight(3F)) {
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
                            modifier = Modifier
                                .padding(16.dp)
                        ) {
                            fileListView(onSongChange = { currentSong = it }, Modifier)
                        }
                    }
                    Card(
                        modifier = Modifier
                            .padding(16.dp)
                            .weight(1F)
                    ) {
                        songQueueView(songQueue)
                    }
                }
            }
        }
    }
}
