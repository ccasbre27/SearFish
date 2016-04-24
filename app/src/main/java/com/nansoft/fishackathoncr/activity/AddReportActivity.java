package com.nansoft.fishackathoncr.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.nansoft.fishackathoncr.R;

public class AddReportActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_report);


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
}
