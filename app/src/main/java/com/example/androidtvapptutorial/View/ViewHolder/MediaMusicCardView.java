package com.example.androidtvapptutorial.View.ViewHolder;

import android.content.Context;
import android.view.LayoutInflater;
import android.widget.TextView;
import androidx.leanback.widget.BaseCardView;
import com.example.androidtvapptutorial.Model.DataModel.AudioModel;
import com.example.androidtvapptutorial.R;

public class MediaMusicCardView extends BaseCardView {

    public MediaMusicCardView(Context context) {
        super(context, null, com.example.androidtvapptutorial.R.style.TextCardStyle);
        LayoutInflater.from(getContext()).inflate(R.layout.item_music_card, this);
        setFocusable(true);
        setFocusableInTouchMode(true);
    }

    public void updateView(Object item) {
        TextView textTitle = findViewById(com.example.androidtvapptutorial.R.id.text_title);
        TextView textDescription = findViewById(com.example.androidtvapptutorial.R.id.text_description);

        if (item instanceof AudioModel) {
            AudioModel audioModel = (AudioModel) item;

            textTitle.setText(audioModel.getTitle());
            textDescription.setText(audioModel.getDescription());
        }
    }
}
