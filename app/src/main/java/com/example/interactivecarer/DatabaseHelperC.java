package com.example.interactivecarer;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelperC extends SQLiteOpenHelper {
    public static final String CARER_DATABASE = "registerc.db";
    public static final String CARER_TABLE = "registercarer";
    public static final String CARER_ID = "ID";
    public static final String CARER_USERNAME = "cusername";
    public static final String CARER_PASSWORD = "cpassword";

    public DatabaseHelperC(Context context) {
        super(context, CARER_DATABASE, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("CREATE TABLE registercarer (ID INTEGER PRIMARY KEY AUTOINCREMENT, cusername TEXT, cpassword TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion) {
        sqLiteDatabase.execSQL(" DROP TABLE IF EXISTS " + CARER_TABLE);
        onCreate(sqLiteDatabase);
    }

    public long addCarer(String carer, String cpassword) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("cusername", carer);
        contentValues.put("cpassword", cpassword);
        long res = db.insert("registercarer", null, contentValues);
        db.close();
        return res;

    }

    public boolean checkCarer(String cusername, String cpassword) {
        String[] columns = {CARER_ID};
        SQLiteDatabase db = getReadableDatabase();
        String selection = CARER_USERNAME + "=?" + " and " + CARER_PASSWORD + "=?";
        String[] selectionArgs = {cusername, cpassword};
        Cursor cursor = db.query(CARER_TABLE, columns, selection, selectionArgs, null, null, null);
        int count = cursor.getCount();
        cursor.close();
        db.close();

        if (count > 0)
            return true;
        else
            return false;

    }
}
