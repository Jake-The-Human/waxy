package ContextMenus

data class ContextMenuItem(
    val title: String,
    val onClick: () -> Unit
)