package com.example.androidtvapptutorial.View.Presenter;

import android.content.Context;
import com.example.androidtvapptutorial.View.ViewHolder.MediaMusicCardView;

public class MediaMusicPresenter extends AbstractCardPresenter<MediaMusicCardView> {

    public MediaMusicPresenter(Context context) {
        super(context);
    }

    @Override
    protected MediaMusicCardView onCreateView() {
        return new MediaMusicCardView(getContext());
    }

    @Override
    public void onBindViewHolder(Object item, MediaMusicCardView cardView) {
        cardView.updateView(item);
    }
}
