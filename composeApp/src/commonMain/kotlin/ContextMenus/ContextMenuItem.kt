package ContextMenus

data class ContextMenuItem(
    val title: String,
    val onClick: () -> Unit,
    val subMenuItems: List<ContextMenuItem> = emptyList(),
)