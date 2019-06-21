package com.example.androidtvapptutorial.Custom.Header;

import androidx.leanback.widget.HeaderItem;

/**
 *  @author benedict.b.contawe
 *  Used with {@link IconHeaderItemPresenter}, it can display the header item with an icon on it.
 *  @see {https://github.com/benedictcontawe/AndroidTVappTutorial} for more information.
 */
public class IconHeaderItem extends HeaderItem {

    public static final int ICON_NONE = -1;

    /** Hold an icon resource id */
    private int mIconResId = ICON_NONE;

    public IconHeaderItem(long id, String name, int iconResId) {
        super(id, name);
        mIconResId = iconResId;
    }

    public IconHeaderItem(long id, String name) {
        this(id, name, ICON_NONE);
    }

    public IconHeaderItem(String name) {
        super(name);
    }

    public int getIconResId() {
        return mIconResId;
    }

    public void setIconResId(int iconResId) {
        this.mIconResId = iconResId;
    }
}
