package com.example.tpdm_u5_tarea1;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class BaseDatos extends SQLiteOpenHelper {

    public BaseDatos(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE CANCIONREG(IDCANCION INTEGER PRIMARY KEY AUTOINCREMENT,CANCION VARCHAR(200))");
        db.execSQL("INSERT INTO CANCIONREG (CANCIONREG) VALUES ('Pasame la botella - Daddy & Match .')," +
                "('La gasolina- Daddy Yankee ')," +
                "('La Metralladora -  Daddy yankee')," +
                "('Rompe - Daddy Yankee')," +
                "('Si alguna vez - La factoria ')," +
                "('Sale el sol - Don Omar')");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {

    }
}
