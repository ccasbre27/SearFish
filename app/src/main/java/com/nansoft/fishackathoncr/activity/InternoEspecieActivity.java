package com.nansoft.fishackathoncr.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.MenuItem;

import com.nansoft.fishackathoncr.R;
import com.nansoft.fishackathoncr.adapter.ItemAdapter;
import com.nansoft.fishackathoncr.adapter.ItemSugeridosAdapter;
import com.nansoft.fishackathoncr.model.Especie;
import com.nansoft.fishackathoncr.model.Item;

import java.util.ArrayList;

public class InternoEspecieActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.desc_intern_especie);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

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