package com.example.androidtvapptutorial.View;

import android.os.Bundle;
import android.util.Log;
import androidx.leanback.app.BrowseSupportFragment;
import androidx.leanback.widget.*;
import com.example.androidtvapptutorial.R;
import com.example.androidtvapptutorial.ViewController.RowFragmentFactory;
import com.example.androidtvapptutorial.SimpleBackgroundManager;

import java.util.ArrayList;
import java.util.List;

//import androidx.leanback.app.BrowseFragment;

public class MainFragment extends BrowseSupportFragment {

    private static SimpleBackgroundManager simpleBackgroundManager = null;

    private ArrayObjectAdapter mRowsAdapter;
    private static final int GRID_ITEM_WIDTH = 300;
    private static final int GRID_ITEM_HEIGHT = 200;

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        Log.e(MainFragment.class.getSimpleName(), "onActivityCreated");
        super.onActivityCreated(savedInstanceState);

        prepareBackgroundManager();

        setupUIElements();

        loadData();

        Log.e(MainFragment.class.getSimpleName(),String.valueOf(getSelectedPosition()));

        getMainFragmentRegistry().registerFragment(PageRow.class,new RowFragmentFactory());
    }

    private void prepareBackgroundManager(){
        simpleBackgroundManager = new SimpleBackgroundManager(getActivity());
    }

    private void setupUIElements() {
        // setBadgeDrawable(getActivity().getResources().getDrawable(R.drawable.videos_by_google_banner));
        setTitle("Hello Android TV!"); // Badge, when set, takes precedent
        /*if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            setBadgeDrawable(getResources().getDrawable(R.mipmap.videos_by_google_banner,getContext().getTheme()));
        }*/
        // over title
        setHeadersState(HEADERS_ENABLED);
        setHeadersTransitionOnBackEnabled(true);

        // set fastLane (or headers) background color
        setBrandColor(getResources().getColor(R.color.fastlane_background));
        // set search icon color
        setSearchAffordanceColor(getResources().getColor(R.color.search_opaque));
        /*
        setHeaderPresenterSelector(new PresenterSelector() {
            @Override
            public Presenter getPresenter(Object o) {
                return new IconHeaderItemPresenter();
            }
        });
        */
        prepareEntranceTransition();
    }

    private void loadData(){
        createRows();
        //After the Fragment finishes the loading data it will execute an entrance transition
        startEntranceTransition();
    }

    private void createRows(){
        //Create Array Object Adapter Instance and Set Adapter to Browse Rows
        mRowsAdapter = new ArrayObjectAdapter(new ListRowPresenter());
        setAdapter(mRowsAdapter);


        mRowsAdapter.add(new SectionRow(new HeaderItem("USB Devices")));
        mRowsAdapter.add(new DividerRow());

        //Create List of HeaderItem Data and add to the Instance of Array Object Adapter
        List<HeaderItem> dummyHeaders = new ArrayList<>();
        dummyHeaders.add(new HeaderItem(0, "USB All"));
        dummyHeaders.add(new HeaderItem(0, "USB1"));
        dummyHeaders.add(new HeaderItem(1, "USB2"));
        dummyHeaders.add(new HeaderItem(2, "USB3"));
        for (HeaderItem header : dummyHeaders) {
            mRowsAdapter.add(new PageRow(header));
        }

        mRowsAdapter.add(new DividerRow());
    }
}
