package com.example.lgy;

import android.app.ListActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;

import java.util.List;

/**
 * 详细列表
 */
public class DetailListActivity extends ListActivity {

    private JsonRepository mRepository;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mRepository = JsonRepository.getInstance(this);

        //pre 从上一步界面中拿到跳转过来的标签
        String tag = getIntent().getStringExtra("tag");

        //1 定义数据源
        //pre2 根据标签找到对应的Item
        List<Item> dataSource = mRepository.findByTags(tag);

        //3 组装适配器
        ItemAdapter adapter = new ItemAdapter(this, dataSource);

        //4 赋值ListView
        setListAdapter(adapter);
    }
}
