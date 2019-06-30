package com.example.androidtvapptutorial.Model.Room;

import android.content.Context;
import android.os.AsyncTask;
import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;
import com.example.androidtvapptutorial.Model.Room.DataAccessObject.MediaDAO;
import com.example.androidtvapptutorial.Model.Room.Entity.MediaEntity;

@Database(entities = {MediaEntity.class}, version = 1) //@Database(entities = {MediaEntity.class,MediaEntity.class}, version = 1)
public abstract class MediaDatabase extends RoomDatabase {

    private static MediaDatabase instance;

    public abstract MediaDAO mediaDAO();

    public static synchronized MediaDatabase getInstance(Context context){
        if (instance == null){
            instance = Room.databaseBuilder(context.getApplicationContext(),
                    MediaDatabase.class,"media_database")
                    .fallbackToDestructiveMigration()
                    .addCallback(roomCallback)
                    .build();
        }
        return instance;
    }

    private static RoomDatabase.Callback roomCallback = new RoomDatabase.Callback(){
        @Override
        public void onCreate(@NonNull SupportSQLiteDatabase db) {
            super.onCreate(db);
            new PopulateDatabaseAsyncTask(instance).execute();
        }

        @Override
        public void onOpen(@NonNull SupportSQLiteDatabase db) {
            super.onOpen(db);
        }
    };

    private static class PopulateDatabaseAsyncTask extends AsyncTask<Void, Void, Void> {
        private MediaDAO mediaDAO;

        private PopulateDatabaseAsyncTask(MediaDatabase db) {
            mediaDAO = db.mediaDAO();
        }

        @Override
        protected Void doInBackground(Void... voids) {
            //mediaDAO.insert(new MediaEntity("VIDEO","video.mp4","Lorem Ipsum Dolor","Lorem"));
            return null;
        }
    }
}


