package com.nansoft.fishackathoncr.activity;

import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.nansoft.fishackathoncr.R;
import com.nansoft.fishackathoncr.adapter.ItemAdapter;

import org.w3c.dom.Text;

public class ExternoEspecieActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.desc_extern_especie);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        cargarDatosExternos();
    }

    private void cargarDatosExternos()
    {
        TextView txtvNombreComun = (TextView) findViewById(R.id.txtvNombreComunEx);
        txtvNombreComun.setText(ItemAdapter.especieActual.nombreComun);

        TextView txtvNombreCientifico = (TextView) findViewById(R.id.txtvNombreCientificoEx);
        txtvNombreCientifico.setText(ItemAdapter.especieActual.nombreCientifico);

        ImageView imgvPez = (ImageView) findViewById(R.id.imgvPezEx);

        Glide.with(this)
                .load(ItemAdapter.especieActual.urlImagen.trim())
                .asBitmap()
                .fitCenter()
                .placeholder(R.drawable.image_loading)
                .error(R.drawable.image_error)
                .into(imgvPez);

        TextView txtvGrupo = (TextView) findViewById(R.id.txtvGrupoEx);
        txtvGrupo.setText(ItemAdapter.especieActual.grupo);

        TextView txtvEstadoAmenaza = (TextView) findViewById(R.id.txtvEstadoAmenazaEx);
        txtvEstadoAmenaza.setText(ItemAdapter.especieActual.categoriaUICN);

        TextView txtvCategoriaConsumo = (TextView) findViewById(R.id.txtvCategoriaConsumoEx);
        txtvCategoriaConsumo.setText(ItemAdapter.especieActual.categoriaDeConsumo);

        TextView txtvLongitud = (TextView) findViewById(R.id.txtvLongitudEx);
        txtvLongitud.setText(ItemAdapter.especieActual.tallasMinMax);

        TextView txtvHabitat = (TextView) findViewById(R.id.txtvHabitatEx);
        txtvHabitat.setText(ItemAdapter.especieActual.habitat);


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
