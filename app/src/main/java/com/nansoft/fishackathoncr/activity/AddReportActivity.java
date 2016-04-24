package com.nansoft.fishackathoncr.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.nansoft.fishackathoncr.R;

public class AddReportActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_report);

        // se obtiene el action bar y se habilita el botón de navegación
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        // adapter de tipos
        Spinner spnrTipo = (Spinner) findViewById(R.id.spnrTipoReporte);
        // Cargamos el spinner con el array de strings
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(AddReportActivity.this,
                R.array.tipos_reporte_array, android.R.layout.simple_dropdown_item_1line);

        spnrTipo.setAdapter(adapter);

        spnrTipo = (Spinner) findViewById(R.id.spnrZonaReporte);
        // Cargamos el spinner con el array de strings
        adapter = ArrayAdapter.createFromResource(AddReportActivity.this,
                R.array.provincias_array, android.R.layout.simple_dropdown_item_1line);

        spnrTipo.setAdapter(adapter);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        switch(item.getItemId())
        {
            case android.R.id.home:
                super.onBackPressed();
                break;
        }

        return super.onOptionsItemSelected(item);
    }
}
