package com.example.novacibus;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class Veritabani extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "sepet";
    private static final int DATABASE_VERSION = 1;
    private static final String TABLO_URUNLER = "urunler";
    private static final String ROW_ID = "id";
    private static final String ROW_URUNAD = "urunadi";
    private static final String ROW_FIYATI = "urunfiyati";

    public Veritabani(Context context) {
        super(context, DATABASE_NAME,null,DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE " + TABLO_URUNLER + "("
                + ROW_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + ROW_URUNAD + " TEXT NOT NULL, "
                + ROW_FIYATI + " TEXT NOT NULL)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLO_URUNLER);
        onCreate(db);
    }

    public void VeriEkle(String urunadı, String urunfiyati){
        SQLiteDatabase db = this.getWritableDatabase();
        try {
            ContentValues cv = new ContentValues();
            cv.put(ROW_URUNAD, urunadı);
            cv.put(ROW_FIYATI, urunfiyati);
            db.insert(TABLO_URUNLER, null,cv);
        }catch (Exception e){
        }

        db.close();
    }

    public List<String> VeriListele(){
        List<String> veriler = new ArrayList<String>();
        SQLiteDatabase db = this.getReadableDatabase();
        try {
            String[] stunlar = {ROW_ID,ROW_URUNAD,ROW_FIYATI};
            Cursor cursor = db.query(TABLO_URUNLER, stunlar,null,null,null,null,null);
            while (cursor.moveToNext()){
                veriler.add(cursor.getString(1)
                        + " - "
                        + cursor.getString(2));
            }
        }catch (Exception e){

        }
        db.close();
        return veriler;
    }

    public Double Hesapla(){
        //List<String> toplam = new ArrayList<String>();
        Double toplam=0.0;
        SQLiteDatabase db = this.getReadableDatabase();
        try {
            String[] stunlar = {ROW_ID,ROW_URUNAD,ROW_FIYATI};
            Cursor cursor = db.query(TABLO_URUNLER, stunlar,null,null,null,null,null);
            while (cursor.moveToNext()){
                toplam+=cursor.getDouble(2);
            }
        }catch (Exception e){

        }
        db.close();
        return toplam;
    }

    public void Reset(){
        SQLiteDatabase db = this.getReadableDatabase();

        String clearDBQuery = "DELETE FROM "+TABLO_URUNLER;
        db.execSQL(clearDBQuery);
        
        db.close();
    }

    /*public void VeriSil(int id){
        SQLiteDatabase db = this.getWritableDatabase();
        try {
            // id ye göre verimizi siliyoruz
            String where = ROW_ID + " = " + id ;
            db.delete(TABLO_URUNLER,where,null);
        }catch (Exception e){
        }
        db.close();
    }

    /*public void VeriDuzenle(int id, String ad, String soyad, String tel){
        SQLiteDatabase db = this.getWritableDatabase();
        try {
            ContentValues cv = new ContentValues();
            cv.put(ROW_URUNAD, ad);
            cv.put(ROW_FIYATI, soyad);
            String where = ROW_ID +" = '"+ id + "'";
            db.update(TABLO_URUNLER,cv,where,null);
        }catch (Exception e){
        }
        db.close();
        }*/

}
