package com.example.androidtvapptutorial.Presenter;

import android.content.Context;
import android.view.ContextThemeWrapper;
import androidx.leanback.widget.ImageCardView;
import com.example.androidtvapptutorial.DataModel.MediaData;
import com.example.androidtvapptutorial.DataModel.MediaTitle;
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
    public void onBindViewHolder(MediaData MediaData, final ImageCardView cardView) {
        cardView.setTag(MediaData);
        cardView.setTitleText(MediaData.getTitle());
        cardView.setContentText(MediaData.getDescription());
        /*
        Glide.with(getContext())
                .asBitmap()
                .load(R.mipmap.ic_launcher)
                .into(cardView.getMainImageView());
        */
    }
}
