package tw.com.flag.sw_activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private EditText inputName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.v("Milk", "onCreate");

        inputName = findViewById(R.id.inputName);
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.v("Milk", "onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.v("Milk", "onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.v("Milk", "onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.v("Milk", "onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.v("Milk", "onDestroy");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.v("Milk", "onRestart");
    }

    public void test1(View view) {
        finish();
    }

    @Override
    public void finish() {
        super.finish();
        //Toast.makeText(this, "One more", Toast.LENGTH_SHORT).show();
    }

    public void test2(View view) {
        Intent intent = new Intent(this, Page2Activity.class);
        startActivity(intent);
    }

    public void test3(View view) {
        String name = inputName.getText().toString();
        Intent intent = new Intent(this, Page2Activity.class);
        intent.putExtra("name", name);
        startActivity(intent);
    }
}


