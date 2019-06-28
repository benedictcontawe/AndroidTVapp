package com.example.androidtvapptutorial.View;

import android.os.Bundle;
import android.util.Log;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ViewModelProviders;
import com.example.androidtvapptutorial.DataModel.MediaStateModel;
import com.example.androidtvapptutorial.R;
import com.example.androidtvapptutorial.ViewModel.MainViewModel;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends FragmentActivity {

    private MainViewModel mainViewModel;
    private List<MediaStateModel> usbInfoList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d(MainActivity.class.getSimpleName(),"onCreate");

        //dummy
        usbInfoList.add(new MediaStateModel(true, "usb1"));
        usbInfoList.add(new MediaStateModel(true, "usb2"));
        usbInfoList.add(new MediaStateModel(true, "usb3"));
        usbInfoList.add(new MediaStateModel(true, "usb4"));

        mainViewModel = ViewModelProviders.of(this).get(MainViewModel.class);
        mainViewModel.setUsbInfoList(usbInfoList);
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(MainActivity.class.getSimpleName(),"onStart");

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(MainActivity.class.getSimpleName(),"onDestroy");

    }
}
