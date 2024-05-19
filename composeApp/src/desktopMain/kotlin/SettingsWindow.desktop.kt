import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.selection.selectableGroup
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.RadioButton
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
actual fun SettingsWindow(
    settings: Settings,
    onClose: () -> Unit,
    modifier: Modifier,

): Platform {
    val isSystemDark = isSystemInDarkTheme()
    val themeOptions = listOf("System", "Dark", "Light")
    val (selectedOption, onOptionSelected) = remember { mutableStateOf(settings.getThemeString()) }

    MaterialTheme (colors = settings.getTheme()) {
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
                        style = MaterialTheme.typography.body1.merge(),
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
                        style = MaterialTheme.typography.body1.merge(),
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
                        style = MaterialTheme.typography.body1.merge(),
                        modifier = Modifier.align(Alignment.CenterVertically)
                    )
                }

                Spacer(modifier = Modifier.height(16.dp))
                Button(onClick = onClose) {
                    Text("Close")
                }
            }
        }
    }
    return getPlatform()
}
