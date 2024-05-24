package ContextMenus

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.unit.DpOffset

class ContextMenuHandler {
    var showMenu by mutableStateOf(false)
        private set
    var menuOffset by mutableStateOf(DpOffset.Zero)
        private set

    private val subMenuHandlers = mutableListOf<ContextMenuHandler>()

    fun handleRightClick(position: DpOffset) {
        menuOffset = position
        showMenu = true
        dismissAllSubMenus()
    }

    fun handleSubMenuClick(position: DpOffset): ContextMenuHandler {
        val subMenuHandler = ContextMenuHandler()
        subMenuHandler.menuOffset = position
        subMenuHandlers.add(subMenuHandler)
        return subMenuHandler
    }

    fun dismissMenu() {
        showMenu = false
        dismissAllSubMenus()
    }

    private fun dismissAllSubMenus() {
        subMenuHandlers.forEach { it.dismissMenu() }
        subMenuHandlers.clear()
    }
}
