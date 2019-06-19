package com.example.androidtvapptutorial;

import androidx.leanback.app.BrowseSupportFragment;
import androidx.leanback.app.RowsSupportFragment;

class RowFragmentFactory extends BrowseSupportFragment.FragmentFactory {

    @Override
    public RowsSupportFragment createFragment(Object rowObj) {
        return new CardRowFragment();
    }
}
