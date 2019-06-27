package com.example.androidtvapptutorial.ViewController;

//import android.graphics.Bitmap;
//import android.graphics.drawable.BitmapDrawable;
import android.content.Context;
import android.util.Log;
import androidx.leanback.widget.Presenter;
import androidx.leanback.widget.PresenterSelector;
import com.example.androidtvapptutorial.DataModel.*;
import com.example.androidtvapptutorial.Presenter.MediaDocumentsPresenter;
import com.example.androidtvapptutorial.Presenter.MediaImagePresenter;
import com.example.androidtvapptutorial.Presenter.MediaVideoPresenter;
import com.example.androidtvapptutorial.Presenter.MediaMusicPresenter;
//import com.bumptech.glide.Glide;
//import com.squareup.picasso.Picasso;
//import com.squareup.picasso.Target;

//import java.net.URI;

public class MediaPresenterSelector extends PresenterSelector {

    private Context mContext;

    public MediaPresenterSelector(Context context) {
        this.mContext = context;
    }

    public Presenter getPresenter(Object item) {
        Presenter presenter;
        if (item instanceof ImageModel) {
            presenter = new MediaImagePresenter(mContext);
        } else if (item instanceof VideoModel) {
            presenter = new MediaVideoPresenter(mContext);
        } else if (item instanceof MusicModel) {
            presenter = new MediaMusicPresenter(mContext);
        } else if (item instanceof DocumentModel){
            presenter = new MediaDocumentsPresenter(mContext);
        } else {
            presenter = new MediaDocumentsPresenter(mContext);
        }

        return presenter;
    }

}
