package com.example.oalvarezalvarez.agendaa;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends Activity
{
    public ArrayList<Agenda> agenda = new ArrayList<Agenda>();

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        final Intent intento = new Intent(MainActivity.this, ListaActivity.class);
        Button bAñadir = (Button) findViewById(R.id.bAñadir);
        Button bListar = (Button) findViewById(R.id.bListar);



        bAñadir.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                EditText eNombre = (EditText) findViewById(R.id.eNombre);
                EditText eTelefono = (EditText) findViewById(R.id.eTelefono);


                if ("".equals(eNombre.getText().toString()) || "".equals(eTelefono.getText().toString()))
                {
                    showToast("ERROR, NO PUEDE ESTAR VACIO");
                }
                else
                {
                    agenda.add(new Agenda(eNombre.getText().toString(), Integer.parseInt(eTelefono.getText().toString())));
                    eNombre.setText("");
                    eTelefono.setText("");
                }
            }
        });

        

        bListar.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                ArrayList<Agenda> ag = agenda;
                intento.putExtra("id1", ag);
                startActivityForResult(intento, 1);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        getMenuInflater().inflate(R.menu.menu_main, menu);
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

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data)
    {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK)
        {
            Agenda modificado = (Agenda) data.getSerializableExtra("id3");
            Agenda contacto = (Agenda) data.getSerializableExtra("id4");

            for (int i = 0; i < agenda.size(); i++)
            {
                if (agenda.get(i).getNombre().equalsIgnoreCase(contacto.getNombre().toString()))
                {
                    agenda.get(i).setNombre(modificado.getNombre());
                    agenda.get(i).setTelefono(modificado.getTelefono());
                }
            }

            showToast("Has añadido el nombre: " + modificado.getNombre() + " y su telefono: " + String.valueOf(modificado.getTelefono()));
        }
    }

    public void showToast(String mensaje)
    {
        Context context = getApplicationContext();
        int duration = Toast.LENGTH_SHORT;
        Toast toast = Toast.makeText(context, mensaje, duration);
        toast.show();
    }
}
