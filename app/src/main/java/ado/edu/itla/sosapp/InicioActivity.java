package ado.edu.itla.sosapp;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.preference.PreferenceManager;
import android.support.annotation.NonNull;
import android.support.annotation.RequiresApi;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.FrameLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import ado.edu.itla.sosapp.entidad.Solicitud;
import ado.edu.itla.sosapp.entidad.Usuario;
import ado.edu.itla.sosapp.repositorio.funciones.Sesion;
import ado.edu.itla.sosapp.repositorio.solicitud.SolicitudRepositorioimpl;
import ado.edu.itla.sosapp.repositorio.usuario.UsuarioRepositorioImpl;


public class InicioActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private BottomNavigationView bottomNavigationView;
    ListView list;
    int imgs[] = {R.drawable.ic_menu_gallery, R.drawable.ic_menu_share};

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inicio);

        Toolbar toolbar = findViewById(R.id.toolbar_her);
        toolbar.setTitle("SosApp");

        setSupportActionBar(toolbar);

        DrawerLayout drawerLayout = findViewById(R.id.drawer_layout);

        ActionBarDrawerToggle actionBarDrawerToggle = new ActionBarDrawerToggle(
                this,drawerLayout,toolbar,R.string.navigation_drawer_open,R.string.navigation_drawer_close);

        drawerLayout.addDrawerListener(actionBarDrawerToggle);

        actionBarDrawerToggle.syncState();
        NavigationView navigationView = findViewById(R.id.menuview);
        navigationView.setNavigationItemSelectedListener(this);

        /**************LISTAS********************/
        list = findViewById(R.id.missolicitudes_list);
        final List<Solicitud> solicituds = new SolicitudRepositorioimpl(getApplicationContext()).buscarTodos();
        SolicitudAdapter adapter = new SolicitudAdapter(getApplicationContext(),solicituds);
        list.setAdapter(adapter);

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                solicituds.get(position).getId();
                Toast.makeText(InicioActivity.this,
                        "Crear vista solicitud para la solicitud "+String.valueOf(solicituds.get(position).getId())+
                        ", de la posición ("+position+")",Toast.LENGTH_SHORT).show();
                Intent i = new Intent(InicioActivity.this, VerSolicitud.class);
                i.putExtra("idSolicitud", String.valueOf(solicituds.get(position).getId()));
                startActivity(i);
            }

        });

    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        seleccionarItem(menuItem.getItemId());
        return false;
    }

    public boolean seleccionarItem(int itemid)
    {
        Activity activity = null;
        Intent it = null;
        String titulo = "SosApp";

        if(itemid == R.id.action_inicio)
        {
            titulo = titulo + " - Inicio";
            /*LISTAS*/
            list = findViewById(R.id.missolicitudes_list);
            final List<Solicitud> solicituds = new SolicitudRepositorioimpl(getApplicationContext()).buscarTodos();
            SolicitudAdapter adapter = new SolicitudAdapter(getApplicationContext(),solicituds);
            list.setAdapter(adapter);

        }else if(itemid == R.id.action_missolicitudes)
        {
            titulo = titulo + " - Mis solicitudes";
            list = findViewById(R.id.missolicitudes_list);
            Sesion sesion = new Sesion(getApplicationContext());
            String correo = sesion.get("email");
            Usuario usuario = new UsuarioRepositorioImpl(getApplicationContext()).buscar(correo);
            final List<Solicitud> solicituds = new SolicitudRepositorioimpl(getApplicationContext()).buscarSolicitudesPor(usuario);
            SolicitudAdapter adapter = new SolicitudAdapter(getApplicationContext(),solicituds);
            list.setAdapter(adapter);

        }else if(itemid == R.id.action_solicitudesseleccionadas)
        {
            titulo = titulo + " - Solicitudes a resolver";
            list = findViewById(R.id.missolicitudes_list);
            Sesion sesion = new Sesion(getApplicationContext());
            String correo = sesion.get("email");
            Usuario usuario = new UsuarioRepositorioImpl(getApplicationContext()).buscar(correo);
            final List<Solicitud> solicituds = new SolicitudRepositorioimpl(getApplicationContext()).buscarSolicitudesSeleccionadas(usuario,"Proceso");
            SolicitudAdapter adapter = new SolicitudAdapter(getApplicationContext(),solicituds);
            list.setAdapter(adapter);
            /**************TRABAJANDO CON LISTAS********************/
        }else if(itemid == R.id.action_nsolicitud)
        {
            titulo = titulo + " - Nueva Solicitud";
            it = new Intent(InicioActivity.this, NuevaSolicitud.class);
        }
        else if(itemid == R.id.action_settings)
        {
            titulo = titulo + " - Configuración \n En construcción!!!";
        }else if(itemid == R.id.action_Cerrars)
        {
            //Cerrar sesión
            SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
            preferences.edit().remove("email").commit();
            it = new Intent(InicioActivity.this,MainActivity.class);

        }

        if(it != null)
        {startActivity(it);}

        Toast.makeText(this, ""+titulo, Toast.LENGTH_SHORT).show();
        DrawerLayout drawerLayout =  findViewById(R.id.drawer_layout);
        drawerLayout.closeDrawer(GravityCompat.START);
        return true;



    }
}
