package com.example.androidtvapptutorial.Model.Room.DataAccessObject;

import androidx.lifecycle.LiveData;
import androidx.room.*;
import com.example.androidtvapptutorial.Model.Room.Entity.MediaEntity;

import java.util.List;

@Dao
public interface MediaDAO<T> {

    @Insert
    void insert(MediaEntity mediaEntity);

    @Update
    void update(MediaEntity mediaEntity);

    @Delete
    void delete(MediaEntity mediaEntity);

    @Query("DELETE FROM media_source")
    void deleteAll();

    @Query("SELECT * FROM media_source ORDER BY id DESC")
    LiveData<List<MediaEntity>> getAll();
}
