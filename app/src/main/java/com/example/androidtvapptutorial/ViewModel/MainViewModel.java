package com.example.androidtvapptutorial.ViewModel;

import android.app.Application;
import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import com.example.androidtvapptutorial.DataModel.MediaMountedState;
import com.example.androidtvapptutorial.DataModel.MediaTitle;
import com.example.androidtvapptutorial.Repository.Repository;

import java.util.List;
import java.util.Map;

public class MainViewModel extends AndroidViewModel {

    private Repository repository;
    private LiveData<Map<String, List<MediaTitle>>> usbInfoMap;

    public MainViewModel(@NonNull Application application) {
        super(application);

        repository = Repository.getInstance(application);
    }

    public void setUsbInfoList(List<MediaMountedState> usbInfoList) {
        repository.setUSBInfoList(usbInfoList);
        usbInfoMap = repository.getUsbInfoMap();
    }
}
