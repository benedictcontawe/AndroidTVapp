package com.example.androidtvapptutorial.View.ViewController;

//import android.graphics.Bitmap;
//import android.graphics.drawable.BitmapDrawable;
import android.content.Context;
import androidx.leanback.widget.Presenter;
import androidx.leanback.widget.PresenterSelector;
import com.example.androidtvapptutorial.Model.DataModel.DocumentModel;
import com.example.androidtvapptutorial.Model.DataModel.ImageModel;
import com.example.androidtvapptutorial.Model.DataModel.MusicModel;
import com.example.androidtvapptutorial.Model.DataModel.VideoModel;
import com.example.androidtvapptutorial.View.Presenter.MediaDocumentsPresenter;
import com.example.androidtvapptutorial.View.Presenter.MediaImagePresenter;
import com.example.androidtvapptutorial.View.Presenter.MediaVideoPresenter;
import com.example.androidtvapptutorial.View.Presenter.MediaMusicPresenter;
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
