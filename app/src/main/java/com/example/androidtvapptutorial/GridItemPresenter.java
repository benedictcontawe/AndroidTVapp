package com.example.androidtvapptutorial;

import android.graphics.Color;
import androidx.leanback.widget.Presenter;
import android.view.Gravity;
import android.view.ViewGroup;
import android.widget.TextView;

public class GridItemPresenter extends Presenter {

    private int GRID_ITEM_WIDTH;
    private int GRID_ITEM_HEIGHT;
    private int BACKGROUND_COLOR;

    /**
     *
     * @author {Benedict Contawe}
     * @param GRID_ITEM_WIDTH Specifies the lenght of the Width of an item
     * @param GRID_ITEM_HEIGHT Specifies the lenght of the Height of an item
     * @param BACKGROUND_COLOR Specifies the Color of the background of an item
     *
     */
    public GridItemPresenter(int GRID_ITEM_WIDTH,int GRID_ITEM_HEIGHT, int BACKGROUND_COLOR){
        this.GRID_ITEM_WIDTH = GRID_ITEM_WIDTH;
        this.GRID_ITEM_HEIGHT = GRID_ITEM_HEIGHT;
        this.BACKGROUND_COLOR = BACKGROUND_COLOR;
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent) {
        TextView view = new TextView(parent.getContext());
        view.setLayoutParams(new ViewGroup.LayoutParams(GRID_ITEM_WIDTH,GRID_ITEM_HEIGHT));
        view.setFocusable(true);
        view.setFocusableInTouchMode(true);
        view.setBackgroundColor(BACKGROUND_COLOR);
        view.setTextColor(Color.WHITE);
        view.setGravity(Gravity.CENTER);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, Object item) {
        ((TextView) viewHolder.view).setText((String) item);
    }

    @Override
    public void onUnbindViewHolder(ViewHolder viewHolder) {

    }
}
