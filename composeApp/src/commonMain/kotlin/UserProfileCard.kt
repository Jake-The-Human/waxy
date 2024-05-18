import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Button
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import org.jetbrains.compose.resources.ExperimentalResourceApi
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.ui.tooling.preview.Preview
import waxy.composeapp.generated.resources.Res
import waxy.composeapp.generated.resources.waxy_icon_2

@OptIn(ExperimentalResourceApi::class)
@Composable
@Preview
fun userProfileView(profile: UserProfile, onClick: () -> Unit) {
    val padding = 16.dp
    Card(
        backgroundColor = Color.Cyan,
        modifier = Modifier
            .wrapContentSize()
            .padding(padding)
    ) {
        Row(
            modifier = Modifier
        ) {
            Column(
                modifier = Modifier
                    .wrapContentSize()
                    .align(Alignment.CenterVertically)
                    .padding(8.dp)
            ) {
                Image(
                    painter = painterResource(Res.drawable.waxy_icon_2),
                    contentDescription = "Picture of the current user.",
                    modifier = Modifier
                        .size(width = 64.dp, height = 64.dp)
                        .clip(shape = CircleShape)
                )
            }
            Column(modifier = Modifier) {
                Row {
                    Text(
                        text = profile.userName,
                        style = MaterialTheme.typography.h4,
                        modifier = Modifier.padding(8.dp)
                    )
                    Button(
                        onClick = { onClick() },
                        modifier = Modifier
                            .padding(8.dp)
                            .align(Alignment.CenterVertically)
                    ) {
                        Text(text = "Settings")
                    }
                }

                Card(
                    modifier = Modifier
                        .wrapContentSize()
                        .padding(8.dp)
                ) {
                    Row {
                        Text(
                            text = "Albums: ${profile.numberAlbums}",
                            modifier = Modifier.padding(4.dp).weight(1f),
                            textAlign = TextAlign.Center,
                        )
                        Text(
                            text = "Songs: ${profile.numberSongs}",
                            modifier = Modifier.padding(4.dp).weight(1f),
                            textAlign = TextAlign.Center,
                        )
                    }
                }
            }
        }
    }
}
