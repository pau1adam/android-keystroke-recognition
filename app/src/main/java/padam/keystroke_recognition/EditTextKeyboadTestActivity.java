package padam.keystroke_recognition;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;


public class EditTextKeyboadTestActivity extends AppCompatActivity {

    @BindView(R.id.keyEventData) TextView keyEventData;
    @BindView(R.id.motionEventData) TextView motionEventData;
    @BindView(R.id.inputEditText) EditText inputEditText;
    @BindView(R.id.resetButton) Button resetButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_text_keyboad_test);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.resetButton)
    public void resetButtonClick(){
        keyEventData.setText("");
        motionEventData.setText("");
        inputEditText.setText("");
    }
}
