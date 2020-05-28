package tw.com.flag.myfiletest;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class MainActivity extends AppCompatActivity {

    private SharedPreferences sp;
    private SharedPreferences.Editor editor;
    private File sdroot, approot;
    private TextView mesg;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (ContextCompat.checkSelfPermission(this,
                Manifest.permission.WRITE_EXTERNAL_STORAGE)
                != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this,
                    new String[]{Manifest.permission.READ_EXTERNAL_STORAGE,
                            Manifest.permission.WRITE_EXTERNAL_STORAGE},
                    1);
        }
        else{
            init();
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        if (grantResults[0] == PackageManager.PERMISSION_GRANTED &&
                grantResults[1] == PackageManager.PERMISSION_GRANTED ) {
            init();
        }else{
            finish();
        }
    }

    public void init(){
        mesg = findViewById(R.id.mesg);

        sp = getSharedPreferences("game", MODE_PRIVATE);
        editor = sp.edit();

        sdroot = Environment.getExternalStorageDirectory();
        Log.v("milk","sdroot"+ sdroot.getAbsolutePath());
        approot = new File(sdroot, "Android/data/" + getPackageName()+"/");
        if(!approot.exists()){
            if(approot.mkdir()){
                Log.v("milk","mkdir ok");
            }else {Log.v("milk","mkdir fail");}
        }
    }



    public void test1(View view) {
        String username = sp.getString("username", "milk");
        boolean isSound = sp.getBoolean("sound", true);
        int stage = sp.getInt("stage", 4);
        Log.v("milk", username+" : "+ isSound + " : " + stage);
    }

    public void test2(View view) {
        editor.putString("username", "sw_user");
        editor.putBoolean("sound", false);
        editor. putInt("stage", 7);
        editor.commit();
        Toast.makeText(this, "Save OK", Toast.LENGTH_SHORT).show();
    }

    public void test3(View view) {
        try {
            FileOutputStream fout = openFileOutput("data1.txt", MODE_APPEND);
            fout.write("Hello, SW\n".getBytes());
            fout.flush();
            fout.close();
            Toast.makeText(this, "Save OK", Toast.LENGTH_SHORT).show();
        } catch (IOException e) {
            Toast.makeText(this, "Error", Toast.LENGTH_SHORT).show();
        }
    }

    public void test4(View view) {

        try {
            FileInputStream fin = openFileInput("data1.txt");
            BufferedReader br = new BufferedReader(new InputStreamReader(fin));
            String line;
            while((line = br.readLine()) != null){
                 Log.v("milk", line);
            }

            fin.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void test5(View view) {
        File file1 = new File(sdroot, "test5.txt");
        try {
            FileOutputStream fout = new FileOutputStream(file1);
            fout.write("OK".getBytes());
            fout.flush();
            fout.close();
            Toast.makeText(this, "Save5 Ok", Toast.LENGTH_SHORT).show();
        } catch (IOException e) {
            e.printStackTrace();
            Log.v("milk", "milk5 :" + e.toString());
        }

    }

    public void test6(View view) {
        File file1 = new File(approot, "test5.txt");
        try {
            FileOutputStream fout = new FileOutputStream(file1);
            fout.write("OK".getBytes());
            fout.flush();
            fout.close();
            Toast.makeText(this, "Save6 Ok", Toast.LENGTH_SHORT).show();
        } catch (IOException e) {
            e.printStackTrace();
            Log.v("milk", "milk6 :" + e.toString());
        }
    }

    public void test7(View view) {
        File file1 = new File(sdroot, "test5.txt");
        try {
            BufferedReader br = new BufferedReader(
                    new InputStreamReader(new FileInputStream(file1)));
            String line;
            StringBuffer sb = new StringBuffer();
            while((line = br.readLine())!=null) {
                sb.append(line+"\n");
            }
            br.close();
            mesg.setText(sb);
        } catch (Exception e) {

        }

    }

    public void test8(View view) {
        File file1 = new File(approot, "test1.txt");
        try {
            BufferedReader br = new BufferedReader(
                    new InputStreamReader(new FileInputStream(file1)));
            String line;
            StringBuffer sb = new StringBuffer();
            while((line = br.readLine())!=null) {
                sb.append(line+"\n");
            }
            br.close();
            mesg.setText(sb);
        } catch (Exception e) {
            mesg.setText("");
        }
    }
}
