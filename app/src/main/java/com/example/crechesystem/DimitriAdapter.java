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

    private ArrayList<Student>kids;
    private Student student;
    private Activity context;

    public DimitriAdapter(Activity context,ArrayList <Student> kids) {
        super(context, R.layout.activity_main,kids);

        this.context = context;
        this.kids = kids;
    }


    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();
        View rowView = inflater.inflate(R.layout.layout,null,true);
        ImageView imageView = rowView.findViewById(R.id.imageView);
        TextView t1 = (TextView) rowView.findViewById(R.id.idView);
        TextView t2 = (TextView) rowView.findViewById(R.id.nameView);
        TextView t3 = (TextView) rowView.findViewById(R.id.surnameView);
        TextView t4 = (TextView) rowView.findViewById(R.id.genderView);
        TextView t5 = (TextView) rowView.findViewById(R.id.addressView);
        TextView t6 = (TextView) rowView.findViewById(R.id.allergiesView);
        TextView t7 = (TextView) rowView.findViewById(R.id.classView);
 /*
        Student student = new Student(kids[position].getId(),kids[position].getName(),kids[position].getSurname(),kids[position].getGender(),
                kids[position].getAddress(),kids[position].getAllergies(),kids[position].getClassGroup());
       for(Student st:kids){
            student = new Student(st.getId(),st.getName(),st.getSurname(),st.getGender(),st.getAddress(),st.getAllergies(),st.getClassGroup());

         */
       /*student = new Student(kids.get(0).getId(),kids.get(0).getName(),kids.get(0).getId(),kids.get(0).getId(),kids.get(0).getId(),
                kids.get(0).getId(),kids.get(0).getId());*/
            t1.setText(kids.get(position).getId());
            t2.setText(kids.get(position).getName());
            t3.setText(kids.get(position).getSurname());
            t4.setText(kids.get(position).getGender());
            t5.setText(kids.get(position).getAddress());
            t6.setText(kids.get(position).getAllergies());
            t7.setText(kids.get(position).getClassGroup());


        if(kids.get(position).getGender().equalsIgnoreCase("male")) {
            imageView.setImageResource(R.drawable.boy);
        }
        else{
            imageView.setImageResource(R.drawable.girl);
        }


        return rowView;

    }
}
