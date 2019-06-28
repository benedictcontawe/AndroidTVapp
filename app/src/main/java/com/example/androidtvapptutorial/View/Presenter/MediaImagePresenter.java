package com.example.androidtvapptutorial.View.Presenter;

import android.content.Context;
import android.view.ContextThemeWrapper;
import androidx.leanback.widget.ImageCardView;
import com.bumptech.glide.Glide;
import com.example.androidtvapptutorial.Model.DataModel.ImageModel;
import com.example.androidtvapptutorial.R;

public class MediaImagePresenter extends AbstractCardPresenter<ImageCardView> {

    private MediaImagePresenter(Context context, int cardThemeResId) {
        super(new ContextThemeWrapper(context, cardThemeResId));
    }

    public MediaImagePresenter(Context context) {
        this(context, R.style.DefaultCardTheme);
    }

    @Override
    protected ImageCardView onCreateView() {
        return new ImageCardView(getContext());
    }

    @Override
    public void onBindViewHolder(Object item, final ImageCardView cardView) {
        ImageModel imageModel = (ImageModel) item;
        cardView.setTag(imageModel);
        cardView.setTitleText(imageModel.getTitle());
        cardView.setContentText(imageModel.getDescription());
        Glide.with(getContext())
                .asBitmap()
                .load(R.mipmap.ic_launcher)
                .into(cardView.getMainImageView());
    }
}
