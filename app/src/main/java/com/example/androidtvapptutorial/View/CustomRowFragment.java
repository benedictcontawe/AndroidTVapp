package com.example.androidtvapptutorial.View;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;
import androidx.annotation.Nullable;
import androidx.leanback.app.RowsSupportFragment;
import androidx.leanback.widget.*;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import com.example.androidtvapptutorial.Model.DataModel.*;
import com.example.androidtvapptutorial.Model.Room.Entity.MediaEntity;
import com.example.androidtvapptutorial.View.ViewController.MediaPresenterSelector;
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
        mainViewModel.getRows(selectedUnivarsalSerialBusName).observe(this, new Observer<List<MediaEntity>>() {
            @Override
            public void onChanged(List<MediaEntity> mediaEntities) {
                rowsAdapter.clear();
                List<MediaTitle> mediaTitle = new ArrayList<>();
                List<VideoModel> mediaDataVideo = new ArrayList<>();
                List<MusicModel> mediaDataMusic = new ArrayList<>();
                List<ImageModel> mediaDataImage = new ArrayList<>();
                List<DocumentModel> mediaDataDocuments = new ArrayList<>();

                for (MediaEntity mediaEntity : mediaEntities){
                    switch (mediaEntity.getType()){
                        case "IMAGE":
                            mediaDataImage.add(new ImageModel(mediaEntity.getTitle(),mediaEntity.getDescription()));
                            break;
                        case "VIDEO":
                            mediaDataVideo.add(new VideoModel(mediaEntity.getTitle(),mediaEntity.getDescription()));
                            break;
                        case "MUSIC":
                            mediaDataMusic.add(new MusicModel(mediaEntity.getTitle(),mediaEntity.getDescription()));
                            break;
                        case "DOC":
                            mediaDataDocuments.add(new DocumentModel(mediaEntity.getTitle()));
                            break;
                        default:
                            Log.e(CustomRowFragment.class.getSimpleName(),mediaEntity.getTitle() + " " + mediaEntity.getDescription() + " " + mediaEntity.getType() + " " + mediaEntity.getLocalImageResource());
                            break;
                    }
                }
                mediaTitle.add(new MediaTitle("Video", mediaDataVideo));
                mediaTitle.add(new MediaTitle("Music", mediaDataMusic));
                mediaTitle.add(new MediaTitle("Pictures", mediaDataImage));
                mediaTitle.add(new MediaTitle("Documents", mediaDataDocuments));
                rowsAdapter.add(createCardRow(mediaTitle));
            }
        });
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
