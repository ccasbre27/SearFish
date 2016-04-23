package com.nansoft.fishackathoncr.fragment;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
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
import java.util.List;

/**
 * Created by Carlos on 23/04/2016.
 */
public class EspecieFragment extends Fragment
{
    SwipeRefreshLayout mSwipeRefreshLayout;
    EspecieAdapter adapter;
    ImageView imgvSad;
    TextView txtvSad;
    List<Especie> lstEspecies;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        //This layout contains your list view
        View view = inflater.inflate(R.layout.fragment_general, container, false);

        getActivity().setTitle(getString(R.string.peces));

        // se obtiene el id para saber si se deben cargar peces o tiburones
        Bundle bundle = getArguments();
        final int ID = bundle.getInt("id");

        lstEspecies = new ArrayList<Especie>();

        View includedLayout = view.findViewById(R.id.sindatos);
        imgvSad = (ImageView) includedLayout.findViewById(R.id.imgvInfoProblema);
        txtvSad = (TextView) includedLayout.findViewById(R.id.txtvInfoProblema);

        txtvSad.setText(getResources().getString(R.string.noconnection));

        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.lstvGeneral);

        adapter = new EspecieAdapter(view.getContext());


        recyclerView.setAdapter(adapter);
        //recyclerView.setLayoutManager(new GridLayoutManager(view.getContext(),2));
        recyclerView.setLayoutManager(new LinearLayoutManager(view.getContext()));
        mSwipeRefreshLayout = (SwipeRefreshLayout) view.findViewById(R.id.swprlGeneral);
        mSwipeRefreshLayout.setColorSchemeResources(R.color.colorPrimaryDark);


        mSwipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                cargarAreas(getActivity(),ID);
            }
        });
        mSwipeRefreshLayout.post(new Runnable() {
            @Override
            public void run() {
                mSwipeRefreshLayout.setRefreshing(true);
            }
        });




        cargarAreas(getActivity(),ID);
        return view;
    }

    public void cargarAreas(final FragmentActivity activity, int id) {
        /*
        estadoAdapter(false);
        mSwipeRefreshLayout.setEnabled(false);
        new AsyncTask<Void, Void, Boolean>() {

            MobileServiceClient mClient;
            MobileServiceTable<Area> mAreaTable;

            @Override
            protected void onPreExecute()
            {
                try {

                    mClient = new MobileServiceClient(
                            "https://msprojectnetworkjs.azure-mobile.net/",
                            "gSewfUQpGFAVMRajseDOZwqCCRUwwD62",
                            activity.getApplicationContext()
                    );

                } catch (MalformedURLException e) {

                }
                mAreaTable = mClient.getTable("Area",Area.class);
            }

            @Override
            protected Boolean doInBackground(Void... params) {
                try {
                    areasList = mAreaTable.orderBy("nombre", QueryOrder.Ascending).execute().get();

                    adapter.setData(areasList);

                    activity.runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            adapter.notifyDataSetChanged();
                        }
                    });



                    return true;
                } catch (Exception exception) {

                }
                return false;
            }

            @Override
            protected void onPostExecute(Boolean success)
            {

                mSwipeRefreshLayout.setRefreshing(false);

                estadoAdapter(success);
                mSwipeRefreshLayout.setEnabled(true);
            }

            @Override
            protected void onCancelled()
            {
                super.onCancelled();
            }
        }.execute();
        */

        Especie especie = new Especie();


        especie.nombreCostaRica = id == 0 ? "A" : "B";
        especie.urlImagenReal = "http://www.mascotasyplantas.com/images/2010/10/tiburon-martillo1.jpg";
        for (int i = 0; i < 10; i++) {
            lstEspecies.add(especie);
        }

        adapter.setEspecies(lstEspecies);
        adapter.notifyDataSetChanged();

        mSwipeRefreshLayout.post(new Runnable() {
            @Override
            public void run() {
                mSwipeRefreshLayout.setRefreshing(false);
            }
        });
    }

    private void estadoAdapter(boolean pEstadoError)
    {
        if(lstEspecies.isEmpty() && pEstadoError)
        {
            imgvSad.setVisibility(View.VISIBLE);
            txtvSad.setVisibility(View.VISIBLE);

        }
        else
        {
            imgvSad.setVisibility(View.INVISIBLE);
            txtvSad.setVisibility(View.INVISIBLE);
        }
    }


}

