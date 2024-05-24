package ContextMenus

import androidx.compose.foundation.layout.Box
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
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
            for (item in menuItems) DropdownMenuItem(
                text = { Text(item.title) },
                onClick = {
                    item.onClick()
                    contextMenuHandler.dismissMenu()
                },
                trailingIcon = { if (item.contextSubMenu.isNotEmpty()) Icon(Icons.Default.Menu, "sub menu") }
            )
        }
    }
}
