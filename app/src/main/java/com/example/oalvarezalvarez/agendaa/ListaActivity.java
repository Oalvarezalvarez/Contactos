package com.example.oalvarezalvarez.agendaa;

import android.app.Activity;
import android.app.ListActivity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;


public class ListaActivity extends ListActivity {

    ArrayList<Agenda> contactos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
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
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_lista, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK) {
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
