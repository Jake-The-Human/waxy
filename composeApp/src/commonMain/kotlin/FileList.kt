import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

class FileList {
    private var songList = Song.dummyList
    
    @Composable
    fun fileListView() {
        LazyColumn () {
            items(songList) { song ->
                song.songRow()
            }
        }
    }
}
