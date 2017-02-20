package com.code19.toolkit.base;

import android.support.v7.widget.RecyclerView;
import android.view.View;

/**
 * Created by gh0st on 2017/2/20.
 */

public class BaseRecyclerViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener, View.OnLongClickListener {
    public BaseRecyclerViewHolder(View itemView) {
        super(itemView);
        itemView.setOnClickListener(this);
        itemView.setOnLongClickListener(this);
    }

    OnItemClickListener onItemClickListener;

    @Override
    public void onClick(View v) {
        if (onItemClickListener != null) {
            onItemClickListener.onItemClick(getLayoutPosition(), v);
        }
    }

    public void onItemClickListener(OnItemClickListener listener) {
        this.onItemClickListener = listener;
    }

    @Override
    public boolean onLongClick(View v) {
        return false;
    }

    public interface OnItemClickListener {
        void onItemClick(int position, View view);
    }
}
