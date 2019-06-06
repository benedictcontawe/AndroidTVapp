package com.example.androidtvapptutorial;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

public class MainActivity extends Activity {

    private static final String TAG = MainActivity.class.getSimpleName();

    private Intent serviceIntent;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d(TAG,"onCreate");
        Toast.makeText(this,"Hellow",Toast.LENGTH_SHORT).show();
        serviceIntent = new Intent(getApplicationContext(),MessengerService.class);
    }

    @Override
    protected void onStart() {
        super.onStart();
        startService(serviceIntent);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG,"onDestroy");
        stopService(serviceIntent);
    }
}
