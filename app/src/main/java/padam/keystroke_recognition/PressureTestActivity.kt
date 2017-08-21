package padam.keystroke_recognition

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.MotionEvent
import kotlinx.android.synthetic.main.activity_pressure_test.*

class PressureTestActivity : AppCompatActivity() {

    var maxPressure = -1f
    var maxSize = -1f

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pressure_test)
        activity_pressure_test.setOnTouchListener { _, event -> pressureTestClick(event) }
        resetButton.setOnClickListener { _ -> resetFields() }
    }

    private fun pressureTestClick(event: MotionEvent): Boolean {
        displayPressure.text = "Pressure: " + maxPressure.toString()
        displaySize.text = "Size: " + maxSize.toString()
        maxValues(event.pressure, event.size)
        return true
    }

    private fun resetFields() {
        displayPressure.text = ""
        displaySize.text = ""
        displayMaxPressure.text = ""
        displayMaxSize.text = ""
        maxPressure = -1f
        maxSize = -1f
    }

    private fun maxValues(pressure: Float, size: Float) {
        if (maxPressure < pressure) {
            maxPressure = pressure
            displayMaxPressure.text = "Maximum Pressure: " + maxPressure.toString()
        }
        if (maxSize < size) {
            maxSize = size
            displayMaxSize.text = "Maximum Size: " + maxSize.toString()
        }
    }
}
