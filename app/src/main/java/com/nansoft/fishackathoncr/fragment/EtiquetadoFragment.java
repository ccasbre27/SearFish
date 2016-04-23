package com.nansoft.fishackathoncr.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.nansoft.fishackathoncr.R;
import com.nansoft.fishackathoncr.adapter.EspecieAdapter;
import com.nansoft.fishackathoncr.model.Especie;

import java.util.ArrayList;

/**
 * Created by Carlos on 23/04/2016.
 */

public class EtiquetadoFragment extends Fragment
{
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        //This layout contains your list view
        View view = inflater.inflate(R.layout.normas_etiquetado, container, false);

        getActivity().setTitle(getString(R.string.etiqueta));


        return view;
    }

}
