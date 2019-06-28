package com.example.androidtvapptutorial.View.ViewController;

import android.util.Log;
import androidx.leanback.app.BrowseSupportFragment.FragmentFactory;
import androidx.leanback.app.RowsSupportFragment;
import androidx.leanback.widget.Row;
import com.example.androidtvapptutorial.View.CustomRowFragment;

public class RowFragmentFactory extends FragmentFactory {

    @Override
    public RowsSupportFragment createFragment(Object rowObj) {
        Row row = (Row) rowObj;

        Log.e(RowFragmentFactory.class.getSimpleName(), "RowsSupportFragment createFragment: " + row.getHeaderItem().getName());
        return new CustomRowFragment.companionObject().newBundle(row.getHeaderItem().getName());
    }
}
