package com.example.androidtvapptutorial

import android.graphics.Color
import android.support.v17.leanback.widget.Presenter
import android.view.Gravity
import android.view.ViewGroup
import android.widget.TextView

class GridItemPresenter : Presenter {
    var GRID_ITEM_WIDTH : Int? = null
    var GRID_ITEM_HEIGHT : Int? = null
    var BACKGROUND_COLOR : Int? = null
    /**
     *
     * @author {Benedict Contawe}
     * @param GRID_ITEM_WIDTH Specifies the lenght of the Width of an item
     * @param GRID_ITEM_HEIGHT Specifies the lenght of the Height of an item
     * @param BACKGROUND_COLOR Specifies the Color of the background of an item
     *
     */
    constructor(GRID_ITEM_WIDTH : Int, GRID_ITEM_HEIGHT : Int, BACKGROUND_COLOR : Int){
        this.GRID_ITEM_WIDTH = GRID_ITEM_WIDTH
        this.GRID_ITEM_HEIGHT = GRID_ITEM_HEIGHT
        this.BACKGROUND_COLOR = BACKGROUND_COLOR
    }

    override fun onCreateViewHolder(parent: ViewGroup): ViewHolder {
        val view : TextView = TextView(parent.getContext())
        view.setLayoutParams(ViewGroup.LayoutParams(GRID_ITEM_WIDTH?:0,GRID_ITEM_HEIGHT?:0))
        view.setFocusable(true)
        view.setFocusableInTouchMode(true)
        //view.setBackgroundColor(getResources().getColor(R.color.default_background));
        view.setBackgroundColor(BACKGROUND_COLOR?:0)
        view.setTextColor(Color.WHITE)
        view.setGravity(Gravity.CENTER)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, item: Any) {
        (viewHolder.view as TextView).text = item as String
    }

    override fun onUnbindViewHolder(viewHolder: ViewHolder) {

    }

}