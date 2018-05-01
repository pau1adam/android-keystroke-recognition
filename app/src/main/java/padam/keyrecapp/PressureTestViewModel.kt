package padam.keyrecapp

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import android.view.MotionEvent

/**
 * Created by Paul on 02-Dec-17.
 */

class PressureTestViewModel : ViewModel() {
    private var maxPressure = -1f
    private var maxSize = -1f

    var pressureText = MutableLiveData<String>()
    var maxPressureText = MutableLiveData<String>()
    var sizeText = MutableLiveData<String>()
    var maxSizeText = MutableLiveData<String>()

    fun pressureTestClick(event: MotionEvent): Boolean {
        pressureText.value = "Pressure: " + event.pressure
        sizeText.value = "Size: " + event.size
        maxValues(event.pressure, event.size)
        return true
    }

    private fun maxValues(pressure: Float, size: Float) {
        if (maxPressure < pressure) {
            maxPressure = pressure
            maxPressureText.value = "Maximum Pressure: " + maxPressure.toString()
        }
        if (maxSize < size) {
            maxSize = size
            maxSizeText.value = "Maximum Size: " + maxSize.toString()
        }
    }

    fun reset() {
        pressureText.value = ""
        maxPressureText.value = ""
        maxSizeText.value = ""
        sizeText.value = ""
        maxPressure = -1f
        maxSize = -1f
    }
}