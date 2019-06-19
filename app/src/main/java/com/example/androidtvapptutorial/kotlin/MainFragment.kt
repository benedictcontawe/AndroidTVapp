/*
package com.example.androidtvapptutorial

import android.content.res.Resources
import android.graphics.Color
import android.os.Build
import android.os.Bundle
import android.support.v17.leanback.app.BrowseFragment
import android.support.v17.leanback.widget.*
import android.util.Log
import android.view.Gravity
import android.view.ViewGroup
import android.widget.TextView
import android.support.v17.leanback.widget.ListRowPresenter
import android.support.v17.leanback.widget.ArrayObjectAdapter
import android.support.v17.leanback.widget.ListRow







class MainFragment : BrowseFragment() {
    private val TAG = MainFragment::class.java.simpleName

    private lateinit var mRowsAdapter: ArrayObjectAdapter
    private val GRID_ITEM_WIDTH = 300
    private val GRID_ITEM_HEIGHT = 200

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        Log.i(TAG, "onActivityCreated")
        super.onActivityCreated(savedInstanceState)

        setupElements()

        loadRows()
    }

    private fun setupElements(){
        setTitle("Hello Android TV!")
        */
/*
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            setBadgeDrawable(resources.getDrawable(R.mipmap.ic_launcher,context.theme))
        }
        *//*

        setHeadersState(HEADERS_ENABLED);
        setHeadersTransitionOnBackEnabled(true);
        setBrandColor(getResources().getColor(R.color.fastlane_background));
        setSearchAffordanceColor(getResources().getColor(R.color.search_opaque));
    }

    private fun loadRows() {
        mRowsAdapter = ArrayObjectAdapter(ListRowPresenter())

        val gridItemPresenterHeader : HeaderItem = HeaderItem(0,"GridItemPresenter")
        val mGridItemPresenter : GridItemPresenter = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            GridItemPresenter(GRID_ITEM_WIDTH,GRID_ITEM_HEIGHT,getResources().getColor(R.color.default_background,context.getTheme()))
        } else {
            GridItemPresenter(GRID_ITEM_WIDTH,GRID_ITEM_HEIGHT,getResources().getColor(R.color.default_background))
        }
        val gridRowAdapter : ArrayObjectAdapter = ArrayObjectAdapter(mGridItemPresenter)
        gridRowAdapter.add("Item 1")
        gridRowAdapter.add("Item 2")
        gridRowAdapter.add("Item 3")
        mRowsAdapter.add(ListRow(gridItemPresenterHeader, gridRowAdapter))

        // set
        setAdapter(mRowsAdapter)
    }
}*/
