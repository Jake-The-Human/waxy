import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.awaitEachGesture
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.input.pointer.PointerEvent
import androidx.compose.ui.input.pointer.PointerEventType
import androidx.compose.ui.input.pointer.PointerKeyboardModifiers
import androidx.compose.ui.input.pointer.isBackPressed
import androidx.compose.ui.input.pointer.isForwardPressed
import androidx.compose.ui.input.pointer.isPrimaryPressed
import androidx.compose.ui.input.pointer.isSecondaryPressed
import androidx.compose.ui.input.pointer.isTertiaryPressed
import androidx.compose.ui.input.pointer.pointerInput
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch

fun Modifier.onMouseClick(
    onLeftClick: (Offset, PointerKeyboardModifiers) -> Unit = { _: Offset, _: PointerKeyboardModifiers -> },
    onRightClick: (Offset, PointerKeyboardModifiers) -> Unit = { _: Offset, _: PointerKeyboardModifiers -> },
    onMiddleClick: (Offset, PointerKeyboardModifiers) -> Unit = { _: Offset, _: PointerKeyboardModifiers -> },
    onBackClick: (Offset, PointerKeyboardModifiers) -> Unit = { _: Offset, _: PointerKeyboardModifiers -> },
    onForwardClick: (Offset, PointerKeyboardModifiers) -> Unit = { _: Offset, _: PointerKeyboardModifiers -> },
): Modifier = pointerInput(Unit) {
    coroutineScope {
        awaitEachGesture {
            val event: PointerEvent = awaitPointerEvent()
            when (event.type) {
                PointerEventType.Press -> {
                    val button = event.buttons
                    val offset = event.changes.first().position
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
