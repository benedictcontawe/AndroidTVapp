package com.example.androidtvapptutorial.View;

import android.os.Bundle;
import android.widget.Toast;
import androidx.annotation.Nullable;
import androidx.leanback.app.RowsSupportFragment;
import androidx.leanback.widget.*;
import com.example.androidtvapptutorial.DataModel.MediaData;
import com.example.androidtvapptutorial.DataModel.MediaTitle;
import com.example.androidtvapptutorial.Presenter.MediaPresenterSelector;

import java.util.ArrayList;
import java.util.List;

public class CardRowFragment extends RowsSupportFragment implements OnItemViewClickedListener {


    private ArrayObjectAdapter rowsAdapter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setOnItemViewClickedListener(this);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        loadData();
        getMainFragmentAdapter().getFragmentHost().notifyDataReady(getMainFragmentAdapter());
    }

    private void loadData() {
        rowsAdapter = new ArrayObjectAdapter(new ListRowPresenter());
        setAdapter(rowsAdapter);

        List<MediaTitle> sampleMediaTitle = new ArrayList<>();
        List<MediaData> mediaDataVideo = new ArrayList<>();
        List<MediaData> mediaDataMusic = new ArrayList<>();
        List<MediaData> mediaDataImage = new ArrayList<>();

        mediaDataVideo.add(new MediaData("video.mp4","video.mp4", MediaData.Type.VIDEO));
        mediaDataVideo.add(new MediaData("video1.mp4", "video.mp4",MediaData.Type.VIDEO));
        mediaDataVideo.add(new MediaData("video2.mp4", "video.mp4",MediaData.Type.VIDEO));

        mediaDataMusic.add(new MediaData("music1.mp3", "music1asdasdasdasd music1asdasdasdasd music1asdasdasdasdmusic1asdasdasdasdmusic1asdasdasdasdmusic1asdasdasdasd music1asdasdasdasd music1asdasdasdasd music1asdasdasdasd music1asdasdasdasd music1asdasdasdasd music1asdasdasdasdv music1asdasdasdasd", MediaData.Type.MUSIC));
        mediaDataMusic.add(new MediaData("music2.mp3", "music1asdasdasdasd music1asdasdasdasd music1asdasdasdasdmusic1asdasdasdasdmusic1asdasdasdasdmusic1asdasdasdasd music1asdasdasdasd music1asdasdasdasd music1asdasdasdasd music1asdasdasdasd music1asdasdasdasd music1asdasdasdasdv music1asdasdasdasd", MediaData.Type.MUSIC));
        mediaDataMusic.add(new MediaData("music3.mp3","music1asdasdasdasd music1asdasdasdasd music1asdasdasdasdmusic1asdasdasdasdmusic1asdasdasdasdmusic1asdasdasdasd music1asdasdasdasd music1asdasdasdasd music1asdasdasdasd music1asdasdasdasd music1asdasdasdasd music1asdasdasdasdv music1asdasdasdasd",  MediaData.Type.MUSIC));
        mediaDataMusic.add(new MediaData("music4.mp3", "music1asdasdasdasd music1asdasdasdasd music1asdasdasdasdmusic1asdasdasdasdmusic1asdasdasdasdmusic1asdasdasdasd music1asdasdasdasd music1asdasdasdasd music1asdasdasdasd music1asdasdasdasd music1asdasdasdasd music1asdasdasdasdv music1asdasdasdasd3", MediaData.Type.MUSIC));
        mediaDataMusic.add(new MediaData("music5.mp3","music1asdasdasdasd music1asdasdasdasd music1asdasdasdasdmusic1asdasdasdasdmusic1asdasdasdasdmusic1asdasdasdasd music1asdasdasdasd music1asdasdasdasd music1asdasdasdasd music1asdasdasdasd music1asdasdasdasd music1asdasdasdasdv music1asdasdasdasd",  MediaData.Type.MUSIC));
        mediaDataMusic.add(new MediaData("music6.mp3", " music1asdasdasdasd music1asdasdasdasd music1asdasdasdasdmusic1asdasdasdasdmusic1asdasdasdasdmusic1asdasdasdasd music1asdasdasdasd music1asdasdasdasd music1asdasdasdasd music1asdasdasdasd music1asdasdasdasd music1asdasdasdasdv music1asdasdasdasd.mp3", MediaData.Type.MUSIC));
        mediaDataMusic.add(new MediaData("music7.mp3","music1asdasdasdasd music1asdasdasdasd music1asdasdasdasdmusic1asdasdasdasdmusic1asdasdasdasdmusic1asdasdasdasd music1asdasdasdasd music1asdasdasdasd music1asdasdasdasd music1asdasdasdasd music1asdasdasdasd music1asdasdasdasdv music1asdasdasdasd",  MediaData.Type.MUSIC));

        mediaDataImage.add(new MediaData("img1.png", "img1.png",MediaData.Type.IMAGE));
        mediaDataImage.add(new MediaData("img2.png","img1.png", MediaData.Type.IMAGE));
        mediaDataImage.add(new MediaData("img3.png","img1.png", MediaData.Type.IMAGE));
        mediaDataImage.add(new MediaData("img4.png","img1.png", MediaData.Type.IMAGE));

        sampleMediaTitle.add(new MediaTitle("Video", mediaDataVideo));
        sampleMediaTitle.add(new MediaTitle("Music", mediaDataMusic));
        sampleMediaTitle.add(new MediaTitle("Pictures", mediaDataImage));

        for (MediaTitle mediaTitle : sampleMediaTitle) {
            rowsAdapter.add(createCardRow(mediaTitle));
        }
    }

    private Row createCardRow(MediaTitle mediaTitle) {
        PresenterSelector presenterSelector = new MediaPresenterSelector(getActivity());
        ArrayObjectAdapter adapter = new ArrayObjectAdapter(presenterSelector);
        for (MediaData mediaData : mediaTitle.getData()) {
            adapter.add(mediaData);
        }
        HeaderItem headerItem = new HeaderItem(mediaTitle.getTitle());

        return new ListRow(headerItem, adapter);
    }

    @Override
    public void onItemClicked(Presenter.ViewHolder itemViewHolder, Object item, RowPresenter.ViewHolder rowViewHolder, Row row) {
        MediaData mediaData = (MediaData) item;
        Toast.makeText(getActivity(), "Clicked " + mediaData.getTitle(), Toast.LENGTH_SHORT).show();
    }
}
