package com.example.worldskills.tsppsp;

import android.content.ContentValues;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.provider.BaseColumns;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.view.menu.ListMenuItemView;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.example.worldskills.tsppsp.bd.AyudaBaseDatos;
import com.example.worldskills.tsppsp.bd.TablaDatos;

import java.util.ArrayList;
import java.util.List;

public class MenuActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    List listaProyectos;
    ListView lvMenuListaProyecto;
    Button btnCrearProyecto;
    EditText etNombreProyecto;
    Cursor consulta;
    ArrayAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);



        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);


        //comienza menu proyecto
        etNombreProyecto = (EditText)findViewById(R.id.etNombreProyecto);
        btnCrearProyecto = (Button) findViewById(R.id.btnCrearProyecto);
        lvMenuListaProyecto = (ListView)findViewById(R.id.lvProyectosMenu);
        actualizarProyecto();

        btnCrearProyecto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                if (!TextUtils.isEmpty(etNombreProyecto.getText().toString().trim())){
                    AyudaBaseDatos baseDatos = new AyudaBaseDatos(getApplicationContext());
                    SQLiteDatabase bd = baseDatos.getWritableDatabase();
                    ContentValues valores = new ContentValues();

                    String nombre= etNombreProyecto.getText().toString();
                    valores.put(TablaDatos.LectorEntrada.COLUMNa_NOMBREPROYECTO,nombre);
                    long nuevoProyecto = bd.insert(TablaDatos.LectorEntrada.TABLA_NOMBRE, null, valores);
                }else{
                    Toast.makeText(getApplicationContext(),"Ingrese un nombre para el proyecto",Toast.LENGTH_LONG).show();
                }

                actualizarProyecto();
            }

        });

        lvMenuListaProyecto.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
              // String menu = (String) lvMenuListaProyecto.get
                String idMenu;

                SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
                SharedPreferences.Editor editor = preferences.edit();

            //    editor.putInt("IDPROYECTO",menu);
              //  editor.commit();

            //Toast.makeText(getApplicationContext(),""+menu,Toast.LENGTH_LONG).show();

            }
        });







    }

    private void actualizarProyecto() {
        AyudaBaseDatos baseDatos = new AyudaBaseDatos(getApplicationContext());
        SQLiteDatabase bd = baseDatos.getReadableDatabase();
        ContentValues valores = new ContentValues();
        listaProyectos = new ArrayList<String>();


      String consultarSQL = "SELECT * FROM proyectos";
      consulta = bd.rawQuery(consultarSQL,null);
      if (consulta.moveToFirst()){
          do {
              String proyecto = consulta.getString(0)+": "+
                      consulta.getString(1);
              listaProyectos.add(proyecto);
              Log.i("Lista: ",proyecto);
          }while (consulta.moveToNext());

          adapter = new ArrayAdapter(getApplicationContext(),android.R.layout.simple_list_item_1,listaProyectos);
          lvMenuListaProyecto.setAdapter(adapter);
          consulta.close();
      }
      return;


    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }



    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement


        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_time_log) {
            Intent timeLog = new Intent(MenuActivity.this,TimeLogActivity.class);
            startActivity(timeLog);
        } else if (id == R.id.nav_defect_log) {

        } else if (id == R.id.nav_proyect_plan_summary) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
