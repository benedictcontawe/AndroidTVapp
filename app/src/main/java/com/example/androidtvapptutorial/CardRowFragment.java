package com.example.androidtvapptutorial;

import android.os.Bundle;
import android.widget.Toast;
import androidx.annotation.Nullable;
import androidx.leanback.app.RowsSupportFragment;
import androidx.leanback.widget.*;

import java.util.ArrayList;
import java.util.List;

class CardRowFragment extends RowsSupportFragment implements OnItemViewClickedListener {


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

        List<UsbFileCardRow> dummyUsbFileCardRows = new ArrayList<>();
        List<UsbFileCard> dummyUsbFileCardsVid = new ArrayList<>();
        List<UsbFileCard> dummyUsbFileCardsMusic = new ArrayList<>();
        List<UsbFileCard> dummyUsbFileCardsImg = new ArrayList<>();

        dummyUsbFileCardsVid.add(new UsbFileCard("video.mp4"));
        dummyUsbFileCardsVid.add(new UsbFileCard("video1.mp4"));
        dummyUsbFileCardsVid.add(new UsbFileCard("video2.mp4"));

        dummyUsbFileCardsMusic.add(new UsbFileCard("music1.mp3"));
        dummyUsbFileCardsMusic.add(new UsbFileCard("music2.mp3"));
        dummyUsbFileCardsMusic.add(new UsbFileCard("music3.mp3"));
        dummyUsbFileCardsMusic.add(new UsbFileCard("music4.mp3"));
        dummyUsbFileCardsMusic.add(new UsbFileCard("music5.mp3"));
        dummyUsbFileCardsMusic.add(new UsbFileCard("music6.mp3"));
        dummyUsbFileCardsMusic.add(new UsbFileCard("music7.mp3"));

        dummyUsbFileCardsImg.add(new UsbFileCard("img1.png"));
        dummyUsbFileCardsImg.add(new UsbFileCard("img2.png"));
        dummyUsbFileCardsImg.add(new UsbFileCard("img3.png"));
        dummyUsbFileCardsImg.add(new UsbFileCard("img4.png"));

        dummyUsbFileCardRows.add(new UsbFileCardRow("Video", dummyUsbFileCardsVid));
        dummyUsbFileCardRows.add(new UsbFileCardRow("Music", dummyUsbFileCardsMusic));
        dummyUsbFileCardRows.add(new UsbFileCardRow("Pictures", dummyUsbFileCardsImg));

        for (UsbFileCardRow usbFileCardRow : dummyUsbFileCardRows) {
            rowsAdapter.add(createCardRow(usbFileCardRow));
        }
    }

    private Object createCardRow(UsbFileCardRow usbFileCardRow) {
        CardPresenter cardPresenter;
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.M) {
            cardPresenter = new CardPresenter(getResources().getColor(R.color.default_background, getContext().getTheme()));
        } else {
            cardPresenter = new CardPresenter(getResources().getColor(R.color.default_background));
        }

        ArrayObjectAdapter adapter = new ArrayObjectAdapter(cardPresenter);
        for (UsbFileCard usbFileCard : usbFileCardRow.getUsbFileCards()) {
            adapter.add(usbFileCard);
        }
        HeaderItem headerItem = new HeaderItem(usbFileCardRow.getTitle());

        return new ListRow(headerItem, adapter);
    }

    @Override
    public void onItemClicked(Presenter.ViewHolder itemViewHolder, Object item, RowPresenter.ViewHolder rowViewHolder, Row row) {
        UsbFileCard usbFileCard = (UsbFileCard) item;
        Toast.makeText(getActivity(), "Clicked " + usbFileCard.getFileName(), Toast.LENGTH_SHORT).show();
    }
}
