import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

val emptySong = Api.OSSSong(id = "", isDir = false, title = "", type = "")

@Composable
fun App(openSettings: (Boolean) -> Unit, settings: Settings) {
    val currentProfile by remember { mutableStateOf(UserProfile.waxyProfile) }
    val songQueue = remember { mutableStateListOf<Api.OSSSong>() }
    var currentSong: Api.OSSSong by remember { mutableStateOf(emptySong) }

    MaterialTheme(colorScheme = settings.getTheme()) {
        Surface {
            Column {
                Row(
                    modifier = Modifier.wrapContentSize()
                ) {

                    userProfileView(currentProfile, Modifier.weight(9F))
                    Button(
                        onClick = { openSettings(true) },
                        modifier = Modifier
                            .align(Alignment.CenterVertically)
                            .weight(1F)
                            .padding(8.dp)
                    ) {
                        Icon(Icons.Default.Settings, "settings")
                    }
                }
                Row {

                        Card(
                            modifier = Modifier
                                .padding(16.dp)
                                .weight(3F)
                        ) {
                            fileListView(onSongChange = { currentSong = it }, addSongToQueue = { songQueue.add(it) }, Modifier)
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
