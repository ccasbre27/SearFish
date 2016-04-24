package com.nansoft.fishackathoncr.activity;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

import com.microsoft.windowsazure.mobileservices.MobileServiceClient;
import com.microsoft.windowsazure.mobileservices.MobileServiceList;
import com.microsoft.windowsazure.mobileservices.table.MobileServiceTable;
import com.microsoft.windowsazure.mobileservices.table.query.QueryOrder;
import com.nansoft.fishackathoncr.R;
import com.nansoft.fishackathoncr.model.Comentario;

import java.util.ArrayList;

public class AddReportActivity extends AppCompatActivity {

    Spinner spnrTipo;
    Spinner spnrProvincia;
    EditText edtDescripcion;
    EditText edtUsuario;
    EditText edtEmail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_report);

        // se obtiene el action bar y se habilita el botón de navegación
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        // adapter de tipos
         spnrTipo = (Spinner) findViewById(R.id.spnrTipoReporte);
        // Cargamos el spinner con el array de strings
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(AddReportActivity.this,
                R.array.tipos_reporte_array, android.R.layout.simple_dropdown_item_1line);

        spnrTipo.setAdapter(adapter);

        spnrProvincia = (Spinner) findViewById(R.id.spnrZonaReporte);
        // Cargamos el spinner con el array de strings
        adapter = ArrayAdapter.createFromResource(AddReportActivity.this,
                R.array.provincias_array, android.R.layout.simple_dropdown_item_1line);

        spnrProvincia.setAdapter(adapter);

        // referencia del edittext para la descripción
        edtDescripcion = (EditText) findViewById(R.id.edtDescripcionReporte);

        // referencia al edittext para el nombre de usuario
        edtUsuario = (EditText) findViewById(R.id.edtUsuarioReporte);

        // referencia al edittext para el email
        edtEmail = (EditText) findViewById(R.id.edtEmailReporte);

        // on click listener del botón
        findViewById(R.id.btnEnviar).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // creamos el objeto Comentario
                Comentario comentario = new Comentario();

                comentario.nombreUsuarioPregunta = edtUsuario.getText().toString();
                comentario.descripcionPregunta = edtDescripcion.getText().toString();
                comentario.email = edtEmail.getText().toString();

                EnviarReporte(comentario);

            }
        });
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

    private void EnviarReporte(final Comentario comentario)
    {
        new AsyncTask<Void, Void, Boolean>() {


            MobileServiceTable<Comentario> mComentarioTable;
            MobileServiceClient mClient;
            ProgressDialog progressDialog;

            @Override
            protected void onPreExecute()
            {

                try {
                    mClient = new MobileServiceClient(
                            "https://fishackathoncr.azure-mobile.net/",
                            "MGQHOhPeEaBsghWIPZUxbrsjqYNQpk25",
                            getApplicationContext()
                    );


                    mComentarioTable = mClient.getTable("tbl_Comentarios", Comentario.class);

                    progressDialog = new ProgressDialog(AddReportActivity.this);
                    progressDialog.setMessage("Agregando registro...");
                    progressDialog.show();
                    progressDialog.setCancelable(false);

                } catch (Exception exception) {

                    Snackbar.make(spnrTipo, "Error al conectar con el servicio", Snackbar.LENGTH_LONG)
                            .setAction("Action", null).show();
                }


            }

            @Override
            protected Boolean doInBackground(Void... params) {
                try {

                    mComentarioTable.insert(comentario).get();

                    return true;
                } catch (Exception exception) {
                    Snackbar.make(spnrTipo, "Error " + exception.toString(), Snackbar.LENGTH_LONG)
                            .setAction("Action", null).show();
                }
                return false;
            }

            @Override
            protected void onPostExecute(Boolean success)
            {

                progressDialog.dismiss();

                Snackbar.make(spnrTipo, "¡Reporte agregado, muchas gracias!", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();

            }
        }.execute();
    }
}
