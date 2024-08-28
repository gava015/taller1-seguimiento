package co.edu.uniquindio.gimnasio.model;

import java.util.ArrayList;
import java.util.List;

public class Cliente extends Usuario {
    private String correo;
    private String direccion;
    private String telefono;
    private String contrasenia;
    private List <Entrenamiento> listaEntrenaiento;
    private List <Entrenamiento> listaHistorial;




    public Cliente(String nombre, String id, String correo, String direccion, String telefono, String contrasenia) {
        super(nombre, id);
        this.correo = correo;
        this.direccion = direccion;
        this.telefono = telefono;
        this.contrasenia = contrasenia;
        listaEntrenaiento = new ArrayList<>();
        listaHistorial = new ArrayList<>();

    }


    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getContrasenia() {
        return contrasenia;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }

    public List<Entrenamiento> getListaEntrenaiento() {
        return listaEntrenaiento;
    }

    public void setListaEntrenaiento(List<Entrenamiento> listaEntrenaiento) {
        this.listaEntrenaiento = listaEntrenaiento;
    }

    public List<Entrenamiento> getListaHistorial() {
        return listaHistorial;
    }

    public void setListaHistorial(List<Entrenamiento> listaHistorial) {
        this.listaHistorial = listaHistorial;
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "correo='" + correo + '\'' +
                ", direccion='" + direccion + '\'' +
                ", telefono='" + telefono + '\'' +
                ", contraseña='" + contrasenia+ '\'' +
                ", listaEntrenaiento=" + listaEntrenaiento +
                ", listaHistorial=" + listaHistorial +
                ", nombre='" + nombre + '\'' +
                ", id='" + id + '\'' +
                '}';
    }
}
