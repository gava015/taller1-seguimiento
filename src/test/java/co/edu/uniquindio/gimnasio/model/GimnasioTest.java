package co.edu.uniquindio.gimnasio.model;

import co.edu.uniquindio.gimnasio.Enum.EstadoDisponibilidad;
import co.edu.uniquindio.gimnasio.Enum.TipoClase;
import co.edu.uniquindio.gimnasio.Enum.TipoEntrenamiento;
import org.junit.jupiter.api.Test;


import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class GimnasioTest {

    @Test
    public void TestInscribirClase() throws Exception {
        Gimnasio gimnasio = new Gimnasio("marval", "acacias");
        Entrenador entrenador = gimnasio.crearEntrenador("Brayan", "1097", "Crossfit");

        Cliente cliente = gimnasio.crearCliente("Tefa", "1094", "tefa@", "tebaida",
                "311762", "tefa12");
        LocalDate fechaActual = LocalDate.now();
        Clase clase = gimnasio.crearClase("001", "Espalda", "1:00 pm a 5:00pm", 2, fechaActual,
                fechaActual.plusDays(7), EstadoDisponibilidad.DISPONIBLE, TipoClase.PESAS, entrenador);

        gimnasio.inscribirClase("001", cliente);
        assertEquals(1, clase.getListaInscritos().size());
    }

    @Test
    public void TestInscribirClaseEstadoNoDisponible() throws Exception {
        Gimnasio gimnasio = new Gimnasio("marval", "acacias");
        Entrenador entrenador = gimnasio.crearEntrenador("Brayan", "1097", "Crossfit");

        Cliente cliente = gimnasio.crearCliente("Tefa", "1094", "tefa@", "tebaida", "311762", "tefa12");
        LocalDate fechaActual = LocalDate.now();
        Clase clase = gimnasio.crearClase("001", "Espalda", "1:00 pm a 5:00pm", 1, fechaActual, fechaActual.plusDays(7), EstadoDisponibilidad.DISPONIBLE, TipoClase.PESAS, entrenador);

        gimnasio.inscribirClase("001", cliente);

        assertEquals(EstadoDisponibilidad.NO_DISPONIBLE, clase.getEstadoDisponibilidad());
    }

    @Test
    public void TestCancelarInscripcion() throws Exception {
        Gimnasio gimnasio = new Gimnasio("marval", "acacias");
        Cliente cliente1 = gimnasio.crearCliente("Tefa", "1094", "tefa@", "tebaida", "311762", "tefa12");
        Cliente cliente2 = gimnasio.crearCliente("valen","1098","valen@","armenia","34779","valen13");

        Entrenador entrenador2 = gimnasio.crearEntrenador("Brayan","1097","Crossfit");

        LocalDate fechaActual = LocalDate.now();
        Clase clase = gimnasio.crearClase("001","Espalda","1:00 pm a 5:00pm",2,  fechaActual, fechaActual.plusDays(7),EstadoDisponibilidad.DISPONIBLE,TipoClase.PESAS,entrenador2 );

        gimnasio.inscribirClase("001", cliente1);
        gimnasio.inscribirClase("001", cliente2);

        gimnasio.cancelarInscripcion("001", "1098");
        assertEquals(1, clase.getListaInscritos().size());
    }

    @Test
    public void TestInscribirClaseSinClienteError() throws Exception {
        Gimnasio gimnasio = new Gimnasio("marval", "acacias");
        Exception exception = assertThrows(Exception.class, () -> {
            gimnasio.inscribirClase("001", null);
        });

        assertEquals("Datos incorrectos", exception.getMessage());
    }

    @Test
    public void TestCancelarInscripcionSinClaseIdError() throws Exception {
        Gimnasio gimnasio = new Gimnasio("marval", "acacias");
        Exception exception = assertThrows(Exception.class, () -> {
            gimnasio.cancelarInscripcion("", null);
        });

        assertEquals("Datos incorrectos", exception.getMessage());
    }

    @Test
    public void TestInscribirEntrenamientoCliente() throws Exception {
        Gimnasio gimnasio = new Gimnasio("marval", "acacias");
        Cliente cliente = gimnasio.crearCliente("Tefa", "1094", "tefa@", "tebaida", "311762", "tefa12");

        gimnasio.inscribirEntrenamientoCliente(cliente.getId(), TipoEntrenamiento.POTENCIA, 1, 1);

        assertEquals(1, cliente.getListaHistorial().size());
    }

    @Test
    public void TestInscribirEntrenamientoClienteError() throws Exception {
        Gimnasio gimnasio = new Gimnasio("marval", "acacias");

        Exception exception = assertThrows(Exception.class, () -> {
            gimnasio.inscribirEntrenamientoCliente("", TipoEntrenamiento.POTENCIA, 1, 1);
        });

        assertEquals("El id del cliente no puede ser vacío", exception.getMessage());
    }
}