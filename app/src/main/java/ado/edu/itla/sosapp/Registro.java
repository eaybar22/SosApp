package ado.edu.itla.sosapp;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import ado.edu.itla.sosapp.repositorio.DbConexion;


public class Registro extends AppCompatActivity {
    private EditText ed_email, ed_nombre, ed_password, ed_conpassword;

    Button btnCancelar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);

        ed_email = (EditText) findViewById(R.id.edEmail);
        ed_nombre = (EditText) findViewById(R.id.edNombre);
        ed_password = (EditText) findViewById(R.id.edPass);
        ed_conpassword = (EditText) findViewById(R.id.edConfPass);

        btnCancelar = (Button) findViewById(R.id.bCancelar);
        btnCancelar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent cancelar = new Intent(Registro.this, MainActivity.class);
                startActivity(cancelar);
            }
        });


    }

    //Metodo botón guardar
    public void R_Usuario(View view) {
        DbConexion admin = new DbConexion(this, "DbConexion", null, 1);
        SQLiteDatabase BaseDeDatos = admin.getWritableDatabase();

        String mail = ed_email.getText().toString();
        String name = ed_nombre.getText().toString();
        String password = ed_password.getText().toString();
        String conpass = ed_conpassword.getText().toString();

        if (!mail.isEmpty() && !name.isEmpty() && !password.isEmpty() && !conpass.isEmpty()) {
            ContentValues registro = new ContentValues();

            registro.put("email", mail);
            registro.put("nombre", name);
            registro.put("password", password);

            BaseDeDatos.insert("usuario", null, registro);

            BaseDeDatos.close();

            ed_email.setText("");
            ed_nombre.setText("");
            ed_password.setText("");
            ed_conpassword.setText("");

            Toast.makeText(this, "Registro correcto", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "Los campos no pueden estar en blanco", Toast.LENGTH_SHORT).show();
        }

    }

}