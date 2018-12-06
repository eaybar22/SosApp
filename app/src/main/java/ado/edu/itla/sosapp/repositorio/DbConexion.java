package ado.edu.itla.sosapp;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DbConexion extends SQLiteOpenHelper {

    private static String NOMBRE_BASEDATOS = "sosapp_db.db";
    private static int VERSION_BASEDATOS = 1;
    private static String TABLA_USUARIO = "CREATE TABLE usuario (" +
            "id INTEGER PRIMARY KEY AUTOINCREMENT," +
            "email TEXT NOT NULL," +
            "nombre TEXT NOT NULL," +
            "password TEXT NOT NULL" +
            ")";


    public DbConexion(Context context, String name, SQLiteDatabase.CursorFactory factory, int vesion) {
        super(context, name, factory, vesion);
    }

//Creando la base de datos.
    public DbConexion(Context context) {
        super(context, NOMBRE_BASEDATOS, null, VERSION_BASEDATOS);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(TABLA_USUARIO);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
