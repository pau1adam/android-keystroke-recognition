package padam.keystroke_recognition;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.goToPressureTestActivity) Button goToPressureTest;
    @BindView(R.id.goToEditTextKeyboadTestActivity) Button goToEditTextKeyboadTest;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.goToPressureTestActivity)
    public void goToPressureTestActivity(){
        Intent pressureTestIntent = new Intent(this, PressureTestActivity.class);
        startActivity(pressureTestIntent);
    }

    @OnClick(R.id.goToEditTextKeyboadTestActivity)
    public void goToEditTextKeyboadTestActivity(){
        Intent editTextKeyboadTestIntent = new Intent(this, EditTextKeyboardTestActivity.class);
        startActivity(editTextKeyboadTestIntent);
    }
}
