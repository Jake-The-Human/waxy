import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Button
import androidx.compose.material.Card
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

    @Composable
    fun songQueueView(songQueue: SnapshotStateList<Api.OSSSong>, modifier: Modifier = Modifier) {
//        runBlocking {
//            val result = Api.getRandomSongs(HttpClient(CIO))
//            result.onSuccess { res ->
//                songList = res.randomSongs.song.map { ossSong ->
//                    Song(ossSong)
//                }.toTypedArray()
//            }
//        }
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
                    Divider()
                }
            }
            // it would be cool if the background was the album art
            Card(modifier = Modifier.padding(4.dp).fillMaxWidth().weight(1F)) {
                Column {
                    Text(text = "now playing")
                    Row (modifier = Modifier.padding(4.dp).align(Alignment.CenterHorizontally)){
                        Button(modifier = Modifier.padding(4.dp, 0.dp), onClick = {}) { Text("⏮️") }
                        Button(modifier = Modifier.padding(4.dp, 0.dp), onClick = {}) {Text("⏯️")}
                        Button(modifier = Modifier.padding(4.dp, 0.dp), onClick = {}) {Text("⏭️")}
                    }
                }
            }
        }
    }