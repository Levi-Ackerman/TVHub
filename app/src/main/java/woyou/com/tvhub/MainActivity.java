package woyou.com.tvhub;

import android.app.Activity;
import android.app.FragmentManager;
import android.os.Bundle;
import android.support.v17.leanback.app.BrowseFragment;
import android.support.v17.leanback.widget.ArrayObjectAdapter;
import android.support.v17.leanback.widget.HeaderItem;
import android.support.v17.leanback.widget.ListRow;
import android.support.v17.leanback.widget.ListRowPresenter;

/**
 * ************************************************************
 * Copyright (C) 2005 - 2017 UCWeb Inc. All Rights Reserved
 * Description  :  woyou.com.tvhub.MainActivity.java
 * <p>
 * Creation     : 2017/3/28
 * Author       : zhengxian.lzx@alibaba-inc.com
 * History      : Creation, 2017 lizx, Create the file
 * *************************************************************
 *
 * @author Administrator
 * @date 2017/03/28
 */
public class MainActivity extends Activity {
    public static final String TAG ="BrowseActivity";

    protected BrowseFragment mBrowseFragment;
    private ArrayObjectAdapter mRowsAdapter;
    private static final int NUM_ROWS = 4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final FragmentManager fragmentManager = getFragmentManager();
        mBrowseFragment = (BrowseFragment) fragmentManager.findFragmentById(
                R.id.browse_fragment);

        // Set display parameters for the BrowseFragment
        mBrowseFragment.setHeadersState(BrowseFragment.HEADERS_ENABLED);
        mBrowseFragment.setTitle(getString(R.string.app_name));
        mBrowseFragment.setBadgeDrawable(getResources().getDrawable(
                R.drawable.ic_launcher));
        buildRowsAdapter();
    }
    private void buildRowsAdapter() {
        mRowsAdapter = new ArrayObjectAdapter(new ListRowPresenter());

        for (int i = 0; i < NUM_ROWS; ++i) {
            ArrayObjectAdapter listRowAdapter = new ArrayObjectAdapter(
                    new StringPresenter());
            listRowAdapter.add("Media Item 1");
            listRowAdapter.add("Media Item 2");
            listRowAdapter.add("Media Item 3");
            HeaderItem header = new HeaderItem(i, "Category " + i);
            mRowsAdapter.add(new ListRow(header, listRowAdapter));
        }

        mBrowseFragment.setAdapter(mRowsAdapter);
    }
}
