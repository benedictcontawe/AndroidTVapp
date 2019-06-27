package com.example.androidtvapptutorial.ViewModel;

import androidx.leanback.widget.HeaderItem;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import com.example.androidtvapptutorial.DataModel.MediaData;

import java.util.ArrayList;
import java.util.List;

public class MainViewModel {
    private LiveData<List<HeaderItem>> universalSerialBus = new MutableLiveData<>();
    private MutableLiveData<List<MediaData>> audio = new MutableLiveData<>();
    private MutableLiveData<List<MediaData>> image = new MutableLiveData<>();
    private MutableLiveData<List<MediaData>> video = new MutableLiveData<>();

    public void setUniversalSerialBus(MutableLiveData<List<HeaderItem>> universalSerialBus) {
        this.universalSerialBus = universalSerialBus;
    }

    public void setAudio(MutableLiveData<List<MediaData>> audio) {
        this.audio = audio;
    }

    public void setImage(   List<MediaData> image) {
        List<MediaData> mediaDataVideo = new ArrayList<>();

        mediaDataVideo.add(new MediaData("video.mp4","video.mp4", MediaData.Type.VIDEO));
        mediaDataVideo.add(new MediaData("video1.mp4", "video.mp4",MediaData.Type.VIDEO));
        mediaDataVideo.add(new MediaData("video2.mp4", "video.mp4",MediaData.Type.VIDEO));

        this.image.setValue(image);
    }

    public void setVideo(MutableLiveData<List<MediaData>> video) {
        this.video = video;
    }

    public LiveData<List<HeaderItem>> getUniversalSerialBus() {
        return universalSerialBus;
    }

    public LiveData<List<MediaData>> getAudio() {
        return audio;
    }

    public LiveData<List<MediaData>> getImage() {
        return image;
    }

    public LiveData<List<MediaData>> getVideo() {
        return video;
    }
}
