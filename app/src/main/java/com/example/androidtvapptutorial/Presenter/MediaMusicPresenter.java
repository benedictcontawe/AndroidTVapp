package com.example.androidtvapptutorial.Presenter;

import android.content.Context;
import com.example.androidtvapptutorial.DataModel.MediaData;
import com.example.androidtvapptutorial.ViewHolder.MediaMusicCardView;

public class MediaMusicPresenter extends AbstractCardPresenter<MediaMusicCardView> {

    public MediaMusicPresenter(Context context) {
        super(context);
    }

    @Override
    protected MediaMusicCardView onCreateView() {
        return new MediaMusicCardView(getContext());
    }

    @Override
    public void onBindViewHolder(MediaData mediaCategory, MediaMusicCardView cardView) {
        cardView.updateView(mediaCategory);
    }
}
