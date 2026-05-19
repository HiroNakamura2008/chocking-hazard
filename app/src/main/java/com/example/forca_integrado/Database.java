package com.example.forca_integrado;

import android.content.ContentValues;
import android.content.Context;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

public class Database extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;

    private static final String DATABASE_NAME = "Banco.db";

    public Database(Context contexto){

        super(contexto, DATABASE_NAME, null, DATABASE_VERSION);

    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL("CREATE TABLE IF NOT EXISTS tabelaPalavra_id (Interger PRIMARY KEY AUTOINCREMENT, palavra TEXT, categoria TEXT)");

    }

    public void saveWord (Palavra p){

        SQLiteDatabase bd = getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("palavra", p.getWordDigit());
        values.put("categoria", p.getCategory());
        bd.insert("tabelaPalavra", null, values);
        bd.close();

    }

    public ArrayList<Palavra> palavraArrayList(){

        ArrayList<Palavra> list = new ArrayList<Palavra>();
        SQLiteDatabase DB = getReadableDatabase();
        Cursor cursor = DB.query("tabelaPalavra",null,null,null,null,null,null);

        while(cursor.moveToNext()){

            String word = cursor.getString(cursor.getColumnIndexOrThrow("palavra"));
            String category = cursor.getString(cursor.getColumnIndexOrThrow("categoria"));
            Palavra P = new Palavra();
            P.setWordDigit(word);
            P.setCategory(category);
            list.add(P);

        }

        cursor.close();
        DB.close();
        return list;

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
