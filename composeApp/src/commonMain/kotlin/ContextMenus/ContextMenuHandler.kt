package ContextMenus

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.geometry.Offset

class ContextMenuHandler {
    var showMenu by mutableStateOf(false)
        private set
    var menuOffset by mutableStateOf(Offset.Zero)
        private set

    fun handleRightClick(position: Offset) {
        menuOffset = position
        showMenu = true
    }

    fun dismissMenu() {
        showMenu = false
    }
}
