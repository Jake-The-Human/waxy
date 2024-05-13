import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Divider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

class FileList {
    private var songList = Song.dummyList

    @Composable
    fun fileListView() {
        Box(
            modifier = Modifier
                .fillMaxHeight()
        ) {
            LazyColumn {
                items(songList) { song ->
                    song.songRow()
                    Divider()
                }
            }
        }
    }
}
