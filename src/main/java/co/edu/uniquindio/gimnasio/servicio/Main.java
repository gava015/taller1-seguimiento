package co.edu.uniquindio.gimnasio.servicio;

import co.edu.uniquindio.gimnasio.Enum.EstadoDisponibilidad;
import co.edu.uniquindio.gimnasio.Enum.TipoClase;
import co.edu.uniquindio.gimnasio.Enum.TipoEntrenamiento;
import co.edu.uniquindio.gimnasio.model.*;

import java.time.LocalDate;

public class Main {


    public static void main(String[] args) {

        try {
            Gimnasio gimnasio = new Gimnasio("marval", "acacias");
            Cliente cliente1 = gimnasio.crearCliente("Tefa", "1094", "tefa@", "tebaida", "311762", "tefa12");
            Cliente cliente2 = gimnasio.crearCliente("valen","1098","valen@","armenia","34779","valen13");
            Cliente cliente3 = gimnasio.crearCliente("Camilo","1095","cami@","armenia","31124","cami17");

            Entrenador entrenador1 = gimnasio.crearEntrenador("Benito", "12345", "Baile");
            Entrenador entrenador2 = gimnasio.crearEntrenador("Brayan","1097","Crossfit");

            LocalDate fechaActual = LocalDate.now();
            gimnasio.crearClase("001","Espalda","1:00 pm a 5:00pm",2,  fechaActual, fechaActual.plusDays(7),EstadoDisponibilidad.DISPONIBLE,TipoClase.PESAS,entrenador2 );
            gimnasio.crearClase("008", "Zumba", "09:00am - 10:00am", 5, fechaActual, fechaActual.plusDays(5), EstadoDisponibilidad.DISPONIBLE, TipoClase.ZUMBA, entrenador1);


            gimnasio.inscribirClase("001", cliente1);
            gimnasio.inscribirClase("001", cliente2);

            gimnasio.inscribirClase("008", cliente1);
            gimnasio.inscribirClase("008", cliente2);
            gimnasio.inscribirClase("008", cliente3);
            gimnasio.cancelarInscripcion("001", "1098");

            gimnasio.inscribirEntrenamientoCliente(cliente1.getId(), TipoEntrenamiento.POTENCIA,1, 230);
            gimnasio.inscribirEntrenamientoCliente(cliente2.getId(), TipoEntrenamiento.FUERZA,2, 150);

            System.out.println(cliente1.getListaHistorial().size());

        }catch (Exception ex){
            System.out.println("Lo sentimos, ocurrió un error: [" + ex.getMessage()+ "]");
        }
    }
}
