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


public class MainActivity2 extends Activity
{
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_activity2);

        final Agenda contacto = (Agenda) getIntent().getSerializableExtra("id2");
        final EditText eNombre = (EditText) findViewById(R.id.eNombre);
        final EditText eTelefono = (EditText) findViewById(R.id.eTelefono);

        Button bEditar = (Button) findViewById(R.id.bEditar);

        eNombre.setText(contacto.getNombre());
        eTelefono.setText(String.valueOf(contacto.getTelefono()));

        bEditar.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                if ("".equalsIgnoreCase(eNombre.getText().toString().trim()) || "".equalsIgnoreCase(eTelefono.getText().toString().trim()))
                {
                    showToast("ERROR");
                    return;
                }
                else
                {
                    final Intent intento = new Intent(MainActivity2.this, MainActivity.class);

                    Agenda modificado = new Agenda(eNombre.getText().toString(),Integer.parseInt(eTelefono.getText().toString()));
                    intento.putExtra("id3", modificado);
                    intento.putExtra("id4",contacto);
                    setResult(RESULT_OK, intento);
                    finish();
                }
            }
        });
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        getMenuInflater().inflate(R.menu.menu_main_activity2, menu);
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

    public void showToast(String mensaje)
    {
        Context context = getApplicationContext();
        int duration = Toast.LENGTH_SHORT;
        Toast toast = Toast.makeText(context, mensaje, duration);
        toast.show();
    }
}
