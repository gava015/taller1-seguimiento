package co.edu.uniquindio.gimnasio.model;

public class Entrenador extends Usuario {
    private String especialidad;

    public Entrenador(String especialidad) {
        this.especialidad = especialidad;
    }

    public Entrenador(String nombre, String id, String especialidad) {
        super(nombre, id);
        this.especialidad = especialidad;
    }

    @Override
    public String toString() {
        return "Entrenador{" +
                "especialidad='" + especialidad + '\'' +
                ", nombre='" + nombre + '\'' +
                ", id='" + id + '\'' +
                '}';
    }
}
