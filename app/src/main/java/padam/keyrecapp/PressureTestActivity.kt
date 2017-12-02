package padam.keyrecapp

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_pressure_test.*

class PressureTestActivity : AppCompatActivity() {

    private lateinit var model: PressureTestViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pressure_test)
        model = ViewModelProviders.of(this).get(PressureTestViewModel::class.java)
        setupUI()
    }

    private fun setupUI() {
        activity_pressure_test.setOnTouchListener { _, event -> model.pressureTestClick(event) }
        resetButton.setOnClickListener { model.reset() }

        model.maxPressureText.observe(this, Observer {
            displayMaxPressure.text = model.maxPressureText.value
        })
        model.pressureText.observe(this, Observer {
            displayPressure.text = model.pressureText.value
        })

        model.maxSizeText.observe(this, Observer {
            displayMaxSize.text = model.maxSizeText.value
        })
        model.sizeText.observe(this, Observer {
            displaySize.text = model.sizeText.value
        })
    }
}
