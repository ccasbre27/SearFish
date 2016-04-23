package com.nansoft.fishackathoncr.model;

/**
 * Created by Carlos on 23/04/2016.
 */
public class Item
{
    public int id;
    public String nombre;
    public int urlImagen;

    public Item(int id, String nombre, int urlImagen) {
        this.id = id;
        this.nombre = nombre;
        this.urlImagen = urlImagen;
    }
}
