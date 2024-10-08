package co.edu.uniquindio.gimnasio.model;

import co.edu.uniquindio.gimnasio.Enum.EstadoDisponibilidad;
import co.edu.uniquindio.gimnasio.Enum.TipoClase;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Clase {
    private String claseId;
    private String nombre;
    private String horario;
    private int capacidad;
    private LocalDate fechaInicio;
    private LocalDate fechaFin;
    private EstadoDisponibilidad estadoDisponibilidad;
    private TipoClase tipoClase;
    private Entrenador entrenador;
    private List <Inscripcion> listaInscritos;

    public Clase() {
    }

    public Clase(String claseId, String nombre, String horario, int capacidad, LocalDate fechaInicio, LocalDate fechaFin,
                 EstadoDisponibilidad estadoDisponibilidad, TipoClase tipoClase, Entrenador entrenador) {
        this.claseId = claseId;
        this.nombre = nombre;
        this.horario = horario;
        this.capacidad = capacidad;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.estadoDisponibilidad = estadoDisponibilidad;
        this.tipoClase = tipoClase;
        this.entrenador = entrenador;
        listaInscritos = new ArrayList<>();
    }

    public String getClaseId() {
        return claseId;
    }

    public void setClaseId(String claseId) {
        this.claseId = claseId;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }

    public LocalDate getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(LocalDate fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public LocalDate getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(LocalDate fechaFin) {
        this.fechaFin = fechaFin;
    }

    public EstadoDisponibilidad getEstadoDisponibilidad() {
        return estadoDisponibilidad;
    }

    public void setEstadoDisponibilidad(EstadoDisponibilidad estadoDisponibilidad) {
        this.estadoDisponibilidad = estadoDisponibilidad;
    }

    public TipoClase getTipoClase() {
        return tipoClase;
    }

    public void setTipoClase(TipoClase tipoClase) {
        this.tipoClase = tipoClase;
    }

    public Entrenador getEntrenador() {
        return entrenador;
    }

    public void setEntrenador(Entrenador entrenador) {
        this.entrenador = entrenador;
    }

    public List<Inscripcion> getListaInscritos() {
        return listaInscritos;
    }

    public void setListaInscritos(List<Inscripcion> listaInscritos) {
        this.listaInscritos = listaInscritos;
    }


    public void sincronizarDisponibilidad(){
        if(this.getListaInscritos().size() == this.getCapacidad()) {
            setEstadoDisponibilidad(EstadoDisponibilidad.NO_DISPONIBLE);
        }else{
            setEstadoDisponibilidad(EstadoDisponibilidad.DISPONIBLE);
        }
    }


    @Override
    public String toString() {
        return "Clase{" +
                "claseId='" + claseId + '\'' +
                ", nombre='" + nombre + '\'' +
                ", horario='" + horario + '\'' +
                ", capacidad=" + capacidad +
                ", fechaInicio=" + fechaInicio +
                ", fechaFin=" + fechaFin +
                ", estadoDisponibilidad=" + estadoDisponibilidad +
                ", tipoClase=" + tipoClase +
                ", entrenador=" + entrenador +
                ", listaInscritos=" + listaInscritos +
                '}';
    }
}

