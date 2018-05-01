package padam.keyrecapp

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        goToPressureTestButton.setOnClickListener { goToPressureTestActivity() }
        goToEditTextKeyboardTestButton.setOnClickListener { goToEditTextKeyboardTestActivity() }
    }

    private fun goToPressureTestActivity() {
        val pressureTestIntent = Intent(this, PressureTestActivity::class.java)
        startActivity(pressureTestIntent)
    }

    private fun goToEditTextKeyboardTestActivity() {
        val editTextKeyboadTestIntent = Intent(this, EditTextKeyboardTestActivity::class.java)
        startActivity(editTextKeyboadTestIntent)
    }
}
