package com.nansoft.fishackathoncr.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.nansoft.fishackathoncr.R;

/**
 * Created by Carlos on 23/04/2016.
 */
public class EspecieAdapter
{



    static class EspecieViewHolder extends RecyclerView.ViewHolder
    {
        public TextView txtvTitulo;
        public TextView txtvSubtitulo;
        public TextView txtvFecha;
        public ImageView imgvLogoUsuario;

        public EspecieViewHolder(View view)
        {
            super(view);

            imgvLogoUsuario = (ImageView) view.findViewById(R.id.imgvCategoria);
            txtvTitulo = (TextView) view.findViewById(R.id.txtvTituloCategoria);
        }
    }

}
