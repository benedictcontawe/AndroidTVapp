package com.example.androidtvapptutorial.ViewHolder;

import androidx.leanback.app.BrowseSupportFragment;
import androidx.leanback.app.RowsSupportFragment;
import com.example.androidtvapptutorial.ViewHolder.CardRowFragment;

public class RowFragmentFactory extends BrowseSupportFragment.FragmentFactory {

    @Override
    public RowsSupportFragment createFragment(Object rowObj) {
        return new CardRowFragment();
    }
}
