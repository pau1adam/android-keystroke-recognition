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
    @BindView(R.id.displayMaxPressure) TextView displayMaxPressureTextView;
    @BindView(R.id.displayMaxSize) TextView displayMaxSizeTextView;
    @BindView(R.id.resetButton) Button resetButton;

    private float maxPressure = -1;
    private float maxSize = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pressure_test);
        ButterKnife.bind(this);
    }

    @OnTouch(R.id.activity_pressure_test)
    public boolean pressureTestClick(View v, MotionEvent motionEvent){
        float pressure = motionEvent.getPressure();
        float size = motionEvent.getSize();
        displayPressureTextView.setText("Pressure: "+String.valueOf(pressure));
        displaySizeTextView.setText("Size: "+String.valueOf(size));
        maxValues(pressure, size);
        return true;
    }

    @OnClick(R.id.resetButton)
    public void resetButtonClick(){
        displayPressureTextView.setText("");
        displaySizeTextView.setText("");
        displayMaxPressureTextView.setText("");
        displayMaxSizeTextView.setText("");
    }

    private void maxValues(float pressure, float size){
        if (maxPressure < pressure){
            maxPressure = pressure;
            displayMaxPressureTextView.setText("Maximum Pressure: "+String.valueOf(maxPressure));
        }
        if(maxSize < size){
            maxSize = size;
            displayMaxSizeTextView.setText("Maximum Size: "+String.valueOf(maxSize));
        }
    }
}
