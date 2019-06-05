package com.example.tpdm_u5_tarea1;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class BaseDatosRock extends SQLiteOpenHelper {

    public BaseDatosRock(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE CANCIONROCK(IDCANCION INTEGER PRIMARY KEY AUTOINCREMENT,CANCION VARCHAR(200))");
        db.execSQL("INSERT INTO CANCIONROCK (CANCIONES) VALUES ('The pretender - FF .')," +
                "('Revolution - The Beatles ')," +
                "('Smoke On the Water - ')," +
                "('PainKiller')," +
                "('T.N.T.')," +
                "('Master of puppets')");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {

    }
}
