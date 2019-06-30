package com.example.androidtvapptutorial.Model.Room.DataAccessObject;

import androidx.leanback.widget.HeaderItem;
import androidx.lifecycle.LiveData;
import androidx.room.*;
import com.example.androidtvapptutorial.Model.Room.Entity.MediaEntity;

import java.util.List;

@Dao
public interface MediaDAO {

    @Insert
    void insert(MediaEntity mediaEntity);

    @Update
    void update(MediaEntity mediaEntity);

    @Delete
    void delete(MediaEntity mediaEntity);

    @Query("DELETE FROM media_table")
    void deleteAll();

    @Query("SELECT DISTINCT Name FROM media_table")
    LiveData<List<String>> getNames();

    @Query("SELECT * FROM media_table WHERE Name = :mediaName" )
    LiveData<MediaEntity> getFirst(String mediaName);

    @Query("SELECT * FROM media_table ORDER BY id DESC")
    LiveData<List<MediaEntity>> getAll();

}
