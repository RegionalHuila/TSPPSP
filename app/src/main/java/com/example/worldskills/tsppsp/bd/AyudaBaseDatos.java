package com.example.worldskills.tsppsp.bd;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class AyudaBaseDatos extends SQLiteOpenHelper {

    private static final String NOMBRE_BASE_DATOS = "tsp.db";
    private static final int VERSION_BASE_DATOS = 1;

    private static final String CREAR_TABLA =
            "CREATE TABLE " + TablaDatos.LectorEntrada.TABLA_NOMBRE + " (" +
                    TablaDatos.LectorEntrada._ID + " INTEGER PRIMARY KEY," +
                    TablaDatos.LectorEntrada.COLUMNa_NOMBREPROYECTO + " TEXT)";
                   // TablaDatos.LectorEntrada.COLUMNA_START + " DATE," +
                    //TablaDatos.LectorEntrada.COLUMNa_INTERRUPCIONES + " )";

    private static final String ELIMINAR_TABLA =
            "DROP TABLE IF EXISTS " + TablaDatos.LectorEntrada.TABLA_NOMBRE;


    public AyudaBaseDatos(Context context) {
        super(context, NOMBRE_BASE_DATOS, null, VERSION_BASE_DATOS);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREAR_TABLA);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(ELIMINAR_TABLA);
        onCreate(db);
    }
}
