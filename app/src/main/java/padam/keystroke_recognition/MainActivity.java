package padam.keystroke_recognition;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.goToPressureTestActivity) Button goToPressureTest;

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
}
