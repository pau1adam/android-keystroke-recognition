package gr.padam.tests.keystrokecollectorkeyboard

import android.app.Activity
import android.content.Context
import android.inputmethodservice.Keyboard
import android.inputmethodservice.KeyboardView
import android.text.Editable
import android.util.AttributeSet
import android.view.MotionEvent
import android.view.View
import android.widget.EditText
import gr.padam.keyrec.KeyPress
import io.reactivex.Observer

/**
 * Created by Pavlos Adam on 30-Jul-17.
 */
class KeystrokeCollectorKeyboardView : KeyboardView {

    private var maxPressure = -1f
    private var maxSize = -1f
    private var pressDuration = -1L
    private var startTime = -1L
    private var endTime = -1L
    private var key = "NO KEY"

    private var isShowingQwerty = true
    private var isShiftPressed = false

    var observer: Observer<KeyPress>? = null

    constructor(context: Context, attrs: AttributeSet) : super(context, attrs) {
        setOnTouchListener(touchListener)
        onKeyboardActionListener = keyboardListener
        keyboard = Keyboard(context, R.xml.qwerty)
        isPreviewEnabled = false
    }

    private val touchListener = View.OnTouchListener { _, event ->
        val pressure = event.pressure
        val size = event.size
        when (event.action) {
            MotionEvent.ACTION_DOWN -> startTime = event.eventTime
            MotionEvent.ACTION_UP -> {
                endTime = event.eventTime
                pressDuration = endTime - startTime
            }
        }
        setMaxValues(pressure, size)
        false
    }

    private val keyboardListener = object : OnKeyboardActionListener {

        val KEYCODE_LANGUAGE_SWITCH = -101

        override fun onKey(primaryCode: Int, keyCodes: IntArray?) {
            key = Character.toString(primaryCode.toChar())
            if (isShiftPressed) key = key.toUpperCase()

            val focusCurrent = (context as Activity).window.currentFocus
            if (focusCurrent == null || focusCurrent !is EditText) {
                reset()
                return
            }
            val editable = focusCurrent.text
            val start = focusCurrent.selectionStart
            val end = focusCurrent.selectionEnd

            when (primaryCode) {
                Keyboard.KEYCODE_DELETE -> deleteKeyImplementation(editable, start, end)
                Keyboard.KEYCODE_DONE -> focusCurrent.focusSearch(View.FOCUS_DOWN)?.requestFocus()
                Keyboard.KEYCODE_SHIFT -> toggleLetterCase()
                Keyboard.KEYCODE_MODE_CHANGE -> toggleSymbolsKeyboard()
                KEYCODE_LANGUAGE_SWITCH -> toastShort(getString(R.string.key_not_supported))
                else -> editable.insert(start, key)
            }
            val key = KeyPress(maxPressure, maxSize, pressDuration, startTime, endTime, key)
            observer?.onNext(key)
        }

        override fun swipeRight() {
            //do nothing
        }

        override fun onPress(p0: Int) {
            //do nothing
        }

        override fun onRelease(primaryCode: Int) {
            //do nothing
        }

        override fun swipeLeft() {
            //do nothing
        }

        override fun swipeUp() {
            //do nothing
        }

        override fun swipeDown() {
            //do nothing
        }

        override fun onText(text: CharSequence?) {
            //do nothing
        }
    }

    private fun reset() {
        maxPressure = -1f
        maxSize = -1f
        pressDuration = -1L
        startTime = -1L
        endTime = -1L
        key = "NO KEY"
    }

    private fun setMaxValues(pressure: Float, size: Float) {
        if (pressure > maxPressure) maxPressure = pressure
        if (size > maxSize) maxSize = size
    }

    fun toggleSymbolsKeyboard() {
        keyboard = if (isShowingQwerty) {
            isShiftPressed = false
            Keyboard(context, R.xml.symbols)
        } else {
            Keyboard(context, R.xml.qwerty)
        }
        isShowingQwerty = !isShowingQwerty
    }

    fun toggleLetterCase() {
        isShiftPressed = !isShiftPressed
        isShifted = isShiftPressed
        invalidateAllKeys()
    }

    private fun deleteKeyImplementation(editable: Editable, start: Int, end: Int) {
        if (start > 0) {
            editable.delete(start - 1, start)
        } else {
            editable.delete(start, end)
        }
    }
}