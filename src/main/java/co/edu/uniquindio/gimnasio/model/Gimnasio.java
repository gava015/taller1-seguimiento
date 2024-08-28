package co.edu.uniquindio.gimnasio.model;

import java.util.ArrayList;
import java.util.List;

public class Gimnasio {
    private String nombre;
    private String direccion;
    private List<Cliente> listaCliente;
    private List<Entrenador> listaEntrenadores;
    private List<Clase> listaClases;




    public String crearCliente(String nombre, String id, String correo, String direccion, String telefono, String contraseña) {
        Cliente cliente = obtenerCliente(id);
        if (cliente == null) {
            cliente = new Cliente(nombre, id, correo, direccion, telefono, contraseña);
            listaCliente.add(cliente);
            return "Cliente creado con existo";
        } else {
            return "x";
        }
    }

    public Cliente obtenerCliente(String id) {
        int tamanioLista = listaCliente.size();
        for (int i = 0; i < tamanioLista; i++) {
            Cliente cliente = listaCliente.get(i);
            if (cliente.getId().equalsIgnoreCase(id)) {
                return cliente;
            }
            return null;
        }


        public boolean actualizarCliente(String nombre, String id, String correo, String direccion, String telefono, String contraseña) {
            Cliente cliente = obtenerCliente(id);
            if (cliente != null) {
                cliente.setNombre(nombre)
                cliente.setCorreo
                vendedor.setEdad(edad);
                return true;

            } else {
                return false;
            }
        }


























    public Gimnasio(String nombre, String direccion) {
            this.nombre = nombre;
            this.direccion = direccion;
            listaCliente = new ArrayList<>();
            listaEntrenadores = new ArrayList<>();
            listaClases = new ArrayList<>();
        }
    }
}

