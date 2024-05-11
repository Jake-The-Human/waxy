import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

class Song(
    val title: String = "",
    val artist: String = "",
    val album: String = "",
    val duration: String = "",
    val year: String = "") {
    
    @Composable
    fun songRow() {
        Row (
            modifier = Modifier
        ){
            Button(
                onClick = {},
                modifier = Modifier
            ) {
                Text(text = title)
                Spacer(modifier = Modifier.padding(4.dp))
                Text(text = artist)
                Spacer(modifier = Modifier.padding(4.dp))
                Text(text = album)
                Spacer(modifier = Modifier.padding(4.dp))
                Text(text = duration)
                Spacer(modifier = Modifier.padding(4.dp))
                Text(text = year)
            }
        }
    }
    
    companion object {
        val dummyList = arrayOf(
            Song(title = "", artist = "Aretha Franklin", album = "I Never Loved a Man the Way I Love You",duration = "4:08",year = "1967"),
            Song(title = "", artist = "The Beatles", album = "Abbey Road", duration = "4:20", year = "1969"),
            Song(title = "", artist = "Michael Jackson", album = "Thriller", duration = "5:25", year = "1982"),
            Song(title = "", artist = "Beyoncé", album = "Lemonade", duration = "3:43", year = "2016"),
            Song(title = "", artist = "Queen", album = "A Night at the Opera", duration = "5:55", year = "1975"),
            Song(title = "", artist = "Bob Dylan", album = "Blood on the Tracks", duration = "4:12", year = "1975"),
            Song(title = "", artist = "Nirvana", album = "Nevermind", duration = "3:42", year = "1991"),
            Song(title = "", artist = "Radiohead", album = "OK Computer", duration = "4:27", year = "1997"),
            Song(title = "", artist = "The Rolling Stones", album = "Sticky Fingers", duration = "4:30", year = "1971"),
            Song(title = "", artist = "Stevie Wonder", album = "Songs in the Key of Life", duration = "5:10", year = "1976"))
    }
}