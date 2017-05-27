package com.example.sanourtomal.api;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Sanour Tomal on 4/7/2017.
 */

public class CustomAdapter extends BaseAdapter {
    Context context;
    ArrayList<Model> models;

    public CustomAdapter(Context context, ArrayList<Model> models) {
        this.context = context;
        this.models = models;
    }

    @Override
    public int getCount() {
        return models.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(convertView==null){
            convertView = LayoutInflater.from(context).inflate(R.layout.row,parent,false);
        }
        TextView title=(TextView)convertView.findViewById(R.id.title);
        TextView sub=(TextView)convertView.findViewById(R.id.subject);
        TextView board=(TextView)convertView.findViewById(R.id.board);
        title.setText(models.get(position).getTitle());
        sub.setText(models.get(position).getSubject());
        board.setText(models.get(position).getBoard());
        return convertView;
    }
}
