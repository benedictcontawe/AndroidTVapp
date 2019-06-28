package com.example.androidtvapptutorial.Repository;

import android.content.Context;
import androidx.lifecycle.MutableLiveData;
import com.example.androidtvapptutorial.DataModel.*;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Repository {

    private static Repository repository = null;
    private JsonReader jsonFileReader;
    private MutableLiveData<Map<String, List<MediaTitle>>> usbInfoMap = new MutableLiveData<>();

    public Repository(Context context) {

    }

    public static Repository getInstance(Context context){
        if (repository == null) {
            return new Repository(context);
        }
        else {
            return repository;
        }
    }

    public void setUSBInfoList(List<MediaStateModel> usbInfoList){
        MediaResponseModel[] mediaResponseModels;
        Map<String, List<MediaTitle>> usbMap = new HashMap<>();

        for (MediaStateModel mediaStateModel : usbInfoList) {
            List<MediaTitle> mediaTitles = new ArrayList<>();
            List<ImageModel> imageFiles = new ArrayList<>();
            List<VideoModel> videoFiles = new ArrayList<>();
            List<MusicModel> musicFiles = new ArrayList<>();
            List<DocumentModel> docFiles = new ArrayList<>();

            String fromJsonFile = jsonFileReader.readJsonFile(mediaStateModel.getFolderName());
            mediaResponseModels = new Gson().fromJson(fromJsonFile, MediaResponseModel[].class);

            for (MediaResponseModel item : mediaResponseModels) {
                switch (item.getType()) {
                    case "IMAGE":
                        imageFiles.add(new ImageModel(item.getTitle(), item.getDescription()));
                        break;
                    case "VIDEO":
                        videoFiles.add(new VideoModel(item.getTitle(), item.getDescription()));
                        break;
                    case "MUSIC":
                        musicFiles.add(new MusicModel(item.getTitle(), item.getDescription()));
                        break;
                    case "DOC":
                        docFiles.add(new DocumentModel(item.getTitle()));
                        break;
                }
            }

           mediaTitles.add(new MediaTitle<>("IMAGE", imageFiles));
           mediaTitles.add(new MediaTitle<>("VIDEO", videoFiles));
           mediaTitles.add(new MediaTitle<>("MUSIC", musicFiles));
           mediaTitles.add(new MediaTitle<>("DOCUMENT", docFiles));

            usbMap.put(mediaStateModel.getFolderName(), mediaTitles);
        }
        usbInfoMap.setValue(usbMap);
    }

    public MutableLiveData<Map<String, List<MediaTitle>>> getUsbInfoMap() {
        return usbInfoMap;
    }
}
