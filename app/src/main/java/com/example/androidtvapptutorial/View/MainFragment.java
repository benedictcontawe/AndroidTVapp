package com.example.androidtvapptutorial.View;

import android.os.Bundle;
import android.util.Log;
import androidx.leanback.app.BrowseSupportFragment;
import androidx.leanback.widget.*;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import com.example.androidtvapptutorial.R;
import com.example.androidtvapptutorial.View.ViewController.RowFragmentFactory;
import com.example.androidtvapptutorial.SimpleBackgroundManager;
import com.example.androidtvapptutorial.ViewModel.MainViewModel;

import java.util.List;
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
        /*
        mainViewModel.getHeaders().observe(this, new Observer<Set<String>>() {
            @Override
            public void onChanged(Set<String> strings) {
                rowsAdapter.add(0,new SectionRow(new HeaderItem("USB Devices")));
                rowsAdapter.add(1,new DividerRow());
                rowsAdapter.add(2,new PageRow(new HeaderItem("USB All")));
                for (String header : strings){
                    HeaderItem headerItem = new HeaderItem(header);
                    rowsAdapter.add(new PageRow(headerItem));
                }
                rowsAdapter.add(rowsAdapter.size(),new DividerRow());
            }
        });
        */
        mainViewModel.getHeaders().observe(this, new Observer<List<String>>() {
            @Override
            public void onChanged(List<String> headerItems) {
                rowsAdapter.add(0,new SectionRow(new HeaderItem("USB Devices")));
                rowsAdapter.add(1,new DividerRow());
                rowsAdapter.add(2,new PageRow(new HeaderItem("USB All")));
                for (String header : headerItems) {
                    rowsAdapter.add(new PageRow(new HeaderItem(header)));
                    //rowsAdapter.add(new PageRow(header));
                }
                rowsAdapter.add(rowsAdapter.size(),new DividerRow());
            }
        });
    }
}
