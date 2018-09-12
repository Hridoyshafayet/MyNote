package com.example.hridoy.mynote;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class NoteAdapter extends BaseAdapter {
    Context context;
    ArrayList<String> title;
    ArrayList<String> description;

    public NoteAdapter(Context context, ArrayList<String> title, ArrayList<String> description) {
        this.context = context;
        this.title = title;
        this.description = description;
    }

    @Override
    public int getCount() {
        return title.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        LayoutInflater inflater = LayoutInflater.from(context);

        view = inflater.inflate(R.layout.note_list_item,null,false);

        TextView titleTv = view.findViewById(R.id.title);
        TextView descriptionTv = view.findViewById(R.id.description);

        titleTv.setText(title.get(i));
        descriptionTv.setText(description.get(i));

        return view;
    }
}
