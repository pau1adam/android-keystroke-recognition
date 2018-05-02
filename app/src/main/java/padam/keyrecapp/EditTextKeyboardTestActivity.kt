package padam.keyrecapp

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import gr.padam.keyrec.KeyPress
import gr.padam.tests.keystrokecollectorkeyboard.disableDefaultKeyboard
import io.reactivex.observers.DisposableObserver
import kotlinx.android.synthetic.main.activity_edit_text_keyboad_test.*
import timber.log.Timber

class EditTextKeyboardTestActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit_text_keyboad_test)
        setSupportActionBar(toolbar)
        inputEditText.disableDefaultKeyboard()
        keyboardView.observer = observer
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_activity_edit_text_keyboad_test, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        resetFields()
        return true
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
