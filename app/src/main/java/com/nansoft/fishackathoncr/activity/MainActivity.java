package com.nansoft.fishackathoncr.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.nansoft.fishackathoncr.R;
import com.nansoft.fishackathoncr.adapter.EspecieAdapter;
import com.nansoft.fishackathoncr.fragment.ConsejosFragment;
import com.nansoft.fishackathoncr.fragment.EspecieFragment;
import com.nansoft.fishackathoncr.fragment.EtiquetadoFragment;
import com.nansoft.fishackathoncr.fragment.ReportFragment;
import com.nansoft.fishackathoncr.model.Especie;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    NavigationView navigationView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();

                // navegamos a la activity para reportar
                Intent intent = new Intent(MainActivity.this,AddReportActivity.class);
                startActivity(intent);

            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);


        Fragment fragment = new EspecieFragment();
        Bundle bundle = new Bundle();
        bundle.putInt("id",0);
        fragment.setArguments(bundle);
        FragmentManager fragmentManager = getSupportFragmentManager();

        // se cambia el fragment
        fragmentManager.beginTransaction()
                .replace(R.id.your_placeholder, fragment)
                .commit();










    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        // Handle navigation view item clicks here.

        Fragment fragment = new EspecieFragment();
        Bundle bundle = new Bundle();

        FragmentManager fragmentManager = getSupportFragmentManager();


        switch (id)
        {
            case R.id.nav_fish:
                fragment = new EspecieFragment();
                bundle.putInt("id",0);
                break;

            case R.id.nav_shark:
                fragment = new EspecieFragment();
                bundle.putInt("id",1);
                break;

            case R.id.nav_tag:
                fragment = new EtiquetadoFragment();
                break;

            case R.id.nav_help:
                fragment = new ConsejosFragment();
                break;

            case R.id.nav_form:
                fragment = new ReportFragment();
                break;
        }

        fragment.setArguments(bundle);


        // se cambia el fragment
        fragmentManager.beginTransaction()
                .replace(R.id.your_placeholder, fragment)
                .commit();

        // establece la navegación al inicio
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);

        // se resalta el item que se selecciono para que el usuario tenga noción del lugar donde está
        navigationView.getMenu().findItem(item.getItemId()).setChecked(true);



        return true;
    }
}
