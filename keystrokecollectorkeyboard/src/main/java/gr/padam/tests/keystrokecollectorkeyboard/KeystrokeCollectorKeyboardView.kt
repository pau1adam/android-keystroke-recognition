package gr.padam.tests.keystrokecollectorkeyboard

import android.content.Context
import android.inputmethodservice.KeyboardView
import android.util.AttributeSet
import android.view.MotionEvent
import android.view.View

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

    constructor(context: Context, attrs: AttributeSet) : super(context, attrs) {
        setOnTouchListener(touchListener)
        onKeyboardActionListener = keyboardListener
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

        override fun onKey(primaryCode: Int, keyCodes: IntArray?) {
            key = Character.toString(primaryCode.toChar())
        }

        override fun swipeRight() {
            TODO("not implemented")
        }

        override fun onPress(p0: Int) {
            //do nothing
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

    private fun setMaxValues(pressure: Float, size: Float) {
        if (pressure > maxPressure) maxPressure = pressure
        if (size > maxSize) maxSize = size
    }

}