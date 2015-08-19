package com.example.lgy;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;

public class Hzp_indexActivity extends ListActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        //1 定义数据源
        String[] values = new String[]{"眉笔", "CC霜", "口红", "腮红", "眼线笔",};


        //3 组装适配器
        ListAdapter adapter = new ArrayAdapter<String>(
                this,
                android.R.layout.simple_list_item_1, android.R.id.text1,
                values
        );

        //4 赋值ListView
        setListAdapter(adapter);


    }

    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        if (!getListAdapter().getItem(position).toString().startsWith("---")) {
            startActivity(
                    new Intent()
                            .setClass(this, DetailListActivity.class)
                            .putExtra("tag", getListAdapter().getItem(position).toString())
            );

        }

    }
}
