import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.Colors
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

class Settings {
    private var usingCustomTheme: Boolean = false
    @Composable
    fun getTheme(): Colors {
        if (usingCustomTheme) return Colors(
            primary = Color(0xFF6200EE),
            primaryVariant = Color(0xFF3700B3),
            secondary = Color(0xFF03DAC6),
            secondaryVariant = Color(0xFF018786),
            background = Color.White,
            surface = Color.White,
            error = Color(0xFFB00020),
            onPrimary = Color.White,
            onSecondary = Color.Black,
            onBackground = Color.Black,
            onSurface = Color.Black,
            onError = Color.White,
            isLight = true)
        return if (isSystemInDarkTheme()) darkColors() else lightColors()}

}

