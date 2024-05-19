package ContextMenus

import androidx.compose.foundation.layout.Box
import androidx.compose.material.DropdownMenu
import androidx.compose.material.DropdownMenuItem
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.DpOffset
import androidx.compose.ui.unit.dp

@Composable
fun SongContextMenu(
    contextMenuHandler: ContextMenuHandler,
    modifier: Modifier = Modifier,
) {
    Box(modifier = modifier) {
        DropdownMenu(
            expanded = contextMenuHandler.showMenu,
            onDismissRequest = { contextMenuHandler.dismissMenu() },
            offset = DpOffset(contextMenuHandler.menuOffset.x.dp, contextMenuHandler.menuOffset.y.dp)
        ) {
            DropdownMenuItem(onClick = { /* Handle action 1 */ }) {
                Text("Action 1")
            }
            DropdownMenuItem(onClick = { /* Handle action 2 */ }) {
                Text("Action 2")
            }
            DropdownMenuItem(onClick = { /* Handle action 3 */ }) {
                Text("Action 3")
            }
        }
    }
}
