package gr.padam.tests.keystrokecollectorkeyboard

import android.app.Activity
import android.content.Context
import android.text.InputType
import android.view.inputmethod.InputMethodManager
import android.widget.EditText

/**
 * Created by Pavlos Adam on 27-Aug-17.
 */

/**
 * Hide soft keyboard
 */
fun Activity.hideKeyboard(): Boolean {
    val view = currentFocus
    view?.let {
        val inputMethodManager = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        return inputMethodManager.hideSoftInputFromWindow(view.windowToken, InputMethodManager.HIDE_NOT_ALWAYS)
    }
    return false
}


fun EditText.disableDefaultKeyboard() {
    //if default keyboard is visible hide it
    setOnFocusChangeListener { view, hasFocus ->
        if (hasFocus) {
            val activity = (view.context as Activity)
            activity.hideKeyboard()
        }
    }
    //disable default keyboard
    setOnTouchListener { _, motionEvent ->
        val editText = this
        val inType = editText.inputType
        editText.inputType = InputType.TYPE_NULL
        editText.onTouchEvent(motionEvent)
        editText.inputType = inType
        true
    }
}