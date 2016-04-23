package com.nansoft.fishackathoncr.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.nansoft.fishackathoncr.R;
import com.nansoft.fishackathoncr.model.Especie;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Carlos on 23/04/2016.
 */
public class EspecieAdapter extends
        RecyclerView.Adapter<EspecieAdapter.ViewHolder>
{

    // Store a member variable for the contacts
    private List<Especie> lstEspecies;

    private Context context;

    public EspecieAdapter(Context pContext)
    {
        context = pContext;
        lstEspecies = new ArrayList<>();
    }

    // Usually involves inflating a layout from XML and returning the holder
    @Override
    public EspecieAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        // Inflate the custom layout
        View contactView = inflater.inflate(R.layout.item_categoria, parent, false);

        // Return a new holder instance
        ViewHolder viewHolder = new ViewHolder(contactView);
        return viewHolder;
    }

    // Involves populating data into the item through holder
    @Override
    public void onBindViewHolder(EspecieAdapter.ViewHolder viewHolder, int position) {
        // Get the data model based on position
        Especie especie = lstEspecies.get(position);

        // Set item views based on the data model
        TextView textView = viewHolder.txtvTitulo;
        textView.setText(especie.nombreCostaRica);


        Glide.with(context)
                .load(especie.urlImagenReal.trim())
                .asBitmap()
                .fitCenter()
                .placeholder(R.drawable.image_loading)
                .error(R.drawable.image_error)
                .into(viewHolder.imgvIcon);
    }

    // Return the total count of items
    @Override
    public int getItemCount() {
        return lstEspecies.size();
    }

    public void setEspecies(List<Especie> pLstEspecies)
    {
        lstEspecies = pLstEspecies;
    }

    static class ViewHolder extends RecyclerView.ViewHolder
    {
        public TextView txtvTitulo;
        public ImageView imgvIcon;

        public ViewHolder(View view)
        {
            super(view);

            imgvIcon = (ImageView) view.findViewById(R.id.imgvCategoria);
            txtvTitulo = (TextView) view.findViewById(R.id.txtvTituloCategoria);
        }
    }

}
