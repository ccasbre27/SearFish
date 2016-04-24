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
import com.nansoft.fishackathoncr.activity.DivisionEspecieActivity;
import com.nansoft.fishackathoncr.activity.ExternoEspecieActivity;
import com.nansoft.fishackathoncr.activity.InternoEspecieActivity;
import com.nansoft.fishackathoncr.model.Especie;
import com.nansoft.fishackathoncr.model.Item;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Carlos on 23/04/2016.
 */
public class ItemSugeridosAdapter extends
        RecyclerView.Adapter<ItemSugeridosAdapter.ViewHolder>
{

    // Store a member variable for the contacts
    private List<Especie> lstItems;
    private static Especie especieActual;

    private Context context;

    public ItemSugeridosAdapter(Context pContext, ArrayList<Especie> plstItems, Especie pEspecie)
    {
        context = pContext;
        lstItems = plstItems;
        especieActual = pEspecie;

    }

    // Usually involves inflating a layout from XML and returning the holder
    @Override
    public ItemSugeridosAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
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
    public void onBindViewHolder(ItemSugeridosAdapter.ViewHolder viewHolder, int position) {
        // Get the data model based on position
        final Especie item = lstItems.get(position);

        // Set item views based on the data model
        TextView textView = viewHolder.txtvTitulo;
        textView.setText(item.nombreComun);

        //viewHolder.imgvIcon.setImageResource(item.urlImagen);


        Glide.with(context)
                .load(item.urlImagen.trim())
                .asBitmap()
                .fitCenter()
                .placeholder(R.drawable.image_loading)
                .error(R.drawable.image_error)
                .into(viewHolder.imgvIcon);

        viewHolder.imgvIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(context, DivisionEspecieActivity.class) ;
                intent.putExtra("especie",item);
                context.startActivity(intent);
            }
        });
    }

    // Return the total count of items
    @Override
    public int getItemCount() {
        return lstItems.size();
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

