package vista;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import javax.swing.*;

/**
 * Panel para crear un cliente nuevo.
 */
public class PanelNuevo extends JPanel {

    private final JTextField txtNumero = new JTextField();
    private final JTextField txtNombre = new JTextField();
    private final JTextField txtFecha = new JTextField();
    private final JTextField txtPuntos = new JTextField();

    private final JLabel lblError = new JLabel(" ");

    private final JButton btnGuardar = new JButton("Guardar");
    private final JButton btnLimpiar = new JButton("Limpiar");

    public PanelNuevo() {
        setLayout(new BorderLayout(10, 10));

        JPanel campos = new JPanel(new GridLayout(4, 2, 8, 8));

        campos.add(new JLabel("Número:"));
        campos.add(txtNumero);

        campos.add(new JLabel("Nombre:"));
        campos.add(txtNombre);

        campos.add(new JLabel("Fecha (AAAA-MM-DD):"));
        campos.add(txtFecha);

        campos.add(new JLabel("Puntos (0-1000):"));
        campos.add(txtPuntos);

        JPanel botones = new JPanel();
        botones.add(btnGuardar);
        botones.add(btnLimpiar);

        // El mensaje de error aparecerá en rojo.
        lblError.setForeground(java.awt.Color.RED);

        add(campos, BorderLayout.CENTER);

        JPanel inferior = new JPanel(new BorderLayout());
        inferior.add(lblError, BorderLayout.NORTH);
        inferior.add(botones, BorderLayout.SOUTH);

        add(inferior, BorderLayout.SOUTH);
    }

    // Métodos para leer los datos del formulario.
    public String getNumero() {
        return txtNumero.getText().trim();
    }

    public String getNombre() {
        return txtNombre.getText().trim();
    }

    public String getFecha() {
        return txtFecha.getText().trim();
    }

    public String getPuntos() {
        return txtPuntos.getText().trim();
    }

    // Limpia los campos del formulario.
    public void limpiar() {
        txtNumero.setText("");
        txtNombre.setText("");
        txtFecha.setText("");
        txtPuntos.setText("");
        mostrarError("");
    }

    // Muestra errores en rojo.
    public void mostrarError(String mensaje) {
        lblError.setText(mensaje);
    }

    // Eventos de los botones.
    public void addGuardarListener(ActionListener l) {
        btnGuardar.addActionListener(l);
    }

    public void addLimpiarListener(ActionListener l) {
        btnLimpiar.addActionListener(l);
    }
}
