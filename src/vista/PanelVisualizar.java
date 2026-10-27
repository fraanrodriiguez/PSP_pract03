package vista;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import javax.swing.*;

/**
 * Panel que muestra los datos de un cliente.
 */
public class PanelVisualizar extends JPanel {
    
    //Atributos
    private final JLabel lblPosicion = new JLabel("", SwingConstants.CENTER);
    private final JLabel lblNumero = new JLabel();
    private final JLabel lblNombre = new JLabel();
    private final JLabel lblFecha = new JLabel();
    private final JLabel lblPuntos = new JLabel();
    private final JLabel lblError = new JLabel(" ");
    private final JButton btnPrimero = new JButton("Primero");
    private final JButton btnAnterior = new JButton("Anterior");
    private final JButton btnSiguiente = new JButton("Siguiente");
    private final JButton btnUltimo = new JButton("Último");
    private final JButton btnBorrar = new JButton("Borrar");

    //Constructor
    public PanelVisualizar() {
        setLayout(new BorderLayout(10, 10));

        JPanel datos = new JPanel(new GridLayout(4, 2, 8, 8));

        datos.add(new JLabel("Número:"));
        datos.add(lblNumero);

        datos.add(new JLabel("Nombre:"));
        datos.add(lblNombre);

        datos.add(new JLabel("Fecha de nacimiento:"));
        datos.add(lblFecha);

        datos.add(new JLabel("Puntos:"));
        datos.add(lblPuntos);

        JPanel botones = new JPanel(new FlowLayout());

        botones.add(btnPrimero);
        botones.add(btnAnterior);
        botones.add(btnSiguiente);
        botones.add(btnUltimo);
        botones.add(btnBorrar);

        lblError.setForeground(java.awt.Color.RED);

        add(lblPosicion, BorderLayout.NORTH);
        add(datos, BorderLayout.CENTER);

        JPanel inferior = new JPanel(new BorderLayout());
        inferior.add(botones, BorderLayout.CENTER);
        inferior.add(lblError, BorderLayout.SOUTH);

        add(inferior, BorderLayout.SOUTH);
    }

    //Métodos
    //Muestra los datos recibidos del controlador.
    public void mostrarCliente(
            int numero,
            String nombre,
            String fecha,
            float puntos,
            int posicion,
            int total) {

        lblPosicion.setText("Cliente " + posicion + " de " + total);
        lblNumero.setText(String.valueOf(numero));
        lblNombre.setText(nombre);
        lblFecha.setText(fecha);
        lblPuntos.setText(String.valueOf(puntos));
    }

    //Limpia los datos cuando no hay clientes.
    public void limpiar() {
        lblPosicion.setText("No hay clientes");
        lblNumero.setText("");
        lblNombre.setText("");
        lblFecha.setText("");
        lblPuntos.setText("");
    }

    //Activa o desactiva los botones según la posición.
    public void setNavegacion(
            boolean primero,
            boolean anterior,
            boolean siguiente,
            boolean ultimo,
            boolean borrar) {

        btnPrimero.setEnabled(primero);
        btnAnterior.setEnabled(anterior);
        btnSiguiente.setEnabled(siguiente);
        btnUltimo.setEnabled(ultimo);
        btnBorrar.setEnabled(borrar);
    }

    //Muestra un mensaje de error en rojo.
    public void mostrarError(String mensaje) {
        lblError.setText(mensaje);
    }

    //Eventos de los botones.
    public void addPrimeroListener(ActionListener l) {
        btnPrimero.addActionListener(l);
    }

    public void addAnteriorListener(ActionListener l) {
        btnAnterior.addActionListener(l);
    }

    public void addSiguienteListener(ActionListener l) {
        btnSiguiente.addActionListener(l);
    }

    public void addUltimoListener(ActionListener l) {
        btnUltimo.addActionListener(l);
    }

    public void addBorrarListener(ActionListener l) {
        btnBorrar.addActionListener(l);
    }
}