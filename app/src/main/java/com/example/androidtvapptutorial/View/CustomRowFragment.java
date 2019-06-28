package com.example.androidtvapptutorial.View;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;
import androidx.annotation.Nullable;
import androidx.leanback.app.RowsSupportFragment;
import androidx.leanback.widget.*;
import androidx.lifecycle.ViewModelProviders;
import com.example.androidtvapptutorial.DataModel.*;
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
    private MainViewModel mainViewModel;
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

        mainViewModel = ViewModelProviders.of(getActivity()).get(MainViewModel.class);
        loadData();
        getMainFragmentAdapter().getFragmentHost().notifyDataReady(getMainFragmentAdapter());
    }

    private void loadData() {
        Log.e(CustomRowFragment.class.getSimpleName(), "loadData()");
        rowsAdapter = new ArrayObjectAdapter(new ListRowPresenter());
        setAdapter(rowsAdapter);

        createRows();
    }

    private void createRows() {
        mainViewModel.getUsbFilesList(selectedUnivarsalSerialBusName).observe(this, usbFileList -> {
            for (MediaTitle mediaTitle : usbFileList) {
                rowsAdapter.add(createCardRow(mediaTitle));
            }
        });
        /*
        List<MediaTitle> sampleMediaTitle = new ArrayList<>();
        List<VideoModel> mediaDataVideo = new ArrayList<>();
        List<MusicModel> mediaDataMusic = new ArrayList<>();
        List<ImageModel> mediaDataImage = new ArrayList<>();
        List<DocumentModel> mediaDataDocuments = new ArrayList<>();

        Log.e(CustomRowFragment.class.getSimpleName(), "loadData() Selected Header " + selectedUnivarsalSerialBusName);

        mediaDataVideo.add(new VideoModel("video.mp4","video.mp4"));
        mediaDataVideo.add(new VideoModel("video1.mp4", "video.mp4"));
        mediaDataVideo.add(new VideoModel("video2.mp4", "video.mp4"));

        mediaDataMusic.add(new MusicModel("music1.mp3", "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Cras hendrerit erat tortor. Phasellus auctor tortor in sodales convallis. Curabitur in mauris leo. Class aptent taciti sociosqu ad litora torquent per conubia nostra, per inceptos himenaeos. Quisque eget molestie enim. Maecenas mollis diam nunc, sed sodales ante vestibulum nec. Donec in elit vitae nibh mollis gravida in luctus neque."));
        mediaDataMusic.add(new MusicModel("music2.mp3", "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Cras hendrerit erat tortor. Phasellus auctor tortor in sodales convallis. Curabitur in mauris leo. Class aptent taciti sociosqu ad litora torquent per conubia nostra, per inceptos himenaeos. Quisque eget molestie enim. Maecenas mollis diam nunc, sed sodales ante vestibulum nec. Donec in elit vitae nibh mollis gravida in luctus neque."));
        mediaDataMusic.add(new MusicModel("music3.mp3","Lorem ipsum dolor sit amet, consectetur adipiscing elit. Cras hendrerit erat tortor. Phasellus auctor tortor in sodales convallis. Curabitur in mauris leo. Class aptent taciti sociosqu ad litora torquent per conubia nostra, per inceptos himenaeos. Quisque eget molestie enim. Maecenas mollis diam nunc, sed sodales ante vestibulum nec. Donec in elit vitae nibh mollis gravida in luctus neque."));
        mediaDataMusic.add(new MusicModel("music4.mp3", "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Cras hendrerit erat tortor. Phasellus auctor tortor in sodales convallis. Curabitur in mauris leo. Class aptent taciti sociosqu ad litora torquent per conubia nostra, per inceptos himenaeos. Quisque eget molestie enim. Maecenas mollis diam nunc, sed sodales ante vestibulum nec. Donec in elit vitae nibh mollis gravida in luctus neque."));
        mediaDataMusic.add(new MusicModel("music5.mp3", "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Cras hendrerit erat tortor. Phasellus auctor tortor in sodales convallis. Curabitur in mauris leo. Class aptent taciti sociosqu ad litora torquent per conubia nostra, per inceptos himenaeos. Quisque eget molestie enim. Maecenas mollis diam nunc, sed sodales ante vestibulum nec. Donec in elit vitae nibh mollis gravida in luctus neque."));
        mediaDataMusic.add(new MusicModel("music6.mp3", "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Cras hendrerit erat tortor. Phasellus auctor tortor in sodales convallis. Curabitur in mauris leo. Class aptent taciti sociosqu ad litora torquent per conubia nostra, per inceptos himenaeos. Quisque eget molestie enim. Maecenas mollis diam nunc, sed sodales ante vestibulum nec. Donec in elit vitae nibh mollis gravida in luctus neque."));
        mediaDataMusic.add(new MusicModel("music7.mp3", "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Cras hendrerit erat tortor. Phasellus auctor tortor in sodales convallis. Curabitur in mauris leo. Class aptent taciti sociosqu ad litora torquent per conubia nostra, per inceptos himenaeos. Quisque eget molestie enim. Maecenas mollis diam nunc, sed sodales ante vestibulum nec. Donec in elit vitae nibh mollis gravida in luctus neque."));

        mediaDataImage.add(new ImageModel("img1.png", "img1.png"));
        mediaDataImage.add(new ImageModel("img2.png","img1.png"));
        mediaDataImage.add(new ImageModel("img3.png","img1.png"));
        mediaDataImage.add(new ImageModel("img4.png","img1.png"));

        mediaDataDocuments.add(new DocumentModel("Document 1"));
        mediaDataDocuments.add(new DocumentModel("Document 2"));
        mediaDataDocuments.add(new DocumentModel("Document 3"));
        mediaDataDocuments.add(new DocumentModel("Document 4"));
        mediaDataDocuments.add(new DocumentModel("Document 5"));

        sampleMediaTitle.add(new MediaTitle("Video", mediaDataVideo));
        sampleMediaTitle.add(new MediaTitle("Music", mediaDataMusic));
        sampleMediaTitle.add(new MediaTitle("Pictures", mediaDataImage));
        sampleMediaTitle.add(new MediaTitle("Documents", mediaDataDocuments));

        for (MediaTitle mediaTitle : sampleMediaTitle) {
            //rowsAdapter.clear();
            rowsAdapter.add(createCardRow(mediaTitle));
        }
        */
    }

    private Row createCardRow(MediaTitle mediaTitle) {
        PresenterSelector presenterSelector = new MediaPresenterSelector(getActivity());
        ArrayObjectAdapter adapter = new ArrayObjectAdapter(presenterSelector);

        for (Object item : mediaTitle.getDatum()) {
            if (item instanceof ImageModel) {
                Log.e("createCardRow",((ImageModel) item).getTitle());
                ImageModel imageModel = (ImageModel) item;
                adapter.add(imageModel);
            } else if (item instanceof VideoModel) {
                Log.e("createCardRow",((VideoModel) item).getTitle());
                VideoModel videoModel = (VideoModel) item;
                adapter.add(videoModel);
            } else if (item instanceof MusicModel) {
                Log.e("createCardRow",((MusicModel) item).getTitle());
                MusicModel musicModel = (MusicModel) item;
                adapter.add(musicModel);
            } else if (item instanceof DocumentModel) {
                Log.e("createCardRow",((DocumentModel) item).getTitle());
                DocumentModel documentModel = (DocumentModel) item;
                adapter.add(documentModel);
            }
        }

        HeaderItem headerItem = new HeaderItem(mediaTitle.getTitle());

        return new ListRow(headerItem, adapter);
    }

    @Override
    public void onItemClicked(Presenter.ViewHolder itemViewHolder, Object item, RowPresenter.ViewHolder rowViewHolder, Row row) {
        Toast.makeText(getActivity(), "Clicked " + row, Toast.LENGTH_SHORT).show();
    }
}
