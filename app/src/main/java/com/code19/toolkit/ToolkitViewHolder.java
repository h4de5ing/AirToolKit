package com.code19.toolkit;

import android.view.View;
import android.widget.TextView;

import com.code19.toolkit.base.BaseRecyclerViewHolder;

/**
 * Created by gh0st on 2017/2/20.
 */

public class ToolkitViewHolder extends BaseRecyclerViewHolder {
    public TextView tvName;

    public ToolkitViewHolder(View itemView) {
        super(itemView);
        tvName = (TextView) itemView.findViewById(R.id.tv_tool);
    }
}
