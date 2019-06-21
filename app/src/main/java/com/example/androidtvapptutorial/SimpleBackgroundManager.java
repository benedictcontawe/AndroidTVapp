package com.example.androidtvapptutorial;

import android.app.Activity;
import android.graphics.drawable.Drawable;
import androidx.leanback.app.BackgroundManager;
import android.util.DisplayMetrics;
import com.example.androidtvapptutorial.R;

public class SimpleBackgroundManager {

    private final int DEFAULT_BACKGROUND_RES_ID = R.mipmap.ic_launcher;
    private static Drawable mDefaultBackground;

    private Activity mActivity;
    private BackgroundManager mBackgroundManager;

    public SimpleBackgroundManager(Activity activity) {
        mActivity = activity;
        mDefaultBackground = activity.getDrawable(DEFAULT_BACKGROUND_RES_ID);
        mBackgroundManager = BackgroundManager.getInstance(activity);
        mBackgroundManager.attach(activity.getWindow());
        activity.getWindowManager().getDefaultDisplay().getMetrics(new DisplayMetrics());
    }

    public void updateBackground(Drawable drawable) {
        mBackgroundManager.setDrawable(drawable);
    }

    public void clearBackground() {
        //mBackgroundManager.setDrawable(mDefaultBackground);
        mBackgroundManager.setDrawable(null);
    }

}
