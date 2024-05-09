import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color

class UserProfile {
    private val user_name: String = "jake"
//    val user_id: UUID
    
    @Composable
    fun userProfileView() {
        Row {
            Text (
                text = user_name,
                color = Color.Cyan
            )
        }
    }
}