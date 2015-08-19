package com.example.lgy;

import android.app.ListActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;

public class Xmps_indexActivity extends ListActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		//1 定义数据源
		String[] values = new String[] { "高跟", "中跟", "平跟", "春", "夏","秋", "冬", "休闲","正式","华丽" };



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
