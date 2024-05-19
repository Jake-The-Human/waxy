import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

class Song(ossSong: Api.OSSSong) {
    val title = ossSong.title
    val artist = ossSong.artist
    val album = ossSong.album
    val duration = "TODO"
    val year = ossSong.year

    @Composable
    fun songRow(modifier: Modifier = Modifier, onclick: (song: Song) -> Unit) {
        Row(
            modifier = modifier
                .fillMaxWidth()
                .clickable { onclick(this) },
        ) {
            Text(
                text = title,
                modifier = Modifier.weight(2F)
            )
            VerticalDivider(modifier = Modifier.weight(1F), color = Color.Black)
            Text(
                text = artist?: "",
                modifier = Modifier.weight(2F)
            )
            VerticalDivider(modifier = Modifier.weight(1F), color = Color.Black)
            Text(
                text = album?: "",
                modifier = Modifier.weight(2F)
            )
            VerticalDivider(modifier = Modifier.weight(1F), color = Color.Black)
            Text(
                text = "TODO: DURATION",
                modifier = Modifier.weight(2F)
            )
            VerticalDivider(modifier = Modifier.weight(1F), color = Color.Black)
            Text(
                text = year.toString(),
                modifier = Modifier.weight(2F)
            )
        }
    }

    companion object {
        val dummyList = arrayListOf(
            Song(Api.OSSSong(
                id = "1",
                title = "11111 aaaaa",
                artist = "Aretha Franklin",
                album = "I Never Loved a Man the Way I Love You",
                year = 1967,
                isDir = false,
                type = "music"
            )),
            Song(Api.OSSSong(
                id = "2",
                title = "22222 bbbbb",
                artist = "The Beatles",
                album = "Abbey Road",
                year = 1969,
                isDir = false,
                type = "music"
            )),
            Song(Api.OSSSong(
                id = "3",
                title = "3333 ccccc",
                artist = "Michael Jackson",
                album = "Thriller",
                year = 1982,
                isDir = false,
                type = "music"
            )),
        )
    }
}