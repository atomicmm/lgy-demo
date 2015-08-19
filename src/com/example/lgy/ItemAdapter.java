package com.example.lgy;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class ItemAdapter extends BaseAdapter {

    private List<Item> mDataSource;
    private Context mContext;

    public ItemAdapter(Context context, List<Item> mDataSource) {
        this.mDataSource = mDataSource;
        this.mContext = context;
    }

    @Override
    public int getCount() {
        return mDataSource.size();
    }

    @Override
    public Object getItem(int position) {
        return mDataSource.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Item item = mDataSource.get(position);

        View view = LayoutInflater.from(mContext).inflate(R.layout.detail_list_item, null);

        ImageView image = (ImageView) view.findViewById(R.id.ivavatar);
        TextView text = (TextView) view.findViewById(R.id.tvname);

        text.setText(item.getName());
        image.setImageResource(R.drawable.ic_launcher);

        return view;
    }

}
