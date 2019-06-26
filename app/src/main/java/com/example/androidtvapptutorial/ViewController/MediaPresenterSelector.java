package com.example.androidtvapptutorial.ViewController;

//import android.graphics.Bitmap;
//import android.graphics.drawable.BitmapDrawable;
import android.content.Context;
import androidx.leanback.widget.Presenter;
import androidx.leanback.widget.PresenterSelector;
import com.example.androidtvapptutorial.DataModel.MediaData;
import com.example.androidtvapptutorial.Presenter.MediaImagePresenter;
import com.example.androidtvapptutorial.Presenter.MediaVideoPresenter;
import com.example.androidtvapptutorial.Presenter.TextCardPresenter;
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
                break;
            case VIDEO:
                presenter = new MediaVideoPresenter(mContext);
                break;
            case MUSIC:
            case DOCUMENT:
            default:
                presenter = new TextCardPresenter(mContext);
        }
        return presenter;
    }

}
