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
        ArrayList<Item> lstItems = new ArrayList<>();
        lstItems.add(new Item(1,"Externo",R.drawable.extern));
        lstItems.add(new Item(2,"Interno",R.drawable.intern));
        lstItems.add(new Item(2,"Interno",R.drawable.intern));
        lstItems.add(new Item(2,"Interno",R.drawable.intern));
        lstItems.add(new Item(2,"Interno",R.drawable.intern));
        lstItems.add(new Item(2,"Interno",R.drawable.intern));


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