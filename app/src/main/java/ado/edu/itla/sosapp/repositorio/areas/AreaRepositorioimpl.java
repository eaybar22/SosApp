package ado.edu.itla.sosapp.repositorio.areas;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

import ado.edu.itla.sosapp.entidad.AreaAfin;
import ado.edu.itla.sosapp.entidad.Usuario;
import ado.edu.itla.sosapp.repositorio.Dbconexion;

public class AreaRepositorioimpl implements AreaRepositorio {

    private Dbconexion dbConexion;

    public AreaRepositorioimpl(Context context) {
        this.dbConexion = new Dbconexion(context);
    }
    @Override
    public ArrayList<AreaAfin> buscarTodos() {

        SQLiteDatabase db = dbConexion.getReadableDatabase();
        Cursor c = null;
        String nombre ="";
        ArrayList<AreaAfin> area = new ArrayList<>();
        AreaAfin areafin = null;
        try
        {
            c = db.query("catalogo_area",null,null,
                    null,null,null,null);

            while(c.moveToNext()){
                areafin = new AreaAfin();

                areafin.setId(c.getInt(c.getColumnIndex("id")));
                areafin.setNombre(c.getString(c.getColumnIndex("area")));

                area.add(areafin);
            }
            c.close();
            c.close();
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return area;
    }

    @Override
    public AreaAfin buscarPor(int id) {

        SQLiteDatabase db = dbConexion.getReadableDatabase();
        Cursor c = null;
        String nombre ="";

        AreaAfin areafin = null;
        try
        {

            c = db.query("catalogo_area",null,"id=?",
                    new String[]{String.valueOf(id)},null,null,null);

            while(c.moveToNext()){
                areafin = new AreaAfin();

                areafin.setId(c.getInt(c.getColumnIndex("id")));
                areafin.setNombre(c.getString(c.getColumnIndex("area")));


            }
            c.close();
            c.close();
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return areafin;
    }
}
