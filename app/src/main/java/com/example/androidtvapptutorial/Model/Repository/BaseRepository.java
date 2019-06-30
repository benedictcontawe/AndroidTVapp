package com.example.androidtvapptutorial.Model.Repository;

import androidx.lifecycle.LiveData;
import com.example.androidtvapptutorial.Model.Room.Entity.MediaEntity;

import java.util.List;

public interface BaseRepository {

    public void insert(MediaEntity mediaEntity);

    public void update(MediaEntity mediaEntity);

    public void delete(MediaEntity mediaEntity);

    public void deleteAll();

    //public void getFirst(MediaEntity mediaEntity);

    //public LiveData<List<MediaEntity>> getAll();
}
