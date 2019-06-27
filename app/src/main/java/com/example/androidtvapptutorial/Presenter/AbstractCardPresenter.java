
package com.example.androidtvapptutorial.Presenter;

import android.content.Context;
import android.view.ViewGroup;
import androidx.leanback.widget.BaseCardView;
import androidx.leanback.widget.Presenter;

/**
 * This abstract, generic class will create and manage the
 * ViewHolder and will provide typed Presenter callbacks such that you do not have to perform casts
 * on your own.as
 *
 * @param <T> View type for the file.
 */
public abstract class AbstractCardPresenter<T extends BaseCardView> extends Presenter {

    private static final String TAG = "AbstractCardPresenter";
    private Context mContext;

    /**
     * @param context The current context.
     */
    AbstractCardPresenter(Context context) {
        mContext = context;
    }

    public Context getContext() {
        return mContext;
    }

    @Override
    public final ViewHolder onCreateViewHolder(ViewGroup parent) {
        T cardView = onCreateView();
        return new ViewHolder(cardView);
    }

    @Override
    public final void onBindViewHolder(ViewHolder viewHolder, Object item) {
        onBindViewHolder(item, (T) viewHolder.view);
    }

    @Override
    public final void onUnbindViewHolder(ViewHolder viewHolder) {
        onUnbindViewHolder((T) viewHolder.view);
    }

    private void onUnbindViewHolder(T cardView) {
        // Nothing to clean up. Override if necessary.
    }

    protected abstract T onCreateView();

    public abstract void onBindViewHolder(Object item, T cardView);

}
