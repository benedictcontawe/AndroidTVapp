package com.example.androidtvapptutorial.Model.Repository;

import android.app.Application;
import android.os.AsyncTask;
import androidx.lifecycle.LiveData;
import com.example.androidtvapptutorial.Model.Room.DataAccessObject.MediaDAO;
import com.example.androidtvapptutorial.Model.Room.Entity.MediaEntity;
import com.example.androidtvapptutorial.Model.Room.MediaDatabase;

import java.util.List;

public class MediaRepository implements BaseRepository {
    private MediaDAO mediaDAO;
    private LiveData<List<MediaEntity>> allMedia;

    public MediaRepository(Application application){
        MediaDatabase database = MediaDatabase.getInstance(application);
        mediaDAO = database.mediaDAO();
        allMedia = mediaDAO.getAll();
    }


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

    @Override
    public void getFirst(MediaEntity mediaEntity) {

    }

    public LiveData<List<MediaEntity>> getAllMedia(){
        return allMedia;
    }

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
}
