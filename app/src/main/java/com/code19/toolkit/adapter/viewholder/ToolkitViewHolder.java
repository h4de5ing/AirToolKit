package com.code19.toolkit.adapter.viewholder;

import android.view.View;
import android.widget.TextView;

import com.code19.toolkit.R;
import com.code19.toolkit.base.BaseRecyclerViewHolder;
import com.github.ivbaranov.mli.MaterialLetterIcon;

/**
 * Created by gh0st on 2017/2/20.
 */

public class ToolkitViewHolder extends BaseRecyclerViewHolder {
    public TextView tvName;
    public MaterialLetterIcon mliIcon;

    public ToolkitViewHolder(View itemView) {
        super(itemView);
        tvName = (TextView) itemView.findViewById(R.id.tv_tool);
        mliIcon = (MaterialLetterIcon) itemView.findViewById(R.id.mli_icon);
    }
}
