package com.example.androidtvapptutorial.View;

import android.os.Bundle;
import android.util.Log;
import androidx.fragment.app.FragmentActivity;
import com.example.androidtvapptutorial.R;

public class MainActivity extends FragmentActivity {

    private static final String TAG = MainActivity.class.getSimpleName();

    //private Intent serviceIntent;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d(TAG,"onCreate");

        //serviceIntent = new Intent(getApplicationContext(),MessengerService.class);
    }

    @Override
    protected void onStart() {
        super.onStart();
        //startService(serviceIntent);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG,"onDestroy");
        //stopService(serviceIntent);
    }
}
