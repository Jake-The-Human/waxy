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
            ContextMenuItem("Add to Queue") { addToQueue(song) },
            ContextMenuItem("Edit Track") {}
        ),
        modifier)
}
