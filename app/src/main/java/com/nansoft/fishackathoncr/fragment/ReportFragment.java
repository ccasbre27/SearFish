package com.nansoft.fishackathoncr.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.nansoft.fishackathoncr.R;

/**
 * Created by Carlos on 23/04/2016.
 */
public class ReportFragment extends Fragment
{
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        //This layout contains your list view
        View view = inflater.inflate(R.layout.fragment_report, container, false);

        getActivity().setTitle(getString(R.string.etiqueta));


        return view;
    }

}

