import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

class Song(
    val title: String = "",
    val artist: String = "",
    val album: String = "",
    val duration: String = "",
    val year: String = ""
) {

    @Composable
    fun songRow() {
        Row(
            modifier = Modifier
                .padding(4.dp)
                .fillMaxWidth()
        ) {
            Text(
                text = title,
                modifier = Modifier.weight(2F)
            )
            VerticalDivider(modifier = Modifier.weight(1F), color = Color.Black)
            Text(
                text = artist,
                modifier = Modifier.weight(2F)
            )
            VerticalDivider(modifier = Modifier.weight(1F), color = Color.Black)
            Text(
                text = album,
                modifier = Modifier.weight(2F)
            )
            VerticalDivider(modifier = Modifier.weight(1F), color = Color.Black)
            Text(
                text = duration,
                modifier = Modifier.weight(2F)
            )
            VerticalDivider(modifier = Modifier.weight(1F), color = Color.Black)
            Text(
                text = year,
                modifier = Modifier.weight(2F)
            )
        }
    }

    companion object {
        val dummyList = arrayOf(
            Song(
                title = "11111 aaaaa",
                artist = "Aretha Franklin",
                album = "I Never Loved a Man the Way I Love You",
                duration = "4:08",
                year = "1967"
            ),
            Song(title = "22222 bbbbb", artist = "The Beatles", album = "Abbey Road", duration = "4:20", year = "1969"),
            Song(
                title = "3333 ccccc",
                artist = "Michael Jackson",
                album = "Thriller",
                duration = "5:25",
                year = "1982"
            ),
            Song(title = "44444 dddddd", artist = "Beyoncé", album = "Lemonade", duration = "3:43", year = "2016"),
            Song(
                title = "55555 eeeee",
                artist = "Queen",
                album = "A Night at the Opera",
                duration = "5:55",
                year = "1975"
            ),
            Song(
                title = "666666 fffff",
                artist = "Bob Dylan",
                album = "Blood on the Tracks",
                duration = "4:12",
                year = "1975"
            ),
            Song(title = "777777 gggg", artist = "Nirvana", album = "Nevermind", duration = "3:42", year = "1991"),
            Song(title = "888888 hhhh", artist = "Radiohead", album = "OK Computer", duration = "4:27", year = "1997"),
            Song(
                title = "999999 iiiiiiiii",
                artist = "The Rolling Stones",
                album = "Sticky Fingers",
                duration = "4:30",
                year = "1971"
            ),
            Song(
                title = "10 jjjjjjj",
                artist = "Stevie Wonder",
                album = "Songs in the Key of Life",
                duration = "5:10",
                year = "1976"
            )
        )
    }
}