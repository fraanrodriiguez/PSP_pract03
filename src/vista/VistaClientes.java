package vista;

import java.awt.CardLayout;
import java.awt.event.ActionListener;
import javax.swing.*;

/**
 * VISTA PRINCIPAL:
 * Contiene el menú y los paneles de la aplicación.
 */
public class VistaClientes extends JFrame {

    private final CardLayout tarjetas = new CardLayout();
    private final JPanel contenedor = new JPanel(tarjetas);

    private final PanelVisualizar panelVisualizar =
            new PanelVisualizar();

    private final PanelNuevo panelNuevo =
            new PanelNuevo();

    private final JMenuItem itemVisualizar =
            new JMenuItem("Visualizar");

    private final JMenuItem itemNuevo =
            new JMenuItem("Nuevo");

    private final JMenuItem itemSalir =
            new JMenuItem("Salir");

    public VistaClientes() {
        super("Gestión de clientes");

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(550, 330);
        setResizable(false);
        setLocationRelativeTo(null);

        // Creamos el menú.
        JMenuBar barraMenu = new JMenuBar();
        JMenu menu = new JMenu("Clientes");

        menu.add(itemVisualizar);
        menu.add(itemNuevo);
        menu.addSeparator();
        menu.add(itemSalir);

        barraMenu.add(menu);
        setJMenuBar(barraMenu);

        // Añadimos los dos paneles al contenedor.
        contenedor.add(panelVisualizar, "visualizar");
        contenedor.add(panelNuevo, "nuevo");

        add(contenedor);

        // Al iniciar mostramos el panel de visualización.
        mostrarPanel("visualizar");
    }

    // Cambia el panel que se muestra.
    public void mostrarPanel(String nombre) {
        tarjetas.show(contenedor, nombre);
    }

    // Permite al controlador acceder a los paneles.
    public PanelVisualizar getPanelVisualizar() {
        return panelVisualizar;
    }

    public PanelNuevo getPanelNuevo() {
        return panelNuevo;
    }

    // Eventos del menú.
    public void addVisualizarListener(ActionListener l) {
        itemVisualizar.addActionListener(l);
    }

    public void addNuevoListener(ActionListener l) {
        itemNuevo.addActionListener(l);
    }

    public void addSalirListener(ActionListener l) {
        itemSalir.addActionListener(l);
    }
}
