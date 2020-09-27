package com.example.crechesystem;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class DimitriAdapter extends ArrayAdapter<String> {

    private String [] childName;
    private Integer [] childImage;
    private Activity context;

    public DimitriAdapter(Activity context, Integer [] childImage, String [] childName) {
        super(context, R.layout.activity_main,childName);

        this.context = context;
        this.childName = childName;
        this.childImage = childImage;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();
        View rowView = inflater.inflate(R.layout.layout,null,true);
        TextView text = (TextView) rowView.findViewById(R.id.textView);
        ImageView pics = (ImageView) rowView.findViewById(R.id.imageView);
        text.setText(childName[position]);
        pics.setImageResource(childImage[position]);
        return rowView;

    }
}
