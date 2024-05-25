import ExtraComposables.Table
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import io.ktor.client.HttpClient
import io.ktor.client.engine.cio.CIO
import kotlinx.coroutines.runBlocking
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
@Preview
fun fileListView(onSongChange: (Api.OSChild) -> Unit, addSongToQueue: (Api.OSChild) -> Unit, modifier: Modifier = Modifier) {
    var songList: ArrayList<Api.OSChild> = arrayListOf()
    runBlocking {
        Api.getAllSongs(HttpClient(CIO)).onSuccess {
            if (it.searchResult3.song?.isNotEmpty() == true)
                songList = it.searchResult3.song as ArrayList<Api.OSChild>
        }
    }

    Box(
        modifier = modifier
            .fillMaxHeight()
    ) {
        Table(header, songList, Modifier, onSongChange, addSongToQueue)
    }
}

val header = arrayListOf("title", "artist", "album", "duration", "year")
