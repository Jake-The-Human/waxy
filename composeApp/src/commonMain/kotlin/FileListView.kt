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
    runBlocking {
        Api.getAllSongs(HttpClient(CIO)).onSuccess {
            songList = it.searchResult3.song as ArrayList<Api.OSChild>
        }
    }

    Box(
        modifier = modifier
            .fillMaxHeight()
    ) {
        Table(header, songList, Modifier, onSongChange, addSongToQueue)
//            items(dummyList) { song ->
//                songRowView(song, Modifier, onSongChange, addSongToQueue)
//                HorizontalDivider()
//            }
    }
}

val header = arrayListOf("title", "artist", "album", "duration", "year")

var songList = arrayListOf(
    Api.OSChild(
        id = "1",
        title = "11111 aaaaa",
        artist = "Aretha Franklin",
        album = "I Never Loved a Man the Way I Love You",
        year = 1967,
        isDir = false,
        type = "music"
    ),
    Api.OSChild(
        id = "2",
        title = "22222 bbbbb",
        artist = "The Beatles",
        album = "Abbey Road",
        year = 1969,
        isDir = false,
        type = "music"
    ),

    Api.OSChild(
        id = "3",
        title = "3333 ccccc",
        artist = "Michael Jackson",
        album = "Thriller",
        year = 1982,
        isDir = false,
        type = "music"
    ),
    Api.OSChild(
        id = "1",
        title = "11111 aaaaa",
        artist = "Aretha Franklin",
        album = "I Never Loved a Man the Way I Love You",
        year = 1967,
        isDir = false,
        type = "music"
    ),
    Api.OSChild(
        id = "2",
        title = "22222 bbbbb",
        artist = "The Beatles",
        album = "Abbey Road",
        year = 1969,
        isDir = false,
        type = "music"
    ),

    Api.OSChild(
        id = "3",
        title = "3333 ccccc",
        artist = "Michael Jackson",
        album = "Thriller",
        year = 1982,
        isDir = false,
        type = "music"
    ),
    Api.OSChild(
        id = "1",
        title = "11111 aaaaa",
        artist = "Aretha Franklin",
        album = "I Never Loved a Man the Way I Love You",
        year = 1967,
        isDir = false,
        type = "music"
    ),
    Api.OSChild(
        id = "2",
        title = "22222 bbbbb",
        artist = "The Beatles",
        album = "Abbey Road",
        year = 1969,
        isDir = false,
        type = "music"
    ),

    Api.OSChild(
        id = "3",
        title = "3333 ccccc",
        artist = "Michael Jackson",
        album = "Thriller",
        year = 1982,
        isDir = false,
        type = "music"
    ),
    Api.OSChild(
        id = "1",
        title = "11111 aaaaa",
        artist = "Aretha Franklin",
        album = "I Never Loved a Man the Way I Love You",
        year = 1967,
        isDir = false,
        type = "music"
    ),
    Api.OSChild(
        id = "2",
        title = "22222 bbbbb",
        artist = "The Beatles",
        album = "Abbey Road",
        year = 1969,
        isDir = false,
        type = "music"
    ),

    Api.OSChild(
        id = "3",
        title = "3333 ccccc",
        artist = "Michael Jackson",
        album = "Thriller",
        year = 1982,
        isDir = false,
        type = "music"
    ),
)
