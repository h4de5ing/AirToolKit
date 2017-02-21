package com.code19.toolkit;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.code19.toolkit.adapter.viewholder.ToolkitViewHolder;
import com.code19.toolkit.base.BaseRecyclerViewAdapter;
import com.code19.toolkit.base.BaseRecyclerViewHolder;
import com.code19.toolkit.model.Toolkit;
import com.code19.toolkit.ui.activity.ShareAppActivity;
import com.github.lzyzsd.randomcolor.RandomColor;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private List<Toolkit> mToolkitList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mToolkitList = new ArrayList<>();
        String[] stringArray = getResources().getStringArray(R.array.tab_nav);
        for (String s : stringArray) {
            Toolkit toolkit = new Toolkit();
            toolkit.icon = R.mipmap.ic_launcher;
            toolkit.name = s;
            mToolkitList.add(toolkit);
        }
        RecyclerView recylist = (RecyclerView) findViewById(R.id.recy_list);
        recylist.setLayoutManager(new GridLayoutManager(this, 4, GridLayoutManager.VERTICAL, false));
        BaseRecyclerViewAdapter<Toolkit> adapter = new BaseRecyclerViewAdapter<Toolkit>(this, mToolkitList, R.layout.item_recy_toolkit) {

            @Override
            public void onBindItem(RecyclerView.ViewHolder holder, int postion, Toolkit item) {
                super.onBindItem(holder, postion, item);
                ToolkitViewHolder viewHolder = (ToolkitViewHolder) holder;
                viewHolder.tvName.setText(item.name);
                viewHolder.mliIcon.setLetter(String.valueOf(mToolkitList.get(postion).name.charAt(0)));
                viewHolder.mliIcon.setShapeColor(new RandomColor().randomColor());
                viewHolder.onItemClickListener(new BaseRecyclerViewHolder.OnItemClickListener() {
                    @Override
                    public void onItemClick(int position, View view) {
                        switch (position) {
                            case 0://分享APK
                                startActivity(new Intent(MainActivity.this, ShareAppActivity.class));
                                break;
                            case 1:
                                break;
                        }
                    }
                });
            }

            @Override
            protected BaseRecyclerViewHolder setViewHolder(View view, int viewType) {
                return new ToolkitViewHolder(view);
            }
        };
        recylist.setAdapter(adapter);
        adapter.notifyDataSetChanged();
    }
}
