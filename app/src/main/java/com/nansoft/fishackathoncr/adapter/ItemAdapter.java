package com.nansoft.fishackathoncr.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.nansoft.fishackathoncr.R;
import com.nansoft.fishackathoncr.activity.ExternoEspecieActivity;
import com.nansoft.fishackathoncr.activity.InternoEspecieActivity;
import com.nansoft.fishackathoncr.model.Especie;
import com.nansoft.fishackathoncr.model.Item;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Carlos on 23/04/2016.
 */
public class ItemAdapter extends
        RecyclerView.Adapter<ItemAdapter.ViewHolder>
{

    // Store a member variable for the contacts
    private List<Item> lstItems;
    public static Especie especieActual;

    private Context context;

    public ItemAdapter(Context pContext,ArrayList<Item> plstItems,Especie pEspecie)
    {
        context = pContext;
        lstItems = plstItems;
        especieActual = pEspecie;

    }

    // Usually involves inflating a layout from XML and returning the holder
    @Override
    public ItemAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        // Inflate the custom layout
        View contactView = inflater.inflate(R.layout.item, parent, false);

        // Return a new holder instance
        ViewHolder viewHolder = new ViewHolder(contactView);
        return viewHolder;
    }

    // Involves populating data into the item through holder
    @Override
    public void onBindViewHolder(ItemAdapter.ViewHolder viewHolder, int position) {
        // Get the data model based on position
        final Item item = lstItems.get(position);

        // Set item views based on the data model
        TextView textView = viewHolder.txtvTitulo;
        textView.setText(item.nombre);

        viewHolder.imgvIcon.setImageResource(item.urlImagen);

        viewHolder.imgvIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = item.id == 1 ?  new Intent(context, ExternoEspecieActivity.class) :  new Intent(context, InternoEspecieActivity.class);;
                intent.putExtra("especie",especieActual);
                context.startActivity(intent);
            }
        });
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
        public ImageView imgvIcon;

        public ViewHolder(View view)
        {
            super(view);

            imgvIcon = (ImageView) view.findViewById(R.id.imgvItem);
            txtvTitulo = (TextView) view.findViewById(R.id.txtvTituloItem);
        }
    }

}
