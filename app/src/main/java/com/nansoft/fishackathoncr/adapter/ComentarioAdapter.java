package com.nansoft.fishackathoncr.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.nansoft.fishackathoncr.R;
import com.nansoft.fishackathoncr.activity.ExternoEspecieActivity;
import com.nansoft.fishackathoncr.activity.InternoEspecieActivity;
import com.nansoft.fishackathoncr.helper.CircularImageView;
import com.nansoft.fishackathoncr.model.Comentario;
import com.nansoft.fishackathoncr.model.Especie;
import com.nansoft.fishackathoncr.model.Item;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Carlos on 23/04/2016.
 */
public class ComentarioAdapter extends
        RecyclerView.Adapter<ComentarioAdapter.ViewHolder>
{

    // Store a member variable for the contacts
    private List<Comentario> lstItems;
    private static Especie especieActual;

    private Context context;

    public ComentarioAdapter(Context pContext, ArrayList<Comentario> plstItems, Especie pEspecie)
    {
        context = pContext;
        lstItems = plstItems;
        especieActual = pEspecie;

    }

    // Usually involves inflating a layout from XML and returning the holder
    @Override
    public ComentarioAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        // Inflate the custom layout
        View contactView = inflater.inflate(R.layout.item_comentario, parent, false);

        // Return a new holder instance
        ViewHolder viewHolder = new ViewHolder(contactView);
        return viewHolder;
    }

    // Involves populating data into the item through holder
    @Override
    public void onBindViewHolder(ComentarioAdapter.ViewHolder viewHolder, int position) {
        // Get the data model based on position
        final Comentario item = lstItems.get(position);

        // Set item views based on the data model
        viewHolder.txtvTitulo.setText(item.nombreUsuario);
        viewHolder.txtvDescripcion.setText(item.descripcion);

        viewHolder.imgvIcon.setImageResource(item.urlImagenUsuario);

    
    }

    // Return the total count of items
    @Override
    public int getItemCount() {
        return lstItems.size();
    }

    public Especie getEspecieActual()
    {
        return especieActual;
    }

    static class ViewHolder extends RecyclerView.ViewHolder
    {
        public TextView txtvTitulo;
        public TextView txtvDescripcion;
        public CircularImageView imgvIcon;

        public ViewHolder(View view)
        {
            super(view);

            imgvIcon = (CircularImageView) view.findViewById(R.id.imgvLogoUsuario_comment);
            txtvTitulo = (TextView) view.findViewById(R.id.txtvNombreUsuario_comment);
            txtvDescripcion = (TextView) view.findViewById(R.id.txtvDescripcion_comment);
        }
    }

}