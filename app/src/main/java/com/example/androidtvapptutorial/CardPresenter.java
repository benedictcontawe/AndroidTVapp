package com.example.androidtvapptutorial;

import android.content.Context;
//import android.graphics.Bitmap;
//import android.graphics.drawable.BitmapDrawable;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.view.Gravity;
import android.widget.TextView;
import androidx.leanback.widget.ImageCardView;
import androidx.leanback.widget.Presenter;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
//import com.bumptech.glide.Glide;
//import com.squareup.picasso.Picasso;
//import com.squareup.picasso.Target;

//import java.net.URI;

public class CardPresenter extends Presenter {

    private static final int CARD_ITEM_WIDTH = 300;
    private static final int CARD_ITEM_HEIGHT = 200;
    private int backgroundColor;

    public CardPresenter(int backgroundColor) {
        this.backgroundColor = backgroundColor;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent) {
        TextView view = new TextView(parent.getContext());
        view.setLayoutParams(new ViewGroup.LayoutParams(CARD_ITEM_WIDTH, CARD_ITEM_HEIGHT));
        view.setFocusable(true);
        view.setFocusableInTouchMode(true);
        view.setBackgroundColor(backgroundColor);
        view.setTextColor(Color.WHITE);
        view.setGravity(Gravity.CENTER);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, Object item) {
        UsbFileCard usbFileCard = (UsbFileCard) item;
        ((TextView) viewHolder.view).setText(usbFileCard.getFileName());
    }

    @Override
    public void onUnbindViewHolder(ViewHolder viewHolder) {

    }

}
