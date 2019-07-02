package com.example.androidtvapptutorial.View.Presenter;

import android.content.Context;
import com.example.androidtvapptutorial.View.ViewHolder.MediaMusicCardView;

public class MediaAudioPresenter extends AbstractCardPresenter<MediaMusicCardView> {

    public MediaAudioPresenter(Context context) {
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
