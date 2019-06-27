package com.example.androidtvapptutorial.ViewController;

//import android.graphics.Bitmap;
//import android.graphics.drawable.BitmapDrawable;
import android.content.Context;
import android.util.Log;
import androidx.leanback.widget.Presenter;
import androidx.leanback.widget.PresenterSelector;
import com.example.androidtvapptutorial.DataModel.MediaData;
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
        MediaData file = (MediaData) item;

        Presenter presenter;
        switch (file.getType()) {
            case IMAGE:
                presenter = new MediaImagePresenter(mContext);
                Log.e(MediaPresenterSelector.class.getSimpleName(),"getPresenter() IMAGE " + file.getTitle());
                break;
            case VIDEO:
                presenter = new MediaVideoPresenter(mContext);
                Log.e(MediaPresenterSelector.class.getSimpleName(),"getPresenter() VIDEO " + file.getTitle());
                break;
            case MUSIC:
                presenter = new MediaMusicPresenter(mContext);
                Log.e(MediaPresenterSelector.class.getSimpleName(),"getPresenter() MUSIC " + file.getTitle());
                break;
            case DOCUMENT:
                presenter = new MediaDocumentsPresenter(mContext);
                Log.e(MediaPresenterSelector.class.getSimpleName(),"getPresenter() DOCUMENT " + file.getTitle());
                break;
            default:
                presenter = new MediaDocumentsPresenter(mContext);
                Log.e(MediaPresenterSelector.class.getSimpleName(),"getPresenter() DEFAULT " + file.getTitle());
                break;
        }
        return presenter;
    }

}
