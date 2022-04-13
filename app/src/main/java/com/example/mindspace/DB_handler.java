package com.example.mindspace;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.mindspace.Contacts.Registration;

import java.util.ArrayList;

public class DB_handler extends SQLiteOpenHelper {

    // code for connection
    public DB_handler(Context context) {
        super(context, "userdata.db", null, 1);
    }
    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String createTable = "CREATE TABLE registration_table(regId INTEGER PRIMARY KEY, name TEXT, mob TEXT)";
        sqLiteDatabase.execSQL(createTable);
    }
    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        String dropTable = "DROP TABLE if EXISTS " + "registration_table";
        sqLiteDatabase.execSQL(dropTable);
    }
    //end

    // function to use to insert data in database
    public Boolean insertData(String name, String mob) {
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("name", name);
        contentValues.put("mob", mob);
        long result = sqLiteDatabase.insert("registration_table", null, contentValues);

        if (result==-1)
            return false;
        else
            return true;
    }

    public ArrayList<Registration> getAllRegistrations() {
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        ArrayList<Registration> regList = new ArrayList<>();
        String select = "SELECT * FROM registration_table";
        Cursor cursor = sqLiteDatabase.rawQuery(select, null);

        if(cursor.moveToFirst()) {
            do {
                Registration newReg = new Registration();
                newReg.setId(Integer.parseInt(cursor.getString(0)));
                newReg.setName(cursor.getString(1));
                newReg.setMob(cursor.getString(2));
                regList.add(newReg);
            }while(cursor.moveToNext());
        }
        return regList;
    }

    public  Boolean deleteRecord(int id) {
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery("Select * from registration_table where regId = ?", new String[]{String.valueOf(id)});
        if (cursor.getCount() > 0) {
            long result = sqLiteDatabase.delete("registration_table", "regId = ?", new String[]{String.valueOf(id)});
            cursor.close();
            if (result == -1) {
                return false;
            } else {
                return true;
            }
        } else {
            return false;
        }
    }

}