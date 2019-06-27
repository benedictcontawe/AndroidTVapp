package com.example.androidtvapptutorial.Presenter;

import android.content.Context;
import com.example.androidtvapptutorial.DataModel.MediaData;
import com.example.androidtvapptutorial.ViewHolder.MediaDocumentCardView;

public class MediaDocumentsPresenter extends AbstractCardPresenter<MediaDocumentCardView> {

    public MediaDocumentsPresenter(Context context) {
        super(context);
    }

    @Override
    protected MediaDocumentCardView onCreateView() {
        return new MediaDocumentCardView(getContext());
    }

    @Override
    public void onBindViewHolder(MediaData mediaCategory, MediaDocumentCardView cardView) {
        cardView.updateView(mediaCategory);
    }
}
