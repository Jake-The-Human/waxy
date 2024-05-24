import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

val emptySong = Api.OSChild(id = "", isDir = false, title = "")

@Composable
fun App(openSettings: (Boolean) -> Unit, settings: Settings) {
    val currentProfile by remember { mutableStateOf(UserProfile.waxyProfile) }
    val songQueue = remember { mutableStateListOf<Api.OSChild>() }
    var currentSong: Api.OSChild by remember { mutableStateOf(emptySong) }

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
