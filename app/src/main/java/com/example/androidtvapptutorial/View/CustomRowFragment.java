package com.example.androidtvapptutorial.View;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;
import androidx.annotation.Nullable;
import androidx.leanback.app.RowsSupportFragment;
import androidx.leanback.widget.*;
import com.example.androidtvapptutorial.DataModel.MediaData;
import com.example.androidtvapptutorial.DataModel.MediaTitle;
import com.example.androidtvapptutorial.ViewController.MediaPresenterSelector;
import com.example.androidtvapptutorial.ViewModel.MainViewModel;

import java.util.ArrayList;
import java.util.List;

public class CustomRowFragment extends RowsSupportFragment implements OnItemViewClickedListener {

    public static final class companionObject{

        static final String ARGUMENT_ITEM_NAME = "Argument Item Name";

        public static RowsSupportFragment newBundle(String selectedHeaderName) {
            Bundle bundle = new Bundle();
            bundle.putString(ARGUMENT_ITEM_NAME, selectedHeaderName);

            CustomRowFragment customRowFragment = new CustomRowFragment();
            customRowFragment.setArguments(bundle);

            return customRowFragment;
        }
    }

    private ArrayObjectAdapter rowsAdapter;
    private String selectedUnivarsalSerialBusName;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Bundle bundle = getArguments();
        selectedUnivarsalSerialBusName = bundle.getString(companionObject.ARGUMENT_ITEM_NAME);

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

        createRows();
        Log.e(CustomRowFragment.class.getSimpleName(), "loadData()");
    }

    private void createRows() {
        List<MediaTitle> sampleMediaTitle = new ArrayList<>();
        List<MediaData> mediaDataVideo = new ArrayList<>();
        List<MediaData> mediaDataMusic = new ArrayList<>();
        List<MediaData> mediaDataImage = new ArrayList<>();
        List<MediaData> mediaDataDocuments = new ArrayList<>();

        Log.e(CustomRowFragment.class.getSimpleName(), "loadData() Selected Header " + selectedUnivarsalSerialBusName);

        mediaDataVideo.add(new MediaData("video.mp4","video.mp4", MediaData.Type.VIDEO));
        mediaDataVideo.add(new MediaData("video1.mp4", "video.mp4",MediaData.Type.VIDEO));
        mediaDataVideo.add(new MediaData("video2.mp4", "video.mp4",MediaData.Type.VIDEO));

        mediaDataMusic.add(new MediaData("music1.mp3", "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Cras hendrerit erat tortor. Phasellus auctor tortor in sodales convallis. Curabitur in mauris leo. Class aptent taciti sociosqu ad litora torquent per conubia nostra, per inceptos himenaeos. Quisque eget molestie enim. Maecenas mollis diam nunc, sed sodales ante vestibulum nec. Donec in elit vitae nibh mollis gravida in luctus neque.", MediaData.Type.MUSIC));
        mediaDataMusic.add(new MediaData("music2.mp3", "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Cras hendrerit erat tortor. Phasellus auctor tortor in sodales convallis. Curabitur in mauris leo. Class aptent taciti sociosqu ad litora torquent per conubia nostra, per inceptos himenaeos. Quisque eget molestie enim. Maecenas mollis diam nunc, sed sodales ante vestibulum nec. Donec in elit vitae nibh mollis gravida in luctus neque.", MediaData.Type.MUSIC));
        mediaDataMusic.add(new MediaData("music3.mp3","Lorem ipsum dolor sit amet, consectetur adipiscing elit. Cras hendrerit erat tortor. Phasellus auctor tortor in sodales convallis. Curabitur in mauris leo. Class aptent taciti sociosqu ad litora torquent per conubia nostra, per inceptos himenaeos. Quisque eget molestie enim. Maecenas mollis diam nunc, sed sodales ante vestibulum nec. Donec in elit vitae nibh mollis gravida in luctus neque.",  MediaData.Type.MUSIC));
        mediaDataMusic.add(new MediaData("music4.mp3", "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Cras hendrerit erat tortor. Phasellus auctor tortor in sodales convallis. Curabitur in mauris leo. Class aptent taciti sociosqu ad litora torquent per conubia nostra, per inceptos himenaeos. Quisque eget molestie enim. Maecenas mollis diam nunc, sed sodales ante vestibulum nec. Donec in elit vitae nibh mollis gravida in luctus neque.", MediaData.Type.MUSIC));
        mediaDataMusic.add(new MediaData("music5.mp3", "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Cras hendrerit erat tortor. Phasellus auctor tortor in sodales convallis. Curabitur in mauris leo. Class aptent taciti sociosqu ad litora torquent per conubia nostra, per inceptos himenaeos. Quisque eget molestie enim. Maecenas mollis diam nunc, sed sodales ante vestibulum nec. Donec in elit vitae nibh mollis gravida in luctus neque.", MediaData.Type.MUSIC));
        mediaDataMusic.add(new MediaData("music6.mp3", "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Cras hendrerit erat tortor. Phasellus auctor tortor in sodales convallis. Curabitur in mauris leo. Class aptent taciti sociosqu ad litora torquent per conubia nostra, per inceptos himenaeos. Quisque eget molestie enim. Maecenas mollis diam nunc, sed sodales ante vestibulum nec. Donec in elit vitae nibh mollis gravida in luctus neque.", MediaData.Type.MUSIC));
        mediaDataMusic.add(new MediaData("music7.mp3", "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Cras hendrerit erat tortor. Phasellus auctor tortor in sodales convallis. Curabitur in mauris leo. Class aptent taciti sociosqu ad litora torquent per conubia nostra, per inceptos himenaeos. Quisque eget molestie enim. Maecenas mollis diam nunc, sed sodales ante vestibulum nec. Donec in elit vitae nibh mollis gravida in luctus neque.", MediaData.Type.MUSIC));

        mediaDataImage.add(new MediaData("img1.png", "img1.png",MediaData.Type.IMAGE));
        mediaDataImage.add(new MediaData("img2.png","img1.png", MediaData.Type.IMAGE));
        mediaDataImage.add(new MediaData("img3.png","img1.png", MediaData.Type.IMAGE));
        mediaDataImage.add(new MediaData("img4.png","img1.png", MediaData.Type.IMAGE));

        mediaDataDocuments.add(new MediaData("Document 1", "",MediaData.Type.DOCUMENT));
        mediaDataDocuments.add(new MediaData("Document 2","", MediaData.Type.DOCUMENT));
        mediaDataDocuments.add(new MediaData("Document 3","", MediaData.Type.DOCUMENT));
        mediaDataDocuments.add(new MediaData("Document 4","", MediaData.Type.DOCUMENT));

        sampleMediaTitle.add(new MediaTitle("Video", mediaDataVideo));
        sampleMediaTitle.add(new MediaTitle("Music", mediaDataMusic));
        sampleMediaTitle.add(new MediaTitle("Pictures", mediaDataImage));
        sampleMediaTitle.add(new MediaTitle("Documents", mediaDataDocuments));

        for (MediaTitle mediaTitle : sampleMediaTitle) {
            //rowsAdapter.clear();
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
