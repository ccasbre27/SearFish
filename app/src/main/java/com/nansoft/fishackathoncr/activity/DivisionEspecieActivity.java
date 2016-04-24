package com.nansoft.fishackathoncr.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MenuItem;

import com.nansoft.fishackathoncr.R;
import com.nansoft.fishackathoncr.adapter.EspecieAdapter;
import com.nansoft.fishackathoncr.adapter.ItemAdapter;
import com.nansoft.fishackathoncr.model.Especie;
import com.nansoft.fishackathoncr.model.Item;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class DivisionEspecieActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.fragment_general);

        // se habilita navegación home
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);



        // se obtiene el objeto enviado
        Especie especie  = (Especie) getIntent().getParcelableExtra("especie");

        // se establece el título de la activity
        setTitle(especie.nombreComun);

        // se agregan las opciones de caracerísticas externas e internas
        ArrayList<Item> lstItems = new ArrayList<>();
        lstItems.add(new Item(1,"Externo",R.drawable.extern));
        lstItems.add(new Item(2,"Interno",R.drawable.intern));

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.lstvGeneral);

        ItemAdapter adapter = new ItemAdapter(this,lstItems,especie);


        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new GridLayoutManager(this,2));






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
