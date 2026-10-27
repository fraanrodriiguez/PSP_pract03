package aplicacion;

import controlador.ControladorClientes;
import modelo.Cliente;
import modelo.GestorCliente;
import vista.VistaClientes;
import java.time.LocalDate;
import javax.swing.SwingUtilities;

public class App {

    public static void main(String[] args) {

        //Swing debe iniciarse en su hilo de eventos.
        SwingUtilities.invokeLater(() -> {

            //Creamos el modelo.
            GestorCliente modelo = new GestorCliente();

            //Añadimos clientes de prueba para que haya datos.
            modelo.anadirCliente(new Cliente(1, "Francisco",LocalDate.of(1999, 2, 10),100.0f));
            modelo.anadirCliente(new Cliente(2, "Javier",LocalDate.of(2001, 4, 22),80.0f));
            modelo.anadirCliente(new Cliente(3, "Jorge",LocalDate.of(2006, 9, 30),300.0f));
            modelo.anadirCliente(new Cliente(4, "Fernando",LocalDate.of(1998, 6, 6),500.0f));
            modelo.anadirCliente(new Cliente(5, "Samuel",LocalDate.of(1990, 6, 13),999.0f));
            modelo.anadirCliente(new Cliente(6, "Manuel",LocalDate.of(2003, 10, 1),1.0f));
            modelo.anadirCliente(new Cliente(7, "Luis",LocalDate.of(2000, 1, 27), 50.0f));
            modelo.anadirCliente(new Cliente(8, "Miguel",LocalDate.of(1999, 12, 11),765.0f));

            //Creamos la vista.
            VistaClientes vista = new VistaClientes();

            //Conectamos el modelo y la vista.
            new ControladorClientes(modelo, vista);

            //Mostramos la ventana.
            vista.setVisible(true);
        });
    }
}