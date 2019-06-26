package com.example.androidtvapptutorial.ViewHolder;

import android.content.Context;
import android.view.LayoutInflater;
import android.widget.TextView;
import androidx.leanback.widget.BaseCardView;
import com.example.androidtvapptutorial.DataModel.MediaData;

public class TextCardView extends BaseCardView {

    public TextCardView(Context context) {
        super(context, null, com.example.androidtvapptutorial.R.style.TextCardStyle);
        LayoutInflater.from(getContext()).inflate(com.example.androidtvapptutorial.R.layout.item_simple_card, this);
        setFocusable(true);
        setFocusableInTouchMode(true);
    }

    public void updateUi(MediaData mediaCategory) {
        TextView textTitle = findViewById(com.example.androidtvapptutorial.R.id.text_title);
        TextView textDescription = findViewById(com.example.androidtvapptutorial.R.id.text_description);

        textTitle.setText(mediaCategory.getTitle());
        if (mediaCategory.getType() == MediaData.Type.MUSIC) {
            textDescription.setText(mediaCategory.getDescription());
        }
    }
}
