package padam.keyrecapp

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import gr.padam.keyrec.KeyPress
import gr.padam.tests.keystrokecollectorkeyboard.disableDefaultKeyboard
import io.reactivex.observers.DisposableObserver
import kotlinx.android.synthetic.main.activity_edit_text_keyboad_test.*
import timber.log.Timber

class EditTextKeyboardTestActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit_text_keyboad_test)
        resetButton.setOnClickListener { resetFields() }
        inputEditText.disableDefaultKeyboard()
        keyboardView.observer = observer
    }

    private fun resetFields() {
        keyPressData.text = ""
        inputEditText.setText("")
    }

    private val observer = object : DisposableObserver<KeyPress>() {
        override fun onComplete() {
        }

        override fun onNext(keyPress: KeyPress) {
            keyPressData.text = keyPress.toString()
            Timber.d(keyPress.toString())
        }

        override fun onError(e: Throwable) {
        }

    }
}
