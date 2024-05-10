import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import org.jetbrains.compose.resources.ExperimentalResourceApi
import org.jetbrains.compose.resources.painterResource
import waxy.composeapp.generated.resources.Res
import waxy.composeapp.generated.resources.waxy_icon_2

@OptIn(ExperimentalResourceApi::class)
class UserProfile {
    private val user_name = "Waxy"
    private val number_albums = 0
    private val number_songs = 0
//    val user_id: UUID


    @Composable
    fun userProfileView() {
        val padding = 16.dp
        Card(
            backgroundColor = Color.Cyan,
            modifier = Modifier.padding(padding)
        ) {
            Row(modifier = Modifier.wrapContentHeight()) {
//                Column (
//                    modifier = Modifier.padding(8.dp).align(Alignment.Top)
//                ) {
//                    Image(
//                        painter = painterResource(Res.drawable.waxy_icon_2),
//                        contentDescription = "Picture of the current user.",
//                        modifier = Modifier
//                            .scale(0.5F)
//                            .clip(shape = CircleShape)
//                            .weight(1f),
//                        )
//                    Spacer(modifier = Modifier.weight(1f))
//                }
                Column(

                ) {
                    Text(
                        text = user_name,
                        modifier = Modifier.padding(8.dp)
                    )
                    Card(
                        modifier = Modifier.padding(8.dp)
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