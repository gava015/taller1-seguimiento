package co.edu.uniquindio.gimnasio.model;

import java.time.LocalDate;

public class Inscripcion {
    private int id;
    private Cliente cliente;
    private LocalDate fechaRegistro;

    public Inscripcion() {
    }

    public Inscripcion(int id, Cliente cliente, LocalDate fechaRegistro) {
        this.id = id;
        this.cliente = cliente;
        this.fechaRegistro = fechaRegistro;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public LocalDate getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(LocalDate fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    @Override
    public String toString() {
        return "Inscripcion{" +
                "id=" + id +
                ", cliente=" + cliente +
                ", fechaRegistro=" + fechaRegistro +
                '}';
    }
}
