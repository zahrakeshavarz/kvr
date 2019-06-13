package com.example.myapplication;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class dataAdapter extends ArrayAdapter<NewsModel> {
    private Context context;

    public dataAdapter(@NotNull Context context, int resource, @NotNull List<NewsModel> news) {
        super(context, resource, news);
        this.context = context;
    }

    @NotNull
    @Override
    public View getView(int position, @Nullable View convertView, @NotNull ViewGroup parent) {
        final NewsModel news = getItem(position);
        if (convertView == null)
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.adapter_item, parent, false);
        TextView title = convertView.findViewById(R.id.titleTxt);
        TextView text = convertView.findViewById(R.id.desTxt);
        title.setText(news.title);
        text.setText(news.text);
        return convertView;
    }
}