import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Divider
import androidx.compose.runtime.Composable
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.compose.ui.Modifier
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
@Preview
fun fileListView(songQueue: SnapshotStateList<Song>, modifier: Modifier = Modifier) {
    Box(
        modifier = modifier
            .fillMaxHeight()
    ) {
        LazyColumn {
            items(Song.dummyList) { song ->
                song.songRow {
                    songQueue.add(it)
                }
                Divider()
            }
        }
    }
}
