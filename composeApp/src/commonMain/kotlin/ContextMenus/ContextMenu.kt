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
    onDismissRequest: () -> Unit = { contextMenuHandler.dismissMenu() },
) {
    var width by remember { mutableStateOf(0) }
    var height by remember { mutableStateOf(0) }
    DropdownMenu(
        modifier = modifier.onSizeChanged {
            width = it.width
            height = it.height
        },
        expanded = contextMenuHandler.showMenu,
        onDismissRequest = onDismissRequest,
        offset = contextMenuHandler.menuOffset
    ) {
        menuItems.forEach { item ->
            var subMenuHandler by remember { mutableStateOf(ContextMenuHandler()) }
            DropdownMenuItem(
                text = { Text(item.title) },
                onClick = {
                    item.onClick()
                    if (item.contextSubMenu.isEmpty()) {
                        onDismissRequest()
                    } else {
                        subMenuHandler = contextMenuHandler.handleSubMenuClick(DpOffset(width.dp, height.dp))
                        subMenuHandler.handleRightClick(DpOffset(width.dp, height.dp))
                    }
                },
                trailingIcon = { if (item.contextSubMenu.isNotEmpty()) Icon(Icons.Default.Menu, "sub menu") },
            )
            if (item.contextSubMenu.isNotEmpty()) {
                ContextMenu(
                    contextMenuHandler = subMenuHandler,
                    menuItems = item.contextSubMenu,
                    modifier = modifier,
                    onDismissRequest = { contextMenuHandler.dismissMenu() }
                )
            }
        }
    }
}
