package com.example.paulomag.myapplication.Database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.paulomag.myapplication.Classes.User;

/**
 * Created by paulomag on 9/5/17.
 */

public class DatabaseHelper extends SQLiteOpenHelper{
    public DatabaseHelper(Context context) {
        super(context,"banco", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("CREATE TABLE login(" +
                                "id integer primary key autoincrement," +
                                "username text not null," +
                                "password text not null)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    public void newUser(User user){
        SQLiteDatabase db = this.getReadableDatabase();
        ContentValues values = new ContentValues();
        values.put("username",user.getUsername());
        values.put("password",user.getPassword());

        db.insert("login", null, values);
        db.close();
    }

    public boolean userExists(User usr){
        SQLiteDatabase db = this.getReadableDatabase();
        String user = usr.getUsername();
        String password = usr.getPassword();

        Cursor cursor = db.query("login", new String[]{"username","password"}, "username=? AND password=?",
                new String[]{user,password},null,null,null);
        if(cursor.getCount() > 0){
            return true;
        }
        return false;
    }
}
