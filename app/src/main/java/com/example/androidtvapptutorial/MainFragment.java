package com.example.androidtvapptutorial;

import android.os.Build;
import android.os.Bundle;
import androidx.annotation.RequiresApi;
import androidx.leanback.app.BrowseFragment;
import androidx.leanback.app.BrowseSupportFragment;
import androidx.leanback.widget.*;
import android.util.Log;
import android.widget.Toast;
import com.example.androidtvapptutorial.Custom.IconHeaderItemPresenter;

public class MainFragment extends BrowseFragment {

    private final String TAG = MainFragment.class.getSimpleName();

    private static SimpleBackgroundManager simpleBackgroundManager = null;

    private ArrayObjectAdapter mRowsAdapter;
    private static final int GRID_ITEM_WIDTH = 300;
    private static final int GRID_ITEM_HEIGHT = 200;

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        Log.i(TAG, "onActivityCreated");
        super.onActivityCreated(savedInstanceState);

        prepareBackgroundManager();

        setupUIElements();

        loadRows();

        setupEventListeners();
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
    }

    private void loadRows(){
        mRowsAdapter = new ArrayObjectAdapter(new ListRowPresenter());

        //region GridItemPresenter
        HeaderItem gridItemPresenterHeader = new HeaderItem(0, "GridItemPresenter");

        GridItemPresenter mGridPresenter;
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.M) {
            mGridPresenter = new GridItemPresenter(GRID_ITEM_WIDTH,GRID_ITEM_HEIGHT,getResources().getColor(R.color.default_background,getContext().getTheme()));
        }
        else {
            mGridPresenter = new GridItemPresenter(GRID_ITEM_WIDTH,GRID_ITEM_HEIGHT,getResources().getColor(R.color.default_background));
        }
        ArrayObjectAdapter gridRowAdapter = new ArrayObjectAdapter(mGridPresenter);
        gridRowAdapter.add("ITEM 1");
        gridRowAdapter.add("ITEM 2");
        gridRowAdapter.add("ITEM 3");
        mRowsAdapter.add(new ListRow(gridItemPresenterHeader, gridRowAdapter));
        //endregion

        //region CardPresenter
        HeaderItem cardPresenterHeader = new HeaderItem(1, "CardPresenter");
        CardPresenter cardPresenter = new CardPresenter();
        ArrayObjectAdapter cardRowAdapter = new ArrayObjectAdapter(cardPresenter);

        /*
        Movie movie = new Movie();
        movie.setId(0);
        movie.setTitle("title 1");
        movie.setStudio("sub title 1");
        //movie.setCardImageUrl("");
        Log.i("Movie Information",movie.toString());
        cardRowAdapter.add(movie);

        movie.setId(1);
        movie.setTitle("title 2");
        movie.setStudio("sub title 2");
        //movie.setCardImageUrl("");
        Log.i("Movie Information",movie.toString());
        cardRowAdapter.add(movie);

        movie.setId(2);
        movie.setTitle("title 3");
        movie.setStudio("sub title 3");
        //movie.setCardImageUrl("");
        Log.i("Movie Information",movie.toString());
        cardRowAdapter.add(movie);

        movie.setId(3);
        movie.setTitle("title 4");
        movie.setStudio("sub title 4");
        //movie.setCardImageUrl("");
        Log.i("Movie Information",movie.toString());
        cardRowAdapter.add(movie);
        */

        /*
        for(int i=0; i<10; i++) {
            Movie movie = new Movie();
            movie.setTitle("title" + i);
            movie.setStudio("studio" + i);
            //movie.setCardImageUrl("http://heimkehrend.raindrop.jp/kl-hacker/wp-content/uploads/2014/08/DSC02580.jpg");
            Log.i("Movie Information",movie.toString());
            cardRowAdapter.add(movie);
        }
        */

        Movie movie = new Movie();
        movie.setTitle("title 0");
        movie.setStudio("studio 0");
        Log.i("Movie Information",movie.toString());
        cardRowAdapter.add(movie);

        Movie movie1 = new Movie();
        movie1.setTitle("title 1");
        movie1.setStudio("studio 1");
        Log.i("Movie Information",movie1.toString());
        cardRowAdapter.add(movie1);

        Movie movie2 = new Movie();
        movie2.setTitle("title 2");
        movie2.setStudio("studio 2");
        Log.i("Movie Information",movie2.toString());
        cardRowAdapter.add(movie2);

        Movie movie3 = new Movie();
        movie3.setTitle("title 3");
        movie3.setStudio("studio 3");
        Log.i("Movie Information",movie3.toString());
        cardRowAdapter.add(movie3);

        Movie movie4 = new Movie();
        movie4.setTitle("title 4");
        movie4.setStudio("studio 4");
        Log.i("Movie Information",movie4.toString());
        cardRowAdapter.add(movie4);

        mRowsAdapter.add(new ListRow(cardPresenterHeader, cardRowAdapter));
        //endregion

        /* Set */
        setAdapter(mRowsAdapter);
    }

    private void setupEventListeners() {
        setOnItemViewSelectedListener(new ItemViewSelectedListener());
        setOnItemViewClickedListener(new ItemViewClickedListener());
    }

    private final class ItemViewSelectedListener implements OnItemViewSelectedListener {
        @Override
        public void onItemSelected(Presenter.ViewHolder itemViewHolder, Object item,
                                   RowPresenter.ViewHolder rowViewHolder, Row row) {
            // each time the item is selected, code inside here will be executed.
            if (item instanceof String) { // GridItemPresenter row
                simpleBackgroundManager.clearBackground();
            } else if (item instanceof Movie) { // CardPresenter row
                simpleBackgroundManager.updateBackground(getActivity().getDrawable(R.drawable.movie));
            }
        }
    }

    private final class ItemViewClickedListener implements OnItemViewClickedListener {
        @RequiresApi(api = Build.VERSION_CODES.M)
        @Override
        public void onItemClicked(Presenter.ViewHolder itemViewHolder, Object item,
                                  RowPresenter.ViewHolder rowViewHolder, Row row) {
            // each time the item is clicked, code inside here will be executed.
            Toast.makeText(getContext(),"Click",Toast.LENGTH_SHORT).show();
        }
    }

}
