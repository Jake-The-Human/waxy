package ContextMenus

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.onSizeChanged
import androidx.compose.ui.unit.DpOffset
import androidx.compose.ui.unit.dp

@Composable
fun ContextMenu(
    contextMenuHandler: ContextMenuHandler,
    menuItems: List<ContextMenuItem>,
    modifier: Modifier = Modifier,
) {
    var width by remember { mutableStateOf(0) }
    var height by remember { mutableStateOf(0) }
    DropdownMenu(
        modifier = modifier.onSizeChanged {
            width = it.width
        },
        expanded = contextMenuHandler.showMenu,
        onDismissRequest = { contextMenuHandler.dismissMenu() },
        offset = contextMenuHandler.menuOffset,
        ) {
        menuItems.forEach { item ->
            var subMenuHandler by remember { mutableStateOf(ContextMenuHandler()) }
            DropdownMenuItem(
                modifier = Modifier.onSizeChanged {
                    height = it.height
                },
                text = { Text(item.title) },
                onClick = {
                    item.onClick()
                    if (item.contextSubMenu.isEmpty()) {
                        contextMenuHandler.dismissMenu()
                    } else {
                        subMenuHandler = contextMenuHandler.getSubMenuHandler()
                        subMenuHandler.handleRightClick(DpOffset(width.dp, 0.dp))
                    }
                },
                trailingIcon = {
                    if (item.contextSubMenu.isNotEmpty()) {
                        Icon(Icons.Default.Menu, "sub menu")
                    }
                },
            )

            if (item.contextSubMenu.isNotEmpty()) {
                ContextMenu(
                    contextMenuHandler = subMenuHandler,
                    menuItems = item.contextSubMenu,
                    modifier = modifier,
                )
            }
        }
    }
}
