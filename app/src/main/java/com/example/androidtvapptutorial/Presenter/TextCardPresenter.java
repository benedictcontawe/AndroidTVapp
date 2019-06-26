package com.example.androidtvapptutorial.Presenter;

import android.content.Context;
import com.example.androidtvapptutorial.DataModel.MediaData;
import com.example.androidtvapptutorial.ViewHolder.TextCardView;

public class TextCardPresenter extends AbstractCardPresenter<TextCardView> {

    public TextCardPresenter(Context context) {
        super(context);
    }

    @Override
    protected TextCardView onCreateView() {
        return new TextCardView(getContext());
    }

    @Override
    public void onBindViewHolder(MediaData mediaCategory, TextCardView cardView) {
        cardView.updateUi(mediaCategory);
    }
}
