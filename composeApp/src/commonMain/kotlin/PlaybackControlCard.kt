import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.automirrored.filled.ArrowForward
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material3.Button
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun PlaybackControlCard(modifier: Modifier) {
    // it would be cool if the background was the album art
    ElevatedCard(
        modifier = modifier
            .padding(4.dp)
            .fillMaxWidth()
    ) {
        Column(modifier = Modifier.align(Alignment.CenterHorizontally)) {
            Text(text = "now playing")
            Row(modifier = Modifier.padding(4.dp).align(Alignment.CenterHorizontally)) {
                Button(
                    modifier = Modifier.padding(4.dp, 0.dp),
                    onClick = {}) { Icon(Icons.AutoMirrored.Filled.ArrowBack, "back") }
                Button(modifier = Modifier.padding(4.dp, 0.dp), onClick = {}) { Icon(Icons.Filled.PlayArrow, "play") }
                Button(
                    modifier = Modifier.padding(4.dp, 0.dp),
                    onClick = {}) { Icon(Icons.AutoMirrored.Filled.ArrowForward, "forward") }
            }
        }
    }

}