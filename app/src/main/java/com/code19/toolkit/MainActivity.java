package com.code19.toolkit;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.code19.toolkit.base.BaseRecyclerViewAdapter;
import com.code19.toolkit.base.BaseRecyclerViewHolder;
import com.code19.toolkit.model.Toolkit;

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
        recylist.setLayoutManager(new GridLayoutManager(this, 4));
        recylist.setAdapter(new BaseRecyclerViewAdapter<Toolkit>(this, mToolkitList, R.layout.item_recy_toolkit) {

            @Override
            public void onBindItem(RecyclerView.ViewHolder holder, int postion, Toolkit item) {
                super.onBindItem(holder, postion, item);
                ToolkitViewHolder viewHolder = (ToolkitViewHolder) holder;
                viewHolder.tvName.setText(item.name);
            }

            @Override
            protected BaseRecyclerViewHolder setViewHolder(View view, int viewType) {
                return new ToolkitViewHolder(view);
            }
        });
    }
}
