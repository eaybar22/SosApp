package ado.edu.itla.sosapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import java.util.ArrayList;
import java.util.List;
import ado.edu.itla.sosapp.entidad.Usuario;

public class MainActivity extends AppCompatActivity {
    TextView tv_registrar;
    private static final String TAG = "SOSAPP.MAINACTIVITY";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.d(TAG, "Entrando al Main Activity");
        Log.e(TAG, "Esto es un error");
        tv_registrar = findViewById(R.id.textViewRegistrarse);
        tv_registrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentReg = new Intent(MainActivity.this, Registro.class);
                MainActivity.this.startActivity(intentReg);
            }
        });

 /*       Button btnBotton = findViewById(R.id.button2);
        btnBotton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Usuario usuario = new Usuario();

                try {
                    usuario.setEdad(-12);
                }   catch(Exception e){
                    Toast.makeText(MainActivity.this, "Edad no permitida", Toast.LENGTH_SHORT).show();
                    e.printStackTrace();

                }
            }
        });*/

        Usuario usuario = new Usuario();
        usuario.setEmail("juandelospalotes@gmail.com");
        usuario.setNombre("cual quier email");
        usuario.setUsername("juandelospalote");

        Usuario usuario1 = new Usuario();
        usuario1.setEmail("juandelospalotes@gmail.com");
        usuario1.setNombre("cual quier email");
        usuario1.setUsername("juandelospalote");

        Usuario usuario2 = new Usuario();
        usuario2.setEmail("juandelospalotes@gmail.com");
        usuario2.setNombre("cual quier email");
        usuario2.setUsername("juandelospalote");

        Usuario usuario3 = new Usuario();
        usuario3.setEmail("juandelospalotes@gmail.com");
        usuario3.setNombre("cual quier email");
        usuario3.setUsername("juandelospalote");

        List<Usuario> usuarioList = new ArrayList<>();
        usuarioList.add(usuario);
        usuarioList.add(usuario1);
        usuarioList.add(usuario2);
        usuarioList.add(usuario3);

        Log.i(TAG, "Tamaño de la lista: "+usuarioList.size());
        for (Usuario u: usuarioList) {
            Log.i(TAG, "Nombre: " + u.getNombre());
        }

            }
        }
