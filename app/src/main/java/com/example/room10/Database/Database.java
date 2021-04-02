package com.example.room10.Database;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteQueryBuilder;
import android.util.Log;

import com.example.room10.Model.Escape;
import com.readystatesoftware.sqliteasset.SQLiteAssetHelper;

import java.util.ArrayList;
import java.util.List;

public class Database extends SQLiteAssetHelper {
    private static final String DB_NAME="Escape.db";
    private static final int DB_VER=1;
    public Database(Context context) {
        super(context, DB_NAME, null, DB_VER);
    }
    //Function get all Escapes
    public List<Escape> getEscapes(){
        SQLiteDatabase db = getReadableDatabase();
        SQLiteQueryBuilder qb = new SQLiteQueryBuilder();
        String[] sqlSelect={"Id", "Region", "Theme", "Cafe", "Room", "Link", "Diff"};
        String tableName="Escapes";

        qb.setTables(tableName);
        Cursor cursor = qb.query(db,sqlSelect, null, null, null, null, null);
        List<Escape> result = new ArrayList<>();
        if(cursor.moveToFirst()){
            do{

                Escape escape = new Escape();
                escape.setId(cursor.getInt(cursor.getColumnIndex("Id")));
                escape.setRegion(cursor.getString(cursor.getColumnIndex("Region")));
                escape.setTheme(cursor.getString(cursor.getColumnIndex("Theme")));
                escape.setCafe(cursor.getString(cursor.getColumnIndex("Cafe")));
                escape.setRoom(cursor.getString(cursor.getColumnIndex("Room")));
                escape.setLink(cursor.getString(cursor.getColumnIndex("Link")));
                escape.setLink(cursor.getString(cursor.getColumnIndex("Diff")));
                result.add(escape);
            }while (cursor.moveToNext());
        }
        return result;
    }
    //Function get all Escape's Region
    public List<String> getRegions(){
        SQLiteDatabase db = getReadableDatabase();
        SQLiteQueryBuilder qb = new SQLiteQueryBuilder();
        String[] sqlSelect={"Region"};
        String tableName="Escapes";

        qb.setTables(tableName);
        Cursor cursor = qb.query(db,sqlSelect, null, null, null, null, null);
        List<String> result = new ArrayList<>();
        if(cursor.moveToFirst()){
            do{
                result.add(cursor.getString(cursor.getColumnIndex("Region")));
            }while (cursor.moveToNext());
        }
        return result;
    }
    //Function get escape by region
    public List<Escape> getEscapeByRegion(String region){
        SQLiteDatabase db = getReadableDatabase();
        SQLiteQueryBuilder qb = new SQLiteQueryBuilder();
        String[] sqlSelect={"Id", "Region", "Theme", "Cafe", "Room", "Link", "Diff"};
        String tableName="Escapes";

        qb.setTables(tableName);
        Cursor cursor = qb.query(db,sqlSelect, "Region LIKE ?", new String[]{"%"+region+"%"}, null, null, null);
        List<Escape> result = new ArrayList<>();
        if(cursor.moveToFirst()){
            do{

                Escape escape = new Escape();
                escape.setId(cursor.getInt(cursor.getColumnIndex("Id")));
                escape.setRegion(cursor.getString(cursor.getColumnIndex("Region")));
                escape.setTheme(cursor.getString(cursor.getColumnIndex("Theme")));
                escape.setCafe(cursor.getString(cursor.getColumnIndex("Cafe")));
                escape.setRoom(cursor.getString(cursor.getColumnIndex("Room")));
                escape.setLink(cursor.getString(cursor.getColumnIndex("Link")));
                escape.setLink(cursor.getString(cursor.getColumnIndex("Diff")));
                result.add(escape);
            }while (cursor.moveToNext());
        }
        return result;
    }

    public List<String> getLink(){
        SQLiteDatabase db = getReadableDatabase();
        SQLiteQueryBuilder qb = new SQLiteQueryBuilder();
        String[] sqlSelect={"Link"};
        String tableName="Escapes";

        qb.setTables(tableName);
        Cursor cursor = qb.query(db,sqlSelect, null, null, null, null, null);
        List<String> result = new ArrayList<>();
        if(cursor.moveToFirst()){
            do{
                result.add(cursor.getString(cursor.getColumnIndex("Link")));
            }while (cursor.moveToNext());
        }
        return result;
    }


}

