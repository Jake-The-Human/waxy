import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material.Card
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
@Preview
fun App() {
    val currentProfile by remember { mutableStateOf(UserProfile.waxyProfile) }
    val songQueue by remember { mutableStateOf(Song.dummyList) }
    MaterialTheme {
        Column {
            Row {
                Box(
                    modifier = Modifier.wrapContentSize()
                ) {
                    userProfileView(currentProfile, {})
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
                        backgroundColor = Color.Cyan,
                        modifier = Modifier
                            .padding(16.dp)
                    ) {
                        fileListView(songQueue)
                    }
                }
                Card(
                    backgroundColor = Color.Cyan,
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