package co.edu.uniquindio.gimnasio.model;

import co.edu.uniquindio.gimnasio.Enum.TipoEntrenamiento;

import java.time.LocalDate;

public class Entrenamiento {
    private TipoEntrenamiento tipoEntrenamiento;
    private int duracionEntrenamiento;
    private int id;
    private int Kcalorias;
    private LocalDate fecha;


    public Entrenamiento(TipoEntrenamiento tipoEntrenamiento, int duracionEntrenamiento, int kcalorias) {
    }

    public Entrenamiento(TipoEntrenamiento tipoEntrenamiento, int duracionEntrenamiento, int id, int kcalorias, LocalDate fecha) {
        this.tipoEntrenamiento = tipoEntrenamiento;
        this.duracionEntrenamiento = duracionEntrenamiento;
        this.id = id;
        Kcalorias = kcalorias;
        this.fecha = fecha;

    }

    public void setTipoEntrenamiento(TipoEntrenamiento tipoEntrenamiento) {
        this.tipoEntrenamiento = tipoEntrenamiento;
    }

    public void setDuracionEntrenamiento(int duracionEntrenamiento) {
        this.duracionEntrenamiento = duracionEntrenamiento;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setKcalorias(int kcalorias) {
        Kcalorias = kcalorias;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    @Override
    public String toString() {
        return "Entrenamiento{" +
                "tipoEntrenamiento=" + tipoEntrenamiento +
                ", duracionEntrenamiento=" + duracionEntrenamiento +
                ", id=" + id +
                ", Kcalorias=" + Kcalorias +
                ", fecha=" + fecha +
                '}';
    }
}
