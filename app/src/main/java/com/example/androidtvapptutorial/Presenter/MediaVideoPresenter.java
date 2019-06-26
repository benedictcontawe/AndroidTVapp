package com.example.androidtvapptutorial.Presenter;

import android.content.Context;
import android.view.ContextThemeWrapper;
import androidx.leanback.widget.ImageCardView;
import com.example.androidtvapptutorial.DataModel.MediaData;
import com.example.androidtvapptutorial.R;

public class MediaVideoPresenter extends AbstractCardPresenter<ImageCardView> {

    public MediaVideoPresenter(Context context) {
        this(context, R.style.DefaultCardTheme);
    }

    public MediaVideoPresenter(Context context, int cardThemeResId) {
        super(new ContextThemeWrapper(context, cardThemeResId));
    }

    @Override
    protected ImageCardView onCreateView() {
        return new ImageCardView(getContext());
    }

    @Override
    public void onBindViewHolder(MediaData mediaCategory, final ImageCardView cardView) {
        cardView.setTag(mediaCategory);
        cardView.setTitleText(mediaCategory.getTitle());
        cardView.setContentText(mediaCategory.getDescription());
        /*
        Glide.with(getContext())
                .asBitmap()
                .load(R.mipmap.ic_launcher)
                .into(cardView.getMainImageView());
        */
    }
}
