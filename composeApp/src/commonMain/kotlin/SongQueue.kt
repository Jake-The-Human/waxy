import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Card
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import io.ktor.client.HttpClient
import io.ktor.client.engine.cio.CIO
import kotlinx.coroutines.runBlocking

    @Composable
    fun songQueueView(songList: ArrayList<Song>) {
//        runBlocking {
//            val result = Api.getRandomSongs(HttpClient(CIO))
//            result.onSuccess { res ->
//                songList = res.randomSongs.song.map { ossSong ->
//                    Song(ossSong)
//                }.toTypedArray()
//            }
//        }
        Column(
            modifier = Modifier
                .fillMaxWidth()
        ) {
            LazyColumn(
                modifier = Modifier.weight(3F)
            ) {
                items(songList) { song ->
                    Text(
                        text = song.title,
                        Modifier.padding(4.dp)
                    )
                    Divider()
                }
            }
            // it would be cool if the background was the album art
            Card(modifier = Modifier.padding(4.dp).fillMaxWidth().weight(1F)) {
                Column {
                    Text(text = "now playing")
                    Text(text = "Title place holder")
                    Text(text = "artist place holder")
                }
            }
        }
    }