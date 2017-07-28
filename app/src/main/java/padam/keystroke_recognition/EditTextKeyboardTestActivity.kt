package padam.keystroke_recognition

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_edit_text_keyboad_test.*

class EditTextKeyboardTestActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit_text_keyboad_test)
        resetButton.setOnClickListener { _ -> resetFields() }
    }

    fun resetFields() {
        keyEventData.text = ""
        motionEventData.text = ""
        inputEditText.setText("")
    }
}