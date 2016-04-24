package com.nansoft.fishackathoncr.model;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Carlos on 23/04/2016.
 */
public class Comentario implements Parcelable {

    public String id;
    public String nombreUsuarioPregunta;
    public String descripcionPregunta;
    public int urlImagenUsuarioPregunta;
    public String horaPregunta;

    public String nombreUsuarioRespuesta;
    public String descripcionRespuesta;
    public int urlImagenUsuarioRespuesta;
    public String horaRespuesta;

    public Comentario(String id, String nombreUsuarioPregunta, String descripcionPregunta, int urlImagenUsuarioPregunta, String horaPregunta, String nombreUsuarioRespuesta, String descripcionRespuesta, int urlImagenUsuarioRespuesta, String horaRespuesta) {
        this.id = id;
        this.nombreUsuarioPregunta = nombreUsuarioPregunta;
        this.descripcionPregunta = descripcionPregunta;
        this.urlImagenUsuarioPregunta = urlImagenUsuarioPregunta;
        this.horaPregunta = horaPregunta;
        this.nombreUsuarioRespuesta = nombreUsuarioRespuesta;
        this.descripcionRespuesta = descripcionRespuesta;
        this.urlImagenUsuarioRespuesta = urlImagenUsuarioRespuesta;
        this.horaRespuesta = horaRespuesta;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.id);
        dest.writeString(this.nombreUsuarioPregunta);
        dest.writeString(this.descripcionPregunta);
        dest.writeInt(this.urlImagenUsuarioPregunta);
        dest.writeString(this.horaPregunta);
        dest.writeString(this.nombreUsuarioRespuesta);
        dest.writeString(this.descripcionRespuesta);
        dest.writeInt(this.urlImagenUsuarioRespuesta);
        dest.writeString(this.horaRespuesta);
    }

    protected Comentario(Parcel in) {
        this.id = in.readString();
        this.nombreUsuarioPregunta = in.readString();
        this.descripcionPregunta = in.readString();
        this.urlImagenUsuarioPregunta = in.readInt();
        this.horaPregunta = in.readString();
        this.nombreUsuarioRespuesta = in.readString();
        this.descripcionRespuesta = in.readString();
        this.urlImagenUsuarioRespuesta = in.readInt();
        this.horaRespuesta = in.readString();
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
