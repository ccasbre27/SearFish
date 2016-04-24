package com.nansoft.fishackathoncr.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.nansoft.fishackathoncr.R;
import com.nansoft.fishackathoncr.helper.CircularImageView;
import com.nansoft.fishackathoncr.model.Comentario;
import com.nansoft.fishackathoncr.model.Especie;

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
    private Context context;

    public ComentarioAdapter(Context pContext, ArrayList<Comentario> plstItems)
    {
        context = pContext;
        lstItems = plstItems;
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
        viewHolder.txtvTituloPregunta.setText(item.nombreUsuarioPregunta);
        viewHolder.txtvDescripcionPregunta.setText(item.descripcionPregunta);

        viewHolder.imgvIconPregunta.setImageResource(item.urlImagenUsuarioPregunta);




    }

    // Return the total count of items
    @Override
    public int getItemCount() {
        return lstItems.size();
    }


    static class ViewHolder extends RecyclerView.ViewHolder
    {
        public TextView txtvTituloPregunta;
        public TextView txtvHoraPregunta;
        public TextView txtvDescripcionPregunta;
        public CircularImageView imgvIconPregunta;


        public ViewHolder(View view)
        {
            super(view);

            imgvIconPregunta = (CircularImageView) view.findViewById(R.id.imgvLogoUsuario_comment);
            txtvTituloPregunta = (TextView) view.findViewById(R.id.txtvNombreUsuario_comment);
            txtvHoraPregunta = (TextView) view.findViewById(R.id.txtvFecha_comment);
            txtvDescripcionPregunta = (TextView) view.findViewById(R.id.txtvDescripcion_comment);



        }
    }

}
