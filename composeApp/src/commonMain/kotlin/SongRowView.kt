import ContextMenus.ContextMenuHandler
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Text
import androidx.compose.material3.VerticalDivider
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.input.pointer.PointerKeyboardModifiers
import androidx.compose.ui.unit.DpOffset
import androidx.compose.ui.unit.dp


@Composable
fun songRowView(song: Api.OSChild, modifier: Modifier = Modifier, onclick: (song: Api.OSChild) -> Unit,  addToQueue: (song: Api.OSChild) -> Unit, ) {
    val contextMenuHandler by remember { mutableStateOf(ContextMenuHandler()) }

    Row(
        modifier = modifier
            .fillMaxWidth()
            .onMouseClick(
                onLeftClick = { _: Offset, _: PointerKeyboardModifiers -> onclick(song) },
                onRightClick = { offset: Offset, _: PointerKeyboardModifiers -> contextMenuHandler.handleRightClick(DpOffset(offset.x.dp, offset.y.dp)) })

    ) {
        SongContextMenu(song, addToQueue = addToQueue, contextMenuHandler = contextMenuHandler, modifier = Modifier)

        Text(
            text = song.title,
            modifier = Modifier.weight(1F)
        )
        VerticalDivider()
        Text(
            text = song.artist ?: "",
            modifier = Modifier.weight(1F)
        )
        VerticalDivider()
        Text(
            text = song.album ?: "",
            modifier = Modifier.weight(1F)
        )
        VerticalDivider()
        Text(
            text = song.duration.toString(),
            modifier = Modifier.weight(1F)
        )
        Text(
            text = song.year.toString(),
            modifier = Modifier.weight(1F)
        )
    }
}
