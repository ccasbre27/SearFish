package com.nansoft.fishackathoncr.model;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Carlos on 23/04/2016.
 */
public class Comentario implements Parcelable {
    public String id;
    public String nombreUsuario;
    public String descripcion;
    public int urlImagenUsuario;
    public String hora;

    public Comentario(String id, String nombreUsuario, String descripcion, int urlImagenUsuario, String hora) {
        this.id = id;
        this.nombreUsuario = nombreUsuario;
        this.descripcion = descripcion;
        this.urlImagenUsuario = urlImagenUsuario;
        this.hora = hora;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.id);
        dest.writeString(this.nombreUsuario);
        dest.writeString(this.descripcion);
        dest.writeInt(this.urlImagenUsuario);
        dest.writeString(this.hora);
    }

    protected Comentario(Parcel in) {
        this.id = in.readString();
        this.nombreUsuario = in.readString();
        this.descripcion = in.readString();
        this.urlImagenUsuario = in.readInt();
        this.hora = in.readString();
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
