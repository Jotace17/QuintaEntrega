package com.caselles.mypuppy;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toolbar;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<Detalle>detalles;
    private RecyclerView listaMascotas;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Toolbar miActionbar = (Toolbar) findViewById(R.id.miActionbar);
        //setSupportActionBar(miActionbar);

        listaMascotas = (RecyclerView) findViewById(R.id.rvMascota);



        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL );

        listaMascotas.setLayoutManager(llm);
        InicializarListaMascotas();
        InicializarAdaptador();

        /*ArrayList<String> nombresDetalle = new ArrayList<>();
        for (Detalle detalle:detalles) {
            nombresDetalle.add(detalle.getNombre());
        }


        ListView lstLista = (ListView) findViewById(R.id.lstLista);
        lstLista.setAdapter((new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, nombresDetalle)));

        lstLista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(MainActivity.this,DetalleMascota.class);
                intent.putExtra("Nombre",detalles.get(position).getNombre());
                intent.putExtra("Telefono",detalles.get(position).getTelefono());
                intent.putExtra("Email",detalles.get(position).getEmail());
                startActivity(intent);
            }
        });
        */

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_opciones, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()){

            case R.id.mContacto:
                Intent intent = new Intent(this, ActivityAbout.class);
                startActivity(intent);
                break;
            case R.id.mAcercade:
                Intent i = new Intent(this, ActivitySettings.class);
                startActivity(i);
                break;
        }

        return super.onOptionsItemSelected(item);
    }

    public  void InicializarAdaptador(){
        ContactoAdaptador adaptador = new ContactoAdaptador(detalles,this);
        listaMascotas.setAdapter(adaptador);

    }

    public void InicializarListaMascotas (){
        detalles = new ArrayList<Detalle>();

        detalles.add(new Detalle(R.drawable.perrito1,"tobby","555222888", "Miami"));
        detalles.add(new Detalle(R.drawable.perrito2,"Golden","74102589", "Medellín"));
        detalles.add(new Detalle(R.drawable.perrito3,"Pecas","888444111", "Berlín"));
        detalles.add(new Detalle(R.drawable.perrito4,"Flash","999666666", "Tokio"));
        detalles.add(new Detalle(R.drawable.perrito5,"Wolfy","100110100", "Mónaco"));
    }
}