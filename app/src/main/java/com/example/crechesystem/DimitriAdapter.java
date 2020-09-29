package com.example.crechesystem;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.crechesystem.model.Student;

import java.util.ArrayList;
import java.util.List;

public class DimitriAdapter extends ArrayAdapter<Student> {

    private List<Student> childList;
    private Activity context;
    int resource;

    public DimitriAdapter(Activity context, Integer resource, List<Student> childList) {
        super(context,resource,childList);

        this.context = context;
        this.resource = resource;
        this.childList = childList;
    }


    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();
        View rowView = inflater.inflate(resource,null,false);
        ImageView imageView = rowView.findViewById(R.id.imageView);
        TextView t1 = (TextView) rowView.findViewById(R.id.idView);
        TextView t2 = (TextView) rowView.findViewById(R.id.nameView);
        TextView t3 = (TextView) rowView.findViewById(R.id.surnameView);
        TextView t4 = (TextView) rowView.findViewById(R.id.genderView);
        TextView t5 = (TextView) rowView.findViewById(R.id.addressView);
        TextView t6 = (TextView) rowView.findViewById(R.id.allergiesView);
        TextView t7 = (TextView) rowView.findViewById(R.id.classView);


        Student student = childList.get(position);


        t1.setText(student.getId());
        t2.setText(student.getName());
        t3.setText(student.getSurname());
        t4.setText(student.getGender());
        t5.setText(student.getAddress());
        t6.setText(student.getAllergies());
        t7.setText(student.getClassGroup());
        if(childList.get(position).getGender().equalsIgnoreCase("male")){
            imageView.setImageResource(R.drawable.boy);
        }
        else{
            imageView.setImageResource(R.drawable.girl);
        }

        return rowView;

    }
}
