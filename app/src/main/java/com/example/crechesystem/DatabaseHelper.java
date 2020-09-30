package com.example.crechesystem;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.example.crechesystem.model.Student;

import java.util.ArrayList;
import java.util.List;

public class DatabaseHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "Creche.db";
    public static final String TABLE_NAME = "Creche_Table";
    public static final String COL_1 = "ID";
    public static final String COL_2 = "NAME";
    public static final String COL_3 = "SURNAME";
    public static final String COL_4 = "GENDER";
    public static final String COL_5 = "ADDRESS";
    public static final String COL_6 = "ALLERGIES";
    public static final String COL_7 = "CLASS_GROUP";


    public DatabaseHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table " + TABLE_NAME + "(ID INTEGER PRIMARY KEY AUTOINCREMENT,NAME TEXT,SURNAME TEXT,GENDER TEXT,ADDRESS TEXT,ALLERGIES TEXT,CLASS_GROUP TEXT)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+ TABLE_NAME);
        onCreate(db);

    }

    public boolean insertData(String name, String surname, String gender, String address, String allergies, String classGroup){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_2, name);
        contentValues.put(COL_3, surname);
        contentValues.put(COL_4, gender);
        contentValues.put(COL_5, address);
        contentValues.put(COL_6, allergies);
        contentValues.put(COL_7, classGroup);
        long result = db.insert(TABLE_NAME,null, contentValues);

        if (result == -1){
            return false;
        }
            else{
                return true;
            }
    }

    public Cursor getAllData(){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res = db.rawQuery("select * from "+TABLE_NAME+" order by CLASS_GROUP",null);
        return res;
    }

    public boolean updateData(String id, String name, String surname, String gender, String address, String allergies, String classGroup){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_1, id);
        contentValues.put(COL_2, name);
        contentValues.put(COL_3, surname);
        contentValues.put(COL_4, gender);
        contentValues.put(COL_5, address);
        contentValues.put(COL_6, allergies);
        contentValues.put(COL_7, classGroup);
        db.update(TABLE_NAME, contentValues, "ID = ?",new String[]{id});
        return true;
    }

    public Integer deleteData(String id){
        SQLiteDatabase db = this.getWritableDatabase();
        return db.delete(TABLE_NAME,"ID = ?", new String[]{id});
    }
    public List<Student> getListData(){
        ArrayList<Student> arrayList = new ArrayList<>();
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res = db.rawQuery("select * from "+TABLE_NAME+" order by CLASS_GROUP",null);
        while(res.moveToNext()){
            String id = res.getString(0);
            String name = res.getString(1);
            String surname = res.getString(2);
            String gender = res.getString(3);
            String address = res.getString(4);
            String allergies = res.getString(5);
            String classGroup = res.getString(6);
            Student student = new Student(id,name,surname,gender,address,allergies,classGroup);
            arrayList.add(student);
        }
        return arrayList;

    }

    public List<Student> getListDaisyData(){
        ArrayList<Student> arrayList = new ArrayList<>();
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res = db.rawQuery("select * from "+TABLE_NAME+" where CLASS_GROUP = 'Daisy'",null);
        while(res.moveToNext()){
            String id = res.getString(0);
            String name = res.getString(1);
            String surname = res.getString(2);
            String gender = res.getString(3);
            String address = res.getString(4);
            String allergies = res.getString(5);
            String classGroup = res.getString(6);
            Student student = new Student(id,name,surname,gender,address,allergies,classGroup);
            arrayList.add(student);
        }
        return arrayList;

    }

    public List<Student> getListTulipData(){
        ArrayList<Student> arrayList = new ArrayList<>();
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res = db.rawQuery("select * from "+TABLE_NAME+" where CLASS_GROUP = 'Tulip'",null);
        while(res.moveToNext()){
            String id = res.getString(0);
            String name = res.getString(1);
            String surname = res.getString(2);
            String gender = res.getString(3);
            String address = res.getString(4);
            String allergies = res.getString(5);
            String classGroup = res.getString(6);
            Student student = new Student(id,name,surname,gender,address,allergies,classGroup);
            arrayList.add(student);
        }
        return arrayList;

    }
    /*
    public Cursor getAllDaisy(){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res = db.rawQuery("select * from "+TABLE_NAME+" where CLASS_GROUP = 'Daisy'",null);
        return res;
    }

    public Cursor getAllTulip(){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res = db.rawQuery("select * from "+TABLE_NAME+" where CLASS_GROUP = 'Tulip'",null);
        return res;
    }

     */
}
