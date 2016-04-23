package com.nansoft.fishackathoncr.model;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Carlos on 23/04/2016.
 */
public class Especie implements Parcelable {
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


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.id);
        dest.writeString(this.nombreCientifico);
        dest.writeString(this.nombreCostaRica);
        dest.writeList(this.lstCategorias);
        dest.writeString(this.nombreIngles);
        dest.writeInt(this.idConsumo);
        dest.writeInt(this.idCategoriaUICN);
        dest.writeString(this.tallaConsumo);
        dest.writeString(this.descripcion);
        dest.writeString(this.habitat);
        dest.writeString(this.alimentacion);
        dest.writeString(this.urlImagenReal);
        dest.writeStringList(this.urlImagenesFiletes);
    }

    protected Especie(Parcel in) {
        this.id = in.readString();
        this.nombreCientifico = in.readString();
        this.nombreCostaRica = in.readString();
        this.lstCategorias = new ArrayList<Integer>();
        in.readList(this.lstCategorias, Integer.class.getClassLoader());
        this.nombreIngles = in.readString();
        this.idConsumo = in.readInt();
        this.idCategoriaUICN = in.readInt();
        this.tallaConsumo = in.readString();
        this.descripcion = in.readString();
        this.habitat = in.readString();
        this.alimentacion = in.readString();
        this.urlImagenReal = in.readString();
        this.urlImagenesFiletes = in.createStringArrayList();
    }

    public static final Parcelable.Creator<Especie> CREATOR = new Parcelable.Creator<Especie>() {
        @Override
        public Especie createFromParcel(Parcel source) {
            return new Especie(source);
        }

        @Override
        public Especie[] newArray(int size) {
            return new Especie[size];
        }
    };
}
