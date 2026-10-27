package modelo;

import java.util.ArrayList;
import java.util.Comparator;

public class GestorCliente {
    ArrayList<Cliente> clientes= new ArrayList<>();
    private int indice = 0;

    //Constructor
    public GestorCliente() {
        super();
    }

    //Métodos
    //Ver si la lista está vacía
    public boolean esVacia() {
        return clientes.isEmpty();
    }

    //Ver el siguiente cliente
    public void avanzar() {
        if (indice < clientes.size() - 1) {
            indice++;
        }
    }

    //Ver el anterior cliente
    public void retroceder() {
        if (indice > 0) {
            indice--;
        }
    }

    //Ver el primer cliente
    public void irAlPrimero() {
        if (!clientes.isEmpty()) {
            indice = 0;
        }
    }

    //Ver el último cliente
    public void irAlUltimo() {
        if (!clientes.isEmpty()) {
            indice = clientes.size() - 1;
        }
    }

    //Ver si estamos en el primer cliente
    public boolean esPrimero() {
        return !clientes.isEmpty() && indice == 0;
    }

    //Ver si estamos en el último cliente
    public boolean esUltimo() {
        return !clientes.isEmpty() && indice == clientes.size() - 1;
    }

    //Añadir un cliente a nuestra lista
    public void anadirCliente(Cliente c) {
        clientes.add(c);
    }

    //Borrar un cliente de la lista
    public void borrarCliente() {
        if (!clientes.isEmpty()) {
            clientes.remove(indice);

            //Si hemos borrado el último cliente, retrocedemos una posición.
            if (indice >= clientes.size() && !clientes.isEmpty()) {
                indice = clientes.size() - 1;
            }

            //Si la lista queda vacía, reiniciamos el índice.
            if (clientes.isEmpty()) {
                indice = 0;
            }
        }
    }

    //Devuelve el cliente en el que estamos
    public Cliente obtenerClienteActual() {
        if (clientes.isEmpty()) {
            return null;
        }

        return clientes.get(indice);
    }

    //Devuelve el índice del cliente en el que estamos
    public int getActual() {
        return indice;
    }

    //Nos da el total de clientes
    public int total() {
        return clientes.size();
    }

    //Ordena la lista por número de cliente.
    public void ordenarNumeroCliente() {
        clientes.sort(Comparator.comparingInt(Cliente::getNumero));
        indice = 0;
    }
    
    //Ver si existe el número de cliente
    public boolean existeNumero(int numero) {
    for (Cliente c : clientes) {
        if (c.getNumero() == numero) {
            return true;
        }
    }

    return false;
    }
}
