import ContextMenus.ContextMenu
import ContextMenus.ContextMenuHandler
import ContextMenus.ContextMenuItem
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun SongContextMenu(
    song: Api.OSSSong,
    addToQueue: (Api.OSSSong) -> Unit,
    contextMenuHandler: ContextMenuHandler,
    modifier: Modifier = Modifier,
) {
    ContextMenu(contextMenuHandler,
        arrayListOf(
            ContextMenuItem(title = "Add to Queue", onClick = { addToQueue(song) }),
            ContextMenuItem(title = "Edit Track", onClick = {}),
            ContextMenuItem(
                title = "Add to Playlist",
                onClick = {},
                contextSubMenu = listOf(ContextMenuItem(title = "Edit Track", onClick = {}))
            ),
        ),
        modifier)
}
