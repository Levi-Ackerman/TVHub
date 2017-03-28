package woyou.com.tvhub;

import android.support.v17.leanback.widget.Presenter;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * ************************************************************
 * Copyright (C) 2005 - 2017 UCWeb Inc. All Rights Reserved
 * Description  :  woyou.com.tvhub.StringPresenter.java
 * <p>
 * Creation     : 2017/3/28
 * Author       : zhengxian.lzx@alibaba-inc.com
 * History      : Creation, 2017 lizx, Create the file
 * *************************************************************
 *
 * @author Administrator
 * @date 2017/03/28
 */

public class StringPresenter extends Presenter {
    private static final String TAG = "StringPresenter";

    public ViewHolder onCreateViewHolder(ViewGroup parent) {
        TextView textView = new TextView(parent.getContext());
        textView.setFocusable(true);
        textView.setFocusableInTouchMode(true);

        return new ViewHolder(textView);
    }

    public void onBindViewHolder(ViewHolder viewHolder, Object item) {
        ((TextView) viewHolder.view).setText(item.toString());
    }

    public void onUnbindViewHolder(ViewHolder viewHolder) {
        // no op
    }
}
