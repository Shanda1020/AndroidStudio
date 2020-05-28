package tw.com.flag.sw_activity2;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void test1(View view) {
        Intent intent = new Intent(this, Page2Activity.class);
        startActivityForResult(intent, 666);
    }

    public void test2(View view) {
        Intent intent = new Intent(this, Page3Activity.class);
        startActivityForResult(intent, 111);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode==666) {
            int key1 = data.getIntExtra("key1", -1);
            String key2 = data.getStringExtra("key2");
            Log.v("milk", key1+":"+key2);
        }

        Log.v("milk", "onActivityResult()"+requestCode+":"+resultCode);
    }


}
