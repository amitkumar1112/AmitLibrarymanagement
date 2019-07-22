package com.example.amitlibrarymanagement;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;

public class Mysignuphelper extends SQLiteOpenHelper {
    String TAG = "WordDataBAse";
    //database info
    public static final String databaseName = "signup_db";
    public static final int databaseVersion = 1;
    public static final String tableName = "info_table";
    //column info
    public static final String KEY_ID = "Id";
    public static final String KEY_Name = "Name";
    public static final String KEY_email = "email";
    public static final String KEY_phone = "phone";
    public static final String KEY_password = "password";
    public static final String KEY_confirmpass = "confirmpass";

    //columns
    private String COL_HACK[] = new String[]{KEY_ID,KEY_Name,KEY_email,KEY_phone,KEY_password,KEY_confirmpass};

    Mysignuphelper(Context context, SQLiteDatabase.CursorFactory factory){
        super(context,databaseName,factory,databaseVersion);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_INFO_TABLE = "CREATE TABLE "+tableName+" ( "+ KEY_ID +" INTEGER PRIMARY KEY AUTOINCREMENT,"+KEY_Name + " TEXT,"+ KEY_email + "TEXT," + KEY_phone + "TEXT," + KEY_password + "TEXT," +KEY_confirmpass + "TEXT"+")";
        Log.i(TAG,CREATE_INFO_TABLE);
        db.execSQL(CREATE_INFO_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
    /**
     * Defining the CRUD operations
     */
    //method to add a new word in the table
    public void addinfo(infosignup info){
        SQLiteDatabase db = getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(KEY_ID,info.getId());
        values.put(KEY_Name,info.getName());
        values.put(KEY_email,info.getEmail());
        values.put(KEY_phone,info.getPhone());
        values.put(KEY_password,info.getPassword());
        values.put(KEY_confirmpass,info.getConfirmpass());
        db.insert(tableName,null,values);
        db.close();
    }
    //method to read all the words from the table
    ArrayList<infosignup> loadallinfo(){
        ArrayList<infosignup> infoArrayList = new ArrayList<>();
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.query(tableName,COL_HACK,null,null,null,null,null);
        if(cursor!=null && cursor.moveToFirst()){
            do {
                infosignup info = new infosignup();
                info.setId(Integer.parseInt(cursor.getString(0)));
                info.setName(cursor.getString(1));
                info.setEmail(cursor.getString(2));
                info.setPhone(cursor.getString(3));
                info.setConfirmpass(cursor.getString(4));
                info.setPassword(cursor.getString(5));


                infoArrayList.add(info);
            }while (cursor.moveToNext());
        }

        db.close();
        return infoArrayList;

    }

}


