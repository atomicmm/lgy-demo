package com.example.lgy;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;

/**
 * 如果页面中只有一个ListView,则可以继承ListActivity
 *
 * @author Atomic
 */
public class Hfp_indexActivity extends ListActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //a 绑定ListView---同绑定button
        //...
        //1 定义数据源
        String[] values = new String[]{"洁面奶", "爽肤水", "精华液", "精华霜", "眼霜", "防晒", "面膜"};

        //2 定义行模板,在layout下block_list_view_item.xml

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
