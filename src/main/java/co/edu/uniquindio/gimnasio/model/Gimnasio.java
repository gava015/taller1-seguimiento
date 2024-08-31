package co.edu.uniquindio.gimnasio.model;

import co.edu.uniquindio.gimnasio.Enum.EstadoDisponibilidad;
import co.edu.uniquindio.gimnasio.Enum.TipoClase;
import co.edu.uniquindio.gimnasio.Enum.TipoEntrenamiento;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


public class Gimnasio {
    private String nombre;
    private String direccion;
    private List<Cliente> listaClientes;
    private List<Entrenador> listaEntrenadores;
    private List<Clase> listaClases;

    public Gimnasio(String nombre, String direccion) {
        this.nombre = nombre;
        this.direccion = direccion;
        listaClientes = new ArrayList<>();
        this.listaEntrenadores = new ArrayList<>();
        this.listaClases = new ArrayList<>();
    }

    //CRUD CLIENTE
    public Cliente crearCliente(String nombre, String id, String correo, String direccion, String telefono, String contrasenia) throws Exception {
        Cliente cliente = obtenerCliente(id);
        if (cliente == null) {
            cliente = new Cliente(nombre, id, correo, direccion, telefono, contrasenia);
            listaClientes.add(cliente);
            return cliente;
        }

        return null;
    }

    public Cliente obtenerCliente(String id) throws Exception {
        if(id.equals("")){
            throw new Exception("El id del cliente no puede ser vacío");
        }

        for (Cliente cliente : listaClientes) {
            if (cliente.getId().equalsIgnoreCase(id)) {
                return cliente;
            }
        }
        return null;
    }


    public boolean actualizarCliente(String id, String nombre, String correo, String contrasenia) throws Exception {
        Cliente clienteActualizar = obtenerCliente(id);
        if (clienteActualizar != null) {
            clienteActualizar.setNombre(nombre);
            clienteActualizar.setCorreo(correo);
            clienteActualizar.setContrasenia(contrasenia);
            return true;

        }
        return false;
    }

    public boolean eliminarCliente(String id) throws Exception {
        Cliente clienteEliminado = obtenerCliente(id);
        if (clienteEliminado != null) {
            listaClientes.remove(clienteEliminado);
            return true;
        }
        return false;
    }

    //CRUD ENTRENADOR

    public Entrenador crearEntrenador(String nombre, String id, String especialidad) {
        Entrenador entrenador = obtenerEntrenador(id);
        if (entrenador == null) {
            entrenador = new Entrenador(nombre, id, especialidad);
            listaEntrenadores.add(entrenador);
            return entrenador;
        }
        return null;
    }


    public Entrenador obtenerEntrenador(String id) {
        for (Entrenador entrenador : listaEntrenadores) {
            if (entrenador.getId().equalsIgnoreCase(id)) {
                return entrenador;
            }
        }
        return null;
    }


    public boolean actualizarEntrenador(String nombre, String id, String especialidad) {
        Entrenador entranadorActualizado = obtenerEntrenador(id);
        if (entranadorActualizado != null) {
            entranadorActualizado.setNombre(nombre);
            entranadorActualizado.setEspecialidad(especialidad);
            return true;

        }
        return false;
    }

    public boolean eliminarEntrenador(String id) {
        Entrenador entrenadorEliminado = obtenerEntrenador(id);
        if (entrenadorEliminado != null) {
            listaEntrenadores.remove(entrenadorEliminado);
            return true;
        }
        return false;
    }

    //CLASE

    public Clase crearClase(String id,
                             String nombre,
                             String horario,
                             int capacidad,
                             LocalDate fechaInicio,
                             LocalDate fechaFin,
                             EstadoDisponibilidad estadoDisponibilidad,
                             TipoClase tipoClase,
                             Entrenador entrenador) {
        Clase clase = obtenerClase(id);
        if(clase == null) {
            clase = new Clase(id, nombre, horario, capacidad, fechaInicio, fechaFin, estadoDisponibilidad, tipoClase, entrenador);
            listaClases.add(clase);
            return clase;
        }
        return null;
    }

    public Clase obtenerClase(String id) {
        for (Clase clase : listaClases) {
            if (clase.getClaseId().equalsIgnoreCase(id)) {
                return clase;
            }
        }
        return null;
    }

    public String inscribirClase(String claseId, Cliente cliente) throws Exception {
        if(claseId == "" || cliente == null){
            throw new Exception("Datos incorrectos");
        }

        Clase claseBuscada = obtenerClase(claseId);
        String mensajeRespuesta = "Esta clase " + claseBuscada.getNombre() + "no tiene cupos disponibles";
        if (claseBuscada.getEstadoDisponibilidad() == EstadoDisponibilidad.DISPONIBLE) {
            Inscripcion inscripcion = new Inscripcion(claseId, cliente, LocalDate.now());
            claseBuscada.getListaInscritos().add(inscripcion);
            claseBuscada.sincronizarDisponibilidad();
            mensajeRespuesta = "Se realizó la inscripción con éxito";
        }

        return mensajeRespuesta;
    }

    public String cancelarInscripcion(String claseId, String clienteId) throws Exception {
        if(claseId == "" || clienteId == null){
            throw new Exception("Datos incorrectos");
        }

        Clase claseCancelada = obtenerClase(claseId);
        String mensajeRespuesta = "El cliente no se encuentra inscrito en la clase";

        List<Inscripcion> listaInscritos = claseCancelada.getListaInscritos();
        for (int i = 0; i < listaInscritos.size(); i++) {
            Inscripcion clienteInscrito = listaInscritos.get(i);
            if (clienteInscrito.getCliente().getId().equalsIgnoreCase(clienteId)) {
                listaInscritos.remove(clienteInscrito);
                claseCancelada.sincronizarDisponibilidad();
                mensajeRespuesta = "La inscripción se canceló con éxito";
            }
        }

        return mensajeRespuesta;
    }


    public void inscribirEntrenamientoCliente(String clienteId,
                                              TipoEntrenamiento tipoEntrenamiento,
                                              int duracionEntrenamiento,
                                              int kcalorias) throws Exception {
        Cliente cliente = obtenerCliente(clienteId);
        Entrenamiento entrenamiento = new Entrenamiento(tipoEntrenamiento, duracionEntrenamiento, kcalorias);
        cliente.getListaHistorial().add(entrenamiento);
    }


    public void consultarHistorialEntrenamiento( String clienteId) throws Exception {
         Cliente clienteHistorial = obtenerCliente(clienteId);
         for(int i=0; i < clienteHistorial.getListaHistorial().size(); i++){
             System.out.println(clienteHistorial.getListaHistorial().get(i));

         }
    }

    @Override
    public String toString() {
        return "Gimnasio{" +
                "nombre='" + nombre + '\'' +
                ", direccion='" + direccion + '\'' +
                ", listaClientes=" + listaClientes.size() +
                ", listaEntrenadores=" + listaEntrenadores.size() +
                ", listaClases=" + listaClases.size() +
                '}';
    }
}










