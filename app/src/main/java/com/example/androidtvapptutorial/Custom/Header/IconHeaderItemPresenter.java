package com.example.androidtvapptutorial.Custom.Header;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.leanback.widget.*;
import com.example.androidtvapptutorial.R;

public class IconHeaderItemPresenter extends RowHeaderPresenter {

    private float mUnselectedAlpha;

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup) {
        mUnselectedAlpha = viewGroup.getResources()
                .getFraction(R.fraction.lb_browse_header_unselect_alpha, 1, 1);
        LayoutInflater inflater = (LayoutInflater) viewGroup.getContext()
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View view = inflater.inflate(R.layout.icon_header_item, null);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(Presenter.ViewHolder viewHolder, Object o) {
        IconHeaderItem iconHeaderItem = (IconHeaderItem) ((ListRow) o).getHeaderItem();
        View rootView = viewHolder.view;

        ImageView iconView = (ImageView) rootView.findViewById(R.id.header_icon);
        int iconResId = iconHeaderItem.getIconResId();
        if (iconResId != IconHeaderItem.ICON_NONE) { // Show icon only when it is set.
            Drawable icon = rootView.getResources().getDrawable(iconResId, null);
            iconView.setImageDrawable(icon);
        }

        TextView label = (TextView) rootView.findViewById(R.id.header_label);
        label.setText(iconHeaderItem.getName());
        Log.e(IconHeaderItemPresenter.class.getSimpleName(), label.getText().toString());
    }

    @Override
    public void onUnbindViewHolder(Presenter.ViewHolder viewHolder) {
        // no op
    }

    // TODO: TEMP - remove me when leanback onCreateViewHolder no longer sets the mUnselectAlpha,AND
    // also assumes the xml inflation will return a RowHeaderView
    @Override
    protected void onSelectLevelChanged(RowHeaderPresenter.ViewHolder holder) {
        // this is a temporary fix
        holder.view.setAlpha(mUnselectedAlpha + holder.getSelectLevel() *
                (1.0f - mUnselectedAlpha));
    }
}
