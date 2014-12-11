package com.example.oalvarezalvarez.agendaa;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


public class ActivityBorrar extends Activity
{
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activity_borrar);
        final EditText nom = (EditText) findViewById(R.id.editText);
        final EditText tel = (EditText) findViewById(R.id.editText2);
        Button b = (Button) findViewById(R.id.button);

        final Agenda contacto = (Agenda) getIntent().getSerializableExtra("id3");

        nom.setText(contacto.getNombre());
        tel.setText(String.valueOf(contacto.getTelefono()));

        b.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                final Intent intento = new Intent(ActivityBorrar.this, MainActivity.class);

                Agenda modificado = new Agenda(nom.getText().toString(),Integer.parseInt(tel.getText().toString()));
                intento.putExtra("id4", modificado);
                intento.putExtra("id3",contacto);
                setResult(RESULT_OK, intento);
                startActivity(intento);
                finish();
            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {

        getMenuInflater().inflate(R.menu.menu_activity_borrar, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        int id = item.getItemId();

        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
