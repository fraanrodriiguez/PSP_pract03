package controlador;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import javax.swing.JOptionPane;
import modelo.Cliente;
import modelo.GestorCliente;
import vista.VistaClientes;
import vista.PanelVisualizar;
import vista.PanelNuevo;

/**
 * CONTROLADOR:
 * Conecta el modelo con la vista y valida los datos.
 */
public class ControladorClientes {
    //Atributos
    private final GestorCliente modelo;
    private final VistaClientes vista;
    private final PanelVisualizar visualizar;
    private final PanelNuevo nuevo;

    //Constructor
    public ControladorClientes(GestorCliente modelo, VistaClientes vista) {
        this.modelo = modelo;
        this.vista = vista;

        visualizar = vista.getPanelVisualizar();
        nuevo = vista.getPanelNuevo();

        //Navegación de clientes.
        visualizar.addPrimeroListener(e -> {
            modelo.irAlPrimero();
            mostrar();
        });

        visualizar.addAnteriorListener(e -> {
            modelo.retroceder();
            mostrar();
        });

        visualizar.addSiguienteListener(e -> {
            modelo.avanzar();
            mostrar();
        });

        visualizar.addUltimoListener(e -> {
            modelo.irAlUltimo();
            mostrar();
        });

        //Borrar el cliente actual.
        visualizar.addBorrarListener(e -> borrarCliente());

        //Menú principal.
        vista.addVisualizarListener(e -> {
            vista.mostrarPanel("Visualizar");
            mostrar();
        });

        vista.addNuevoListener(e -> {
            nuevo.limpiar();
            vista.mostrarPanel("Nuevo");
        });

        vista.addSalirListener(e -> {
            vista.dispose();
            System.exit(0);
        });

        //Formulario de nuevo cliente.
        nuevo.addGuardarListener(e -> anadirCliente());
        nuevo.addLimpiarListener(e -> nuevo.limpiar());

        //Muestra el primer cliente si existe alguno.
        mostrar();
    }

    //Métodos
    //Muestra el cliente actual.
    private void mostrar() {
        if (modelo.esVacia()) {
            visualizar.limpiar();
            visualizar.setNavegacion(false, false, false, false, false);
            return;
        }

        Cliente c = modelo.obtenerClienteActual();
        visualizar.mostrarCliente(
            c.getNumero(),
            c.getNombre(),
            c.getFechaNac().toString(),
            c.getPuntos(),
            modelo.getActual() + 1,
            modelo.total()
        );

        visualizar.mostrarError("");
        visualizar.setNavegacion(
            !modelo.esPrimero(),
            !modelo.esPrimero(),
            !modelo.esUltimo(),
            !modelo.esUltimo(),
            true
        );
    }

    //Añade un cliente después de validar los datos.
    private void anadirCliente() {

        try {
            //Comprobamos el número.
            int numero = Integer.parseInt(nuevo.getNumero());
            //Comprobamos que el nombre no esté vacío.
            String nombre = nuevo.getNombre();
            if (nombre.isEmpty()) {
                nuevo.mostrarError("Introduce el nombre.");
                return;
            }

            //Comprobamos la fecha.
            LocalDate fecha = LocalDate.parse(nuevo.getFecha());
            if (fecha.getYear() < 1900 || fecha.getYear() > 2015) {
                nuevo.mostrarError(
                    "El año debe estar entre 1900 y 2015."
                );
                return;
            }

            //Comprobamos los puntos.
            float puntos = Float.parseFloat(nuevo.getPuntos());
            if (puntos < 0 || puntos > 1000
                    || Float.isNaN(puntos)
                    || Float.isInfinite(puntos)) {
                nuevo.mostrarError(
                    "Los puntos deben estar entre 0 y 1000."
                );
                return;
            }

            //Evitamos números de cliente duplicados.
            if (modelo.existeNumero(numero)) {
                nuevo.mostrarError("Ese número de cliente ya existe.");
                return;
            }

            //Creamos el objeto y lo añadimos al modelo.
            Cliente cliente = new Cliente(
                numero, nombre, fecha, puntos
            );

            modelo.anadirCliente(cliente);

            //Seleccionamos el cliente recién añadido.
            modelo.irAlUltimo();
            nuevo.limpiar();
            vista.mostrarPanel("visualizar");
            mostrar();

        } catch (NumberFormatException e) {
            nuevo.mostrarError(
                "El número y los puntos deben ser numéricos."
            );

        } catch (DateTimeParseException e) {
            nuevo.mostrarError(
                "Fecha incorrecta. Usa AAAA-MM-DD."
            );
        }
    }

    //Eliminar el cliente seleccionado.
    private void borrarCliente() {
        if (modelo.esVacia()) {
            return;
        }
        modelo.borrarCliente();
        mostrar();
    }
}
