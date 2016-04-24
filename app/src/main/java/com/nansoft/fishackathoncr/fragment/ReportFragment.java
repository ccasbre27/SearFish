package com.nansoft.fishackathoncr.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.nansoft.fishackathoncr.R;
import com.nansoft.fishackathoncr.adapter.ComentarioAdapter;
import com.nansoft.fishackathoncr.adapter.EspecieAdapter;
import com.nansoft.fishackathoncr.model.Comentario;
import com.nansoft.fishackathoncr.model.Especie;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Carlos on 23/04/2016.
 */
public class ReportFragment extends Fragment
{

    ComentarioAdapter adapter;
    ArrayList<Comentario> lstComentarios;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        //This layout contains your list view
        View view = inflater.inflate(R.layout.fragment_general, container, false);

        getActivity().setTitle(getString(R.string.reporte));

        lstComentarios = new ArrayList<>();
        lstComentarios.add(new Comentario("1","Juan Perez","Mi super descripción",R.drawable.bruce,"Hace 1 hora","Carlos Castro","Mi otra descripción",R.drawable.pez,"Hace 1 minuto"));

        adapter = new ComentarioAdapter(view.getContext(),lstComentarios);

        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.lstvGeneral);

        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(view.getContext()));


        return view;
    }

}

