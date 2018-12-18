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

<<<<<<< HEAD
import java.util.ArrayList;
import java.util.List;

import ado.edu.itla.sosapp.entidad.Usuario;
import ado.edu.itla.sosapp.repositorio.funciones.Sesion;
import ado.edu.itla.sosapp.repositorio.usuario.UsuarioRepositorio;
import ado.edu.itla.sosapp.repositorio.usuario.UsuarioRepositorioimpl;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "SOSAPP.MAINACTIVITY";
    UsuarioRepositorio usuarioRepositorio;
    Sesion sesion = null;
=======
import ado.edu.itla.sosapp.entidad.Usuario;
import ado.edu.itla.sosapp.repositorio.DbConexion;
import ado.edu.itla.sosapp.repositorio.usuario.UsuarioRepositorio;


public abstract class MainActivity extends AppCompatActivity {

        TextView tv_registrar;
    private static final String TAG = "SOSAPP.MAINACTIVITY";


>>>>>>> 9e5982be5e8582d1de3c6e89ffd266810b9df116
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);

<<<<<<< HEAD
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
        usuarioRepositorio = new UsuarioRepositorioimpl(this);

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
=======
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





>>>>>>> 9e5982be5e8582d1de3c6e89ffd266810b9df116
