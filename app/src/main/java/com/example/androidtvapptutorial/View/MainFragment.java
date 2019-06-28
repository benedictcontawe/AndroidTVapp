package com.example.androidtvapptutorial.View;

import android.os.Bundle;
import android.util.Log;
import androidx.leanback.app.BrowseSupportFragment;
import androidx.leanback.widget.*;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import com.example.androidtvapptutorial.R;
import com.example.androidtvapptutorial.ViewController.RowFragmentFactory;
import com.example.androidtvapptutorial.SimpleBackgroundManager;
import com.example.androidtvapptutorial.ViewModel.MainViewModel;

import java.util.Set;

//import androidx.leanback.app.BrowseFragment;

public class MainFragment extends BrowseSupportFragment {

    private ArrayObjectAdapter rowsAdapter;
    private MainViewModel mainViewModel;
    private static SimpleBackgroundManager simpleBackgroundManager = null;

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        Log.e(MainFragment.class.getSimpleName(), "onActivityCreated");
        super.onActivityCreated(savedInstanceState);

        mainViewModel = ViewModelProviders.of(getActivity()).get(MainViewModel.class);

        //prepareBackgroundManager();

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
        //Create Array Object Adapter Instance and Set Adapter to Browse Rows
        rowsAdapter = new ArrayObjectAdapter(new ListRowPresenter());
        setAdapter(rowsAdapter);

        createRows();
        //After the Fragment finishes the loading data it will execute an entrance transition
        startEntranceTransition();
    }

    private void createRows(){
        rowsAdapter.add(new SectionRow(new HeaderItem("USB Devices")));
        rowsAdapter.add(new DividerRow());
        /*
        //Create List of HeaderItem Data and add to the Instance of Array Object Adapter
        List<HeaderItem> dummyHeaders = new ArrayList<>();
        dummyHeaders.add(new HeaderItem(0, "USB All"));
        dummyHeaders.add(new HeaderItem(0, "USB1"));
        dummyHeaders.add(new HeaderItem(1, "USB2"));
        dummyHeaders.add(new HeaderItem(2, "USB3"));
        for (HeaderItem header : dummyHeaders) {
            rowsAdapter.add(new PageRow(header));
        }
        */
        mainViewModel.getHeaders().observe(this, new Observer<Set<String>>() {
            @Override
            public void onChanged(Set<String> strings) {
                for (String header : strings){
                    HeaderItem headerItem = new HeaderItem(header);
                    rowsAdapter.add(new PageRow(headerItem));
                }
            }
        });

        rowsAdapter.add(new DividerRow());
    }
}
