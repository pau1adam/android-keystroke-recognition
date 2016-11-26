package padam.keystroke_recognition;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Layout;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.OnTouch;

import static android.icu.lang.UCharacter.GraphemeClusterBreak.L;

public class PressureTestActivity extends AppCompatActivity {

    @BindView(R.id.activity_pressure_test) View pressureTest;
    @BindView(R.id.displayPressure) TextView displayPressureTextView;
    @BindView(R.id.displaySize) TextView displaySizeTextView;
    @BindView(R.id.resetButton) Button resetButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pressure_test);
        ButterKnife.bind(this);
    }

    @OnTouch(R.id.activity_pressure_test)
    public boolean pressureTestClick(View v, MotionEvent motionEvent){
        float pressure = motionEvent.getPressure();
        displayPressureTextView.setText(String.valueOf(pressure));
        float size = motionEvent.getSize();
        displaySizeTextView.setText(String.valueOf(size));
        return true;
    }

    @OnClick(R.id.resetButton)
    public void resetButtonClick(){
        displayPressureTextView.setText("");
        displaySizeTextView.setText("");
    }
}
