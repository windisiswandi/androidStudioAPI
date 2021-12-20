package com.example.androidapi;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class CustomAdapter extends ArrayAdapter {
    ArrayList<DataFramework> dataFrameworks= new ArrayList();
    LayoutInflater layoutInflater;
    Context context;

    public CustomAdapter(Context context, ArrayList<DataFramework> dataFrameworks) {
        super(context, R.layout.row_custome_list, dataFrameworks);
        this.dataFrameworks = dataFrameworks;
        layoutInflater = LayoutInflater.from(context);
        this.context = context;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        convertView = layoutInflater.inflate(R.layout.row_custome_list, parent, false);
        DataFramework dataFramework = this.dataFrameworks.get(position);

        TextView titleListview = convertView.findViewById(R.id.titleListview);
        TextView authoListview = convertView.findViewById(R.id.authorListview);
        ImageView imageView = convertView.findViewById(R.id.imgListview);

        Glide
            .with(context)
            .load(dataFramework.getImage())
            .placeholder(R.drawable.ic__refresh)
            .into(imageView);

        titleListview.setText(dataFramework.getNameFramework());
        authoListview.setText("Author "+dataFramework.getOriginal_author());

        return convertView;
    }
}
