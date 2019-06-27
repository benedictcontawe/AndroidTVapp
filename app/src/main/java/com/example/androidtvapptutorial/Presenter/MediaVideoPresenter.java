package com.example.androidtvapptutorial.Presenter;

import android.content.Context;
import android.view.ContextThemeWrapper;
import androidx.leanback.widget.ImageCardView;
import com.bumptech.glide.Glide;
import com.example.androidtvapptutorial.DataModel.VideoModel;
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
    public void onBindViewHolder(Object item, final ImageCardView cardView) {
        VideoModel videoModel = (VideoModel) item;
        cardView.setTag(videoModel);
        cardView.setTitleText(videoModel.getTitle());
        cardView.setContentText(videoModel.getDescription());
        Glide.with(getContext())
                .asBitmap()
                .load(R.drawable.moviex)
                .into(cardView.getMainImageView());
    }
}
