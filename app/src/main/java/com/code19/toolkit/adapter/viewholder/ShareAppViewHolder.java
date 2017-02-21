package com.code19.toolkit.adapter.viewholder;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.code19.toolkit.R;
import com.code19.toolkit.base.BaseRecyclerViewHolder;

/**
 * Created by gh0st on 2017/2/21.
 */

public class ShareAppViewHolder extends BaseRecyclerViewHolder {
    public ImageView icon;
    public TextView name;
    public TextView size;

    public ShareAppViewHolder(View itemView) {
        super(itemView);
        icon= (ImageView) itemView.findViewById(R.id.recy_app_icon);
        name= (TextView) itemView.findViewById(R.id.recy_app_name);
        size= (TextView) itemView.findViewById(R.id.recy_app_size);
    }
}
