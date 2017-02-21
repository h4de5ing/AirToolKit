package com.code19.toolkit.base;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

/**
 * Created by gh0st on 2017/2/20.
 */

public abstract class BaseRecyclerViewAdapter<T> extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    protected LayoutInflater mInflater;
    protected Context mContext;
    protected List<T> datalist;
    protected final int mItemLayoutId;
    private BaseRecyclerViewHolder.OnItemClickListener onItemClickListener;

    public BaseRecyclerViewAdapter(Context context, List<T> datalist, int layoutid) {
        this.mContext = context;
        this.datalist = datalist;
        this.mItemLayoutId = layoutid;
        this.mInflater = LayoutInflater.from(context);
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = mInflater.inflate(mItemLayoutId, parent, false);
        BaseRecyclerViewHolder viewHolder = setViewHolder(view, viewType);
        viewHolder.onItemClickListener(onItemClickListener);
        return viewHolder;
    }

    protected abstract BaseRecyclerViewHolder setViewHolder(View view, int viewType);

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        onBindItem(holder, position, datalist.get(position));
    }

    public void onBindItem(RecyclerView.ViewHolder holder, int position, T item) {
    }

    @Override
    public int getItemCount() {
        return datalist.size();
    }
}
