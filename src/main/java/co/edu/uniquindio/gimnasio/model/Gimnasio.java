package co.edu.uniquindio.gimnasio.model;

import co.edu.uniquindio.gimnasio.Enum.EstadoDisponibilidad;
import co.edu.uniquindio.gimnasio.Enum.TipoClase;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Gimnasio {
    private String nombre;
    private String direccion;
    private List<Cliente> listaClientes;
    private List<Entrenador> listaEntrenadores;
    private List<Clase> listaClases;



    public String crearCliente(String nombre, String id, String correo, String direccion, String telefono, String contraseña) {
        Cliente cliente = obtenerCliente(id);
        if (cliente == null) {
            cliente = new Cliente(nombre, id, correo, direccion, telefono, contraseña);
            listaClientes.add(cliente);
            return "Cliente creado con existo";
        } else {
            return "x";
        }
    }


    public Cliente obtenerCliente(String id) {
        for(Cliente cliente:listaClientes){
            if(cliente.getId().equalsIgnoreCase(id)){
                return cliente;
            }
        }
        return null;
    }


    public boolean actualizarCliente(String id, String nombre, String correo, String contrasenia){
        Cliente clienteActualizar = obtenerCliente(id);
        if(clienteActualizar != null){
            clienteActualizar.setNombre(nombre);
            clienteActualizar.setCorreo(correo);
            clienteActualizar.setContrasenia(contrasenia);
            return  true;

        }
        return false;
    }

    public boolean eliminarCliente(String id){
        Cliente clienteEliminado = obtenerCliente(id);
        if(clienteEliminado != null){
            listaClientes.remove(clienteEliminado);
            return  true;
        }
        return false;
    }

    //CRUD ENTRENADOR

    public String crearEntrenador(String nombre, String id, String especialidad) {
        Entrenador entrenador = obtenerEntrenador(id);
        if (entrenador == null) {
            entrenador = new Entrenador(nombre,id,especialidad);
            listaEntrenadores.add(entrenador);
            return "Entrenador creado con existo";
        } else {
            return "x";
        }
    }


    public Entrenador obtenerEntrenador(String id) {
        for(Entrenador entrenador:listaEntrenadores){
            if(entrenador.getId().equalsIgnoreCase(id)){
                return entrenador;
            }
        }
        return null;
    }


    public boolean actualizarEntrenador(String nombre, String id, String especialidad){
        Entrenador entranadorActualizado = obtenerEntrenador(id);
        if(entranadorActualizado != null){
            entranadorActualizado.setNombre(nombre);
            entranadorActualizado.setEspecialidad(especialidad);
            return  true;

        }
        return false;
    }

    public boolean eliminarEntrenador(String id){
       Entrenador entrenadorEliminado = obtenerEntrenador(id);
        if(entrenadorEliminado != null){
            listaEntrenadores.remove(entrenadorEliminado);
            return  true;
        }
        return false;
    }

    //CRUD CLASE

    public String crearClase(String id, String nombre, String horario, int capacidad, LocalDate fechaInicio, LocalDate fechaFin,
                             EstadoDisponibilidad estadoDisponibilidad, TipoClase tipoClase, Entrenador entrenador){
        Clase clase = obtenerClase(id);
        if(clase.getId() == null ){
            clase = new Clase(id,nombre,horario,capacidad,fechaInicio,fechaFin,estadoDisponibilidad,tipoClase,entrenador);
            listaClases.add(clase);
            return "La clase ha sido creada con éxito";
        }
        return null;
    }

    public Clase obtenerClase(String id){
        for(Clase clase:listaClases){
            if(clase.getId().equalsIgnoreCase(id)){
                return clase;
            }
        }
        return null;
    }

    public boolean cancelarClae(String id){
        Clase claseCancelada = obtenerClase(id);
        if(claseCancelada!=null){
            listaClases.remove(claseCancelada);
            return true;
        }
        return false;
    }



























}




