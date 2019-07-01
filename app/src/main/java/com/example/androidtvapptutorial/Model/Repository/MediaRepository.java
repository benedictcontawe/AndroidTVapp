package com.example.androidtvapptutorial.Model.Repository;

import android.app.Application;
import android.os.AsyncTask;
import androidx.leanback.widget.HeaderItem;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import com.example.androidtvapptutorial.Model.DataModel.MediaRequestModel;
import com.example.androidtvapptutorial.Model.DataModel.MediaResponseModel;
import com.example.androidtvapptutorial.Model.DataModel.VideoModel;
import com.example.androidtvapptutorial.Model.JsonReader;
import com.example.androidtvapptutorial.Model.Room.DataAccessObject.MediaDAO;
import com.example.androidtvapptutorial.Model.Room.Entity.MediaEntity;
import com.example.androidtvapptutorial.Model.Room.MediaDatabase;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

public class MediaRepository implements BaseRepository {

    private static MediaRepository repository = null;
    private MediaDAO mediaDAO;
    private JsonReader jsonReader;

    public MediaRepository(Application application){
        MediaDatabase database = MediaDatabase.getInstance(application);
        mediaDAO = database.mediaDAO();
        jsonReader = new JsonReader(application);
    }

    public static MediaRepository getInstance(Application application){
        if (repository == null){
            return new MediaRepository(application);
        }
        return repository;
    }
    //region CRUD Operation
    @Override
    public void insert(MediaEntity mediaEntity) {
        new insertMediaAsyncTask(mediaDAO).execute(mediaEntity);
    }

    @Override
    public void update(MediaEntity mediaEntity) {
        new updateMediaAsyncTask(mediaDAO).execute(mediaEntity);
    }

    @Override
    public void delete(MediaEntity mediaEntity) {
        new deleteMediaAsyncTask(mediaDAO).execute(mediaEntity);
    }

    @Override
    public void deleteAll() {
        new deleteAllMediaAsyncTask(mediaDAO).execute();
    }
    /*
    @Override
    public void getFirst(MediaEntity mediaEntity) {

    }
    */
    public LiveData<List<MediaEntity>> getAllMedia(){
        return mediaDAO.getAll();
    }

    public LiveData<List<String>> getAllHeaders() {
        return mediaDAO.getNames();
    }

    public LiveData<List<VideoModel>> getAllVideos(){
        return mediaDAO.getVideos();
    }
    //endregion
    public void requestMediaCotents(List<MediaRequestModel> mediaContents) {
        MediaResponseModel[] mediaProcessedItems;

        for (MediaRequestModel mediaContent : mediaContents){
            String fromJsonFile = jsonReader.readJsonFile(mediaContent.getFolderName());
            mediaProcessedItems = new Gson().fromJson(fromJsonFile, MediaResponseModel[].class);

            for (MediaResponseModel item : mediaProcessedItems) {
                switch (item.getType()) {
                    case "IMAGE":
                        insert(new MediaEntity(mediaContent.getFolderName(),"IMAGE",item.getTitle(),item.getDescription(),item.getLocalImageResource()));
                        break;
                    case "VIDEO":
                        insert(new MediaEntity(mediaContent.getFolderName(),"VIDEO",item.getTitle(),item.getDescription(),item.getLocalImageResource()));
                        break;
                    case "MUSIC":
                        insert(new MediaEntity(mediaContent.getFolderName(),"MUSIC",item.getTitle(),item.getDescription(),item.getLocalImageResource()));
                        break;
                    case "DOC":
                        insert(new MediaEntity(mediaContent.getFolderName(),"DOC",item.getTitle(),item.getDescription(),item.getLocalImageResource()));
                        break;
                }
            }
        }
    }
    //region Static Class For Repository
    private static class insertMediaAsyncTask extends AsyncTask<MediaEntity, Void, Void> {
        private  MediaDAO mediaDAO;

        private insertMediaAsyncTask(MediaDAO mediaDAO){
            this.mediaDAO = mediaDAO;
        }

        @Override
        protected Void doInBackground(MediaEntity... mediaEntities) {
            mediaDAO.insert(mediaEntities[0]);
            return null;
        }
    }

    private static class updateMediaAsyncTask extends AsyncTask<MediaEntity, Void, Void> {
        private  MediaDAO mediaDAO;

        private updateMediaAsyncTask(MediaDAO mediaDAO){
            this.mediaDAO = mediaDAO;
        }

        @Override
        protected Void doInBackground(MediaEntity... mediaEntities) {
            mediaDAO.update(mediaEntities[0]);
            return null;
        }
    }

    private static class deleteMediaAsyncTask extends AsyncTask<MediaEntity, Void, Void> {
        private  MediaDAO mediaDAO;

        private deleteMediaAsyncTask(MediaDAO mediaDAO){
            this.mediaDAO = mediaDAO;
        }

        @Override
        protected Void doInBackground(MediaEntity... mediaEntities) {
            mediaDAO.delete(mediaEntities[0]);
            return null;
        }
    }

    private static class deleteAllMediaAsyncTask extends AsyncTask<MediaEntity, Void, Void> {
        private  MediaDAO mediaDAO;

        private deleteAllMediaAsyncTask(MediaDAO mediaDAO){
            this.mediaDAO = mediaDAO;
        }


        @Override
        protected Void doInBackground(MediaEntity... mediaEntities) {
            mediaDAO.deleteAll();
            return null;
        }
    }
    //endregion
}
