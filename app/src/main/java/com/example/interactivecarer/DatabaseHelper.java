package com.example.interactivecarer;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {
    public static final String CLIENT_DATABASE = "register.db";
    public static final String CLIENT_TABLE = "registerclient";
    public static final String CLIENT_ID = "ID";
    public static final String CLIENT_USERNAME = "username";
    public static final String CLIENT_PASSWORD = "password";

    public DatabaseHelper(Context context) {
        super(context, CLIENT_DATABASE, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("CREATE TABLE registerclient (ID INTEGER PRIMARY KEY AUTOINCREMENT, username TEXT, password TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion) {
        sqLiteDatabase.execSQL(" DROP TABLE IF EXISTS " + CLIENT_TABLE);
        onCreate(sqLiteDatabase);
    }

    public long addClient(String client, String password) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("username", client);
        contentValues.put("password", password);
        long res = db.insert("registerclient", null, contentValues);
        db.close();
        return res;
    }

    public boolean checkClient(String username, String password) {
        String[] columns = {CLIENT_ID};
        SQLiteDatabase db = getReadableDatabase();
        String selection = CLIENT_USERNAME + "=?" + " and " + CLIENT_PASSWORD + "=?";
        String[] selectionArgs = {username, password};
        Cursor cursor = db.query(CLIENT_TABLE, columns, selection, selectionArgs, null, null, null);
        int count = cursor.getCount();
        cursor.close();
        db.close();

        if (count > 0)
            return true;
        else
            return false;

    }
}
