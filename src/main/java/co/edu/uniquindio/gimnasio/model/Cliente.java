package co.edu.uniquindio.gimnasio.model;

import java.util.ArrayList;
import java.util.List;

public class Cliente extends Usuario {
    private String correo;
    private String direccion;
    private String telefono;
    private String contraseña;
    private List <Entrenamiento> listaEntrenaiento;
    private List <Entrenamiento> listaHistorial;



    public Cliente(String nombre, String id, String correo, String direccion, String telefono, String contraseña) {
        super(nombre, id);
        this.correo = correo;
        this.direccion = direccion;
        this.telefono = telefono;
        this.contraseña = contraseña;
        listaEntrenaiento = new ArrayList<>();
        listaHistorial = new ArrayList<>();

    }

    @Override
    public String toString() {
        return "Cliente{" +
                "correo='" + correo + '\'' +
                ", direccion='" + direccion + '\'' +
                ", telefono='" + telefono + '\'' +
                ", contraseña='" + contraseña + '\'' +
                ", listaEntrenaiento=" + listaEntrenaiento +
                ", listaHistorial=" + listaHistorial +
                ", nombre='" + nombre + '\'' +
                ", id='" + id + '\'' +
                '}';
    }
}
