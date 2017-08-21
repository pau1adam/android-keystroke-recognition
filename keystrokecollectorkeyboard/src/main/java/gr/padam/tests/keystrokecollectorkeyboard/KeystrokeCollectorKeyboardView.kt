package gr.padam.tests.keystrokecollectorkeyboard

import android.content.Context
import android.inputmethodservice.KeyboardView
import android.util.AttributeSet
import android.view.View

/**
 * Created by Pavlos Adam on 30-Jul-17.
 */
class KeystrokeCollectorKeyboardView : KeyboardView {

    private var maxPressure = -1f
    private var maxSize = -1f
    private var pressDuration: Long = -1L
    private var startTime = -1L
    private var endTime = -1L
    private var key = "NO KEY"

    constructor(context: Context, attrs: AttributeSet) : super(context, attrs) {
        setOnTouchListener(touchListener)
        onKeyboardActionListener = keyboardListener
    }

    val touchListener = View.OnTouchListener { view, event ->
        TODO("not implemented")
    }

    val keyboardListener = object : OnKeyboardActionListener {

        override fun onKey(primaryCode: Int, keyCodes: IntArray?) {
            TODO("not implemented")
        }

        override fun swipeRight() {
            TODO("not implemented")
        }

        override fun onPress(p0: Int) {
            TODO("not implemented")
        }

        override fun onRelease(primaryCode: Int) {
            TODO("not implemented")
        }

        override fun swipeLeft() {
            TODO("not implemented")
        }

        override fun swipeUp() {
            TODO("not implemented")
        }

        override fun swipeDown() {
            TODO("not implemented")
        }

        override fun onText(text: CharSequence?) {
            TODO("not implemented")
        }
    }

}