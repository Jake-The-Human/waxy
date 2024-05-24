import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.compose.ui.Modifier

@Composable
fun songQueueView(songQueue: SnapshotStateList<Api.OSChild>, modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .fillMaxSize()
    ) {
        LazyColumn(
            modifier = Modifier.weight(3F),
        ) {
            items(songQueue) { song ->
                Text(
                    text = song.title,
                    Modifier.fillMaxSize()
                        .clickable { songQueue.remove(song) },
                )
                HorizontalDivider()
            }
        }
        PlaybackControlCard(modifier = Modifier.weight(2F))
    }
}