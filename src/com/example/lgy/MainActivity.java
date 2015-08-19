package com.example.lgy;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;

public class MainActivity extends ListActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //a 绑定ListView---同绑定button
        //...
        //1 定义数据源
        String[] values = new String[]{"护肤品类", "化妆品类", "服饰类", "鞋帽配饰类"};

        //2 定义行模板,在layout下block_list_view_item.xml

        //3 组装适配器
        ListAdapter adapter = new ArrayAdapter<String>(
                this,
                android.R.layout.simple_list_item_1, android.R.id.text1,
                values
        );

        //4 赋值ListView
        setListAdapter(adapter);

        //给List中的元素添加点击事件

    }

    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        //每次listview被点击时,则会执行此处代码
        switch (position) {
            case 0:
                startActivity(new Intent().setClass(MainActivity.this, Hfp_indexActivity.class));

                break;
            case 1:
                startActivity(new Intent().setClass(MainActivity.this, Hzp_indexActivity.class));

                break;
            case 2:
                startActivity(new Intent().setClass(MainActivity.this, Fs_indexActivity.class));

                break;
            case 3:
                startActivity(new Intent().setClass(MainActivity.this, Xmps_indexActivity.class));

                break;
        }

    }


}
