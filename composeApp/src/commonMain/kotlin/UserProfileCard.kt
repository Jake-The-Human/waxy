import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import org.jetbrains.compose.resources.ExperimentalResourceApi
import org.jetbrains.compose.resources.painterResource
import waxy.composeapp.generated.resources.Res
import waxy.composeapp.generated.resources.waxy_icon_2
import androidx.compose.foundation.layout.size
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard


@OptIn(ExperimentalResourceApi::class)
class UserProfileCard {
    private val user_name = "Waxy"
    private val number_albums = 0
    private val number_songs = 0
//    val user_id: UUID


    @Composable
    fun userProfileView(onClick: () -> Unit) {
        val padding = 16.dp
        ElevatedCard(
            elevation = CardDefaults.cardElevation(
                defaultElevation = 6.dp
                ),
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
                            text = user_name,
                            style = MaterialTheme.typography.titleLarge,
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
                                text = "Albums: $number_albums",
                                modifier = Modifier.padding(4.dp).weight(1f),
                                textAlign = TextAlign.Center,
                            )
                            Text(
                                text = "Songs: $number_songs",
                                modifier = Modifier.padding(4.dp).weight(1f),
                                textAlign = TextAlign.Center,
                            )
                        }
                    }
                }
            }
        }
    }
}
