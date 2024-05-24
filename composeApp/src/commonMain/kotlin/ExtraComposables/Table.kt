package ExtraComposables

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import songRowView

@Composable
fun TableCell(
    text: String,
    modifier: Modifier
) {
    Text(text = text, modifier = modifier)
}

@Composable
fun Table(header: List<String>, data: List<Api.OSChild>, modifier: Modifier = Modifier, onclick: (song: Api.OSChild) -> Unit,  addToQueue: (song: Api.OSChild) -> Unit) {
    Box {
        Column {
            ElevatedCard(modifier = modifier.fillMaxWidth().padding(4.dp)) {
                Row {
                    for (h in header) TableCell(text = h, Modifier.weight(1F))
                }
            }

            // The LazyColumn will be our table. Notice the use of the weights below
            LazyColumn(modifier) {
                // Here are all the lines of your table.
                items(data) { song ->
                    songRowView(song, Modifier.fillMaxWidth(), onclick, addToQueue)
                }
            }
        }
    }
}
