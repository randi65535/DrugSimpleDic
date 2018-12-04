package com.example.wsu.cs.drugsimpledic;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteStatement;
import android.util.Log;
import java.util.ArrayList;

public class DatabaseHelper extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "Drug_DB";

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        try {
            db.execSQL("CREATE TABLE Drug (_id Integer, db_recent_finded_word varchar(255) );");
        } catch (Exception e) {
            Log.e("Database Error", "CREATE Error");
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }


}

//    public void insert(Drug Drug) {
//
//        SQLiteDatabase db = null;
//        SQLiteStatement stmt = null;
//        try {
//
//            db = this.getWritableDatabase();
//            stmt = db.compileStatement("INSERT INTO Drug VALUES (?,?,?,?)");
////            stmt.bindString(1, Drug.getmIsbn());
////            stmt.bindString(2, Drug.getmTitle());
////            stmt.bindString(3, Drug.getmAuthor());
////            stmt.bindString(4, Drug.getmContent());
//            stmt.execute();
//
//        } catch (Exception e) {
//            Log.e("Database Error", "Insert Error");
//        }
//        close(db);
//    }
//
//    public void delete(String isbn) {
//        SQLiteDatabase db = null;
//
//        try {
//            db = this.getWritableDatabase();
//            SQLiteStatement stmt = db.compileStatement("DELETE FROM Drug WHERE db_isbn = ?");
//            stmt.bindString(1, isbn);
//            stmt.execute();
//        } catch (Exception e) {
//            Log.e("Database Error", "Delete Error");
//        } finally {
//            close(db);
//        }
//
//    }
//
//    public void update(String isbn, String content){
//        SQLiteDatabase db = null;
//
//        try {
//            db = this.getWritableDatabase();
//            SQLiteStatement stmt = db.compileStatement("UPDATE Drug SET db_content = ? WHERE db_isbn = ?");
//            stmt.bindString(1, content);
//            stmt.bindString(2, isbn);
//            stmt.execute();
//        } catch (Exception e) {
//            Log.e("Database Error", "Update Error");
//        } finally {
//            close(db);
//        }
//    }
//
//    public ArrayList<Drug> getAllDrug() {
//
//        ArrayList<Drug> list = new ArrayList<>();
//        SQLiteDatabase db = null;
//        try {
//            db = this.getReadableDatabase();
//            Cursor cursor = db.rawQuery("SELECT * FROM Drug", null);
//
//            while (cursor.moveToNext()) {
//                list.add(new Drug(
//                        //SQLite는 index를 0부터 시작한다.
////                        cursor.getString(0),    // isbn
////                        cursor.getString(1),    // title
////                        cursor.getString(2),    // author
////                        cursor.getString(3)     // content
//                ));
//            }
//        } catch (Exception e) {
//            Log.e("Database  Error", "Select Error");
//        } finally {
//            close(db);
//        }
//
//        return list;
//    }
//
//    public void close(SQLiteDatabase db) {
//        if (db != null) db.close();
//    }
//
//    public int getColumnCount(){
//
//        SQLiteDatabase db = null;
//        int columnCount = 0;
//        try {
//            db = this.getReadableDatabase();
//            Cursor cursor = db.rawQuery("SELECT COUNT(db_isbn) FROM Drug", null);
//            columnCount = cursor.getColumnCount();
//        } catch (Exception e) {
//            Log.e("Database  Error", "Count Error");
//        } finally {
//            close(db);
//        }
//
//        return columnCount;
//
//    }
//
//    public String getContentByIsbn(String isbn) {
//        SQLiteDatabase db = null;
//        String content = null;
//        try {
//            db = this.getReadableDatabase();
//            String query = "SELECT db_isbn FROM Drug WHERE db_isbn = " + isbn;
//            Cursor cursor = db.rawQuery(query, null);
//            cursor.moveToFirst();
//            content = cursor.getString(0);
//
//        } catch (Exception e) {
//            Log.e("Database  Error", "Select Error");
//        } finally {
//            close(db);
//        }
//
//        return content;
//
//    }
