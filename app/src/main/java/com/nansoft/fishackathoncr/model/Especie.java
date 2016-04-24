package com.nansoft.fishackathoncr.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Carlos on 23/04/2016.
 */
public class Especie implements Parcelable {

    @SerializedName("id")
    public int id;

    @SerializedName("Nombrecientifico")
    public String nombreCientifico;

    @SerializedName("Grupo")
    public String grupo;

    @SerializedName("CategoríaDeConsumo")
    public String categoriaDeConsumo;

    @SerializedName("CategoríaUICN")
    public String categoriaUICN;

    @SerializedName("Habitat")
    public String habitat;

    @SerializedName("LongitudFilet")
    public String longitudFilet;

    @SerializedName("PesoFilet")
    public String pesoFilet;

    @SerializedName("ColorFilet")
    public String colorFilet;

    @SerializedName("OlorFilet")
    public String olorFilet;

    @SerializedName("Observaciones")
    public String observaciones;

    @SerializedName("Usos")
    public String usos;

    @SerializedName("cuidados")
    public String cuidados;

    @SerializedName("PosiblesFraudes")
    public String posiblesFraudes;

    @SerializedName("NombreComun")
    public String nombreComun;

    @SerializedName("ModoCaptura")
    public String modoCaptura;

    @SerializedName("TallasMinMax")
    public String tallasMinMax;

    @SerializedName("urlimagen")
    public String urlImagen;

    @SerializedName("urlimagenfilet")
    public String urlImagenFilet;

    @SerializedName("idtipoespecie")
    public int idTipoEspecie;

    public List<Especie> lstPosiblesFraudes;

    public List<Especie> lstSimilares;


    public Especie() {
        nombreCientifico = "Sin definir";
        grupo = "Sin definir";
        categoriaDeConsumo = "Sin definir";
        categoriaUICN = "Sin definir";
        habitat = "Sin definir";
        longitudFilet = "Sin definir";
        pesoFilet = "Sin definir";
        colorFilet = "Sin definir";
        olorFilet = "Sin definir";
        observaciones = "Sin definir";
        usos = "Sin definir";
        cuidados = "Sin definir";
        posiblesFraudes = "Sin definir";
        nombreComun = "Sin definir";
        modoCaptura = "Sin definir";
        tallasMinMax = "Sin definir";
        urlImagenFilet = "Sin definir";
        lstPosiblesFraudes = new ArrayList<>();
        lstSimilares = new ArrayList<>();
        urlImagen = "Sin definir";
        urlImagenFilet = "Sin definir";
        idTipoEspecie = 0;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.id);
        dest.writeString(this.nombreCientifico);
        dest.writeString(this.grupo);
        dest.writeString(this.categoriaDeConsumo);
        dest.writeString(this.categoriaUICN);
        dest.writeString(this.habitat);
        dest.writeString(this.longitudFilet);
        dest.writeString(this.pesoFilet);
        dest.writeString(this.colorFilet);
        dest.writeString(this.olorFilet);
        dest.writeString(this.observaciones);
        dest.writeString(this.usos);
        dest.writeString(this.cuidados);
        dest.writeString(this.posiblesFraudes);
        dest.writeString(this.nombreComun);
        dest.writeString(this.modoCaptura);
        dest.writeString(this.tallasMinMax);
        dest.writeString(this.urlImagen);
        dest.writeString(this.urlImagenFilet);
        dest.writeTypedList(lstPosiblesFraudes);
        dest.writeTypedList(lstSimilares);
        dest.writeInt(this.idTipoEspecie);
    }

    protected Especie(Parcel in) {
        this.id = in.readInt();
        this.nombreCientifico = in.readString();
        this.grupo = in.readString();
        this.categoriaDeConsumo = in.readString();
        this.categoriaUICN = in.readString();
        this.habitat = in.readString();
        this.longitudFilet = in.readString();
        this.pesoFilet = in.readString();
        this.colorFilet = in.readString();
        this.olorFilet = in.readString();
        this.observaciones = in.readString();
        this.usos = in.readString();
        this.cuidados = in.readString();
        this.posiblesFraudes = in.readString();
        this.nombreComun = in.readString();
        this.modoCaptura = in.readString();
        this.tallasMinMax = in.readString();
        this.urlImagen = in.readString();
        this.urlImagenFilet = in.readString();
        this.lstPosiblesFraudes = in.createTypedArrayList(Especie.CREATOR);
        this.lstSimilares = in.createTypedArrayList(Especie.CREATOR);
        this.idTipoEspecie = in.readInt();
    }

    public static final Creator<Especie> CREATOR = new Creator<Especie>() {
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
