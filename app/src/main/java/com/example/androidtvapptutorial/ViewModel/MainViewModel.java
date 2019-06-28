package com.example.androidtvapptutorial.ViewModel;

import android.app.Application;
import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Transformations;
import com.example.androidtvapptutorial.DataModel.MediaStateModel;
import com.example.androidtvapptutorial.DataModel.MediaTitle;
import com.example.androidtvapptutorial.Repository.Repository;

import java.util.List;
import java.util.Map;
import java.util.Set;

public class MainViewModel extends AndroidViewModel {

    private Repository repository;
    private LiveData<Map<String, List<MediaTitle>>> usbInfoMap;

    public MainViewModel(@NonNull Application application) {
        super(application);

        repository = Repository.getInstance(application);
    }

    public void setUsbInfoList(List<MediaStateModel> usbInfoList) {
        repository.setUSBInfoList(usbInfoList);
        usbInfoMap = repository.getUsbInfoMap();
    }

    public LiveData<Set<String>> getHeaders() {
        return Transformations.map(usbInfoMap, Map::keySet);
    }

    public LiveData<List<MediaTitle>> getUsbFilesList(String... usbNames) {
        return Transformations.map(usbInfoMap, map ->
                map.get(usbNames[0])
        );
    }
}
