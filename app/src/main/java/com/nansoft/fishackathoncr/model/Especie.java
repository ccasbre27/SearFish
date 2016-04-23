package com.nansoft.fishackathoncr.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Carlos on 23/04/2016.
 */
public class Especie
{
    public String id;
    public String nombreCientifico;
    public String nombreCostaRica;
    public List<Integer> lstCategorias;
    public String nombreIngles;
    public int idConsumo;
    public int idCategoriaUICN;
    public String tallaConsumo;
    public String descripcion;
    public String habitat;
    public String alimentacion;
    public String urlImagenReal;
    public List<String> urlImagenesFiletes;

    public Especie()
    {
        id = "Sin definir";
        nombreCientifico = "Sin definir";
        nombreCostaRica = "Sin definir";
        lstCategorias = new ArrayList<>();
        nombreIngles = "Sin definir";
        idConsumo = 0;
        idCategoriaUICN = 0;
        tallaConsumo = "Sin definir";
        descripcion = "";
        habitat = "";
        alimentacion = "";
        urlImagenReal = "";
        urlImagenesFiletes = new ArrayList<>();
    }
}
