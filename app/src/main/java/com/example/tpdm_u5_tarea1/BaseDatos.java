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
        db.execSQL("CREATE TABLE CANCIONESREG(IDCANCIONREG INTEGER PRIMARY KEY AUTOINCREMENT,CANCIONREG VARCHAR(200))");
        db.execSQL("INSERT INTO CANCIONESREG (CANCIONREG) VALUES (' Prende tu dia con: \n Pasame la botella - Daddy & Match .')," +
                "('Prende tu dia con: \n La gasolina- Daddy Yankee ')," +
                "('Prende tu dia con: \n La Metralladora -  Daddy yankee')," +
                "('Prende tu dia con: \n Rompe - Daddy Yankee')," +
                "('Prende tu dia con: \n Si alguna vez - La factoria ')," +
                "('Prende tu dia con: \n Sale el sol - Don Omar')");


        db.execSQL("CREATE TABLE CANCIONESROCK(IDCANCIONROCK INTEGER PRIMARY KEY AUTOINCREMENT,CANCIONROCK VARCHAR(200))");
        db.execSQL("INSERT INTO CANCIONESROCK (CANCIONROCK) VALUES ('Prende tu dia con: \n The pretender - Foo Fighters .')," +
                "('Prende tu dia con: \nRevolution - The Beatles ')," +
                "('Prende tu dia con: \n Smoke On the Water - Deep Purple ')," +
                "('Prende tu dia con: \n PainKiller -Judas Priest')," +
                "('Prende tu dia con: \n T.N.T. -  AC/DC')," +
                "('Prende tu dia con: \n Master of puppets - METALLICA')");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {

    }
}
