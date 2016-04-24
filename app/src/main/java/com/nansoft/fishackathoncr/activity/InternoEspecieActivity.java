package com.nansoft.fishackathoncr.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.nansoft.fishackathoncr.R;
import com.nansoft.fishackathoncr.adapter.ItemAdapter;
import com.nansoft.fishackathoncr.adapter.ItemSugeridosAdapter;
import com.nansoft.fishackathoncr.model.Especie;
import com.nansoft.fishackathoncr.model.Item;

import org.w3c.dom.Text;

import java.util.ArrayList;

import uk.co.senab.photoview.PhotoView;

public class InternoEspecieActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.desc_intern_especie);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        // se establece el título de la activity con el pez seleccionado
        setTitle(ItemAdapter.especieActual.nombreComun);

        // se agregan las opciones de caracerísticas externas e internas
        ArrayList<Especie> lstItems = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            lstItems.add(new Especie(5,
                    "Cynoscion albus",
                    "Corvinas, Pollas, Zorras",

                    "Aceptable con reservas",
                    "Sin información",
                    "Esteros, desembocaduras",
                    "50-60 cm de largo por 15-20 cm de ancho.",
                    "Filetes de 100-200 g.",
                    "Fresco: De blanco a rosado. No Fresco: toma coloración amarillenta.",
                    "Olor a pescado fresco, no debe presentar olores fuertes ni rancios.",
                    "La dirección de las fibras musculares se proyectan hacia la parte anterior del individuo.  Los filetes de esta especie no se aprecian tanto las fibras blancas que son muy comunes en otras especies de corvina, dándole una consistencia mucho más pareja y regular. Además es fácilmente identificable porque suelen quedar partes de la piel color blanco adheridas al filete. Además se pueden diferenciar de las otras corvinas por su tamaño, ya que la corvina reina es más grande.",
                    "Se comercializa en filetes frescos o descongelados.",
                    "Respetar las épocas de veda en el Golfo de Nicoya y las tallas mínimas.",
                    "Sin definir",
                    "Corvina Reina",
                    "Pesca artesanal, trasmallo, cuerda",
                    "55.0 - 130.0 cm",
                    "https://wanted.blob.core.windows.net/img/Corvina reina.jpg"	,
                    "https://wanted.blob.core.windows.net/img/Corvina reina.png"));


        }


        RecyclerView recyclerViewSugeridos = (RecyclerView) findViewById(R.id.rvSugeridos);
        RecyclerView recyclerViewSimilares = (RecyclerView) findViewById(R.id.rvEspeciesSimilares);

        ItemSugeridosAdapter adapter = new ItemSugeridosAdapter(this,lstItems,new Especie());

        // Setup layout manager for items
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        // Control orientation of the items
        // also supports LinearLayoutManager.HORIZONTAL
        layoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);

        recyclerViewSugeridos.setLayoutManager(layoutManager);

        recyclerViewSugeridos.setAdapter(adapter);


        layoutManager = new LinearLayoutManager(this);
        // Control orientation of the items
        // also supports LinearLayoutManager.HORIZONTAL
        layoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);

        recyclerViewSimilares.setLayoutManager(layoutManager);
        recyclerViewSimilares.setAdapter(adapter);

        cargarDatosInternos();


    }

    private void cargarDatosInternos()
    {
        PhotoView imgvFilet = (PhotoView) findViewById(R.id.imgvPezIn);

        Glide.with(this)
                .load(ItemAdapter.especieActual.urlImagenFilet.trim())
                .asBitmap()
                .fitCenter()
                .placeholder(R.drawable.image_loading)
                .error(R.drawable.image_error)
                .into(imgvFilet);

        TextView txtvLongitud = (TextView) findViewById(R.id.txtvLongitudIn);
        txtvLongitud.setText(ItemAdapter.especieActual.longitudFilet);

        TextView txtvPeso = (TextView) findViewById(R.id.txtvPesoIn);
        txtvPeso.setText(ItemAdapter.especieActual.pesoFilet);

        TextView txtvColor = (TextView) findViewById(R.id.txtvColorIn);
        txtvColor.setText(ItemAdapter.especieActual.colorFilet);

        TextView txtvOlor = (TextView) findViewById(R.id.txtvOlorIn);
        txtvOlor.setText(ItemAdapter.especieActual.olorFilet);

        TextView txtvObservaciones = (TextView) findViewById(R.id.txtvObservaciones);
        txtvObservaciones.setText(ItemAdapter.especieActual.observaciones);

        TextView txtvUsos = (TextView) findViewById(R.id.txtvUsosIn);
        txtvUsos.setText(ItemAdapter.especieActual.usos);

        TextView txtvRecomendaciones = (TextView) findViewById(R.id.txtvRecomendacionesIn);
        txtvRecomendaciones.setText(ItemAdapter.especieActual.cuidados);

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