package com.example.androidtvapptutorial.Presenter;

import android.content.Context;
//import android.graphics.Bitmap;
//import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import androidx.leanback.widget.ImageCardView;
import androidx.leanback.widget.Presenter;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import com.example.androidtvapptutorial.ViewModel.Movie;
import com.example.androidtvapptutorial.R;
//import com.bumptech.glide.Glide;
//import com.squareup.picasso.Picasso;
//import com.squareup.picasso.Target;

//import java.net.URI;

public class CardPresenter extends Presenter {

    private static final String TAG = CardPresenter.class.getSimpleName();

    private static Context mContext;
    private static int CARD_WIDTH = 313;
    private static int CARD_HEIGHT = 176;

    static class ViewHolder extends Presenter.ViewHolder {
        private Movie mMovie;
        private ImageCardView mCardView;
        private Drawable mDefaultCardImage;
        //private PicassoImageCardViewTarget mImageCardViewTarget;

        public ViewHolder(View view) {
            super(view);
            mCardView = (ImageCardView) view;
            //mImageCardViewTarget = new PicassoImageCardViewTarget(mCardView);
            mDefaultCardImage = mContext.getResources().getDrawable(R.drawable.movie);
        }

        public void setMovie(Movie m) {
            mMovie = m;
        }

        public Movie getMovie() {
            return mMovie;
        }

        public ImageCardView getCardView() {
            return mCardView;
        }

        public Drawable getDefaultCardImage() {
            return mDefaultCardImage;
        }

        /*protected void updateCardViewImage(URI uri){
            Picasso.with(mContext)
                    .load(uri.toString())
                    .resize(Utils.convertDpToPixel(mContext, CARD_WIDTH),
                            Utils.convertDpToPixel(mContext, CARD_HEIGHT))
                    .placeholder(mDefaultCardImage)
                    .error(mDefaultCardImage)
                    .into(mImageCardViewTarget);
        }*/
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent) {
        Log.d(TAG, "onCreateViewHolder");
        mContext = parent.getContext();

        ImageCardView cardView = new ImageCardView(mContext);
        cardView.setFocusable(true);
        cardView.setFocusableInTouchMode(true);
        cardView.setBackgroundColor(mContext.getResources().getColor(R.color.fastlane_background));
        return new ViewHolder(cardView);
    }

    @Override
    public void onBindViewHolder(Presenter.ViewHolder viewHolder, Object item) {
        Log.d(TAG, "onBindViewHolder");
        Movie movie = (Movie) item;
        ViewHolder cardView = ((ViewHolder) viewHolder);

        cardView.setMovie(movie);
        cardView.mCardView.setTitleText(movie.getTitle());
        cardView.mCardView.setContentText(movie.getStudio());
        cardView.mCardView.setMainImageDimensions(CARD_WIDTH, CARD_HEIGHT);

        cardView.mCardView.setMainImage(cardView.getDefaultCardImage());
        //((ViewHolder) viewHolder).updateCardViewImage(movie.getCardImageURI());
        /*Glide.with(viewHolder.view.getContext())
                .load(movie.getCardImageUrl())
                .centerCrop()
                .error(cardView.getDefaultCardImage())
        ;*/
    }

    @Override
    public void onUnbindViewHolder(Presenter.ViewHolder viewHolder) {
        Log.d(TAG, "onUnbindViewHolder");
    }

    @Override
    public void onViewAttachedToWindow(Presenter.ViewHolder viewHolder) {
        // TO DO
    }

    /*public static class PicassoImageCardViewTarget implements Target {
        private ImageCardView mImageCardView;

        public PicassoImageCardViewTarget(ImageCardView imageCardView){
            mImageCardView = imageCardView;
        }

        @Override
        public void onBitmapLoaded(Bitmap bitmap, Picasso.LoadedFrom from) {
            Drawable bitmapDrawable = new BitmapDrawable(mContext.getResources(),bitmap);
            mImageCardView.setMainImage(bitmapDrawable);
        }

        @Override
        public void onBitmapFailed(Drawable errorDrawable) {
            mImageCardView.setMainImage(errorDrawable);
        }

        @Override
        public void onPrepareLoad(Drawable placeHolderDrawable) {
            // Do nothing, default_background manager has its own transitions
        }
    }*/

}
