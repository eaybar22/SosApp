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


import java.util.ArrayList;
import java.util.List;

import ado.edu.itla.sosapp.entidad.Usuario;
import ado.edu.itla.sosapp.repositorio.funciones.Sesion;
import ado.edu.itla.sosapp.repositorio.usuario.UsuarioRepositorio;
import ado.edu.itla.sosapp.repositorio.usuario.UsuarioRepositorioImpl;
import ado.edu.itla.sosapp.repositorio.usuario.UsuarioRepositorioImpl;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "SOSAPP.MAINACTIVITY";
    UsuarioRepositorio usuarioRepositorio;
    Sesion sesion = null;

    
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);
        
        sesion = new Sesion(getApplicationContext());
        String correo = sesion.get("email");
        if(!correo.equals(""))
        {
            Intent ventana = new Intent(MainActivity.this, InicioActivity.class);
            startActivity(ventana);
        }
        TextView tView = (TextView) findViewById(R.id.login_Registrarse);

        tView.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent registraser = new Intent(MainActivity.this, Registrarse.class);
                startActivity(registraser);
            }
        });

    }

    public void login_click(View view)
    {

        final EditText emailText = findViewById(R.id.eUsuario);
        final EditText passwordText = findViewById(R.id.ePassword);
        String email = emailText.getText().toString().toLowerCase().trim();
        String password = passwordText.getText().toString();
        usuarioRepositorio = new UsuarioRepositorioImpl(this);

        Usuario u = null;
        String mensaje = "";
        String mail = "";
        String pass = "";
        u = usuarioRepositorio.buscar(email);

        mail = u==null?"":u.getEmail().toLowerCase();
        pass = u==null?"":u.getPassword().toLowerCase();
        if(mail.equals(email) && password.equals(pass))
        {
            mensaje = "Inicio Sesión  "+email;
            sesion = new Sesion(getApplicationContext());
            sesion.set("email",email);
            Intent ventana = new Intent(MainActivity.this, InicioActivity.class);
            startActivity(ventana);
        }else
            {
                mensaje = "Revisar datos de login!";
                emailText.setError("Revisar datos de email!");
            }
        Toast.makeText(this, mensaje, Toast.LENGTH_SHORT).show();

    }





    }

        


