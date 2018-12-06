package ado.edu.itla.sosapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import ado.edu.itla.sosapp.entidad.Usuario;
import ado.edu.itla.sosapp.repositorio.DbConexion;
import ado.edu.itla.sosapp.repositorio.usuario.UsuarioRepositorio;


public abstract class MainActivity extends AppCompatActivity {

        TextView tv_registrar;
    private static final String TAG = "SOSAPP.MAINACTIVITY";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.d(TAG, "Entrando al Main Activity");
        Log.e(TAG, "SosApp Ing.Aybar");

        tv_registrar = findViewById(R.id.tvRegistrarse);
        tv_registrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentReg = new Intent(MainActivity.this, Registro.class);
                MainActivity.this.startActivity(intentReg);

                    }


                });

    }
}





