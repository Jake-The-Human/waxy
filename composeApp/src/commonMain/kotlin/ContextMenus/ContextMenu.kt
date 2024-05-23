package ContextMenus

import androidx.compose.foundation.layout.Box
import androidx.compose.material.DropdownMenu
import androidx.compose.material.DropdownMenuItem
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.DpOffset
import androidx.compose.ui.unit.dp

@Composable
fun ContextMenu(
    contextMenuHandler: ContextMenuHandler,
    menuItems: List<ContextMenuItem>,
    modifier: Modifier = Modifier,
) {
    Box(modifier = modifier) {
        DropdownMenu(
            expanded = contextMenuHandler.showMenu,
            onDismissRequest = { contextMenuHandler.dismissMenu() },
            offset = DpOffset(contextMenuHandler.menuOffset.x.dp, contextMenuHandler.menuOffset.y.dp)
        ) {
            for (item in menuItems) DropdownMenuItem(onClick = {
                item.onClick()
                contextMenuHandler.dismissMenu()
            }
            ) {
                Text(item.title)
            }
        }
    }
}
