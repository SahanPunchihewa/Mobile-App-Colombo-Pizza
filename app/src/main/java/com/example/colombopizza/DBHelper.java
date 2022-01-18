package com.example.colombopizza;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelper extends SQLiteOpenHelper { // DB Helper class extend SQLite open Helper

    public DBHelper(Context context) {
        super(context, "ColomboPizza.db", null, 1);  // Database Creation
    }

    @Override
    public void onCreate(SQLiteDatabase myDB) {

            // Database Creation
        myDB.execSQL("create Table users(username TEXT primary key, password TEXT NOT NULL )");
        myDB.execSQL("create Table orders(pName TEXT primary key, pType TEXT, pQuantity TEXT, pPrice TEXT, tPrice TEXT)");
        myDB.execSQL("create Table payments(cardno TEXT primary key, choldername TEXT, cvv TEXT, expiredate TEXT)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase myDB, int i, int i1) {

        myDB.execSQL("drop Table if exists users"); // Drop Table
        myDB.execSQL("drop Table if exists orders");
        myDB.execSQL("drop Table if exists payments");

    }

    public boolean checkusernamePassword(String username, String password) { // Check User name and password from database

        SQLiteDatabase myDB = this.getWritableDatabase(); // Database connection
        Cursor cursor = myDB.rawQuery("select * from users where username = ? and password = ?", new String[]{username, password});

        if (cursor.getCount() > 0) {

            return true;
        } else {

            return false;
        }

    }


    public boolean checkusername(String username) { // Check User Name Function

        SQLiteDatabase myDB = this.getWritableDatabase();
        Cursor cursor = myDB.rawQuery("select * from users where username = ?", new String[]{username}); // Sql Query

        // Cursor -to store a set of values that the content resolver can process

        if (cursor.getCount() > 0) {
            return true;
        } else {

            return false;
        }

    }

    public Boolean insertData(String username, String password) { // Insert Data Function

        SQLiteDatabase myDB = this.getWritableDatabase(); // Database Connection
        ContentValues contentValues = new ContentValues();  // Insert new rows into table
        contentValues.put("username", username);
        contentValues.put("password", password);
        contentValues.put("password", password);
        long result = myDB.insert("users", null, contentValues);
        if (result == -1) {

            return false;
        } else {

            return true;
        }

    }

    public Boolean insertorderdata(String pName, String pType, String pQuantity, String pPrice, String tPrice) {
        // Insert order data function

        SQLiteDatabase myDB = this.getReadableDatabase();
        ContentValues contentValues = new ContentValues();

        contentValues.put("pName", pName);
        contentValues.put("pType", pType);
        contentValues.put("pQuantity", pQuantity);
        contentValues.put("pPrice", pPrice);
        contentValues.put("tPrice", tPrice);
        long result = myDB.insert("orders", null, contentValues);

        if (result == -1) {
            return false;
        } else {

            return true;
        }
    }

    public Boolean updateorderdata(String pName, String pType, String pQuantity, String pPrice, String tPrice) {

        // Update order data function

        SQLiteDatabase myDB = this.getReadableDatabase();
        ContentValues contentValues = new ContentValues();

        contentValues.put("pName", pName);
        contentValues.put("pType", pType);
        contentValues.put("pQuantity", pQuantity);
        contentValues.put("pPrice", pPrice);
        contentValues.put("tPrice", tPrice);
        Cursor cursor = myDB.rawQuery("select * from orders where pName =?", new String[]{pName});
        if (cursor.getCount() > 0) {

            long result = myDB.update("orders", contentValues, "pName=?", new String[]{String.valueOf(pName)});

            if (result == -1) {
                return false;
            } else {

                return true;
            }

        } else {
            return false;
        }

    }


    public Boolean deletedata(String pName) {

        // Delete Order Function

        SQLiteDatabase myDB = this.getReadableDatabase();

        Cursor cursor = myDB.rawQuery("select * from orders where pName =?", new String[]{pName});
        if (cursor.getCount() > 0) {

            long result = myDB.delete("orders", "pName=?", new String[]{String.valueOf(pName)});

            if (result == -1) {
                return false;
            } else {

                return true;
            }

        } else {
            return false;
        }

    }

    public Cursor getorderdata() { // View Order Data

        SQLiteDatabase myDB = this.getReadableDatabase();

        Cursor cursor = myDB.rawQuery("select * from orders", null);

        return cursor;

    }

    public Boolean InsertPaymentDetails(String cardno, String choldername, String cvv, String expiredate) {

        // Insert payment data

        SQLiteDatabase myDB = this.getReadableDatabase();
        ContentValues contentValues = new ContentValues();

        contentValues.put("cardno", cardno);
        contentValues.put("choldername", choldername);
        contentValues.put("cvv", cvv);
        contentValues.put("expiredate", expiredate);

        long result = myDB.insert("payments",null,contentValues);

        if(result == -1) {
            return false;
        }
        else {

            return  true;
        }
    }
}



