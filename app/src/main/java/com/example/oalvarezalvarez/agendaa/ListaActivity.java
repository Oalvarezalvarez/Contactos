package com.example.oalvarezalvarez.agendaa;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;


public class ListaActivity extends ListActivity {

    ArrayList<Agenda> contactos;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista);

        contactos = (ArrayList<Agenda>) getIntent().getSerializableExtra("id1");
        setListAdapter(new ArrayAdapter<Agenda>(this,android.R.layout.simple_list_item_1, contactos));
    }

    public void onListItemClick(ListView parent,View v,int posicion,long id)
    {
        Intent intento = new Intent(ListaActivity.this, MainActivity2.class);
        intento.putExtra("id2", new Agenda (contactos.get(posicion).getNombre(),contactos.get(posicion).getTelefono()));
        startActivityForResult(intento, 1);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        getMenuInflater().inflate(R.menu.menu_lista, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        int id = item.getItemId();
        if (id == R.id.action_settings)
        {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void onActivityResult(int requestCode, int resultCode, Intent data)
    {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK)
        {
            Agenda modificado = (Agenda) data.getSerializableExtra("id3");
            Agenda contacto = (Agenda) data.getSerializableExtra("id4");

            Intent intento = new Intent(ListaActivity.this, MainActivity.class);
            intento.putExtra("id4", contacto);
            intento.putExtra("id3",modificado);
            setResult(RESULT_OK, intento);
            finish();
        }
    }
}
