import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.awaitEachGesture
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.input.pointer.*
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch

fun Modifier.onMouseClick(
    onLeftClick: (Offset, PointerKeyboardModifiers) -> Unit = { _, _ -> },
    onRightClick: (Offset, PointerKeyboardModifiers) -> Unit = { _, _ -> },
    onMiddleClick: (Offset, PointerKeyboardModifiers) -> Unit = { _, _ -> },
    onBackClick: (Offset, PointerKeyboardModifiers) -> Unit = { _, _ -> },
    onForwardClick: (Offset, PointerKeyboardModifiers) -> Unit = { _, _ -> },
): Modifier = pointerInput(Unit) {
    coroutineScope {
        awaitEachGesture {
            val event: PointerEvent = awaitPointerEvent()
            when (event.type) {
                PointerEventType.Press -> {
                    val button = event.buttons
                    val offset = event.changes.first { it.pressed }.position
                    when {
                        button.isPrimaryPressed -> launch { onLeftClick(offset, event.keyboardModifiers) }
                        button.isSecondaryPressed -> launch { onRightClick(offset, event.keyboardModifiers) }
                        button.isTertiaryPressed -> launch { onMiddleClick(offset, event.keyboardModifiers) }
                        button.isBackPressed -> launch { onBackClick(offset, event.keyboardModifiers) }
                        button.isForwardPressed -> launch { onForwardClick(offset, event.keyboardModifiers) }
                    }
                }

                else -> Unit
            }
        }
    }
}.clickable {}
