package ContextMenus

import androidx.compose.foundation.layout.Box
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
    menuContext: ContextMenuHandler,
    menuItems: List<ContextMenuItem>,
    modifier: Modifier = Modifier,
    onDismissRequest: () -> Unit = { menuContext.dismissMenu() },
) {
    var width by remember { mutableStateOf(0) }
    Box {
        DropdownMenu(
            modifier = modifier.onSizeChanged {
                width = it.width
            },
            expanded = menuContext.showMenu,
            onDismissRequest = onDismissRequest,
            offset = menuContext.menuOffset,
            ) {
            menuItems.forEach { item ->
                var subMenuHandler by remember { mutableStateOf(ContextMenuHandler()) }
                DropdownMenuItem(
                    modifier = Modifier,
                    text = { Text(item.title) },
                    onClick = {
                        item.onClick()
                        if (item.subMenuItems.isEmpty()) {
                            menuContext.dismissMenu()
                        } else {
                            subMenuHandler = menuContext.getSubMenuHandler()
                            subMenuHandler.handleRightClick(DpOffset(width.dp, 0.dp))
                        }
                    },
                    trailingIcon = {
                        if (item.subMenuItems.isNotEmpty()) {
                            Icon(Icons.Default.Menu, "sub menu")
                        }
                    },
                )

                if (item.subMenuItems.isNotEmpty()) {
                    val menuHandler by remember { mutableStateOf(menuContext) }
                    ContextMenu(
                        menuContext = subMenuHandler,
                        menuItems = item.subMenuItems,
                        modifier = modifier,
                        onDismissRequest = {
                            menuHandler.dismissMenu()
                            subMenuHandler.dismissMenu()
                        }
                    )
                }
            }
        }
    }
}
