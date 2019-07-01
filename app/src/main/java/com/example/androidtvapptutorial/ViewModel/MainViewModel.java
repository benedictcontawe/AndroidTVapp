package com.example.androidtvapptutorial.ViewModel;

import android.app.Application;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.leanback.widget.HeaderItem;
import androidx.lifecycle.*;
import com.example.androidtvapptutorial.Model.DataModel.*;
import com.example.androidtvapptutorial.Model.Repository.MediaRepository;
import com.example.androidtvapptutorial.Model.Room.Entity.MediaEntity;

import java.util.ArrayList;
import java.util.List;

public class MainViewModel extends AndroidViewModel {

    private MediaRepository repository;
    private MutableLiveData<List<MediaTitle>> rowItems = new MutableLiveData<>();
    private LiveData<List<MediaEntity>> allMedia;

    public MainViewModel(@NonNull Application application) {
        super(application);

        repository = MediaRepository.getInstance(application);
        allMedia = repository.getAllMedia();
    }

    public void requestMediaCotents(List<MediaRequestModel> mediaContents) {
        Log.e(MainViewModel.class.toString(),String.valueOf(mediaContents.size()));
        repository.deleteAll();
        repository.requestMediaCotents(mediaContents);
    }

    public LiveData<List<String>> getHeaders() {
        //List<HeaderItem> dummyHeaders = new ArrayList<>();
        //dummyHeaders.add(new HeaderItem( "USB1"));
        //dummyHeaders.add(new HeaderItem( "USB2"));
        //dummyHeaders.add(new HeaderItem( "USB3"));
        //headerItems.setValue(dummyHeaders);
        return repository.getAllHeaders();
    }

    public LiveData<List<MediaEntity>> getRows(String... selectedHeaderName) {
        Log.e(MainViewModel.class.getSimpleName(),selectedHeaderName[0]);
        //List<MediaTitle> sampleMediaTitle = new ArrayList<>();
        //List<VideoModel> mediaDataVideo = new ArrayList<>();
        //List<MusicModel> mediaDataMusic = new ArrayList<>();
        //List<ImageModel> mediaDataImage = new ArrayList<>();
        //List<DocumentModel> mediaDataDocuments = new ArrayList<>();

        //mediaDataVideo.add(new VideoModel("video.mp4","video.mp4"));
        //mediaDataVideo.add(new VideoModel("video1.mp4", "video.mp4"));
        //mediaDataVideo.add(new VideoModel("video2.mp4", "video.mp4"));


        //mediaDataMusic.add(new MusicModel("music1.mp3", "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Cras hendrerit erat tortor. Phasellus auctor tortor in sodales convallis. Curabitur in mauris leo. Class aptent taciti sociosqu ad litora torquent per conubia nostra, per inceptos himenaeos. Quisque eget molestie enim. Maecenas mollis diam nunc, sed sodales ante vestibulum nec. Donec in elit vitae nibh mollis gravida in luctus neque."));
        //mediaDataMusic.add(new MusicModel("music2.mp3", "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Cras hendrerit erat tortor. Phasellus auctor tortor in sodales convallis. Curabitur in mauris leo. Class aptent taciti sociosqu ad litora torquent per conubia nostra, per inceptos himenaeos. Quisque eget molestie enim. Maecenas mollis diam nunc, sed sodales ante vestibulum nec. Donec in elit vitae nibh mollis gravida in luctus neque."));
        //mediaDataMusic.add(new MusicModel("music3.mp3","Lorem ipsum dolor sit amet, consectetur adipiscing elit. Cras hendrerit erat tortor. Phasellus auctor tortor in sodales convallis. Curabitur in mauris leo. Class aptent taciti sociosqu ad litora torquent per conubia nostra, per inceptos himenaeos. Quisque eget molestie enim. Maecenas mollis diam nunc, sed sodales ante vestibulum nec. Donec in elit vitae nibh mollis gravida in luctus neque."));
        //mediaDataMusic.add(new MusicModel("music4.mp3", "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Cras hendrerit erat tortor. Phasellus auctor tortor in sodales convallis. Curabitur in mauris leo. Class aptent taciti sociosqu ad litora torquent per conubia nostra, per inceptos himenaeos. Quisque eget molestie enim. Maecenas mollis diam nunc, sed sodales ante vestibulum nec. Donec in elit vitae nibh mollis gravida in luctus neque."));
        //mediaDataMusic.add(new MusicModel("music5.mp3", "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Cras hendrerit erat tortor. Phasellus auctor tortor in sodales convallis. Curabitur in mauris leo. Class aptent taciti sociosqu ad litora torquent per conubia nostra, per inceptos himenaeos. Quisque eget molestie enim. Maecenas mollis diam nunc, sed sodales ante vestibulum nec. Donec in elit vitae nibh mollis gravida in luctus neque."));
        //mediaDataMusic.add(new MusicModel("music6.mp3", "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Cras hendrerit erat tortor. Phasellus auctor tortor in sodales convallis. Curabitur in mauris leo. Class aptent taciti sociosqu ad litora torquent per conubia nostra, per inceptos himenaeos. Quisque eget molestie enim. Maecenas mollis diam nunc, sed sodales ante vestibulum nec. Donec in elit vitae nibh mollis gravida in luctus neque."));
        //mediaDataMusic.add(new MusicModel("music7.mp3", "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Cras hendrerit erat tortor. Phasellus auctor tortor in sodales convallis. Curabitur in mauris leo. Class aptent taciti sociosqu ad litora torquent per conubia nostra, per inceptos himenaeos. Quisque eget molestie enim. Maecenas mollis diam nunc, sed sodales ante vestibulum nec. Donec in elit vitae nibh mollis gravida in luctus neque."));

        //mediaDataImage.add(new ImageModel("img1.png", "img1.png"));
        //mediaDataImage.add(new ImageModel("img2.png","img1.png"));
        //mediaDataImage.add(new ImageModel("img3.png","img1.png"));
        //mediaDataImage.add(new ImageModel("img4.png","img1.png"));

        //mediaDataDocuments.add(new DocumentModel("Document 1"));
        //mediaDataDocuments.add(new DocumentModel("Document 2"));
        //mediaDataDocuments.add(new DocumentModel("Document 3"));
        //mediaDataDocuments.add(new DocumentModel("Document 4"));
        //mediaDataDocuments.add(new DocumentModel("Document 5"));

        //sampleMediaTitle.add(new MediaTitle("Video", mediaDataVideo));
        //sampleMediaTitle.add(new MediaTitle("Music", mediaDataMusic));
        //sampleMediaTitle.add(new MediaTitle("Pictures", mediaDataImage));
        //sampleMediaTitle.add(new MediaTitle("Documents", mediaDataDocuments));

        //rowItems.setValue(sampleMediaTitle);
        if(selectedHeaderName[0] == "USB All") {
            return repository.getAllRows();
        }
        else {
            return repository.getAllRows(selectedHeaderName[0]);
        }
    }

    private void insert(MediaEntity mediaEntity){
        repository.insert(mediaEntity);
    }

    private void update(MediaEntity mediaEntity){
        repository.update(mediaEntity);
    }

    private void delete(MediaEntity mediaEntity){
        repository.delete(mediaEntity);
    }

    private void deleteAll(){
        repository.deleteAll();
    }

    public LiveData<List<MediaEntity>> getAll(){
        return allMedia;
    }
}
