package com.nansoft.fishackathoncr.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;
import com.nansoft.fishackathoncr.R;

/**
 * Created by Carlos on 23/04/2016.
 */
public class Comentario implements Parcelable {

    @SerializedName("id")
    public int id;

    @SerializedName("NombreCompleto")
    public String nombreUsuarioPregunta;

    @SerializedName("Descripcion")
    public String descripcionPregunta;

    @SerializedName("urlImagen")
    public int urlImagenUsuarioPregunta;

    @SerializedName("hora")
    public String horaPregunta;

    @SerializedName("Email")
    public String email;




    public Comentario(int id, String nombreUsuarioPregunta, String descripcionPregunta, int urlImagenUsuarioPregunta, String horaPregunta){
        this.id = id;
        this.nombreUsuarioPregunta = nombreUsuarioPregunta;
        this.descripcionPregunta = descripcionPregunta;
        this.urlImagenUsuarioPregunta = urlImagenUsuarioPregunta;
        this.horaPregunta = horaPregunta;
    }

    public Comentario() {
        this.nombreUsuarioPregunta = "Sin definir";
        this.descripcionPregunta = "Sin definir";
        this.urlImagenUsuarioPregunta = R.drawable.bruce;
        this.horaPregunta = "Sin definir";
        email = "Sin definir";
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.id);
        dest.writeString(this.nombreUsuarioPregunta);
        dest.writeString(this.descripcionPregunta);
        dest.writeInt(this.urlImagenUsuarioPregunta);
        dest.writeString(this.horaPregunta);
    }

    protected Comentario(Parcel in) {
        this.id = in.readInt();
        this.nombreUsuarioPregunta = in.readString();
        this.descripcionPregunta = in.readString();
        this.urlImagenUsuarioPregunta = in.readInt();
        this.horaPregunta = in.readString();
    }

    public static final Parcelable.Creator<Comentario> CREATOR = new Parcelable.Creator<Comentario>() {
        @Override
        public Comentario createFromParcel(Parcel source) {
            return new Comentario(source);
        }

        @Override
        public Comentario[] newArray(int size) {
            return new Comentario[size];
        }
    };
}
