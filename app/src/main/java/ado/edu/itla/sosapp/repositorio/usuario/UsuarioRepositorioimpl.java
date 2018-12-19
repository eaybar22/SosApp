package ado.edu.itla.sosapp.repositorio.usuario;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import ado.edu.itla.sosapp.entidad.Usuario;
import ado.edu.itla.sosapp.repositorio.DbConexion;


public class UsuarioRepositorioImpl implements UsuarioRepositorio {
    private DbConexion dbConexion;

    public UsuarioRepositorioImpl(Context context){
        this.dbConexion = new DbConexion(context);
    }

    @Override
    public void guardar(Usuario usuario) {

        ContentValues cv = new ContentValues();
        cv.put("email", usuario.getEmail());
        cv.put("password", usuario.getPassword());
        cv.put("nombre", usuario.getNombre());

        SQLiteDatabase db = dbConexion.getReadableDatabase();

        Long id = db.insert("usuario", null, cv);
        usuario.setId(id.intValue());
    }

    @Override
    public Usuario buscar(String email) {

        //Columnas a buscar en la base de datos.
        String columnas[] = new String[]{"id", "password", "nombre"};

        //abrir conexion a la base de datos (SOLO LECTURA).
        SQLiteDatabase db = dbConexion.getReadableDatabase();

        //Ejecutamos la consulta.
        Cursor cursor = db.query("usuario", columnas, "email=?", new String[]{email}, null, null, null);

        Usuario usuario = null;
        if (cursor.moveToFirst()){

            usuario = new Usuario();

            usuario.setId(cursor.getInt(cursor.getColumnIndex("id")));
            usuario.setNombre(cursor.getString(cursor.getColumnIndex("nombre")));
            usuario.setEmail(cursor.getString(cursor.getColumnIndex("email")));
            usuario.setPassword(cursor.getString(cursor.getColumnIndex("password")));

            cursor.close();
            db.close();
        }
        return usuario;
    }

    @Override
    public String logging(String email, String password) {
        return null;
    }

    @Override
    public Usuario buscarPor(int id) {
        return null;
    }
}
