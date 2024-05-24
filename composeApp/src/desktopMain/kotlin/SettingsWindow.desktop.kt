import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.selection.selectableGroup
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
actual fun settingsWindow(
    settings: Settings,
    onClose: () -> Unit,
    modifier: Modifier,

    ): Platform {
    val isSystemDark = isSystemInDarkTheme()
    val themeOptions = listOf("System", "Dark", "Light")
    val (selectedOption, onOptionSelected) = remember { mutableStateOf(settings.getThemeString()) }

    MaterialTheme(colorScheme = settings.getTheme()) {
        Surface(modifier = modifier.fillMaxSize()) {
            Column(
                modifier = Modifier.padding(16.dp)
            ) {
                // Add your settings options here

                Text("App Theme")
                // Note that Modifier.selectableGroup() is essential to ensure correct accessibility behavior
                Row(Modifier.selectableGroup()) {
                    RadioButton(
                        selected = (themeOptions[0] == selectedOption),
                        onClick =  {
                            onOptionSelected(themeOptions[0])
                            settings.setTheme(themeOptions[0], isSystemInDarkTheme = isSystemDark)
                        }
                    )
                    Text(
                        text = themeOptions[0],
                        style = MaterialTheme.typography.bodyLarge.merge(),
                        modifier = Modifier.align(Alignment.CenterVertically)
                    )
                    RadioButton(
                        selected = (themeOptions[1] == selectedOption),
                        onClick = {
                            onOptionSelected(themeOptions[1])
                            settings.setTheme(themeOptions[1])
                        }
                    )
                    Text(
                        text = themeOptions[1],
                        style = MaterialTheme.typography.bodyLarge.merge(),
                        modifier = Modifier.align(Alignment.CenterVertically)
                    )
                    RadioButton(
                        selected = (themeOptions[2] == selectedOption),
                        onClick =  {
                            onOptionSelected(themeOptions[2])
                            settings.setTheme(themeOptions[2])
                        }
                    )
                    Text(
                        text = themeOptions[2],
                        style = MaterialTheme.typography.bodyLarge.merge(),
                        modifier = Modifier.align(Alignment.CenterVertically)
                    )
                }

                Spacer(modifier = Modifier.height(16.dp))

                Text("Music Folders")

                Spacer(modifier = Modifier.height(16.dp))
                Button(onClick = onClose) {
                    Text("Close")
                }
            }
        }
    }
    return getPlatform()
}
