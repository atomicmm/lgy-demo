package com.example.lgy;

import android.app.ListActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;

public class Fs_indexActivity extends ListActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		

		//1 定义数据源
		String[] values = new String[] { "上装", "下装", "连衣裙/裤", "春", "夏","秋", "冬", "休闲出行","工作正式","艺术文艺" };



		//3 组装适配器
		ListAdapter adapter = new ArrayAdapter<String>(
				this,
				android.R.layout.simple_list_item_1, android.R.id.text1,
				values
				);

		//4 赋值ListView 
		setListAdapter(adapter);	
		
		
	}
}
