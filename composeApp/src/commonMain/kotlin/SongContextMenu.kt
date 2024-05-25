import ContextMenus.ContextMenu
import ContextMenus.ContextMenuHandler
import ContextMenus.ContextMenuItem
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun SongContextMenu(
    song: Api.OSChild,
    addToQueue: (Api.OSChild) -> Unit,
    contextMenuHandler: ContextMenuHandler,
    modifier: Modifier = Modifier,
) {
    ContextMenu(
        menuContext = contextMenuHandler,
        menuItems = arrayListOf(
            ContextMenuItem(title = "Add to Queue", onClick = { addToQueue(song) }),
            ContextMenuItem(title = "Edit Track", onClick = {}),
            ContextMenuItem(
                title = "Add to Playlist",
                onClick = {},
                subMenuItems = listOf(
                    ContextMenuItem(title = "Add Track", onClick = { addToQueue(song) }),
                    ContextMenuItem(title = "Remove Track", onClick = {})
                )
            ),
            ContextMenuItem(title = "Test", onClick = {}),
            ContextMenuItem(
                title = "Add to Playlist 2",
                onClick = {},
                subMenuItems = listOf(
                    ContextMenuItem(title = "Add Track 2", onClick = { addToQueue(song) }),
                    ContextMenuItem(title = "Remove Track 2", onClick = {})
                )
            ),
        ),
        modifier = modifier
    )
}
