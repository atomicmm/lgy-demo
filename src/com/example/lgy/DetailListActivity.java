package com.example.lgy;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;

import java.util.List;

/**
 * 详细列表
 */
public class DetailListActivity extends ListActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //pre 从上一步界面中拿到跳转过来的标签
        String tag = getIntent().getStringExtra("tag");

        //1 定义数据源
        //pre2 根据标签找到对应的Item
        List<Item> dataSource = JsonRepository.getInstance(this).findByTags(tag);

        //3 组装适配器
        ItemAdapter adapter = new ItemAdapter(this, dataSource);

        //4 赋值ListView
        setListAdapter(adapter);
    }
    protected void onListItemClick(ListView l, View v, int position, long id) {

            startActivity(
                    new Intent()
                            .setClass(this, DetailActivity.class)
                            .putExtra("id", ((Item)getListAdapter().getItem(position)).getId())
            );



    }
}
