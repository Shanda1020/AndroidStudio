package tw.com.flag.sw_myveiw;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    private MyVeiw myVeiw;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myVeiw = findViewById(R.id.myView);
    }

    public void clear(View view) {
        myVeiw.clear();
    }

    public void undo(View view) {
        myVeiw.undo();
    }

    public void R_Pen(View view) {
        myVeiw.R_Pen();
    }
}
