package com.example.androidtvapptutorial.Custom.Row;

import androidx.leanback.widget.HeaderItem;
import androidx.leanback.widget.ListRow;
import androidx.leanback.widget.ObjectAdapter;

/**
 *  Used with {@link CustomListRowPresenter}, it can display multiple rows.
 *  Use {@link #setNumRows(int)} method to specify the number of rows, default 1.
 */
public class CustomListRow extends ListRow {

    private int mNumRows;

    public CustomListRow(HeaderItem header, ObjectAdapter adapter) {
        super(header, adapter);
        mNumRows = 1;
    }

    public CustomListRow(HeaderItem header, ObjectAdapter adapter, int mNumRows) {
        super(header, adapter);
        this.mNumRows = mNumRows;
    }

    public CustomListRow(long id, HeaderItem header, ObjectAdapter adapter) {
        super(id, header, adapter);
    }

    public CustomListRow(ObjectAdapter adapter) {
        super(adapter);
    }
    /**
     * @Deprecated
     * Use the constructor with three parameters
     * */
    public void setNumRows(int numRows) {
        mNumRows = numRows;
    }

    public int getNumRows() {
        return mNumRows;
    }
}
