package com.code19.toolkit.ui.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.View;

import com.code19.library.FileUtils;
import com.code19.toolkit.R;
import com.code19.toolkit.adapter.viewholder.ShareAppViewHolder;
import com.code19.toolkit.base.BaseRecyclerViewAdapter;
import com.code19.toolkit.base.BaseRecyclerViewHolder;
import com.code19.toolkit.model.AppModel;
import com.code19.toolkit.utils.AppUtil2;

import java.util.ArrayList;
import java.util.List;

public class ShareAppActivity extends AppCompatActivity {
    private List<AppModel> mAppModelList;
    private BaseRecyclerViewAdapter<AppModel> mAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_share_app);
        getSupportActionBar().setTitle(R.string.share_apk);
        mAppModelList = AppUtil2.getInstallApp(ShareAppActivity.this);
        RecyclerView recylist = (RecyclerView) findViewById(R.id.recy_list);
        recylist.setLayoutManager(new LinearLayoutManager(this));
        mAdapter = new BaseRecyclerViewAdapter<AppModel>(this, mAppModelList, R.layout.item_recy_share_app) {
            @Override
            public void onBindItem(RecyclerView.ViewHolder holder, int postion, final AppModel item) {
                super.onBindItem(holder, postion, item);
                ShareAppViewHolder viewHolder = (ShareAppViewHolder) holder;
                viewHolder.icon.setImageDrawable(item.getAppIcon());
                viewHolder.name.setText(item.getAppName());
                viewHolder.size.setText(item.getAppSize());
                viewHolder.onItemClickListener(new BaseRecyclerViewHolder.OnItemClickListener() {
                    @Override
                    public void onItemClick(int position, View view) {
                        if (!TextUtils.isEmpty(item.getAppApk())) {
                            FileUtils.shareFile(ShareAppActivity.this, getString(R.string.share_apk), item.getAppApk());
                        }
                    }
                });
            }

            @Override
            protected BaseRecyclerViewHolder setViewHolder(View view, int viewType) {
                return new ShareAppViewHolder(view);
            }
        };
        recylist.setAdapter(mAdapter);
    }
}
