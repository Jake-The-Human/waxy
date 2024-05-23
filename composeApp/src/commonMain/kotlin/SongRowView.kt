import ContextMenus.ContextMenuHandler
import ContextMenus.SongContextMenu
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.PointerKeyboardModifiers


@Composable
fun songRowView(song: Api.OSSSong, modifier: Modifier = Modifier, onclick: (song: Api.OSSSong) -> Unit) {
    val contextMenuHandler by remember { mutableStateOf(ContextMenuHandler()) }
    SongContextMenu(contextMenuHandler = contextMenuHandler)
    Row(
        modifier = modifier
            .fillMaxWidth()
            .onMouseClick(
                onLeftClick = { _: Offset, _: PointerKeyboardModifiers -> onclick(song) },
                onRightClick = { offset: Offset, _: PointerKeyboardModifiers ->
                    contextMenuHandler.handleRightClick(
                        offset
                    )
                })

    ) {
        Text(
            text = song.title,
            modifier = Modifier.weight(2F)
        )
        VerticalDivider(modifier = Modifier.weight(1F), color = Color.Black)
        Text(
            text = song.artist ?: "",
            modifier = Modifier.weight(2F)
        )
        VerticalDivider(modifier = Modifier.weight(1F), color = Color.Black)
        Text(
            text = song.album ?: "",
            modifier = Modifier.weight(2F)
        )
        VerticalDivider(modifier = Modifier.weight(1F), color = Color.Black)
        Text(
            text = song.duration.toString(),
            modifier = Modifier.weight(2F)
        )
        VerticalDivider(modifier = Modifier.weight(1F), color = Color.Black)
        Text(
            text = song.year.toString(),
            modifier = Modifier.weight(2F)
        )
    }
}
